package applications.sample.assignment;
import java.util.*;
public class Hand 
{
	private ArrayList<Card> cardList;
	private HandType handType;
	
	public Hand(HandType handType)
	{
		this.cardList = cardList;
		this.handType = handType;
	}
	
	public HandType getHandType()
	{
		return handType;
	}
	
	public int calculateValue()
	{
		int total = 0;
		
		for(Card c:cardList)
		{
			total = total+c.getPointValue();
			
		}
		
		return total;
	}
	
	public void addCard(Card c)
	{
		cardList.add(c);
	}
	
	public void clearHand()
	{
		cardList.clear();
	}

}
