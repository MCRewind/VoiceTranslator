
public class Word {
	int id;
	String word;
	String plural;
	String grammarType;
	String language;
	boolean gender; //True is Male, False is Female	(Will be set to false if gender cannot be applied to word)
	
	
	public Word(int id, String word, String language){
		this.id = id;
		this.word = word;
		this.plural = plural;
		this.language = language;
		this.gender = gender;
	}

	public int getID(){
		return id;
	}
	
	public String getWord(){
		return word;
	}
	
	public String getPlural(){
		return plural;
	}
	
	public String getGramType(){
		return grammarType;
	}
	
	public String getLanguage(){
		return language;
	}
	
	public boolean getGender(){
		return gender;
	}
}
