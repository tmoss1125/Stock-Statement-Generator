package models;

public class StockTrade {

	private String transactionType;
	private String stockSymbol;
	private double pricePerShare;
	private int amountOfShares;
	private double totalAmount;
	
	public StockTrade(String transactionType, String stockSymbol, double pricePerShare, int amountOfShares) {
		this.setTransactionType(transactionType);
		this.setStockSymbol(stockSymbol);
		this.setPricePerShare(pricePerShare);
		this.setAmountOfShares(amountOfShares);
		this.setTotalAmount(pricePerShare, amountOfShares);
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getStockSymbol() {
		return stockSymbol;
	}

	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}

	public double getPricePerShare() {
		return pricePerShare;
	}

	public void setPricePerShare(double pricePerShare) {
		this.pricePerShare = pricePerShare;
	}

	public int getAmountOfShares() {
		return amountOfShares;
	}

	public void setAmountOfShares(int amountOfShares) {
		this.amountOfShares = amountOfShares;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	private void setTotalAmount(double pricePerShare, int amountOfShares) {
		totalAmount = pricePerShare * amountOfShares;
	}

	@Override
	public String toString() {
		return "StockTrade [transactionType=" + transactionType + ", stockSymbol=" + stockSymbol + ", pricePerShare="
				+ pricePerShare + ", amountOfShares=" + amountOfShares + ", totalAmount=" + totalAmount + "]";
	}
	
	
}
