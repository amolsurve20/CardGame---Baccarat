package applications.sample.assignment;

public class Player 
{
	private String name;
	private double amount;
	
	public Player(String name, double amount)
	{
		this.name = name;
		this.amount =amount;
		
	}
	
	public String getName()
	{
		return name;
	}
	
	public double getBalance()
	{
		return amount;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setbalance(double amount)
	{
		this.amount = amount;

	}

}
