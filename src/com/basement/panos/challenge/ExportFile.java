package com.basement.panos.challenge;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

import org.json.simple.JSONObject;

public class ExportFile {
	
	ExportFile(JSONObject json) {
		try {
			File file = new File("NY_20171030_DAILYSUMMARY.txt");
			if (file.exists()) file.delete();
			
			String content = ""
					+ "Max percetange humidity: " + json.get("maxhumidity") + "\n"
					+ "Max Temp in C: " + json.get("maxtempm") + "\n"
					+ "Min Temp in C: " + json.get("mintempm") + "\n"
					+ "Precipitation in mm: " + json.get("precipm");
			
			List<String> lines = Arrays.asList(content);
			Files.write(file.toPath(), 
					lines, 
					Charset.forName("UTF-8"), 
					StandardOpenOption.CREATE_NEW);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}