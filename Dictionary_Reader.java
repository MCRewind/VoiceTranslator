import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class Dictionary_Reader {

	public static void main(String[] args) {
		//dictReader("clean-eng-to-spn-version-final.txt");
		cleaner("Eng to Spn.txt");
	}

	public static void dictReader(String file){
		HashMap<String, String> dictMap = new HashMap<String, String>();
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
			while((line = bufferedReader.readLine()) != null) {
				String[] words = line.split("	");
				String[] spanishWords = words[1].split(",");
				dictMap.put(words[0], spanishWords[0]);


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
		System.out.println(dictMap.keySet());
		System.out.println(dictMap.values());
	}

	public static void cleaner(String file){
		HashMap<String,String> dictMap = new HashMap<String, String>();
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
				String[] words = line.split("	");
				String[] spanishWords = words[1].split(",");

				/*Separates each Spanish word into individuals chars so 
				that if they have a special character instruction (n~ , a/),
				the actual character can be input (ñ , á)*/
				char[] letters = spanishWords[0].toCharArray();
				for (int a = 0; a < letters.length ; a ++){
					//Checks for the special case with tilde over n
					if (letters[a] == '~'){
						//Creates a new ArrayList of characters which won't contain the instructions
						ArrayList<Character> newLetters = new ArrayList<Character>();
						//Filters out the instructions
						for (char character : letters){
							if (character != '~'){
								newLetters.add(character);
							}
						}
						//Replaces the regular letter with the conjugated version
						newLetters.set(a - 1,'ñ');
						String newWord = "";
						for (char character : newLetters){
							newWord += character;
						}
						spanishWords[0] = newWord;
					}
				}
				dictMap.put(words[0], spanishWords[0].toLowerCase());
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
		//System.out.println(dictMap.keySet());
		//System.out.println(dictMap.values());
		
		/*
		try {
			PrintWriter printWriter = new PrintWriter("clean-eng-to-spn-version-4.txt");
			BufferedWriter bufferedWriter = new BufferedWriter(printWriter);

			for (String key : dictMap.keySet()){
				bufferedWriter.write(key);
				bufferedWriter.write("	");
				bufferedWriter.write(dictMap.get(key));
				bufferedWriter.newLine();	
			}

			bufferedWriter.close();
		}

		catch (IOException ex){

		}
		*/
	}
}
