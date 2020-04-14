package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;

import org.json.simple.JSONArray;
import org.junit.jupiter.api.Test;

import files.FileHandling;

class FIleHandlingTests {

	@Test
	//Makes sure that the JSONArray is actually created
	void testGetStockHolders() {
		JSONArray test = FileHandling.getStockHolders();
		
		assertNotNull(test);
	}
	
	@Test
	//Tests to make sure all account holders are in json array
	void testAmountInArray() {
		JSONArray test = FileHandling.getStockHolders();
		
		assertEquals(300, test.size());
	}
	
	@Test
	void testHTMLCreation() {
		String html = "<div><h1>Hello this is a test</h1></div>";
		FileHandling.createHTMLFile("test", html);
		
		File file = new File("html/test.html");
		
		assertTrue(file.exists());
	}
	
	@Test
	void testPDFCreation() {
		FileHandling.htmlToPDF("test");
		
		File file = new File("pdf/test.pdf");
		
		assertTrue(file.exists());
	}

}
