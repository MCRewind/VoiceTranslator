
public class SpnUtils {
	
	public static final String[] SUBJECTS = {"yo","tu","él","ella","usted","nosotros","vosotros","ellos","ellas","ustedes"};

	public static String conjugator(String word, String tense, String ending, String conjugation, boolean irregular, int length){
		String conjVerb = "";

		//Conjugations for past tense (preterite) in 'ir' 'ar' 'er' forms
		if (tense == "past"){
			if ((ending.equals("ir") || (ending.equals("er"))) && irregular == false){
				if (conjugation.equals(SpnUtils.SUBJECTS[0])){
					conjVerb = word.substring(length- 1) + "í";
				}
				if (conjugation.equals(SpnUtils.SUBJECTS[1])){
					conjVerb = word.substring(length- 1) + "iste";
				}
				if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
					conjVerb = word.substring(length- 1) + "ió";
				}
				if (conjugation.equals(SpnUtils.SUBJECTS[5])){
					conjVerb = word.substring(length- 1) + "imos";
				}
				if (conjugation.equals(SpnUtils.SUBJECTS[6])){
					conjVerb = word.substring(length- 1) + "isteis";
				}
				if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
					conjVerb = word.substring(length- 1) + "ieron";
				}
			}
			if (ending.equals("ar") && irregular == false){
				if (conjugation.equals(SpnUtils.SUBJECTS[0])){
					conjVerb = word.substring(length- 1) + "é";
				}
				if (conjugation.equals(SpnUtils.SUBJECTS[1])){
					conjVerb = word.substring(length- 1) + "aste";
				}
				if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
					conjVerb = word.substring(length- 1) + "ó";
				}
				if (conjugation.equals(SpnUtils.SUBJECTS[5])){
					conjVerb = word.substring(length- 1) + "amos";
				}
				if (conjugation.equals(SpnUtils.SUBJECTS[6])){
					conjVerb = word.substring(length- 1) + "asteis";
				}
				if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
					conjVerb = word.substring(length- 1) + "aron";
				}
			}
		}

		//Conjugations for present tense in 'ir' 'ar' 'er' forms
		if (tense == "present"){
			if (ending.equals("ir") && irregular == false){
				if (conjugation.equals(SpnUtils.SUBJECTS[0])){
					conjVerb = word.substring(length- 1) + "o";
				}
				if (conjugation.equals(SpnUtils.SUBJECTS[1])){
					conjVerb = word.substring(length- 1) + "es";
				}
				if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
					conjVerb = word.substring(length- 1) + "e";
				}
				if (conjugation.equals(SpnUtils.SUBJECTS[5])){
					conjVerb = word.substring(length- 1) + "imos";
				}
				if (conjugation.equals(SpnUtils.SUBJECTS[6])){
					conjVerb = word.substring(length- 1) + "ís";
				}
				if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
					conjVerb = word.substring(length- 1) + "en";
				}
			}
			if (ending.equals("ar") && irregular == false){
				if (conjugation.equals(SpnUtils.SUBJECTS[0])){
					conjVerb = word.substring(length- 1) + "o";
				}
				if (conjugation.equals(SpnUtils.SUBJECTS[1])){
					conjVerb = word.substring(length- 1) + "as";
				}
				if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
					conjVerb = word.substring(length- 1) + "a";
				}
				if (conjugation.equals(SpnUtils.SUBJECTS[5])){
					conjVerb = word.substring(length- 1) + "amos";
				}
				if (conjugation.equals(SpnUtils.SUBJECTS[6])){
					conjVerb = word.substring(length- 1) + "áis";
				}
				if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
					conjVerb = word.substring(length- 1) + "an";
				}
			}
			if (ending.equals("er") && irregular == false){
				if (conjugation.equals(SpnUtils.SUBJECTS[0])){
					conjVerb = word.substring(length- 1) + "e";
				}
				if (conjugation.equals(SpnUtils.SUBJECTS[1])){
					conjVerb = word.substring(length- 1) + "es";
				}
				if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
					conjVerb = word.substring(length- 1) + "e";
				}
				if (conjugation.equals(SpnUtils.SUBJECTS[5])){
					conjVerb = word.substring(length- 1) + "emos";
				}
				if (conjugation.equals(SpnUtils.SUBJECTS[6])){
					conjVerb = word.substring(length- 1) + "éis";
				}
				if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
					conjVerb = word.substring(length- 1) + "en";
				}
			}
		}

		//Conjugations for future tense in 'ir' 'ar' 'er' forms
		if (tense == "future"){
			if (irregular == false){
				if (conjugation.equals(SpnUtils.SUBJECTS[0])){
					conjVerb = word.substring(length- 1) + "é";
				}
				if (conjugation.equals(SpnUtils.SUBJECTS[1])){
					conjVerb = word.substring(length- 1) + "ás";
				}
				if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
					conjVerb = word.substring(length- 1) + "á";
				}
				if (conjugation.equals(SpnUtils.SUBJECTS[5])){
					conjVerb = word.substring(length- 1) + "emos";
				}
				if (conjugation.equals(SpnUtils.SUBJECTS[6])){
					conjVerb = word.substring(length- 1) + "éis";
				}
				if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
					conjVerb = word.substring(length- 1) + "án";
				}
			}
		}

		//Conjugations for continuous tense in 'ir' 'ar' 'er' forms
		if (tense == "continuous"){
			if (ending.equals("ar") && irregular == false){
				conjVerb = word.substring(length- 1) + "ando";
			}
			if ((ending.equals("ir") || (ending.equals("er"))) && irregular == false){
				conjVerb = word.substring(length- 1) + " endo";
			}
		}
		return conjVerb;
	}
	
}
