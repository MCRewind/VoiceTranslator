import java.util.ArrayList;
import java.util.HashMap;

public class Phrase{
	HashMap<String, String> phrases = new HashMap<String, String>(); //Key is base words, Value is completed phrase
	ArrayList<String> words; //When running phraseChecker, this will be where we save the current words that possibly make a phrase

	public String phraseChecker(String word){
		int i = -1;
		for (String phrase : phrases.values()){
			i++;
			String[] phraseWords = phrase.split(" ");
			if (phrases.get(words.toString()) != null){
				return phrases.get(words.toString());
			} else if (word.equals(phraseWords[i])){
				words.add(word);
				return "true";
			} else {
				return "false";
			}
		}
		return "false";	
	}
}
