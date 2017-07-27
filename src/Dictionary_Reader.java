import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class Dictionary_Reader {

	public HashMap<String, String> engFrnMap = new HashMap<String, String>();
	public HashMap<String, String> engSpnMap = new HashMap<String, String>();
	public HashMap<String, String> spnEngMap = new HashMap<String, String>();
	public HashMap<String, String> spnFrnMap = new HashMap<String, String>();
	public HashMap<String, String> frnEngMap = new HashMap<String, String>();
	public HashMap<String, String> frnSpnMap = new HashMap<String, String>();


	public void spanishCleaner(String file, HashMap<String, String> map){
		String line = null;

		try {
			//Makes readers to cycle through the dictionary file
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));

			/*Establishes line and creates an array of strings that 
			holds the English word and the corresponding word */
			line = bufferedReader.readLine();

			/*Checks whether there is a line to read, if there is: 
			goes through the array of strings putting the 
			English word and its equivalent in the HashMap*/
			//int lineNumb = 1;
			while( (line = bufferedReader.readLine()) != null) {
				//System.out.println(lineNumb);
				//lineNumb += 1;
				String[] spanishWords = null;
				String[] words = line.split("	");
				if (words[1] != null) {
					spanishWords = words[1].split(" ; ");
				}

				//System.out.println(words[0]);

				String plural = null;

				if(words[1].substring(words[1].length()) == "s" || words[1].substring(words[1].length()) == "h" || words[1].substring(words[1].length()) == "x" || words[1].substring(words[1].length()) == "z") {
					plural = words[1] + "es";
				} else {
					plural = words[1] + "s";
				}

				/*Separates each Spanish word into individuals chars so 
				that if they have a special character instruction (n~ , a/),
				the actual character can be input (ñ , á)*/
				String engPlural = words[0] + "s";

				map.put(words[0], spanishWords[0].toLowerCase());
				map.put(engPlural, plural.toLowerCase());
			}

			bufferedReader.close();

		} catch(FileNotFoundException ex) {
			System.out.println(
					"Unable to open file '" + 
							file + "'");                
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
	}

	public void frenchCleaner(String file, HashMap<String, String> map){
		String line = null;

		try {
			//Makes readers to cycle through the dictionary file
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));

			/*Establishes line and creates an array of strings that 
				holds the English word and the corresponding word */
			line = bufferedReader.readLine();

			/*Checks whether there is a line to read, if there is: 
				goes through the array of strings putting the 
				English word and its equivalent in the HashMap*/
			//int lineNumb = 1;
			while( (line = bufferedReader.readLine()) != null) {
				//System.out.println(lineNumb);
				//lineNumb += 1;
				String[] frenchWords = {""};
				String[] words = line.split("	");
				if (words[1] != null) {
					if (line.contains(";")) {
						frenchWords = words[1].split(" ; ");
					} else if (line.contains(",")) {
						frenchWords = words[1].split(", ");
					} else {
						frenchWords[0] = words[1];
					}
				}

				String plural = null;

				if(words[1].substring(words[1].length()) == "au") {
					plural = words[1] + "x";
				} else if (words[1].substring(words[1].length()) == "ou") {
					if (words[1] == "bijou" || words[1] == "chou" || words[1] == "caillou" || words[1] == "joujou" || words[1] == "genou" || words[1] == "pou" || words[1] == "hibou") {
						plural = words[1] + "x";
					}
				} else if (words[1].substring(words[1].length()) == "al") {
					plural = (words[1].substring(words[1].length()-1) + "ux"); 
				} else if (!(words[1].substring(words[1].length()) == "s" || words[1].substring(words[1].length()) == "x" || words[1].substring(words[1].length()) == "z")) {
					plural = words[1] + "s";
				}

				/*Separates each Spanish word into individuals chars so 
					that if they have a special character instruction (n~ , a/),
					the actual character can be input (ñ , á)*/
				String engPlural = words[0] + "s";

				map.put(words[0], frenchWords[0].toLowerCase());
				map.put(engPlural, plural.toLowerCase());
			}

			bufferedReader.close();

		}


		catch(FileNotFoundException ex) {
			System.out.println(
					"Unable to open file '" + 
							file + "'");                
		}
		catch(IOException ex) {
			ex.printStackTrace();
		} 
	}

	public HashMap<String, String> dictInverter (HashMap<String, String> map){
		HashMap<String, String> invertedMap = new HashMap<String, String>();
		map.forEach((key, value) -> {
			invertedMap.put(value, key);
		});
		return invertedMap;
	}

	public void write(String fileName, HashMap<String, String> map) {
		try {
			BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "UTF-8"));
			for (String key : map.keySet()){
				bufferedWriter.write(key);
				bufferedWriter.write("	");
				bufferedWriter.write(map.get(key));
				bufferedWriter.newLine();	
			}
			System.out.println("done");
			bufferedWriter.close();
		}
		catch (IOException ex){
		}
	}
	
	public HashMap<String,String> dictMaker (HashMap<String, String> first, HashMap<String, String> second){
		HashMap<String, String> newDict = new HashMap<String, String>();
		for (Map.Entry<String, String> entry : first.entrySet()){
			String firstKey = entry.getKey();
			String firstValue = entry.getValue();
		//	System.out.println(firstKey + "First Map!");
			int firstHash = System.identityHashCode(firstKey);
			for (Map.Entry<String, String> entry2 : second.entrySet()){
				String secondKey = entry2.getKey();
				String secondValue = entry2.getValue();
		//		System.out.println(secondKey);
				int secondHash = System.identityHashCode(secondKey);
				if (firstKey.equals(secondKey)){
					newDict.put(firstValue, secondValue);
				}
			}
		}
		return newDict;
	}
}