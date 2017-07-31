
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

}
