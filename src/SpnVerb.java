
public class SpnVerb extends Verb{
	String ending; //Substring of the ending of verbs. Can be "ir", "ar", or "er"
	String conjugation;
	boolean irregular;


	public SpnVerb(int id, String word, String language, String tense, String ending, boolean irregular) {
		super(id, word, language, tense);
		this.ending = ending;
		this.irregular = irregular; 
		/* For Irregulars, Need to check substrings and whole words
		 * Known irregulars: 
		 * Preterite Tense: Ser, Ver, Ir, Dar, Andar, Conducir, Decir, Estar, Hacer, Poner, Poder, Querer, Saber, Tener, Traer, Venir
		 * Present Tense Yo Forms: Caer, Traer, Hacer, Poner, Saber, Salir, Valer, Ver, Conocer, Dar, Caber, Traducir
		 * Present Tense All Forms: Ser, Estar, Ir, Haber
		 * Present Tense Yo Special Rules: 
		 * For every verb that ends in ir: 
		 * if the verb ends in guir - ending becomes "go" (Replace uir with o)
		 * if the verb ends in ger or gir - ending becomes jo (Replace ger or gir with jo)
		 * Future Tense: Caber, Decir, Haber, Hacer, Poder, Poner, Querer, Saber, Salir, Tener, Valer, Venir
		 */
	}	

	public void setConj(String conjugation){
		this.conjugation = conjugation;
	}

