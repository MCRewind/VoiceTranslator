import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.darkprograms.speech.microphone.Microphone;
import com.darkprograms.speech.recognizer.GoogleResponse;
import com.darkprograms.speech.recognizer.Recognizer;
import com.darkprograms.speech.synthesiser.Synthesiser;

import javaFlacEncoder.FLACFileWriter;


/**
 * Jarvis Speech API Tutorial
 * @author Aaron Gokaslan (Skylion)
 *
 */
public class Translator extends JFrame {

	Dictionary_Reader reader = new Dictionary_Reader();
	Graphics graphics = new Graphics();
	Debug debugWindow = new Debug();
	boolean google = true, debug = false;


	public static void main(String[] args) {
		new Translator();
	}

	public Translator() {
		//	reader.indexer();

		debugUpdate();
		if(debug)
			debugWindow.setVisible(true);
		else
			debugWindow.setVisible(false);

		//Spanish Dictionaries
		reader.spanishCleaner("Eng to Spn New.txt", reader.engSpnStringMap);
		reader.spnEngStringMap = reader.dictInverter(reader.engSpnStringMap);

		//French Dictionaries
		reader.frenchCleaner("Eng to Frn.txt", reader.engFrnStringMap);
		reader.frnEngStringMap = reader.dictInverter(reader.engFrnStringMap);

		//Non English Dictionaries
		reader.frenchCleaner("Spn to Frn.txt", reader.spnFrnStringMap);
		//reader.spnFrnStringMap = reader.dictMaker(reader.engSpnStringMap, reader.engFrnStringMap);
		//reader.write("Spn to Frn.txt", reader.spnFrnStringMap);

		reader.frnSpnStringMap = reader.dictInverter(reader.spnFrnStringMap);

		reader.deserializer(reader.engSpnMap, reader.engSpnStringMap, "sp");
		reader.spnEngMap = reader.wordDictInverter(reader.engSpnMap);

		reader.deserializer(reader.engFrnMap, reader.engFrnStringMap, "fr");
		reader.frnEngMap = reader.wordDictInverter(reader.engFrnMap);

		reader.deserializer(reader.spnFrnMap, reader.spnFrnStringMap, "fr");
		reader.frnSpnMap = reader.wordDictInverter(reader.spnFrnMap);

		//Init window	 stuff
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(500, 500);
		setLayout(new GridLayout(3, 1));
		this.setResizable(true);
		this.add(graphics);
		/*for (int i = 0; i < UIManager.getInstalledLookAndFeels().length; i++) {
			System.out.println(UIManager.getInstalledLookAndFeels()[i]);
		}*/
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		this.setVisible(true);
	}

