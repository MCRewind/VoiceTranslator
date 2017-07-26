import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Dictionary_Reader {

	public HashMap<String, String> engSpnMap = new HashMap<String, String>();
	public HashMap<String, String> spnEngMap = new HashMap<String, String>();
	public HashMap<String, String> engFrnMap = new HashMap<String, String>();
	public HashMap<String, String> frnEngMap = new HashMap<String, String>();


	public void spanishCleaner(String file){
		String line = null;

		try {
			//Makes readers to cycle through the dictionary file
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

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

				engSpnMap.put(words[0], spanishWords[0].toLowerCase());
				engSpnMap.put(engPlural, plural.toLowerCase());
			}

			bufferedReader.close();
			engSpnMap.forEach((key, value) -> {
				spnEngMap.put(value, key);
			});
		} catch(FileNotFoundException ex) {
			System.out.println(
					"Unable to open file '" + 
							file + "'");                
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
	}

	public void frenchCleaner(String file){
		String line = null;

		try {
			//Makes readers to cycle through the dictionary file
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

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
				String[] frenchWords = {"j"};
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

				System.out.println(words[1]);
				
				//System.out.println(words[0]);

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

				engFrnMap.put(words[0], frenchWords[0].toLowerCase());
				engFrnMap.put(engPlural, plural.toLowerCase());
			}

			bufferedReader.close();
			engFrnMap.forEach((key, value) -> {
				frnEngMap.put(value, key);
			});
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
}
