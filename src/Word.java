
public class Word {
	int id;
	String word;
	String language;
	
	
	public Word(int id, String word, String language){
		this.id = id;
		this.word = word;
		this.language = language;
	}

	public int getID(){
		return id;
	}
	
	public String getWord(){
		return word;
	}
	
	public String getLanguage(){
		return language;
	}
	

}
