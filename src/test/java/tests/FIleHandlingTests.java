package tests;

import static org.junit.Assert.assertNotNull;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;

import files.FileHandling;

class FIleHandlingTests {

	@Test
	void testGetStockHolder() {
		JSONObject test = FileHandling.getStockHolders();
		
		assertNotNull(test);
	}

}
