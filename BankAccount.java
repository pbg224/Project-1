import java.math.*;
public class BankAccount {
	private String name;
	private int account;
	private double balance;
	private Transaction[] transactions;
	private int transCount;
	
	public BankAccount() {
		name = "";
		balance = 0;
		String acString =  "" + ((int) (Math.random() * 9)) + ((int) (Math.random() * 9)) + ((int) (Math.random() * 9)) + ((int) (Math.random() * 9)) + ((int) (Math.random() * 9)) + ((int) (Math.random() * 9)); 
		account = Integer.parseInt(acString);
		transactions = new Transaction[100];
		transCount = 0;
	}
	
	public BankAccount(String n, double b) {
		name = n;
		balance = b;
		String acString =  "" + ((int) (Math.random() * 9)) + ((int) (Math.random() * 9)) + ((int) (Math.random() * 9)) + ((int) (Math.random() * 9)) + ((int) (Math.random() * 9)) + ((int) (Math.random() * 9)); 
		account = Integer.parseInt(acString);
		transactions = new Transaction[100];
		transCount = 0;
	}

	public String getName() {
		return name;
	}

	public int getAccount() {
		return account;
	}

	public double getBalance() {
		return balance;
	}
	
	public void deposit(double amount, String description)
	{
		balance += amount;
		Transaction t = new Transaction('D', amount, balance, description);
		transactions[transCount] = t;
		transCount++;
	}
	
	public boolean withdraw(double amount, String description)
	{
		if((balance - amount) < 0)
			return false;
		else
		{
			balance -= amount;
			Transaction t = new Transaction('W', amount, balance, description);
			transactions[transCount] = t;
			transCount++;
			return true;
		}
		
	}
	
	public String toString()
	{
		String bank = "Name: " + name + "\tAccount: " + account + "\tBalance: " + balance + "\n";
		
		for(Transaction t: transactions)
		{
			if(t == null)
				continue;
			bank += (t.toString() + "\n");
		}
		
		return bank;
	}
	
}
