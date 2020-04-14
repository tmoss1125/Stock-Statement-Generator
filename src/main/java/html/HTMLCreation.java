package html;

import models.AccountHolder;
import models.StockTrade;

public class HTMLCreation {

	public static String htmlFormat(AccountHolder person) {
		StringBuilder sb = new StringBuilder();
		
		sb.append("<div><h1>" + java.time.LocalDate.now() + " " + person.getFirstName() + " " + person.getLastName() + " SSN: " + person.getSsn() + " Email: " + person.getEmail() + " Phone: " +
		person.getPhone() + " AccountNumber: " + person.getAccountNumber() + "</h1>");
		
		for(StockTrade trade : person.getTrades()) {
			
			sb.append("<p>");
			
			sb.append("Type: " + trade.getTransactionType());
			sb.append(" Stock Symbol: " + trade.getStockSymbol());
			sb.append(" Price Per Share: " + trade.getPricePerShare());
			sb.append(" Shares Traded: " + trade.getAmountOfShares());
			sb.append(" Total Transaction: " + trade.getTotalAmount());
			
			sb.append("</p>");
			
			if(trade.getTransactionType().equalsIgnoreCase("BUY")) {
				
				person.setCash(person.getCash() - trade.getTotalAmount());
				person.setStockHoldings(person.getStockHoldings() + trade.getTotalAmount());
				
			}else if(trade.getTransactionType().equalsIgnoreCase("SELL")) {
				
				person.setCash(person.getCash() + trade.getTotalAmount());
				person.setStockHoldings(person.getStockHoldings() - trade.getTotalAmount());
				
			}
		}
		
		sb.append("<h2>Cash: " + person.getCash() + " Stock Holdings: " + person.getStockHoldings() + "</h2>");
		
		sb.append("</div>");
		
		return sb.toString();
	}
}
