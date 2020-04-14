package run;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import files.FileHandling;
import html.HTMLCreation;
import json.JSONConversion;
import models.AccountHolder;

public class RunTime {

	public static void run() {
		int counter = 0;
		
		JSONArray holders = FileHandling.getStockHolders();
		
		for(Object obj : holders) {
			
			AccountHolder person = JSONConversion.jsonToObject((JSONObject) obj);
			
			String information = HTMLCreation.htmlFormat(person);
			String fileName = person.getLastName() + "_" + person.getFirstName();
			
			FileHandling.createHTMLFile(fileName, information);
			FileHandling.htmlToPDF(fileName);
		}
	}
}
