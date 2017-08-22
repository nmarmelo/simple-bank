package hw5;

import java.util.Scanner;

public class Account extends Person 
{
	private int AccNum;
	private Double balance = 0.00;
	private Double WithdrawLim = 200.00; //sets automatic withdraw limit even if user doesn't input
	private String date;
	private Double totalWithdraw = 0.00;
	
	public Account()
	{
		
	}
	public Account(int num, Double WithdrawLim, String date)
	{
		setAccNum(num);
		setWithdrawLim(WithdrawLim);
		setDate(date);
	}
	
	public Account(int num)
	{
		AccNum = num;
		date = "Today";
	}
	//getters && setters
	
	public int getAccNum()
	{
		return AccNum;
	}
	
	public Double getBalance()
	{
		return balance;
	}
	
	public Double getWithdrawLim()
	{
		return WithdrawLim;
	}
	
	public String getDate()
	{
		return date;
	}
	
	public void setAccNum(int num)
	{
		if (num > 0)
			AccNum = num;
	}	
	 // no setter for balance :D	its private! 
	public void setWithdrawLim(Double limit)
	 {
		 if (limit >= 0)
			 WithdrawLim = limit;
	 }

	public void setDate(String newDate)
	 {
		 if (date != null)
			  date = newDate;
		 else
			 date = "Invalid";
	 }
	
	public void setTotalWithdraw(Double num)
	{
		if(num>=0)
			totalWithdraw = num;
	}
	//OTHER METHODS
	public boolean withdraw(Double num)
	{
		boolean success = false;
		
		if ((num < balance) && (totalWithdraw + num < WithdrawLim))
		{	
			totalWithdraw += num;
			balance -= num;
			success = true;
		}
		
		return success;
	}
	
	public boolean deposit(Double num)
	{
		boolean success = false;
		
		if (num >= 0)
		{
			balance += num;
			success = true;
		}
		
		return success;
	}

	public String toString()
	{
		String info = super.toString();
		info += "Account Number: " + AccNum + "\n" +
				"Balance: " + balance + "\n" +
				"Withdraw Limit: " + WithdrawLim + "\n" +
				"Total Amount Withdrawn: " + totalWithdraw + "\n" +
				"Date: " + date + "\n";
		
		return info;
	}
	@Override
	public String String2File()
	{
		String info = super.String2File() + 
				
				
				AccNum + " " + balance + " " + 
				WithdrawLim + " " + totalWithdraw +
				" " + date;
		
		return info;
	}

	public void loadFromText(String info)
	{
		Scanner scan = new Scanner(info);
		
		super.setName(scan.next());
		super.setGender(scan.next().charAt((getName().length() + 2)));
		super.setAge(scan.nextInt());
		super.setHeight(scan.nextInt());
		super.setWeight(scan.nextInt());
		setAccNum(scan.nextInt());
		deposit(scan.nextDouble());
		setWithdrawLim(scan.nextDouble());
		setTotalWithdraw(scan.nextDouble());
		setDate(scan.next());	
	}
}
