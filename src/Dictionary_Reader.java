import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Dictionary_Reader {
	
	public HashMap<String, String> dictMap = new HashMap<String, String>();
	public HashMap<String, String> inverseMap = new HashMap<String, String>();
	
	public void cleaner(String file){
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

				System.out.println(words[0]);
				
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
				
				dictMap.put(words[0], spanishWords[0].toLowerCase());
				dictMap.put(engPlural, plural.toLowerCase());
			}

			bufferedReader.close();
			dictMap.forEach((key, value) -> {
				inverseMap.put(value, key);
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
