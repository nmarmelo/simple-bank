package hw5;

public class Person 
{
	
	private String name;
	private char gender;
	private int age;
	private int height;
	private int weight;
	
	public Person()
	{
		name = "Dude";
		gender = 'm';
		age = 21;
		height = 71;
		weight = 180;
	}
	
	public Person(String name, char gender, int age, int height, int weight)
	{
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}
	
	//getters
	public String getName()
	{
		if (name != null)
			return name;
		else
			return "Name invalid";
	}
	
	public char getGender()
	{
		if (gender == 'm' || gender == 'f')
			return gender;
		else
			return ' ';
	}
	
	public int getAge()
	{
		return age;
	}
	
	public int getHeight()
	{
		return height;
	}
	
	public int getWeight()
	{
		return weight;
	}
	//setters
	public void setName(String name)
	{
		if (name != null)
			this.name = name;
		else
			this.name = "Invalid Name";
	}
	
	public void setGender(char gender)
	{
		if (gender == 'm' || gender == 'f')
			this.gender = gender;
		else
			this.gender = ' ';
	}
	
	public void setAge(int age)
	{
		if(age >= 0)
			this.age = age;
	}
	
	public void setHeight(int height)
	{
		if(height >= 0)
			this.height = height;
	}
	
	public void setWeight(int weight)
	{
		if (weight >= 0)
			this.weight = weight;
	}
	//other methods
	public String toString()
	{
		String info = "";
		
		info = "Name: " + name + "\n" +
				"Gender: " + gender + "\n" +
				"Age: " + age + "\n" +
				"Height: " + height + "\n" +
				"Weight: " + weight + "\n";
		
		return info;
	}
	
	public String String2File()
	{
		String info = "";
		info = name +  " " + gender + " " + age + " " 
				+ height + " " + weight + " ";
		
		return info;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
