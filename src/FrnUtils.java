	
public class FrnUtils {

	static final String[] SUBJECTS = {"je", "tu", "il", "nous", "vous", "ils"};

	public static String conjugator(String word, String tense, String ending, String conjugation, boolean irregular, int length){
		String conjVerb = "";
		if (tense.equals("past")) {
			if (!irregular) {
				if (ending.equals("er")) {
					if (conjugation.equals(SUBJECTS[0]))
						conjVerb = word.subSequence(0,  length-2)+"ai";
					else if (conjugation.equals(SUBJECTS[1]))
						conjVerb = word.subSequence(0,  length-2)+"as";
					else if (conjugation.equals(SUBJECTS[2]))
						conjVerb = word.subSequence(0,  length-2)+"a";
					else if (conjugation.equals(SUBJECTS[3]))
						conjVerb = word.subSequence(0,  length-2)+"âmes";
					else if (conjugation.equals(SUBJECTS[4]))
						conjVerb = word.subSequence(0,  length-2)+"âtes";
					else if (conjugation.equals(SUBJECTS[5]))
						conjVerb = word.subSequence(0,  length-2)+"èrent";
				} else if (ending.equals("ir")) {
					if (conjugation.equals(SUBJECTS[0]))
						conjVerb = word.subSequence(0,  length-2)+"is";
					else if (conjugation.equals(SUBJECTS[1]))
						conjVerb = word.subSequence(0,  length-2)+"is";
					else if (conjugation.equals(SUBJECTS[2]))
						conjVerb = word.subSequence(0,  length-2)+"it";
					else if (conjugation.equals(SUBJECTS[3]))
						conjVerb = word.subSequence(0,  length-2)+"issons";
					else if (conjugation.equals(SUBJECTS[4]))
						conjVerb = word.subSequence(0,  length-2)+"issez";
					else if (conjugation.equals(SUBJECTS[5]))
						conjVerb = word.subSequence(0,  length-2)+"issent";
				} else if (ending.equals("re")) {
					if (conjugation.equals(SUBJECTS[0]))
						conjVerb = word.subSequence(0,  length-2)+"s";
					else if (conjugation.equals(SUBJECTS[1]))
						conjVerb = word.subSequence(0,  length-2)+"s";
					else if (conjugation.equals(SUBJECTS[2]))
						conjVerb = word.subSequence(0,  length-2)+"";
					else if (conjugation.equals(SUBJECTS[3]))
						conjVerb = word.subSequence(0,  length-2)+"ons";
					else if (conjugation.equals(SUBJECTS[4]))
						conjVerb = word.subSequence(0,  length-2)+"ez";
					else if (conjugation.equals(SUBJECTS[5]))
						conjVerb = word.subSequence(0,  length-2)+"ent";
				}
			} else {
				
			}
		}

		if (tense.equals("present")) {
			if (!irregular) {
				if (ending.equals("er")) {
					if (conjugation.equals(SUBJECTS[0]))
						conjVerb = word.subSequence(0,  length-2)+"e";
					else if (conjugation.equals(SUBJECTS[1]))
						conjVerb = word.subSequence(0,  length-2)+"es";
					else if (conjugation.equals(SUBJECTS[2]))
						conjVerb = word.subSequence(0,  length-2)+"e";
					else if (conjugation.equals(SUBJECTS[3]))
						conjVerb = word.subSequence(0,  length-2)+"onz";
					else if (conjugation.equals(SUBJECTS[4]))
						conjVerb = word.subSequence(0,  length-2)+"ez";
					else if (conjugation.equals(SUBJECTS[5]))
						conjVerb = word.subSequence(0,  length-2)+"ent";
				} else if (ending.equals("ir")) {
					if (conjugation.equals(SUBJECTS[0]))
						conjVerb = word.subSequence(0,  length-2)+"is";
					else if (conjugation.equals(SUBJECTS[1]))
						conjVerb = word.subSequence(0,  length-2)+"is";
					else if (conjugation.equals(SUBJECTS[2]))
						conjVerb = word.subSequence(0,  length-2)+"it";
					else if (conjugation.equals(SUBJECTS[3]))
						conjVerb = word.subSequence(0,  length-2)+"issons";
					else if (conjugation.equals(SUBJECTS[4]))
						conjVerb = word.subSequence(0,  length-2)+"issez";
					else if (conjugation.equals(SUBJECTS[5]))
						conjVerb = word.subSequence(0,  length-2)+"issent";
				} else if (ending.equals("re")) {
					if (conjugation.equals(SUBJECTS[0]))
						conjVerb = word.subSequence(0,  length-2)+"s";
					else if (conjugation.equals(SUBJECTS[1]))
						conjVerb = word.subSequence(0,  length-2)+"s";
					else if (conjugation.equals(SUBJECTS[2]))
						conjVerb = word.subSequence(0,  length-2)+"";
					else if (conjugation.equals(SUBJECTS[3]))
						conjVerb = word.subSequence(0,  length-2)+"ons";
					else if (conjugation.equals(SUBJECTS[4]))
						conjVerb = word.subSequence(0,  length-2)+"ez";
					else if (conjugation.equals(SUBJECTS[5]))
						conjVerb = word.subSequence(0,  length-2)+"ent";
				}
			} else {
				
			}
		}

		if (tense.equals("imperfect")) {
			if (!irregular) {
				if (ending.equals("er")) {
					if (conjugation.equals(SUBJECTS[0]))
						conjVerb = word.subSequence(0,  length-2)+"ais";
					else if (conjugation.equals(SUBJECTS[1]))
						conjVerb = word.subSequence(0,  length-2)+"ais";
					else if (conjugation.equals(SUBJECTS[2]))
						conjVerb = word.subSequence(0,  length-2)+"ait";
					else if (conjugation.equals(SUBJECTS[3]))
						conjVerb = word.subSequence(0,  length-2)+"ions";
					else if (conjugation.equals(SUBJECTS[4]))
						conjVerb = word.subSequence(0,  length-2)+"iez";
					else if (conjugation.equals(SUBJECTS[5]))
						conjVerb = word.subSequence(0,  length-2)+"aient";
				} else if (ending.equals("ir")) {
					if (conjugation.equals(SUBJECTS[0]))
						conjVerb = word.subSequence(0,  length-2)+"is";
					else if (conjugation.equals(SUBJECTS[1]))
						conjVerb = word.subSequence(0,  length-2)+"is";
					else if (conjugation.equals(SUBJECTS[2]))
						conjVerb = word.subSequence(0,  length-2)+"it";
					else if (conjugation.equals(SUBJECTS[3]))
						conjVerb = word.subSequence(0,  length-2)+"issons";
					else if (conjugation.equals(SUBJECTS[4]))
						conjVerb = word.subSequence(0,  length-2)+"issez";
					else if (conjugation.equals(SUBJECTS[5]))
						conjVerb = word.subSequence(0,  length-2)+"issent";
				} else if (ending.equals("re")) {
					if (conjugation.equals(SUBJECTS[0]))
						conjVerb = word.subSequence(0,  length-2)+"s";
					else if (conjugation.equals(SUBJECTS[1]))
						conjVerb = word.subSequence(0,  length-2)+"s";
					else if (conjugation.equals(SUBJECTS[2]))
						conjVerb = word.subSequence(0,  length-2)+"";
					else if (conjugation.equals(SUBJECTS[3]))
						conjVerb = word.subSequence(0,  length-2)+"ons";
					else if (conjugation.equals(SUBJECTS[4]))
						conjVerb = word.subSequence(0,  length-2)+"ez";
					else if (conjugation.equals(SUBJECTS[5]))
						conjVerb = word.subSequence(0,  length-2)+"ent";
				}
			} else {
				
			}
		}

		if (tense.equals("future")) {

		}

		if (tense.equals("conditional")) {

		}

		if (tense.equals("subjunctive")) {

		}

		if (tense.equals("preterite")) {

		}

		if (tense.equals("continuous")) {

		}

		return conjVerb;
	}

}