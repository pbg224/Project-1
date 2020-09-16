

import java.util.Date;
public class Transaction {
	private Date date;
	private char type;
	private double amount;
	private double balance;
	private String description;
	
	public Transaction(char t, double a, double b, String d)
	{
		date = new Date();
		type = t;
		amount = a;
		balance = b;
		description = d;
	}

	public Date getDate() {
		return date;
	}

	public char getType() {
		return type;
	}

	public double getAmount() {
		return amount;
	}

	public double getBalance() {
		return balance;
	}

	public String getDescription() {
		return description;
	}
	
	public String toString()
	{
		return String.format("Date: %s\tType: %c\tAmount: %.2f\tBalance: %.2f\tDescription: %s", date.toString(), type, amount, balance, description);
	}
	
}
