
public class Word {
	int id;
	String word;
	String language;
	String pos;
	
	public Word(int id, String word, String language, String pos){
		this.id = id;
		this.word = word;
		this.language = language;
		this.pos = pos;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPos() {
		return pos;
	}

	public void setPos(String pos) {
		this.pos = pos;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	
}