	public void record() {
		Microphone mic = new Microphone(FLACFileWriter.FLAC);
		File file = new File("testfile2.flac");//Name your file whatever you want
		try {
			mic.captureAudioToFile(file);
		} catch (Exception ex) {//Microphone not available or some other error.
			System.out.println("ERROR: Microphone is not availible.");
			ex.printStackTrace();
			//TODO Add your error Handling Here
		}
		/* User records the voice here. Microphone starts a separate thread so do whatever you want
		 * in the mean time. Show a recording icon or whatever.
		 */
		try {
			graphics.status.setText("Recording");
			graphics.repaint();
			System.out.println("Recording...");
			Thread.sleep(5000);//In our case, we'll just wait 5 seconds.
			mic.close();
		} catch (InterruptedException ex) {

			ex.printStackTrace();
		}

		mic.close();//Ends recording and frees the resources
		System.out.println("Recording stopped.");
		graphics.status.setText("Translating");
		graphics.repaint();
		if (google) {
			Recognizer recognizer = new Recognizer(toLang(graphics.curInLang), "AIzaSyD2o9tVprWInnns4lJUaq0NW05EwBf25v8"); //Specify your language here.
			//Although auto-detect is available, it is recommended you select your region for added accuracy.
			try {
				int maxNumOfResponses = 4;
				GoogleResponse response = recognizer.getRecognizedDataForFlac(file, maxNumOfResponses, (int)mic.getAudioFormat().getSampleRate());

				System.out.println("Google Response: " + response.getResponse());
				graphics.inText.setText("Input: " + response.getResponse());
				repaint();
				graphics.responses.removeAllItems();
				if (graphics.curInLang.equals(graphics.curOutLang))
					graphics.outText.setText("Output: " + response.getResponse());
				else
					graphics.outText.setText("Output: " + translate(response.getResponse().toLowerCase(), toISO(graphics.curOutLang)));
				graphics.no.setSelected(false);
				graphics.yes.setSelected(false);
				graphics.question.setVisible(true);
				graphics.yes.setVisible(true);
				graphics.no.setVisible(true);
				System.out.println(translate(response.getResponse(), toISO(graphics.curOutLang)));
				graphics.status.setText("Waiting");
				repaint();
				System.out.println("Google is " + Double.parseDouble(response.getConfidence())*100 + "% confident in"
						+ " the reply");
				System.out.println("Other Possible responses are: ");
				for(String s: response.getAllPossibleResponses()){
					graphics.addResponse(s);
					graphics.repaint();
					System.out.println("\t" + s);
				}
			} catch (Exception ex) {
				// TODO Handle how to respond if Google cannot be contacted
				System.out.println("ERROR: Google cannot be contacted");
				System.out.println("Please try speaking more clearly");
				ex.printStackTrace();
			}

			file.deleteOnExit();//Deletes the file as it is no longer necessary.
		}
	}

	public void talk(String text){
		//String language = "auto";//Uses language autodetection
		//** While the API can detect language by itself, this is reliant on the Google Translate API which is prone to breaking. For maximum stability, please specify the language.**//
		//System.out.println(graphics.curOutLang);
		String language = toISO(graphics.curOutLang);//English (US) language code	 //If you want to specify a language use the ISO code for your country. Ex: en-us
		/*If you are unsure of this code, use the Translator class to automatically detect based off of
		 * Either text from your language or your system settings.
		 */
		Synthesiser synth = new Synthesiser(language);
		try {
			InputStream is = synth.getMP3Data(text);
			final Path destination = Paths.get("audio.mp3");
			Files.copy(is, destination, StandardCopyOption.REPLACE_EXISTING);
		} catch (Exception e) {
			System.out.println("Error");
			e.printStackTrace();
			return;
		}
	}

