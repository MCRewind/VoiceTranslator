
public class Noun extends Word{
	
	String plural;
	boolean gender; //True is Male, False is Female	(Will be set to false if gender cannot be applied to word)


	public Noun(int id, String word, String language, String plural, boolean gender) {
		super(id, word, language, "noun", false);
		this.plural = plural;
		this.gender = gender;
	}
	
	public String getPlural(){
		return plural;
	}
	
	public boolean getGender(){
		return gender;
	}

}
