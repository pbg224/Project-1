
public class Bank {

	private String name;
	private String branch;
	private BankAccount[] bankAccounts;
	private static double monthlyFee;
	private int accounts;
	
	public Bank()
	{
		name = "none";
		branch = "none";
		bankAccounts = new BankAccount[10];
		accounts = 0;
	}
	
	public Bank(String name, String branch)
	{
		this.name = name;
		this.branch = branch;
		bankAccounts = new BankAccount[10];
		accounts = 0;
	}
	
	public BankAccount getAccount(int number)
	{
		for(int i = 0; i < bankAccounts.length; i++)
		{
			if(bankAccounts[i].getAccount() == number)
				return bankAccounts[i];
		}
		return null;
	}
	
	public void addAccount(BankAccount ba)
	{
		bankAccounts[accounts] = ba;
		accounts++;
	}
	
	public void removeAccount(BankAccount ba)
	{
		for(int i = 0; i < bankAccounts.length; i++)
		{
			if(bankAccounts[i].getAccount() == ba.getAccount())
			{
				for(int j = i; j < bankAccounts.length - 1; j++)
				{
					bankAccounts[j] = bankAccounts[j + 1];
				}
				accounts--;
			}
		}
		
	}
	
	public void applyMonthlyFee()
	{
		for(int i = 0; i < accounts; i++)
		{
			bankAccounts[i].withdraw(monthlyFee, "Monthly Fee");
		}
	}
	
	public String toString()
	{
		String c = "| " + name + " | " + branch + " |\n" + "Account        Owner          $Balance\n";
		for(int i = 0; i < accounts; i++)
		{
			String s = addZeros(bankAccounts[i].getAccount()) + addZeros(bankAccounts[i].getAccount()) + addZeros(bankAccounts[i].getAccount()) + "\n";
			c += s;
		}
		return c;
	}
	
	public String addZeros(String s)
	{
		int numSpaces = (15 - s.length());
		while(numSpaces > 0)
		{
			s +=" ";
		}
		
		return s;
	}
	
	public String addZeros(int i)
	{
		String s = Integer.toString(i);
		int numSpaces = (15 - s.length());
		while(numSpaces > 0)
		{
			s +=" ";
		}
		
		return s;
	}
	
	public String addZeros(double d)
	{
		String s = Double.toString(d);
		int numSpaces = (15 - s.length());
		while(numSpaces > 0)
		{
			s +=" ";
		}
		
		return s;
	}
	public static void setMonthlyFee(double m)
	{
		monthlyFee = m;
	}
	
}
