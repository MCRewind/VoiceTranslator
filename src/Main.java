import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.JFrame;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class Main extends JFrame {

	GsonBuilder gsonBuilder = new GsonBuilder().registerTypeAdapter(Word.class, new WordDeserializer());
	Gson gson = gsonBuilder.setPrettyPrinting().create();

	ArrayList<Word> words = new ArrayList<Word>();

	String APIKey = "dict.1.1.20170728T185107Z.90ec571409763166.f186d1665f258b67d120a45aa57e09747e0193a9";

	String pos = "";

	public static void main(String[] args) {
		new Main();
	}

	public Main() {
		serializer();
	}

	public void writeTest() {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("word.json"), "UTF-8"));
		} catch (UnsupportedEncodingException | FileNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			bw.write(gson.toJson(new Test(1, 2, 3)));
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
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

	public void deserializer() {
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("word.json"), "UTF-8"));
			Word word = gson.fromJson(br, Word.class);
			System.out.println(word);
		}catch (Exception e){
			System.err.println("Error: " + e.getMessage());
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


}
