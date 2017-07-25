import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

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
	boolean google = true;
	
	public static void main(String[] args) {
		new Translator();
	}

	public Translator() {
		//System.out.println(reader.dictMap.containsValue("que tal"));
		reader.cleaner("Eng to Spn New.txt");
		
		//Init window stuff
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
			System.out.println("Recording...");
			repaint();
			Thread.sleep(5000);//In our case, we'll just wait 5 seconds.
	                    mic.close();
		} catch (InterruptedException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}

		mic.close();//Ends recording and frees the resources
		System.out.println("Recording stopped.");
		graphics.status.setText("Translating");
		repaint();
		if (google) {
			Recognizer recognizer = new Recognizer(Recognizer.Languages.ENGLISH_US, "AIzaSyD2o9tVprWInnns4lJUaq0NW05EwBf25v8"); //Specify your language here.
			//Although auto-detect is avalible, it is recommended you select your region for added accuracy.
			try {
				int maxNumOfResponses = 4;
				GoogleResponse response = recognizer.getRecognizedDataForFlac(file, maxNumOfResponses, (int)mic.getAudioFormat().getSampleRate());
				System.out.println("Google Response: " + response.getResponse());
				graphics.inText.setText("Input: " + response.getResponse());
				repaint();
				graphics.outText.setText("Output: " + translate(response.getResponse(), "es-mx"));
				System.out.println(translate(response.getResponse(), "es-mx"));
				graphics.status.setText("Waiting");
				repaint();
				System.out.println("Google is " + Double.parseDouble(response.getConfidence())*100 + "% confident in"
						+ " the reply");
				System.out.println("Other Possible responses are: ");
				for(String s: response.getOtherPossibleResponses()){
					System.out.println("\t" + s);
				}
			} catch (Exception ex) {
				// TODO Handle how to respond if Google cannot be contacted
				System.out.println("ERROR: Google cannot be contacted");
				ex.printStackTrace();
			}
	
			file.deleteOnExit();//Deletes the file as it is no longer necessary.
		}
	}
	
	public void talk(String text){
		//String language = "auto";//Uses language autodetection
		//** While the API can detect language by itself, this is reliant on the Google Translate API which is prone to breaking. For maximum stability, please specify the language.**//
		System.out.println(graphics.curOutLang);
		String language = toISO("es-mx");//English (US) language code	 //If you want to specify a language use the ISO code for your country. Ex: en-us
		/*If you are unsure of this code, use the Translator class to automatically detect based off of
		 * Either text from your language or your system settings.
		 */
		Synthesiser synth = new Synthesiser(language);
		try {
			InputStream is = synth.getMP3Data(text);
			final Path destination = Paths.get("audio.mp3");
			Files.copy(is, destination, StandardCopyOption.REPLACE_EXISTING);
			try{
				AudioInputStream ais = AudioSystem.getAudioInputStream(is);
				Clip clip = AudioSystem.getClip();  
				clip.open(ais);
				clip.start();
				clip.drain();
				clip.close();
			} catch(Exception ex) {
				System.out.println("Audio Error");
			}

		} catch (Exception e) {
			System.out.println("Error");
			e.printStackTrace();
			return;
		}
	}

	public String translate(String text, String lang) {
		if (lang == "en-us")
			return text;
		else if (lang == "es-mx") {
			String[] words = text.split(" ");
			String[] newWords = new String[words.length];
			for(int i = 0; i < words.length; i++) {
				newWords[i] = reader.dictMap.get(words[i]);
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
		}
		return lang;
	}
	
	public class Graphics extends JPanel {
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		JComboBox<String> inLang = new JComboBox<String>(new String[]{"English", "Spanish"});
		JComboBox<String> outLang = new JComboBox<String>(new String[]{"Spanish", "English"});
		JButton record = new JButton("Record");
		JLabel to = new JLabel("to");
		JLabel status = new JLabel("Waiting...");
		JLabel inText = new JLabel("Input: ");
		JLabel outText = new JLabel("Output: ");
		String curOutLang, curInLang;

		public Graphics() {
			setLayout(new GridBagLayout());
			
			inLang.setSelectedIndex(0);
			outLang.setSelectedIndex(0);

			inLang.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					curInLang = inLang.getItemAt(inLang.getSelectedIndex());
				}

			});

			outLang.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					curOutLang = outLang.getItemAt(outLang.getSelectedIndex());
				}

			});
			
			record.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					record();
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
			
			inLang.setVisible(true);
			outLang.setVisible(true);
			to.setVisible(true);
			record.setVisible(true);
			inText.setVisible(true);
			outText.setVisible(true);
		}

	}

}