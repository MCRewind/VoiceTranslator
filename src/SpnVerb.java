
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
		 * Still dont have stem changers or reflexives being taken into account here
		 * Stem Changers (In Preterite Tense, only ir stem changers stem change. Never in Future, In Progressive, only ir):
		 * 	Present:
		 * 		e:ie - acertar, encender, advertir, entender, cerrar, fregar, comenzar, hervir, confesar, mentir, consentir, negar, converter, pensar, defender, perder, empezar, preferir
		 * 		e:i - bendecir, impedir, colegir, maldecir, competir, medir, conseguir, pedir, corregir, perseguir, decir, reír, despedir, repetir, elegir, seguir, freír, servir, gemir, sonreír
		 *		o:ue - almorzar, morir, aprobar, mostrar, colgar, mover, contar, probar, costar, recordar, devolver, resolver, vovler, rogar, dormir, sonar, encontrar, soñar, envolver, tostar, morder, volar
		 *	Past:
		 *		ir verbs - dormir, servir, preferir, seguir, sentir, pedir, convertir, morir, repetir
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
