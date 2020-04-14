package json;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import models.AccountHolder;
import models.StockTrade;

public class JSONConversion {
	
	public static AccountHolder jsonToObject(JSONObject stockHolder) {
		AccountHolder person;
		
		Long accountNumber = (Long) stockHolder.get("account_number");
		String ssn = (String) stockHolder.get("ssn");
		String firstName = (String) stockHolder.get("first_name");
		String lastName = (String) stockHolder.get("last_name");
		String email = (String) stockHolder.get("email");
		String phone = (String) stockHolder.get("phone");
		String cash = (String) stockHolder.get("beginning_balance");
		
		JSONArray jsonTrades = (JSONArray) stockHolder.get("stock_trades");
		ArrayList<StockTrade> trades = getStockTrades(jsonTrades);
		
		cash = cash.replace("$", " ").trim();
		Double doubleCash = Double.parseDouble(cash);
		
		person = new AccountHolder(accountNumber.intValue(), ssn, firstName, lastName, email, phone, doubleCash, trades);
		
		return person;
	}
	
	public static ArrayList<StockTrade> getStockTrades(JSONArray jsonTrades) {
		ArrayList<StockTrade> trades = new ArrayList<>();
		
		for(Object obj : jsonTrades) {
			StockTrade temp = getIndividualTrades(obj);
			trades.add(temp);
		}
		
		return trades;
	}
	
	public static StockTrade getIndividualTrades(Object obj) {
		StockTrade trade;
		JSONObject jsonTrade = (JSONObject) obj;
		
		String type = (String) jsonTrade.get("type");
		String symbol = (String) jsonTrade.get("stock_symbol");
		Long shareCount = (Long) jsonTrade.get("count_shares");
		String price = (String) jsonTrade.get("price_per_share");
		
		price = price.replace("$", " ").trim();
		Double pricePShare = Double.parseDouble(price);
		
		trade = new StockTrade(type, symbol, pricePShare, shareCount.intValue());
		
		return trade;
	}
}
