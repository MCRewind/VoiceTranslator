
public class SpnUtils {

	public static final String[] SUBJECTS = {"yo","tu","�l","ella","usted","nosotros","vosotros","ellos","ellas","ustedes"};

	public static String conjugator(String word, String tense, String ending, String conjugation, boolean irregular, int length){
		String conjVerb = "";
		length = word.length();
		ending = word.substring(length - 2); //This is what the ending is but I dont know if we want to set it here?

		//Conjugations for past tense (preterite) in 'ir' 'ar' 'er' forms
		if (tense.equals("past")){
			if ((ending.equals("ir")) || (ending.equals("er")) && irregular == false){
				if (conjugation.equals(SpnUtils.SUBJECTS[0])){
					conjVerb = word.subSequence(0, length - 2) + "�";
				} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
					conjVerb = word.subSequence(0, length - 2) + "iste";
				} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
					conjVerb = word.subSequence(0, length - 2) + "i�";
				} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
					conjVerb = word.subSequence(0, length - 2) + "imos";
				} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
					conjVerb = word.subSequence(0, length - 2) + "isteis";
				} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
					conjVerb = word.subSequence(0, length - 2) + "ieron";
				}
			} else if (ending.equals("ar") && irregular == false){
				if (conjugation.equals(SpnUtils.SUBJECTS[0])){
					conjVerb = word.subSequence(0, length - 2) + "�";
				} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
					conjVerb = word.subSequence(0, length - 2) + "aste";
				} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
					conjVerb = word.subSequence(0, length - 2) + "�";
				} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
					conjVerb = word.subSequence(0, length - 2) + "amos";
				} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
					conjVerb = word.subSequence(0, length - 2) + "asteis";
				} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
					conjVerb = word.subSequence(0, length - 2) + "aron";
				}
			} else if (word.substring(length - 3).equals("cir")){
				if (conjugation.equals(SpnUtils.SUBJECTS[0])){
					conjVerb = word.subSequence(0, length - 3) + "ije";
				} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
					conjVerb = word.subSequence(0, length - 3) + "ijiste";
				} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
					conjVerb = word.subSequence(0, length - 3) + "ijo";
				} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
					conjVerb = word.subSequence(0, length - 3) + "ijimos";
				} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
					conjVerb = word.subSequence(0, length - 3) + "ijisteis";
				} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
					conjVerb = word.subSequence(0, length - 3) + "ijieron";
				}
			} else {
				conjVerb = pretIrregularChecker(word, conjugation, length);
			}
		}

		//Conjugations for present tense in 'ir' 'ar' 'er' forms
		else if (tense.equals("present")){
			if (ending.equals("ir") && irregular == false){
				if (conjugation.equals(SpnUtils.SUBJECTS[0])){
					conjVerb = word.subSequence(0, length - 2) + "o";
				} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
					conjVerb = word.subSequence(0, length - 2) + "es";
				} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
					conjVerb = word.subSequence(0, length - 2) + "e";
				} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
					conjVerb = word.subSequence(0, length - 2) + "imos";
				} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
					conjVerb = word.subSequence(0, length - 2) + "�s";
				} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
					conjVerb = word.subSequence(0, length - 2) + "en";
				}
			}
			if (ending.equals("ar") && irregular == false){
				if (conjugation.equals(SpnUtils.SUBJECTS[0])){
					conjVerb = word.subSequence(0, length - 2) + "o";
				} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
					conjVerb = word.subSequence(0, length - 2) + "as";
				} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
					conjVerb = word.subSequence(0, length - 2) + "a";
				} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
					conjVerb = word.subSequence(0, length - 2) + "amos";
				} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
					conjVerb = word.subSequence(0, length - 2) + "�is";
				} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
					conjVerb = word.subSequence(0, length - 2) + "an";
				}
			}
			if (ending.equals("er") && irregular == false){
				if (conjugation.equals(SpnUtils.SUBJECTS[0])){
					conjVerb = word.subSequence(0, length - 2) + "e";
				} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
					conjVerb = word.subSequence(0, length - 2) + "es";
				} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
					conjVerb = word.subSequence(0, length - 2) + "e";
				} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
					conjVerb = word.subSequence(0, length - 2) + "emos";
				} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
					conjVerb = word.subSequence(0, length - 2) + "�is";
				} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
					conjVerb = word.subSequence(0, length - 2) + "en";
				}
			} else {
				if (word.substring(length - 4) == "guir"){
					if (conjugation.equals(SpnUtils.SUBJECTS[0])){
						conjVerb = word.subSequence(0, length - 4) + "go";
					}
				} else if (word.substring(length - 3) == "ger" || word.substring(length - 3) == "gir"){
					if (conjugation.equals(SpnUtils.SUBJECTS[0])){
						conjVerb = word.subSequence(0, length - 3) + "jo";					
					}
				} else if (word.substring(length - 3) == "cer" || word.substring(length - 4) == "ucir"){
					if (conjugation.equals(SpnUtils.SUBJECTS[0])){
						conjVerb = word.subSequence(0, length - 3) + "zco";
					}
				} else {
					conjVerb = presentIrregularChecker(word, conjugation, length);
				}
			}
		}

		//Conjugations for future tense in 'ir' 'ar' 'er' forms
		else if (tense.equals("future")){
			if (irregular == false){
				if (conjugation.equals(SpnUtils.SUBJECTS[0])){
					conjVerb = word.subSequence(0, length - 2) + "�";
				} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
					conjVerb = word.subSequence(0, length - 2) + "�s";
				} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
					conjVerb = word.subSequence(0, length - 2) + "�";
				} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
					conjVerb = word.subSequence(0, length - 2) + "emos";
				} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
					conjVerb = word.subSequence(0, length - 2) + "�is";
				} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
					conjVerb = word.subSequence(0, length - 2) + "�n";
				}
			} else {
				conjVerb = futureIrregularChecker(word, conjugation, length);
			}
		}

		//Conjugations for continuous tense in 'ir' 'ar' 'er' forms
		else if (tense.equals("continuous")){
			if (irregular == false){
				if (ending.equals("ar")){
					conjVerb = word.subSequence(0, length - 2) + "ando";
				}
				if ((ending.equals("ir")) || (ending.equals("er"))){
					conjVerb = word.subSequence(0, length - 2) + "iendo";
				}
			} else {
				conjVerb = progressiveIrregularChecker(word, length);
				if (conjVerb.equals("")){
					if ((ending ==  "er" || ending == "ir") && irregular == true){
						conjVerb = word.subSequence(0, length - 2) + "yendo";
					}
				}
			}
		}
		return conjVerb;
	}

	static String pretIrregularChecker(String word, String conjugation, int length){
		String conjVerb = "";

		if (word.equals("ser") || word.equals("ir")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "fui";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "fuiste";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "fue";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "fuimos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "fuisteis";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "fueron";
			}
		} else if (word.equals("dar")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "di";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "diste";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "dio";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "dimos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "disteis";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "dieron";
			}
		} else if (word.equals("ver")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "vi";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "viste";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "vio";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "vimos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "visteis";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "vieron";
			}
		} else if (word.equals("estar") || word.equals("andar") || word.equals("tener")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = word.subSequence(0, length - 2) + "uve";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = word.subSequence(0, length - 2) + "uviste";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = word.subSequence(0, length - 2) + "uvo";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = word.subSequence(0, length - 2) + "uvimos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = word.subSequence(0, length - 2) + "uvisteis";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = word.subSequence(0, length - 2) + "uvieron";
			}
		} else if (word.equals("hacer")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "hice";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "hiciste";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "hizo";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "hicimos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "hicisteis";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "hicieron";
			}
		} else if (word.equals("conducir")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "conduje";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "condujiste";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "condujo";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "condujimos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "condujisteis";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "condujeron";
			}
		} else if (word.equals("decir")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "dije";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "dijiste";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "dijo";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "dijimos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "dijisteis";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "dijeron";
			}
		} else if (word.equals("poner")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "puse";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "pusiste";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "puso";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "pusimos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "pusisteis";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "pusieron";
			}
		} else if (word.equals("poder")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "pude";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "pudiste";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "pudo";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "pudimos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "pudisteis";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "pudieron";
			}
		} else if (word.equals("querer")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "quise";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "quisiste";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "quiso";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "quisimos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "quisisteis";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "quisieron";
			}
		} else if (word.equals("saber")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "supe";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "supiste";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "supo";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "supimos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "supisteis";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "supieron";
			}
		} else if (word.equals("traer")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "traje";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "trajiste";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "trajo";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "trajimos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "trajsteis";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "trajeron";
			}
		} else if (word.equals("venir")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "vine";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "viniste";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "vino";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "vinimos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "vinisteis";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "vinieron";
			}
		} else if (word.equals("haber")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "hube";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "hubiste";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "hubo";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "hubimos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "hubisteis";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "hubieron";
			}
		} else if (word.equals("producir")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "produje";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "produjiste";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "produjo";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "produjimos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "produjisteis";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "produjeron";
			}
		} else if (word.equals("servir")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "serv�";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "serviste";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "sirvi�";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "servimos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "servisteis";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "sirvieron";
			}
		} else if (word.equals("dormir")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "dorm�";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "dormiste";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "durmi�";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "dormimos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "dormisteis";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "durmieron";
			}
		} else if (word.equals("preferir")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "prefer�";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "preferiste";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "prefiri�";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "preferimos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "preferisteis";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "prefirieron";
			}
		} else if (word.equals("seguir")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "sergu�";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "seguiste";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "sigui�";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "seguimos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "seguisteis";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "siguieron";
			}
		} else if (word.equals("sentir")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "sent�";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "sentiste";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "sinti�";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "sentimos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "sentisteis";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "sintieron";
			}
		} else if (word.equals("pedir")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "ped�";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "pediste";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "pidi�";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "pedimos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "pedisteis";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "pidieron";
			}
		} else if (word.equals("convertir")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "convert�";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "convertiste";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "convirti�";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "convertimos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "convertisteis";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "convirtieron";
			}
		} else if (word.equals("morir")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "mor�";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "moriste";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "muri�";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "morimos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "moristeis";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "murieron";
			}
		} else if (word.equals("repetir")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "repet�";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "repetiste";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "repiti�";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "repetimos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "repetisteis";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "repitieron";
			}
		}
		return conjVerb;
	}
	static String presentIrregularChecker(String word, String conjugation, int length){
		String conjVerb = "";
		if (word.equals("caber")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "quepo";
			}
		} else if (word.equals("caer")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "caigo";
			}
		} else if (word.equals("conocer")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "conozco";
			}
		} else if (word.equals("dar")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "doy";
			}
		} else if (word.equals("hacer")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "hago";
			}
		} else if (word.equals("poner")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "pongo";
			}
		} else if (word.equals("saber")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "s�";
			}
		} else if (word.equals("salir")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "salgo";
			}
		} else if (word.equals("traducir")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "traduzco";
			}
		} else if (word.equals("traer")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "traigo";
			}
		} else if (word.equals("valer")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "valgo";
			}
		} else if (word.equals("ver")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "veo";
			}
		} else if (word.equals("ser")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "soy";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "eres";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "es";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "somos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "sois";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "son";
			}
		} else if (word.equals("estar")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "estoy";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "est�s";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "est�";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "estamos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "est�is";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "est�n";
			}
		} else if (word.equals("ir")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "voy";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "vas";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "va";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "vamos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "vais";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "van";
			}
		} else if (word.equals("haber")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "he";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "has";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "ha";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "hemos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "hab�is";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "han";
			}
			//Beginning of e:ie stem changer verbs
		} else if (word.equals("acertar")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "acierto";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "aciertas";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "acierta";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "acertamos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "acert�is";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "aciertan";
			}
		} else if (word.equals("encender")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "enciendo";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "enciendes";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "enciende";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "encendemos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "encend�is";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "encienden";
			}
		} else if (word.equals("advertir")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "advierto";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "adviertes";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "advierte";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "advertemos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "advert�s";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "advierten";
			}
		} else if (word.equals("entender")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "entiendo";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "entiendes";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "entiende";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "entendemos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "entend�is";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "entienden";
			}
		} else if (word.equals("cerrar")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "cierro";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "cierras";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "cierra";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "cerramos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "cerr�is";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "cierran";
			}
		} else if (word.equals("fregar")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "friego";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "friegas";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "friega";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "fregamos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "freg�is";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "friegan";
			}
		} else if (word.equals("comenzar")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "comienzo";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "comienzas";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "comienza";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "comenzamos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "comenz�is";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "comienzan";
			}
		} else if (word.equals("hervir")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "hiervo";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "hierves";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "hierve";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "hervimos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "herv�s";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "hierven";
			}
		} else if (word.equals("confesar")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "confieso";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "confiesas";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "confiesa";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "confesamos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "confes�is";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "confiesan";
			}
		} else if (word.equals("mentir")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "miento";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "mientes";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "miente";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "mentimos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "ment�s";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "mienten";
			}
		} else if (word.equals("consentir")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "consiento";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "consientes";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "consiente";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "consentimos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "consent�s";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "consienten";
			}
		} else if (word.equals("negar")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "niego";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "niegas";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "niega";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "negamos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "neg�is";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "niegan";
			}
		} else if (word.equals("convertir")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "convierto";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "conviertes";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "convierte";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "convertimos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "convert�s";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "convierten";
			}
		} else if (word.equals("pensar")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "pienso";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "piensas";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "piensa";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "pensamos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "pens�is";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "piensan";
			}
		} else if (word.equals("defender")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "defiendo";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "defiendas";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "defienda";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "defendemos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "defend�is";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "defienden";
			}
		} else if (word.equals("perder")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "pierdo";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "pierdes";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "pierde";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "perdemos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "perd�is";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "pierden";
			}
		} else if (word.equals("empezar")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "empiezo";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "empiezas";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "empieza";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "empezamos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "empez�is";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "empiezan";
			}
		} else if (word.equals("preferir")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "prefiero";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "prefieres";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "prefiere";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "preferimos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "prefer�s";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "prefieren";
			}
			//Beginning of e:i stem changer verbs
		} else if (word.equals("bendecir")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "bendigo";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "bendices";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "bendice";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "bendecimos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "bendec�s";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "bendicen";
			}
		} else if (word.equals("impedir")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "impido";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "impides";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "impide";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "impedimos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "imped�s";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "impiden";
			}
		} else if (word.equals("colegir")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "colijo";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "coliges";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "colige";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "colegimos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "colegis";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "coligen";
			}
		} else if (word.equals("maldecir")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "maldigo";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "maldices";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "maldice";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "maldecimos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "maldec�s";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "maldicen";
			}
		} else if (word.equals("competir")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "compito";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "compites";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "compite";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "competimos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "compet�s";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "compiten";
			}
		} else if (word.equals("medir")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "mido";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "mides";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "mide";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "medimos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "med�s";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "miden";
			}
		} else if (word.equals("conseguir")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "consigo";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "consigues";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "consigue";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "conseguimos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "consegu�s";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "consiguen";
			}
		}  else if (word.equals("pedir")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "pido";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "pides";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "pide";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "pedimos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "ped�s";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "piden";
			}
		} else if (word.equals("corregir")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "corrijo";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "corriges";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "corrige";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "corregimos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "correg�s";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "corrigen";
			}
		} else if (word.equals("perseguir")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "persigo";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "persigues";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "persigue";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "perseguimos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "persegu�s";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "persiguen";
			}
		} else if (word.equals("decir")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "digo";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "dices";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "dice";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "decimos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "dec�s";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "dicen";
			}
		} else if (word.equals("re�r")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "r�o";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "r�es";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "r�e";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "re�mos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "re�s";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "r�en";
			}
		} else if (word.equals("despedir")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "despido";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "despides";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "despide";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "despedimos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "desped�s";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "despiden";	
			}
		} else if (word.equals("repetir")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "repito";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "repites";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "repite";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "repetimos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "repet�s";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "repiten";	
			}
		} else if (word.equals("elegir")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "elijo";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "eliges";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "elige";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "elegimos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "eleg�s";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "eligen";	
			}
		} else if (word.equals("seguir")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "sigo";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "sigues";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "sigue";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "seguimos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "segu�s";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "siguen";
			}
		} else if (word.equals("fre�r")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "fr�o";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "fr�es";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "fr�e";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "fre�mos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "fre�s";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "fr�en";
			}
		} else if (word.equals("servir")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "sirvo";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "sirves";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "sirve";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "servimos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "serv�s";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "sirven";
			}
		} else if (word.equals("gemir")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "gimo";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "gimes";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "gime";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "gemimos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "gem�s";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "gimen";
			}
		} else if (word.equals("sonre�r")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "sonr�o";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "sonr�es";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "sonr�e";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "sonre�mos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "sonre�s";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "sonr�en";
			}
			//Beginning of o:ue stem changer verbs
		} else if (word.equals("almorzar")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "almuerzo";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "almuerzas";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "almuerza";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "almorzamos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "almorz�is";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "almuerzan";
			}
		} else if (word.equals("morir")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "muero";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "mueres";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "muere";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "morimos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "mor�s";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "mueren";
			}
		} else if (word.equals("aprobar")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "apruebo";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "apruebas";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "aprueba";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "aprobamos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "aprob�is";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "aprueban";
			}
		} else if (word.equals("mostrar")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "muestro";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "muestras";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "muestra";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "mostramos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "mostr�is";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "muestran";
			}
		} else if (word.equals("colgar")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "cuelgo";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "cuelgas";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "cuelga";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "colgamos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "colg�is";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "cuelgan";
			}
		} else if (word.equals("mover")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "muevo";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "mueves";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "mueve";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "movemos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "mov�is";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "mueven";
			}
		} else if (word.equals("contar")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "cuento";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "cuentas";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "cuenta";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "contamos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "cont�is";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "cuentan";
			}
		} else if (word.equals("probar")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "pruebo";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "pruebas";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "prueba";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "probamos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "prob�is";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "prueban";
			}
		} else if (word.equals("costar")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "cuesto";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "cuestas";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "cuesta";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "costamos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "cost�is";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "cuestan";
			}
		} else if (word.equals("recordar")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "recuerdo";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "recuerdas";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "recuerda";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "recordamos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "record�is";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "recuerdan";
			}
		} else if (word.equals("devolver")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "devuelvo";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "devuelves";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "devuelve";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "devolvemos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "devolv�is";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "devuelven";
			}
		} else if (word.equals("revolver")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "revuelvo";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "revuelves";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "revuelve";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "revolvemos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "revolv�is";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "revuelven";
			}
		} else if (word.equals("volver")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "vuelvo";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "vuelves";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "vuelve";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "volvemos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "volv�is";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "vuelven";
			}
		} else if (word.equals("rogar")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "ruego";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "ruegas";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "ruega";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "rogamos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "rog�is";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "ruegan";
			}
		} else if (word.equals("dormir")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "duermo";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "duermes";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "duerme";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "dormimios";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "dorm�s";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "duermen";
			}
		} else if (word.equals("sonar")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "sueno";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "suenas";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "suena";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "sonamos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "son�is";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "suenan";
			}
		} else if (word.equals("encontrar")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "encuentro";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "encuentras";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "encuentra";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "encontramos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "encontr�is";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "encuentran";
			}
		} else if (word.equals("so�ar")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "sue�o";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "sue�as";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "sue�a";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "so�amos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "so��is";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "sue�an";
			}
		} else if (word.equals("envolver")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "envuelvo";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "envuelves";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "devuelve";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "envolvemos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "envolv�is";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "envuelven";
			}
		} else if (word.equals("tostar")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "tuesto";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "tuestas";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "tuesta";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "tostamos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "tost�is";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "tuestan";
			}
		} else if (word.equals("morder")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "muerdo";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "muerdes";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "muerde";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "mordemos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "mord�is";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "muerden";
			}
		} else if (word.equals("volar")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "vuelo";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "vuelas";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "vuela";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "volamos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "vol�is";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "veulan";
			}
		} 
		return conjVerb;
	}
	static String futureIrregularChecker(String word, String conjugation, int length){
		String conjVerb = "";

		if (word.equals("caber")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "cabr�";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "cabr�s";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "cabr�";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "cabremos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "cabr�is";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "cabr�n";
			} 
		} else if (word.equals("decir")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "dir�";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "dir�s";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "dir�";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "diremos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "dir�is";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "dir�n";
			}
		} else if (word.equals("haber")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "habr�";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "habr�s";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "habr�";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb =  "habremos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "habr�is";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "habr�n";
			}
		} else if (word.equals("hacer")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "har�";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "har�s";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "har�";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "haremos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "har�is";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "har�n";
			}
		} else if (word.equals("poder")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "podr�";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "podr�s";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "podr�";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "podremos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "podr�is";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "podr�n";
			}
		} else if (word.equals("poner")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "pondr�";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "pondr�s";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "pondr�";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "pondremos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "pondr�is";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "pondr�n";
			}
		} else if (word.equals("querer")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "querr�";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "querr�s";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "querr�";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "querremos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "querr�is";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "querr�n";
			}
		} else if (word.equals("saber")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "sabr�";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "sabr�s";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "sabr�";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "sabremos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "sabr�is";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "sabr�n";
			}
		} else if (word.equals("salir")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "saldr�";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "saldr�s";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "saldr�";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "saldremos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "saldr�is";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "saldr�n";
			}
		} else if (word.equals("tener")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "tendr�";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "tendr�s";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "tendr�";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "tendremos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "tendr�is";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "tendr�n";
			} 
		} else if (word.equals("valer")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "valdr�";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "valdr�s";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "valdr�";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "valdremos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "valdr�is";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "valdr�n";
			}
		} else if (word.equals("venir")){
			if (conjugation.equals(SpnUtils.SUBJECTS[0])){
				conjVerb = "vendr�";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[1])){
				conjVerb = "vendr�s";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[2]) || conjugation.equals(SpnUtils.SUBJECTS[3]) || conjugation.equals(SpnUtils.SUBJECTS[4])){
				conjVerb = "vendr�";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[5])){
				conjVerb = "vendremos";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[6])){
				conjVerb = "vendr�is";
			} else if (conjugation.equals(SpnUtils.SUBJECTS[7]) || conjugation.equals(SpnUtils.SUBJECTS[8]) || conjugation.equals(SpnUtils.SUBJECTS[9])){
				conjVerb = "vendr�n";
			}
		}
		return conjVerb;
	}
	static String progressiveIrregularChecker(String word, int length){
		String conjVerb = "";
		if (word.equals("dormir")){
			conjVerb = "durmiendo";
		} else if (word.equals("servir")){
			conjVerb = "sirviendo";
		} else if (word.equals("preferir")){
			conjVerb = "prefiriendo";
		} else if (word.equals("seguir")){
			conjVerb = "siguiendo";
		} else if (word.equals("sentir")){
			conjVerb = "sintiendo";
		} else if (word.equals("pedir")){
			conjVerb = "pidiendo";
		} else if (word.equals("convertir")){
			conjVerb = "convirtiendo";
		} else if (word.equals("morir")){
			conjVerb = "muriendo";
		} else if (word.equals("repetir")){
			conjVerb = "repitiendo";
		} else if (word.equals("o�r")){
			conjVerb = "oyendo";
		}
		return conjVerb;
	}
}