	public String translate(String text, String lang) {
		int size = 0;
		//output = english
		if (lang == "en-us") {
			String[] words = text.split(" ");
			ArrayList<String> newWords = new ArrayList<String>(words.length);
			if (graphics.curInLang == "Spanish"){
				for(int i = 0; i < words.length; i++) {
					/////NON EXISTING WORDS HANDLING
					if (reader.spnEngStringMap.get(words[i]) == null){
						newWords.set(i, words[i]);
					} else {
						newWords.set(i,  reader.spnEngStringMap.get(words[i]));
					}
				}
			} else if (graphics.curInLang == "French"){
				for(int i = 0; i < words.length; i++) {
					/////NON EXISTING WORDS HANDLING
					if (reader.frnEngStringMap.get(words[i]) == null){
						newWords.set(i, words[i]);
					} else { 
						newWords.set(i,  reader.spnEngStringMap.get(words[i]));
					}
				}
			}
			String newSentence = "";
			for(String word : newWords) {
				newSentence += word + " ";
			}
			talk(newSentence);
			return newSentence;
			//output = spanish
		} else if (lang == "es-mx") {
			String[] words = text.split(" ");
			ArrayList<String> newWords = new ArrayList<String>(words.length);
			for (int i = 0; i < words.length; i++) {
				newWords.add(i, words[i]);
			}
			boolean specialCase = false;
			if (graphics.curInLang == "English"){
				int tempLength = words.length;
				for(int i = 0; i < tempLength; i++) {
					specialCase = false;
					if (newWords.get(i).equals("does") || newWords.get(i).equals("don't") || newWords.get(i).equals("do") || newWords.get(i).equals("doing") || newWords.get(i).equals("done") || newWords.get(i).equals("did") || newWords.get(i).equals("didn't") || newWords.get(i).equals("doesn't")){
						newWords.remove(i);
						specialCase = true;	
						///// 's HANDLING
					} else if (newWords.get(i).length() >= 3 && newWords.get(i).substring(newWords.get(i).length() - 2).equals("'s")){
						specialCase = true;
						newWords.set(i, (newWords.get(i).subSequence(0, newWords.get(i).length() - 2)).toString());
						newWords.add(i + 1, "is");
						i++;
						tempLength++;
						///// 've HANDLING
					} else if (newWords.get(i).length() >= 3 && newWords.get(i).substring(newWords.get(i).length() - 3).equals("'ve")){
						specialCase = true;
						newWords.set(i,	(newWords.get(i).subSequence(0, newWords.get(i).length() - 3)).toString());
						newWords.add(i + 1, "have");
						i++;
						tempLength ++;
						System.out.println(i);
						/////REFLEXIVE SPANISH VERBS HANDLING

					} else if (reader.engSpnStringMap.get(newWords.get(i)) != null) {
						specialCase = true;
						if (reader.engSpnStringMap.get(newWords.get(i)).length() > 5) {
							if (reader.engSpnStringMap.get(newWords.get(i)).substring(reader.engSpnStringMap.get(newWords.get(i)).length() - 4).equals("arse") || reader.engSpnStringMap.get(newWords.get(i)).substring(reader.engSpnStringMap.get(newWords.get(i)).length() - 4).equals("irse") || reader.engSpnStringMap.get(newWords.get(i)).substring(reader.engSpnStringMap.get(newWords.get(i)).length() - 4).equals("erse")) {
								/*System.out.println(i);
							System.out.println(newWords.get(i));
							System.out.println(newWords.get(i - 1));
							System.out.println(reader.engSpnStringMap.get(newWords.get(i - 1)));*/
								if ((newWords.get(i - 1).equalsIgnoreCase("i"))){
									newWords.add(i, "meR");
									System.out.println("argsrgadfgyjgyjfcv");
								} else if (newWords.get(i - 1).equalsIgnoreCase("you")){
									newWords.add(i, "teR");
								} else if (newWords.get(i - 1).equalsIgnoreCase("he") || newWords.get(i - 1).equalsIgnoreCase("she") || newWords.get(i - 1).equalsIgnoreCase("it")){
									newWords.add(i, "seR");
								} else if (newWords.get(i - 1).equalsIgnoreCase("we")){
									newWords.add(i, "nosR");
								} else if (newWords.get(i - 1).equalsIgnoreCase("yall") || newWords.get(i - 1).equalsIgnoreCase("y'all")){
									newWords.add(i, "osR");
								} else if (newWords.get(i - 1).equalsIgnoreCase("they") || newWords.get(i - 1).equalsIgnoreCase("them")){
									newWords.add(i, "seR");
								} else {
									newWords.add(i, "seR");
								}
								newWords.set(i + 1, reader.engSpnStringMap.get(words[i]).subSequence(0, reader.engSpnStringMap.get(words[i]).length() - 2).toString());
								System.out.println(newWords.get(i));
								
								//Tense Checker
							  /* } else if (newWords.get(i).getPos().equals("verb")) {
								//Past Tense Checker
								if (newWords.get(i).substring(newWords.get(i).length() - 2).equals("ed") || newWords.get(i).substring(newWords.get(i).length() - 3).equals("ove")) {
									newWords.get(i).setTense("past");
									//Future Tense Checker
								}	else if (newWords.get(i - 1).equals("will") || ((newWords.get(i - 2).equals("going") && newWords.get(i - 1).equals("to")))) {
									newWords.get(i).setTense("future");
								}*/
								/////NON EXISTING WORDS HANDLING
							}
						}
					} else if (specialCase == false){
						if (reader.engSpnStringMap.get(words[i]) == null) {
							words[i] = words[i];
						} else {
							words[i] = reader.engSpnStringMap.get(words[i]);
						}
					}
					if (reader.engSpnStringMap.get(words[i]) == null) {
						words[i] = words[i];
					} 
				}
				if (specialCase == true){
					for (int x = 0; x < newWords.size(); x++){
						if (!(reader.engSpnStringMap.containsValue(newWords.get(x)))){
							newWords.set(x, reader.engSpnStringMap.get(newWords.get(x)));
						}
						if (reader.engSpnStringMap.get(newWords.get(x)) == null) {
							newWords.set(x, newWords.get(x));
						} else {
							newWords.set(x, reader.engSpnStringMap.get(newWords.get(x)));
						}
					}

				}
			}
			else if (graphics.curInLang == "French"){
				for(int i = 0; i < words.length; i++) {
					/////REFLEXIVE SPANISH VERBS HANDLING
					/*
					if (reader.frnSpnStringMap.get(words[i]).substring(reader.frnSpnStringMap.get(words[i]).length() - 4) == "arse" || reader.frnSpnStringMap.get(words[i]).substring(reader.frnSpnStringMap.get(words[i]).length() - 4) == "irse" || reader.frnSpnStringMap.get(words[i]).substring(reader.frnSpnStringMap.get(words[i]).length() - 4) == "erse"){
						String[] longWords = new String[words.length + 1];
						for (int x = 0; x < longWords.length; x ++){
							if (x == i){
								if (reader.frnSpnStringMap.get(words[i - 1]) == "yo"){
									longWords[x] = "me";
								} else if (reader.frnSpnStringMap.get(words[i - 1]) == "tu"){
									longWords[x] = "te";
								} else if (reader.frnSpnStringMap.get(words[i - 1]) == "el" || reader.engSpnStringMap.get(words[i - 1]) == "ella" || reader.engSpnStringMap.get(words[i - 1]) == "usted"){
									longWords[x] = "se";
								} else if (reader.frnSpnStringMap.get(words[i - 1]) == "nosotros"){
									longWords[x] = "nos";
								} else if (reader.frnSpnStringMap.get(words[i - 1]) == "vosotros"){
									longWords[x] = "os";
								} else if (reader.frnSpnStringMap.get(words[i - 1]) == "ellos" || reader.engSpnStringMap.get(words[i - 1]) == "ellas" || reader.engSpnStringMap.get(words[i - 1]) == "ustedes"){
									longWords[x] = "se";
								}	
								longWords[x + 1] = reader.frnSpnStringMap.get(words[i]).subSequence(0, words[i].length() - 4).toString();
								x++;
							} else {
								longWords[x] = words[x];
							}
						}
						newWords = longWords;
						/////NON EXISTING WORDS HANDLING
					} else */ if (reader.frnSpnStringMap.get(words[i]) == null){
						newWords.set(i, words[i]);
					} else {
						newWords.set(i, reader.frnSpnStringMap.get(words[i]));
					}
				}
			}
			String newSentence = "";
			if (specialCase == true){
				for(String word : newWords) {
					//		System.out.println(word);
					newSentence += word + " ";
				}
			} else {
				for(String word : words) {
					//	System.out.println(word);
					newSentence += word + " ";
				}
			}
			talk(newSentence);
			return newSentence;
			//output = french
		} else if (lang == "fr-fr") {
			String[] words = text.split(" ");
			String[] newWords = new String[words.length];
			if (graphics.curInLang == "English"){
				for(int i = 0; i < words.length; i++) {
					///// 's HANDLING
					/*
					if (words[i].substring(words[i].length() - 2).equals("'s")){
						String[] longWords = new String[words.length + 1];
						for (int x = 0; x < longWords.length; x ++){
							if (x == i){
								longWords[x] = (words[i].subSequence(0, words[i].length() - 2)).toString();
								longWords[x + 1] = "is";
								x++;
							} if (x > i){
								longWords[x] = words[x - 1];
							} else {
								longWords[x] = words[x];
							}
						}
						newWords[i] = reader.engFrnStringMap.get(longWords[i]);
						///// 've HANDLING
					} else if (words[i].substring(words[i].length() - 3).equals("'ve")){
						String[] longWords = new String[words.length + 1];
						for (int x = 0; x < longWords.length; x ++){
							if (x == i){
								longWords[x] = (words[i].subSequence(0, words[i].length() - 3)).toString();
								longWords[x + 1] = "have";
								x++;
							} if (x > i){
								longWords[x] = words[x - 1];
							} else {
								longWords[x] = words[x];
							}
						}
						newWords[i] = reader.engFrnStringMap.get(longWords[i]);
						/////NON EXISTING WORDS HANDLING
					} else */  if (reader.engFrnStringMap.get(words[i]) == null){
						newWords[i] = words[i];
					} else {
						newWords[i] = reader.engFrnStringMap.get(words[i]);
					}
				}
			} else if (graphics.curInLang == "Spanish"){
				for(int i = 0; i < words.length; i++) {
					/////NON EXISTING WORDS HANDLING
					if (reader.spnFrnStringMap.get(words[i]) == null){
						newWords[i] = words[i];
					} else {
						newWords[i] = reader.spnFrnStringMap.get(words[i]);
					}
				}
			}

			String newSentence = "";
			for(String word : newWords) {
				newSentence += word + " ";
			}
			talk(newSentence);
			return newSentence;
		}
		return text;
	}

