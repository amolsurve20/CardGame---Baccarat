package applications.sample.assignment;
import java.util.*;
public class Shoe 
{
	private ArrayList<Card>cardList;
	
	public Shoe()
	{
		this.cardList = cardList;
		this.buildShoe();
	}
	
	public void buildShoe()
	{
		
		Suit suit;
			for(int i=0; i<52; i++)
			{
				
				int suitVal = (int) Math.floor(i/13);
				
				switch(suitVal)
				{
				case'0':
					suit = Suit.SPADE;
					break;
				case'1':
					suit = Suit.CLUB;
					break;
				case'2':
					suit = Suit.DIAMOND;
					break;
				default:
					suit = Suit.DIAMOND;
					break;
				}
				
				cardList.add(new Card(suit, i%13 +1));
				
			}
			
	}
	
	public Card dealCard()
	{
		Random random = new Random();
		int index = random.nextInt(cardList.size());
		Card c = cardList.get(index);
		cardList.remove(index);
		return c;
	}
	
	public boolean isEmpty()
	{
		return cardList.size()==0;
	}
	
	

}
