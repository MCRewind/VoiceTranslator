import java.awt.Color;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.TargetDataLine;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class Main extends JFrame {
	
	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	
	String APIKey = "dict.1.1.20170728T185107Z.90ec571409763166.f186d1665f258b67d120a45aa57e09747e0193a9";
	
	String pos = "";
	
	public static void main(String[] args) {
		new Main();
	}
	
	public Main() {
		indexer();
	}
	
	public void writeTest() {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("word.json"), "UTF-8"));
		} catch (UnsupportedEncodingException | FileNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			bw.write("hello");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void indexer() {
		ArrayList<Word> words = new ArrayList<Word>();

		int index = 0;
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("test.txt"), "UTF-8"));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("word.json"), "UTF-8"));
			String strLine;
			while ((strLine = br.readLine()) != null) {
				System.out.println(strLine);
				if(webWordCheck(strLine)) {
					words.add(new Word(index, strLine, "en", pos));
					System.out.println(index);
					bw.write(gson.toJson(words.get(index)));
					//bw.flush();
					index++;
				}
			}
			//in.close();
		}catch (Exception e){
			System.err.println("Error: " + e.getMessage());
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
