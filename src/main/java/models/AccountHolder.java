package models;

import java.util.ArrayList;

public class AccountHolder {

	private int accountNumber;
	private String ssn;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private double cash;
	private double stockHoldings = 0;
	private ArrayList<StockTrade> trades;
	
	public AccountHolder(int accountNumber, String ssn, String firstName, String lastName, String email, String phone, double cash, ArrayList<StockTrade> trades) {
		
		setAccountNumber(accountNumber);
		setSsn(ssn);
		setFirstName(firstName);
		setLastName(lastName);
		setEmail(email);
		setPhone(phone);
		setCash(cash);
		setTrades(trades);
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public double getCash() {
		return cash;
	}

	public void setCash(double cash) {
		this.cash = cash;
		
		if(this.cash < 0) {
			this.cash = 0;
		}
	}

	public double getStockHoldings() {
		return stockHoldings;
	}

	public void setStockHoldings(double stockHoldings) {
		this.stockHoldings = stockHoldings;
		
		if(this.stockHoldings < 0) {
			this.stockHoldings = 0;
		}
	}

	public ArrayList<StockTrade> getTrades() {
		return trades;
	}

	public void setTrades(ArrayList<StockTrade> trades) {
		this.trades = trades;
	}

	@Override
	public String toString() {
		return "AccountHolder [accountNumber=" + accountNumber + ", ssn=" + ssn + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", phone=" + phone + ", cash=" + cash
				+ ", stockHoldings=" + stockHoldings + ", trades=" + trades + "]";
	}
	
	
}
