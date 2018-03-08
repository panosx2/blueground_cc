package com.basement.panos.challenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJson {

	public JSONObject fromURL(String url) throws MalformedURLException, IOException, ParseException {
		InputStream is = new URL(url).openStream();
	    try {
	      BufferedReader br = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
	      String jsonText = readAll(br);
	      JSONParser parser = new JSONParser();
	      JSONObject json = (JSONObject) parser.parse(jsonText);
	      return json;
	    } finally {
	      is.close();
	    }
	}
	
	/*
	 * den xreiazetai na xrhsimopoihsw th readLine() tou BufferedReader
	 * mias kai exei perissotero kostos kai to json response den douleuei
	 * me th logikh grammwn outws 'h allws, opote oute egw 8a to kanw
	 */
	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
	    int cp;
	    while ((cp = rd.read()) != -1) {
	      sb.append((char) cp);
	    }
	    return sb.toString();
	  }
}