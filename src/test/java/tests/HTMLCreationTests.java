package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import html.HTMLCreation;
import models.AccountHolder;
import models.StockTrade;

class HTMLCreationTests {

	ArrayList<StockTrade> trades = new ArrayList<>();
	AccountHolder person = new AccountHolder(1, "123123123", "Thomas", "Inskeep", "testemail", "testphone", 123123.0, trades);
	
	@Test
	void testBasicHTMLString() {
		String actual = HTMLCreation.htmlFormat(person);
		String expected = "<div><h1>2020-04-13 Thomas Inskeep SSN: 123123123 Email: testemail Phone: testphone AccountNumber: 1</h1><h2>Cash: 123123.0 Stock Holdings: 0.0</h2></div>";
		
		assertEquals(expected, actual);
	}
	
	@Test
	//This test should throw an error
	void TestVoidArrayList() {
		person.setTrades(null);
		HTMLCreation.htmlFormat(person);
	
		fail();
	}

}
