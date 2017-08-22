package hw5;

import java.util.ArrayList;

public class Bank 
{
	private final int initialSize = 100;
	private ArrayList<Account> accounts;
	
	public Bank(int InitialSize)
	{
		accounts = new ArrayList<Account>(InitialSize);
	}
	
	public Bank()
	{
		accounts = new ArrayList<Account>(initialSize);
	}
	
	public void addAccount(Account tmpAccount)
	{
		accounts.add(tmpAccount);
	}
	
	//METHODS
	public Account findAccount(int num)
	{
		return accounts.get(num);
	}
	
	public boolean deleteAccount(int i)
	{
		boolean success = false; 
		
		if (i >= 0)
		{
			accounts.remove(i);
			success = true;
		}
		
		return success;
	}
        	
	public Double getAverageBalance()
	{
		Double total = 0.00;
		Account tmpAccount = null;
		
		for(int i  = 0; i < accounts.size(); i++)
			tmpAccount = accounts.get(i);
			total = total+tmpAccount.getBalance();
			
		Double avgBalance = total/accounts.size();
		
		return avgBalance;
	}
	
	public Double getMaxBalance()
	{
		Account tmpAccount = accounts.get(0);
		Double max = tmpAccount.getBalance();
		
		for(int i = 0; i < accounts.size(); i++)
		{
			tmpAccount = accounts.get(i);
		
			if (tmpAccount.getBalance() > max)
				max = tmpAccount.getBalance();
		}
		
		return max;
	}
	
	public Double getMinBalance()
	{
		Account tmpAccount = accounts.get(0);
		Double min = tmpAccount.getBalance();
		
		for(int i = 0; i < accounts.size(); i++)
		{
			tmpAccount = accounts.get(i);
			
			if (tmpAccount.getBalance() < min)
				min = tmpAccount.getBalance();
		}
		
		return min;
	}
	
	public int getSize()
	{
		return accounts.size();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
