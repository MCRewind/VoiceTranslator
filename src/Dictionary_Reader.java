import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class Dictionary_Reader {

	public HashMap<String, String> engFrnStringMap = new HashMap<String, String>();
	public HashMap<String, String> engSpnStringMap = new HashMap<String, String>();
	public HashMap<String, String> spnEngStringMap = new HashMap<String, String>();
	public HashMap<String, String> spnFrnStringMap = new HashMap<String, String>();
	public HashMap<String, String> frnEngStringMap = new HashMap<String, String>();
	public HashMap<String, String> frnSpnStringMap = new HashMap<String, String>();

	public HashMap<Word, Word> engFrnMap = new HashMap<Word, Word>();
	public HashMap<Word, Word> engSpnMap = new HashMap<Word, Word>();
	public HashMap<Word, Word> spnEngMap = new HashMap<Word, Word>();
	public HashMap<Word, Word> spnFrnMap = new HashMap<Word, Word>();
	public HashMap<Word, Word> frnEngMap = new HashMap<Word, Word>();
	public HashMap<Word, Word> frnSpnMap = new HashMap<Word, Word>();

	String APIKey = "dict.1.1.20170728T185107Z.90ec571409763166.f186d1665f258b67d120a45aa57e09747e0193a9";

	Gson gson = new GsonBuilder().setPrettyPrinting().create();

	String pos = "";
	
	public void spanishCleaner(String file, HashMap<String, String> map){
		String line = null;

		try {
			//Makes readers to cycle through the dictionary file
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));

			/*Establishes line and creates an array of strings that 
			holds the English word and the corresponding word */
			line = bufferedReader.readLine();

			/*Checks whether there is a line to read, if there is: 
			goes through the array of strings putting the 
			English word and its equivalent in the HashMap*/
			//int lineNumb = 1;
			while( (line = bufferedReader.readLine()) != null) {
				//System.out.println(lineNumb);
				//lineNumb += 1;
				String[] spanishWords = null;
				String[] words = line.split("	");
				if (words[1] != null) {
					spanishWords = words[1].split(" ; ");
				}

				//System.out.println(words[0]);

				String plural = null;

				if(words[1].substring(words[1].length()) == "s" || words[1].substring(words[1].length()) == "h" || words[1].substring(words[1].length()) == "x" || words[1].substring(words[1].length()) == "z") {
					plural = words[1] + "es";
				} else {
					plural = words[1] + "s";
				}

				/*Separates each Spanish word into individuals chars so 
				that if they have a special character instruction (n~ , a/),
				the actual character can be input (ñ , á)*/
				String engPlural = words[0] + "s";

				map.put(words[0], spanishWords[0].toLowerCase());
				map.put(engPlural, plural.toLowerCase());
			}

			bufferedReader.close();

		} catch(FileNotFoundException ex) {
			System.out.println(
					"Unable to open file '" + 
							file + "'");                
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
	}

	public void frenchCleaner(String file, HashMap<String, String> map){
		String line = null;

		try {
			//Makes readers to cycle through the dictionary file
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));

			/*Establishes line and creates an array of strings that 
				holds the English word and the corresponding word */
			line = bufferedReader.readLine();

			/*Checks whether there is a line to read, if there is: 
				goes through the array of strings putting the 
				English word and its equivalent in the HashMap*/
			//int lineNumb = 1;
			while( (line = bufferedReader.readLine()) != null) {
				//System.out.println(lineNumb);
				//lineNumb += 1;
				String[] frenchWords = {""};
				String[] words = line.split("	");
				if (words[1] != null) {
					if (line.contains(";")) {
						frenchWords = words[1].split(" ; ");
					} else if (line.contains(",")) {
						frenchWords = words[1].split(", ");
					} else {
						frenchWords[0] = words[1];
					}
				}

				String plural = null;

				if(words[1].substring(words[1].length()) == "au") {
					plural = words[1] + "x";
				} else if (words[1].substring(words[1].length()) == "ou") {
					if (words[1] == "bijou" || words[1] == "chou" || words[1] == "caillou" || words[1] == "joujou" || words[1] == "genou" || words[1] == "pou" || words[1] == "hibou") {
						plural = words[1] + "x";
					}
				} else if (words[1].substring(words[1].length()) == "al") {
					plural = (words[1].substring(words[1].length()-1) + "ux"); 
				} else if (!(words[1].substring(words[1].length()) == "s" || words[1].substring(words[1].length()) == "x" || words[1].substring(words[1].length()) == "z")) {
					plural = words[1] + "s";
				}

				/*Separates each Spanish word into individuals chars so 
					that if they have a special character instruction (n~ , a/),
					the actual character can be input (ñ , á)*/
				String engPlural = words[0] + "s";

				map.put(words[0], frenchWords[0].toLowerCase());
				map.put(engPlural, plural.toLowerCase());
			}

			bufferedReader.close();

		}


		catch(FileNotFoundException ex) {
			System.out.println(
					"Unable to open file '" + 
							file + "'");                
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}

	}

	public void wordMartial() {
		
	}
	
	public void serializer() {
		ArrayList<Word> words = new ArrayList<Word>();

		int index = 0;
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("Eng to Spn New.txt"), "UTF-8"));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("words/" + index + ".json"), "UTF-8"));
			String strLine;
			String[] strWords;
			while ((strLine = br.readLine()) != null) {
				strWords = strLine.split("	");
				System.out.println(strWords[0]);
				if(webWordCheck(strWords[0])) {
					words.add(new Word(index, strWords[0], "en", pos));
					bw.write(gson.toJson(words.get(index)));
					bw.flush();
					index++;
					bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("words/" + index + ".json"), "UTF-8"));
				}
			}
			bw.close();
		}catch (Exception e){
			System.err.println("Error: " + e.getMessage());
		}
	}

	public void fileToFiles() {
		ArrayList<Word> words = new ArrayList<Word>();

		int index = 0;
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("word.json"), "UTF-8"));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("words/" + index + ".json"), "UTF-8"));
			String strLine;
			String[] strWords;
			while ((strLine = br.readLine()) != null) {
				strWords = strLine.split("	");
				System.out.println(strWords[0]);
				words.add(new Word(index, strWords[0], "en", pos));
				bw.write(gson.toJson(words.get(index)));
				bw.flush();
				index++;
				bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("words/" + index + ".json"), "UTF-8"));
			}
			bw.close();
		}catch (Exception e){
			System.err.println("Error: " + e.getMessage());
		}
	}

	public void deserializer(HashMap<Word, Word> map, HashMap<String, String> stringMap, String lang) {
		BufferedReader br;
		for (int i = 0; i < 4741; i++) {
			try{
				br = new BufferedReader(new InputStreamReader(new FileInputStream("words/" + i + ".json"), "UTF-8"));
				Word word = gson.fromJson(br, Word.class);
				map.put(word, new Word(word.getId(), stringMap.get(word.getWord()), lang, word.getPos()));
			}catch (Exception e){
				System.err.println("Error: " + e.getMessage());
			}
		}
	}

	private class WordDeserializer implements JsonDeserializer<Word> {
		public Word deserialize(JsonElement json, java.lang.reflect.Type typeOfT, JsonDeserializationContext context)
				throws JsonParseException {
			final JsonObject jsonObject = json.getAsJsonObject();
			return new Word(jsonObject.get("id").getAsInt(),
					jsonObject.get("word").getAsString(),
					jsonObject.get("language").getAsString(),
					jsonObject.get("pos").getAsString());
		}
	}
	
	public HashMap<String, String> dictInverter (HashMap<String, String> map){
		HashMap<String, String> invertedMap = new HashMap<String, String>();
		map.forEach((key, value) -> {
			invertedMap.put(value, key);
		});
		return invertedMap;
	}

	public HashMap<Word, Word> wordDictInverter (HashMap<Word, Word> map){
		HashMap<Word, Word> invertedMap = new HashMap<Word, Word>();
		map.forEach((key, value) -> {
			invertedMap.put(value, key);
		});
		return invertedMap;
	}
	
	public boolean webWordCheck(String word) {
		String inLang = "en";
		String outLang = "es";
		String sURL = "https://dictionary.yandex.net/api/v1/dicservice.json/lookup?key=" + APIKey + "&lang=" + inLang + "-" + outLang + "&text=" +  word;

		// Connect to the URL using java's native library
		URL url = null;
		try {
			url = new URL(sURL);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		HttpURLConnection request = null;
		try {
			request = (HttpURLConnection) url.openConnection();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			request.connect();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		// Convert to a JSON object to print data
		JsonParser jp = new JsonParser(); //from gson
		JsonElement root = null;
		try {
			root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
		} catch (JsonIOException | JsonSyntaxException | IOException e) {
			e.printStackTrace();
		} //Convert the input stream to a json element
		JsonObject rootobj = root.getAsJsonObject(); //May be an array, may be an object. 
		if(rootobj.getAsJsonArray("def").size() >= 1) {				
			String outIn = ((JsonObject) rootobj.getAsJsonArray("def").get(0)).get("text").getAsString();
			pos = ((JsonObject) rootobj.getAsJsonArray("def").get(0)).get("pos").getAsString();
		if (outIn.equals(word))
			return true;
		else
			return false;
		} else {
			return false;
		}
	}

	/*language codes
		en - english
		es - spanish
		fr - french
	 */
	public void webRead(String word, String inLang, String outLang) {
		String sURL = "https://dictionary.yandex.net/api/v1/dicservice.json/lookup?key=" + APIKey + "&lang=" + inLang + "-" + outLang + "&text=" +  word;

		// Connect to the URL using java's native library
		URL url = null;
		try {
			url = new URL(sURL);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		HttpURLConnection request = null;
		try {
			request = (HttpURLConnection) url.openConnection();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			request.connect();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		// Convert to a JSON object to print data
		JsonParser jp = new JsonParser(); //from gson
		JsonElement root = null;
		try {
			root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
		} catch (JsonIOException | JsonSyntaxException | IOException e) {
			e.printStackTrace();
		} //Convert the input stream to a json element
		JsonObject rootobj = root.getAsJsonObject(); //May be an array, may be an object. 
		String outIn = ((JsonObject) rootobj.getAsJsonArray("def").get(0)).get("text").getAsString();
		String outInPos = ((JsonObject) rootobj.getAsJsonArray("def").get(0)).get("pos").getAsString();
		//System.out.println(gson.toJson(rootobj));
		String outOut = ((JsonObject) rootobj.getAsJsonArray("def").get(0).getAsJsonObject().getAsJsonArray("tr").get(0)).get("text").getAsString();
		String outOutPos = ((JsonObject) rootobj.getAsJsonArray("def").get(0).getAsJsonObject().getAsJsonArray("tr").get(0)).get("pos").getAsString();

		System.out.println(outIn + ", " + outInPos + ", " + outOut + ", " + outOutPos);
	}

	public void write(String fileName, HashMap<String, String> map) {
		try {
			BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "UTF-8"));
			for (String key : map.keySet()){
				bufferedWriter.write(key);
				bufferedWriter.write("	");
				bufferedWriter.write(map.get(key));
				bufferedWriter.newLine();	
			}
			System.out.println("done");
			bufferedWriter.close();
		}
		catch (IOException ex){
		}
	}

	public HashMap<String,String> dictMaker (HashMap<String, String> first, HashMap<String, String> second){
		HashMap<String, String> newDict = new HashMap<String, String>();
		for (Map.Entry<String, String> entry : first.entrySet()){
			String firstKey = entry.getKey();
			String firstValue = entry.getValue();
			//	System.out.println(firstKey + "First Map!");
			int firstHash = System.identityHashCode(firstKey);
			for (Map.Entry<String, String> entry2 : second.entrySet()){
				String secondKey = entry2.getKey();
				String secondValue = entry2.getValue();
				//		System.out.println(secondKey);
				int secondHash = System.identityHashCode(secondKey);
				if (firstKey.equals(secondKey)){
					newDict.put(firstValue, secondValue);
				}
			}
		}
		return newDict;
	}
}