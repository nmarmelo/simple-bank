package hw5;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BankTest {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int menu;
		boolean cont = true;
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		Bank CAISBank = new Bank();
		FileInputStream fis = null;
		Scanner fileInputScanner = null;
		FileOutputStream fos = null;
		//new FileOutputStream("C:\\Users\\nathan\\OneDrive\\WSU\\Spring 2015\\BankFile.doc");
		
		OutputStreamWriter osw  = null;
		//new OutputStreamWriter(fos);
		
		String ActionList = "Which operation would you like to perform?  \n" +
				" 1 Deposit \n" +
				" 2 Withdraw \n" +
				" 3 Check Balance \n " +
				" 4 End Transactions";
		
		
		//Load Bank method
		try
		{
			fis = new FileInputStream("C:\\Users\\nathan\\OneDrive\\WSU\\Spring 2015\\BankFile.doc");
			fileInputScanner = new Scanner(fis);
			InputStreamReader fws = new InputStreamReader(fis);
			
			while (fileInputScanner.hasNextLine()) 
			{
				String AccountInfo = fileInputScanner.nextLine();
				Account tmpAccount = new Account(0);
				tmpAccount.loadFromText(AccountInfo);
				CAISBank.addAccount(tmpAccount);
			}
			fis.close();
		}
		catch(Exception E)
		{
			System.out.println("Could not read files");
		}
		
		
		
		
		while (cont == true)
		{
			System.out.println
			(
			"Welcome, please select an operation \n" +
			"1 Create New Account \n" +
			"2 Perform Operations in an existing account \n" +
			"3 Delete an existing account \n" +
			"4 Display the average of all account balances \n" +
			"5 Display the maximum and minimum account balances \n" +
			"6 Quit"
			);
	
			menu = scan.nextInt();
			
			if (menu == 1)
			{
				int newAccountNumber = CAISBank.getSize() + 1;
				
				Account newAccount  = new Account(newAccountNumber);
						
				System.out.println("Your Account Number is " + newAccountNumber);
				
				System.out.println("Enter Account Information" +
				"\n Name");
				newAccount.setName(scan.next() + scan.next());
				
				System.out.println("Gender:");
				newAccount.setGender(scan.next().charAt(0));
				
				System.out.println("Age:");
				newAccount.setAge(scan.nextInt());
				
				System.out.println("Height (inches):");
				newAccount.setHeight(scan.nextInt());
				
				System.out.println("Weight:");
				newAccount.setWeight(scan.nextInt());
				
				System.out.println("Withdraw Limit:");
				newAccount.setWithdrawLim(scan.nextDouble());
				
				System.out.println("Date:");
				newAccount.setDate(scan.next());
				
				System.out.println("Starting Balance:");
				newAccount.deposit(scan.nextDouble());
				
				CAISBank.addAccount(newAccount);
			}
			
			else if (menu == 2)
			{
				boolean ContOper = true; //different from the main continue, this allows the user to
				//continue operations in the same account
				
				System.out.println("Please enter desired Account number:");
				
				int userAcc = scan.nextInt();
				
				Account editAccount = new Account(userAcc);
				
				editAccount = CAISBank.findAccount(userAcc);
					
				while(ContOper == true)
				{
					System.out.println(ActionList);
					
					int oper = scan.nextInt();
						
					if (oper == 1)
					{
						System.out.println("Enter deposit amount");
						
						 boolean success = editAccount.deposit(scan.nextDouble());
							
						if (success == true)
							System.out.println("Deposit Success");
						else if(success == false)
							System.out.println("Deposit Failure");
					}
						
					else if (oper == 2)
					{
						System.out.println("Enter withdrawal amount");
							
						boolean success = editAccount.withdraw(scan.nextDouble());
						
						if (success == true)
							System.out.println("Withdrawal Success");
						else
							System.out.println("Withdrawal Failure");
					}
					
					else if (oper == 3)
					{
						System.out.println("Your balance is: " + editAccount.getBalance());
					}
					
					else if (oper == 4)
					{
						System.out.println("Thank you for using CAISBank");
						ContOper = false;
					}
					
					else
						System.out.println("Invalid Menu Operation");
				}
		
			}
			
			else if (menu == 3)
			{
				System.out.println("Enter the number of the account you would like to delete");
				
				int i = scan.nextInt();
				boolean success = CAISBank.deleteAccount(i);
			
				if (success == true)
					System.out.println("Account " + i + " has been deleted");
				else
					System.out.println("Error deleting account " + i);
			}
			
			else if (menu == 4)
			{
				System.out.println("The average balance of all accounts is: " + CAISBank.getAverageBalance());
			}
		
			else if (menu == 5)
			{
				System.out.println("The maximum balance is: " + CAISBank.getMaxBalance());
				System.out.println("The minimum balance is: " + CAISBank.getMinBalance());
			}
			
			else if (menu == 6)
				cont = false;
			
		}
		
		System.out.println("Thank you for using CAISBank");
		
		try
		{
			fos = new FileOutputStream("C:\\Users\\nathan\\OneDrive\\WSU\\Spring 2015\\BankFile.doc");
			osw = new OutputStreamWriter(fos);
			
			for (int i = 0; i < CAISBank.getSize(); i++)
			{
				Account tmpAccount = CAISBank.findAccount(i);
				osw.write(tmpAccount.String2File() + "\n");
			}
			osw.close();
			//can use flash or close!
		}
		catch(Exception e)
		{
			System.out.println("Unable to create or write file");
		}
	}

}
