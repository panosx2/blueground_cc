package com.basement.panos.challenge;

import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Main {

	public static void main(String[] args) {
		JSONObject json = new JSONObject();
		try {
			json = new ReadJson().fromURL("http://api.wunderground.com/api/b3b98750993f7432/history_20171030/q/NY/New_York.json");
		} catch (IOException | org.json.simple.parser.ParseException e) {
			e.printStackTrace();
		}
		
		json = (JSONObject) json.get("history");
	    JSONArray dailysummary = (JSONArray) json.get("dailysummary");
	    json = (JSONObject) dailysummary.get(0); //pairnei ton ena kai monadiko pinaka tou dailysummary
	    
	    //test
	    System.out.println("Max percetange humidity: " + json.get("maxhumidity"));
	    System.out.println("Max Temp in C: " + json.get("maxtempm"));
	    System.out.println("Min Temp in C: " + json.get("mintempm"));
	    System.out.println("Precipitation in mm: " + json.get("precipm"));
	    
	    //e3agwgh arxeiou
	    new ExportFile(json);
	}
}