	public String toISO(String lang) {
		switch (lang) {
		case "English":
			return "en-us";
		case "Spanish":
			return "es-mx";
		case "French":
			return "fr-fr";
		}
		return lang;
	}

	public Recognizer.Languages toLang(String lang) {
		switch(lang) {
		case "English":
			return Recognizer.Languages.ENGLISH_US;
		case "Spanish":
			return Recognizer.Languages.SPANISH_MEXICO;
		case "French":
			return Recognizer.Languages.FRENCH;
		}
		return null;

	}


	public class Graphics extends JPanel {

		GridBagConstraints gbc = new GridBagConstraints();

		JComboBox<String> inLang = new JComboBox<String>(new String[]{"English", "Spanish", "French"});
		JComboBox<String> outLang = new JComboBox<String>(new String[]{"Spanish", "English", "French"});
		JComboBox<String> responses = new JComboBox<String>(new String[]{});
		JButton record = new JButton("Record");
		JButton play = new JButton("Play");
		JLabel to = new JLabel("to");
		JLabel status = new JLabel("Waiting...");
		JLabel inText = new JLabel("Input: ");
		JLabel outText = new JLabel("Output: ");
		JLabel question = new JLabel("Is this what you said?");
		JLabel followup = new JLabel("Was it one of these?");
		JCheckBox yes = new JCheckBox("yes");
		JCheckBox no = new JCheckBox("no");

