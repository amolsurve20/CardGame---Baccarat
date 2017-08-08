package applications.sample.assignment;

public class Coup 
{
	private CoupType coupType;
	private double amount;
	
	public Coup(CoupType coup, Double amount)
	{
		this.amount = amount;
		this.coupType = coup;
	}
	
	public CoupType getCoupType()
	{
		return coupType;
	}
	
	public double getCoupAmount()
	{
		return amount;
	}

}
