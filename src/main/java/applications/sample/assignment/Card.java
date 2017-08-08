package applications.sample.assignment;

public class Card 
{
	Suit suit;
	int faceValue, pointValue;
	
	public Card(Suit suit, int faceValue)
	{
		this.suit = suit;
		this.faceValue = faceValue;
		
		if(this.faceValue>9)
			this.pointValue = 0;
		else
			this.pointValue = this.faceValue;
	}
	
	public int getFacevalue()
	{
		return faceValue;
	}
	
	public int getPointValue()
	{
		return pointValue;
	}
	
	public Suit getSuit()
	{
		return suit;
	}
	
	

}
