package ignore;

import java.util.ArrayList;

import html.HTMLCreation;
import models.AccountHolder;
import models.StockTrade;

public class ThrowAwayCode {

	public static void testing() {
		ArrayList<StockTrade> trades = new ArrayList<>();
		AccountHolder person = new AccountHolder(1, "123123123", "Thomas", "Inskeep", "testemail", "testphone", 123123.0, trades);
		
		String test = HTMLCreation.htmlFormat(person);
		System.out.println(test);
	}
}