		String curOutLang = "Spanish", curInLang = "English";

		public void addResponse(String s) {
			responses.addItem(s);
		}

		public Graphics() {
			setLayout(new GridBagLayout());

			this.setBorder(BorderFactory.createEmptyBorder());

			inLang.setSelectedIndex(0);
			outLang.setSelectedIndex(0);

			inLang.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					curInLang = inLang.getItemAt(inLang.getSelectedIndex());
					debugUpdate();
				}

			});

			outLang.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					curOutLang = outLang.getItemAt(outLang.getSelectedIndex());
					debugUpdate();
				}

			});

			record.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					record();
				}

			});

			play.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

				}

			});

			yes.addChangeListener(new ChangeListener() {

				@Override
				public void stateChanged(ChangeEvent e) {
					AbstractButton ab = (AbstractButton) e.getSource();
					ButtonModel bm = ab.getModel();
					if (bm.isSelected()) {
						no.setEnabled(false);
						question.setVisible(false);
						no.setVisible(false);
						yes.setVisible(false);

					} else {
						no.setEnabled(true);
					}
				}

			});

			no.addChangeListener(new ChangeListener() {

				@Override
				public void stateChanged(ChangeEvent e) {
					AbstractButton ab = (AbstractButton) e.getSource();
					ButtonModel bm = ab.getModel();
					if (bm.isSelected()) {
						yes.setEnabled(false);
						followup.setVisible(true);
						responses.setVisible(true);
						responses.setEnabled(true);
					} else {
						yes.setEnabled(true);
						followup.setVisible(false);
						responses.setVisible(false);
					}
				}

			});

			responses.addItemListener(new ItemListener() {

				@Override
				public void itemStateChanged(ItemEvent e) {
					System.out.println("state");
					if (e.getStateChange() == ItemEvent.SELECTED) {
						System.out.println("selected");
						no.setSelected(false);
						yes.setSelected(false);
						inText.setText("Input: " + responses.getItemAt(responses.getSelectedIndex()));
						//graphics.responses.removeAllItems();
						if (curInLang.equals(graphics.curOutLang))
							outText.setText("Output: " + responses.getItemAt(responses.getSelectedIndex()));
						else
							graphics.outText.setText("Output: " + translate(responses.getItemAt(responses.getSelectedIndex()).toLowerCase(), toISO(graphics.curOutLang)));
					}
					/*question.setVisible(false);
					followup.setVisible(false);
					yes.setVisible(false);
					no.setVisible(false);
					responses.setVisible(false);*/
				}	
			});

			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.gridx = 0;
			gbc.gridy = 0;
			add(inLang, gbc);
			gbc.fill = GridBagConstraints.CENTER;
			gbc.gridx = 1;
			gbc.gridy = 0;
			add(to, gbc);
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.gridx = 2;
			gbc.gridy = 0;
			add(outLang, gbc);
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.gridx = 1;
			gbc.gridy = 2;
			add(status, gbc);
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.gridx = 1;
			gbc.gridy = 1;
			add(record, gbc);
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.gridx = 0;
			gbc.gridy = 3;
			add(inText, gbc);
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.gridx = 0;
			gbc.gridy = 4;
			add(outText, gbc);
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.gridx = 0;
			gbc.gridy = 5;
			add(question, gbc);
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.gridx = 1;
			gbc.gridy = 5;
			add(yes, gbc);
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.gridx = 2;
			gbc.gridy = 5;
			add(no, gbc);
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.gridx = 0;
			gbc.gridy = 6;
			add(followup, gbc);
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.gridx = 1;
			gbc.gridy = 6;
			add(responses, gbc);

			inLang.setVisible(true);
			outLang.setVisible(true);
			to.setVisible(true);
			record.setVisible(true);
			inText.setVisible(true);
			outText.setVisible(true);
			question.setVisible(false);
			yes.setVisible(false);
			no.setVisible(false);
			responses.setVisible(false);
			responses.setEnabled(false);
			followup.setVisible(false);
		}

	}

	public void debugUpdate() {
		debugWindow.text(graphics.curInLang, graphics.curOutLang, toISO(graphics.curInLang), toISO(graphics.curInLang), toLang(graphics.curInLang).toString(), toLang(graphics.curOutLang).toString());
		debugWindow.repaint();
	}

	public class Debug extends JFrame {

		JPanel gfx = new JPanel();

		public Debug() {
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setSize(200, 500);
			setLayout(new GridLayout(10, 1));
			setResizable(true);
			add(gfx);
			setVisible(true);
		}

		public void text(String... vars) {
			for(int i = 0; i < vars.length; i++) {
				JLabel text = new JLabel(vars[i]);
				gfx.add(text);
				text.setVisible(true);
			}
		}

	}

}