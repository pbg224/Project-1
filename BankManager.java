import java.util.InputMismatchException;
import java.util.Scanner;
public class BankManager {
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		Bank.setMonthlyFee(20);
		Bank myBank = new Bank("LEHIGH UNIVERSITY BANK", "Bethlehem");
		BankAccount b1 = new BankAccount("John Blake", 1200);
		BankAccount b2 = new BankAccount("Sarah Brown", 2045);
		BankAccount b3 = new BankAccount("Emma Johnson", 450);
		BankAccount b4 = new BankAccount("Suzan Jones", 23000);
		BankAccount b5 = new BankAccount("Mery Chen", 550);
		
		myBank.addAccount(b1);
		myBank.addAccount(b2);
		myBank.addAccount(b3);
		myBank.addAccount(b4);
		myBank.addAccount(b5);
		
		System.out.println(myBank);
		/*
		int function = 0;
		do
		{
			function = getFunction(input);
			switch(function)
			{
			case 1:
				manageAccounts(myBank, input);
				break;
			case 2:
				System.out.println("Enter name: ");
				String name = input.next();
				System.out.println("Enter Balance: ");
				double balance = input.nextDouble();
				myBank.addAccount(new BankAccount(name, balance));
				System.out.println("Account Added");
				break;
			case 3:
				System.out.println("Enter Account Number");
				int num = input.nextInt();
				BankAccount b = myBank.getAccount(num);
				if(b != null) {
					myBank.removeAccount(b);
					System.out.println("Account Removed Successfully");
				}else
				{
					System.out.println("Account not found");
				}
				break;
			case 4:
				viewAllAccounts(myBank);
				break;
			case 5:
				myBank.applyMonthlyFee();
				break;
			case 6:
				System.out.println("Exiting program");
			}
		}while(function != 6);
		
		*/
	}
	
	public static int getFunction(Scanner in)
	{
		System.out.println("1. Manage Existing Account");
		System.out.println("2. Add Account");
		System.out.println("3. Remove Existing Account");
		System.out.println("4. List All Accounts");
		System.out.println("5. Apply Monthly fee");
		System.out.println("6. Exit");
		try {
			int op = in.nextInt();
			if(op < 1 || op > 6)
			{
				throw new Exception("Must enter number between 1 and 6");
			}
			
			return op;
		}catch(InputMismatchException e)
		{
			System.out.println("You have to enter an integer");
			return getOperation(in);
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
			return getOperation(in);
		}
	}
	
	public static int getOperation(Scanner in)
	{
		System.out.println("1. View Balance");
		System.out.println("2. Deposit");
		System.out.println("3. Withdraw");
		System.out.println("4. View Statement");
		System.out.println("5. Exit Manage Account");
		try {
			int op = in.nextInt();
			if(op < 1 || op > 5)
			{
				throw new Exception("Must enter number between 1 and 5");
			}
			
			return op;
		}catch(InputMismatchException e)
		{
			System.out.println("You have to enter an integer");
			return getOperation(in);
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
			return getOperation(in);
		}
			
		
	}
	
	public static void manageAccounts(Bank myBank, Scanner input) {
		int operation = 0;
		int accountNumber = 0;
		
		try {
			System.out.println("Enter Account number: ");
			accountNumber = input.nextInt();
			if(myBank.getAccount(accountNumber) == null)
			{
				System.out.println("pp");
				throw new Exception("Account Number not found");
			}
			
			do 
			{
				
				operation = getOperation(input);
				switch(operation)
				{
				case 1:
					System.out.printf("Account %d Balance: %.2f\n", accountNumber, myBank.getAccount(accountNumber).getBalance());
					break;
				case 2:
					System.out.println("Enter Deposit amount: ");
					double amount = input.nextDouble();
					input.nextLine();
					System.out.println("Enter Deposit Description: ");
					String description = input.nextLine();
					myBank.getAccount(accountNumber).deposit(amount, description);
					System.out.printf("Account %d Balance: %.2f\n", accountNumber, myBank.getAccount(accountNumber).getBalance());
					break;
				case 3:
					System.out.println("Enter Withdraw Amount: ");
					double withdraw = input.nextDouble();
					input.nextLine();
					System.out.println("Enter Withdraw Description: ");
					String des = input.nextLine();
					if(myBank.getAccount(accountNumber).withdraw(withdraw, des))
					{
						System.out.println("Withdraw Successful!");
						System.out.printf("Account %d Balance: %.2f\n", accountNumber, myBank.getAccount(accountNumber).getBalance());
					}
					else
						System.out.println("Withdraw Unsuccessful.");
					break;
				case 4:
					System.out.println(accountNumber);
					System.out.println(myBank.getAccount(accountNumber));
					break;
				case 5:
					System.out.println("Exiting program");
				}
			}while(operation != 5);
		}catch(InputMismatchException e)
		{
			System.out.println("Please enter Integer");
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		
	}
	
	
	public static void viewAllAccounts(Bank myBank)
	{
		System.out.println(myBank);
	}
	
	
	
}

	


	
	
	
	