	public String conjugator(){
		String conjVerb = "";

		//Conjugations for past tense (preterite) in 'ir' 'ar' 'er' forms
		if (tense == "past"){
			if ((ending.equals("ir") || (ending.equals("er"))) && irregular == false){
				if (conjugation.equals(SpnSubjects.SUBJECTS[0])){
					conjVerb = super.word.substring(super.word.length() - 1) + "í";
				}
				if (conjugation.equals(SpnSubjects.SUBJECTS[1])){
					conjVerb = super.word.substring(super.word.length() - 1) + "iste";
				}
				if (conjugation.equals(SpnSubjects.SUBJECTS[2]) || conjugation.equals(SpnSubjects.SUBJECTS[3]) || conjugation.equals(SpnSubjects.SUBJECTS[4])){
					conjVerb = super.word.substring(super.word.length() - 1) + "ió";
				}
				if (conjugation.equals(SpnSubjects.SUBJECTS[5])){
					conjVerb = super.word.substring(super.word.length() - 1) + "imos";
				}
				if (conjugation.equals(SpnSubjects.SUBJECTS[6])){
					conjVerb = super.word.substring(super.word.length() - 1) + "isteis";
				}
				if (conjugation.equals(SpnSubjects.SUBJECTS[7]) || conjugation.equals(SpnSubjects.SUBJECTS[8]) || conjugation.equals(SpnSubjects.SUBJECTS[9])){
					conjVerb = super.word.substring(super.word.length() - 1) + "ieron";
				}
			}
			if (ending.equals("ar") && irregular == false){
				if (conjugation.equals(SpnSubjects.SUBJECTS[0])){
					conjVerb = super.word.substring(super.word.length() - 1) + "é";
				}
				if (conjugation.equals(SpnSubjects.SUBJECTS[1])){
					conjVerb = super.word.substring(super.word.length() - 1) + "aste";
				}
				if (conjugation.equals(SpnSubjects.SUBJECTS[2]) || conjugation.equals(SpnSubjects.SUBJECTS[3]) || conjugation.equals(SpnSubjects.SUBJECTS[4])){
					conjVerb = super.word.substring(super.word.length() - 1) + "ó";
				}
				if (conjugation.equals(SpnSubjects.SUBJECTS[5])){
					conjVerb = super.word.substring(super.word.length() - 1) + "amos";
				}
				if (conjugation.equals(SpnSubjects.SUBJECTS[6])){
					conjVerb = super.word.substring(super.word.length() - 1) + "asteis";
				}
				if (conjugation.equals(SpnSubjects.SUBJECTS[7]) || conjugation.equals(SpnSubjects.SUBJECTS[8]) || conjugation.equals(SpnSubjects.SUBJECTS[9])){
					conjVerb = super.word.substring(super.word.length() - 1) + "aron";
				}
			}
		}

		//Conjugations for present tense in 'ir' 'ar' 'er' forms
		if (tense == "present"){
			if (ending.equals("ir") && irregular == false){
				if (conjugation.equals(SpnSubjects.SUBJECTS[0])){
					conjVerb = super.word.substring(super.word.length() - 1) + "o";
				}
				if (conjugation.equals(SpnSubjects.SUBJECTS[1])){
					conjVerb = super.word.substring(super.word.length() - 1) + "es";
				}
				if (conjugation.equals(SpnSubjects.SUBJECTS[2]) || conjugation.equals(SpnSubjects.SUBJECTS[3]) || conjugation.equals(SpnSubjects.SUBJECTS[4])){
					conjVerb = super.word.substring(super.word.length() - 1) + "e";
				}
				if (conjugation.equals(SpnSubjects.SUBJECTS[5])){
					conjVerb = super.word.substring(super.word.length() - 1) + "imos";
				}
				if (conjugation.equals(SpnSubjects.SUBJECTS[6])){
					conjVerb = super.word.substring(super.word.length() - 1) + "ís";
				}
				if (conjugation.equals(SpnSubjects.SUBJECTS[7]) || conjugation.equals(SpnSubjects.SUBJECTS[8]) || conjugation.equals(SpnSubjects.SUBJECTS[9])){
					conjVerb = super.word.substring(super.word.length() - 1) + "en";
				}
			}
			if (ending.equals("ar") && irregular == false){
				if (conjugation.equals(SpnSubjects.SUBJECTS[0])){
					conjVerb = super.word.substring(super.word.length() - 1) + "o";
				}
				if (conjugation.equals(SpnSubjects.SUBJECTS[1])){
					conjVerb = super.word.substring(super.word.length() - 1) + "as";
				}
				if (conjugation.equals(SpnSubjects.SUBJECTS[2]) || conjugation.equals(SpnSubjects.SUBJECTS[3]) || conjugation.equals(SpnSubjects.SUBJECTS[4])){
					conjVerb = super.word.substring(super.word.length() - 1) + "a";
				}
				if (conjugation.equals(SpnSubjects.SUBJECTS[5])){
					conjVerb = super.word.substring(super.word.length() - 1) + "amos";
				}
				if (conjugation.equals(SpnSubjects.SUBJECTS[6])){
					conjVerb = super.word.substring(super.word.length() - 1) + "áis";
				}
				if (conjugation.equals(SpnSubjects.SUBJECTS[7]) || conjugation.equals(SpnSubjects.SUBJECTS[8]) || conjugation.equals(SpnSubjects.SUBJECTS[9])){
					conjVerb = super.word.substring(super.word.length() - 1) + "an";
				}
			}
			if (ending.equals("er") && irregular == false){
				if (conjugation.equals(SpnSubjects.SUBJECTS[0])){
					conjVerb = super.word.substring(super.word.length() - 1) + "e";
				}
				if (conjugation.equals(SpnSubjects.SUBJECTS[1])){
					conjVerb = super.word.substring(super.word.length() - 1) + "es";
				}
				if (conjugation.equals(SpnSubjects.SUBJECTS[2]) || conjugation.equals(SpnSubjects.SUBJECTS[3]) || conjugation.equals(SpnSubjects.SUBJECTS[4])){
					conjVerb = super.word.substring(super.word.length() - 1) + "e";
				}
				if (conjugation.equals(SpnSubjects.SUBJECTS[5])){
					conjVerb = super.word.substring(super.word.length() - 1) + "emos";
				}
				if (conjugation.equals(SpnSubjects.SUBJECTS[6])){
					conjVerb = super.word.substring(super.word.length() - 1) + "éis";
				}
				if (conjugation.equals(SpnSubjects.SUBJECTS[7]) || conjugation.equals(SpnSubjects.SUBJECTS[8]) || conjugation.equals(SpnSubjects.SUBJECTS[9])){
					conjVerb = super.word.substring(super.word.length() - 1) + "en";
				}
			}
		}

		//Conjugations for future tense in 'ir' 'ar' 'er' forms
		if (tense == "future"){
			if (irregular == false){
				if (conjugation.equals(SpnSubjects.SUBJECTS[0])){
					conjVerb = super.word.substring(super.word.length() - 1) + "é";
				}
				if (conjugation.equals(SpnSubjects.SUBJECTS[1])){
					conjVerb = super.word.substring(super.word.length() - 1) + "ás";
				}
				if (conjugation.equals(SpnSubjects.SUBJECTS[2]) || conjugation.equals(SpnSubjects.SUBJECTS[3]) || conjugation.equals(SpnSubjects.SUBJECTS[4])){
					conjVerb = super.word.substring(super.word.length() - 1) + "á";
				}
				if (conjugation.equals(SpnSubjects.SUBJECTS[5])){
					conjVerb = super.word.substring(super.word.length() - 1) + "emos";
				}
				if (conjugation.equals(SpnSubjects.SUBJECTS[6])){
					conjVerb = super.word.substring(super.word.length() - 1) + "éis";
				}
				if (conjugation.equals(SpnSubjects.SUBJECTS[7]) || conjugation.equals(SpnSubjects.SUBJECTS[8]) || conjugation.equals(SpnSubjects.SUBJECTS[9])){
					conjVerb = super.word.substring(super.word.length() - 1) + "án";
				}
			}
		}

		//Conjugations for continuous tense in 'ir' 'ar' 'er' forms
		if (tense == "continuous"){
			if (ending.equals("ar") && irregular == false){
				conjVerb = super.word.substring(super.word.length() - 1) + "ando";
			}
			if ((ending.equals("ir") || (ending.equals("er"))) && irregular == false){
				conjVerb = super.word.substring(super.word.length() - 1) + " endo";
			}
		}
		return conjVerb;
	}
}
