package hw5;

import java.util.ArrayList;
//ArrayList does a lot of things internally! makes this much easier to create a doubleArray!
public class DoubleArray 
{
	private final int initialSize = 1000;
	private ArrayList<Double> values;
	
	public DoubleArray()
	{
		values = new ArrayList(initialSize);
	}
	
	public DoubleArray(int initialArraySize)
	{
		values = new ArrayList(initialArraySize);
	}
	
	public int getElementCount()
	{
		return values.size();
	}
	
	public void add(double number)
	{
		values.add(number);
	}
	
	public boolean delete(int position)
	{
		boolean success = true;
		
		if (position < 0 || position >= getElementCount())
			success = false;
		else
			values.remove(position);
		
		return success;
	}
	
	public Double getElement(int index)
	{
		Double value = null;
		
		if (index >= 0 && index <  values.size())
			value = values.get(index);
		return value;
	}
	
	public Double average()
	{
		Double total = 0.0;
		Double average = 0.0;
		
		for (int i = 0; i < values.size(); i++)
			total+=getElement(i);
		
		average = total / values.size();
		
		return average;
	}
	
	public Double getMaximum()
	{
		Double max = 0.0;
		if (values.size() == 0)
			max = null;
		else
		{
			max = getElement(0);
		
			for (int i = 0; i < values.size(); i++)
				if (getElement(i) > max)
					max = getElement(i);
		}
		
		return max;
	}
	
	public Double getMinimum()
	{
		Double min = 0.0;
		if (values.size() == 0)
			min = null;
		else
		{
			min = getElement(0);
			
			for (int i = 0; i < values.size(); i++)
				if (getElement(i) < min)
					min = getElement(i);
		}
		
		return min;
	}
}
