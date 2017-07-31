
public class Verb extends Word{
	String tense;	//Possible Tenses to Begin With: Past, Present, Future, Continuous 
	
	public Verb(int id, String word, String language, String tense) {
		super(id, word, language, "verb");
		this.tense = tense;
	}

}
