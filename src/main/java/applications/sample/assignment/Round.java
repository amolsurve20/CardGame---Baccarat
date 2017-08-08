package applications.sample.assignment;
import java.util.*;

import applications.games.cardgames.Hand;
public class Round 
{
	private ArrayList<Coup>coupList;
	private ArrayList<Hand>handList;
	
	public Round()
	{
		this.handList = new ArrayList<Hand>();
		this.coupList = new ArrayList<Coup>();
		handList.add(new Hand(HandType.BANKER));
		handList.add(new Hand(HandType.PLAYER));
	}
	
	void newround()
	{
		for(int i=0; i<2; i++)
		{
			handList.get(i).clearHand();
		}
		
		coupList.clear();
	}
	
	public Coup playerCoup(Player player, double amount, int coupIndex)
	{
		if(amount>player.getBalance())
		{
			System.out.println("Cannot place this bet due to insufficient balance");
			return null;
		}
		
		CoupType coup;
		
		switch(coupIndex)
		{
			case '0':
				coup = CoupType.BANKER;
				break;
			case '1':
				coup = CoupType.PLAYER;
				break;
			case '2':
				coup = CoupType.TIE;
				break;
			case '3':
				coup = CoupType.PASS;
				break;
			default:
				coup = CoupType.PASS;
				break;
		}
		
		return new Coup(coup, amount);
		
		
	}
	
	public void placeAllCoups(ArrayList<Player>players)
	{
		Scanner sc = new Scanner(System.in);
		
		for(int i=0;i<players.size(); i++)
		{
			double amount = sc.nextDouble();
			int index = sc.nextInt();
			Coup coup = playerCoup(players.get(i), amount, index);
			coupList.add(coup);
		}
	}
	
	public Card dealCard(Hand hand, Shoe shoe)
	{
		if(shoe.isEmpty())
			shoe.buildShoe();
		
		Card card = shoe.dealCard();
		hand.addCard(card);
		return card;
		
	}
	
	public void dealTwocards(Shoe shoe)
	{
		for(int i=0; i <2; i++)
		{
			for(int j=0; j <2; j++)
			{
				dealCard(handList.get(i),shoe);
			}
		}
	}
	
	public void dealThirdCard(Shoe shoe)
	{
		boolean bankerDraw = false;

		boolean playerDraw = false;
		
		int playerThirdCard=0;
		int bankerThirdCard;
		
		int playerHandVal, bankerHandVal;
		
		playerHandVal = handList.get(1).calculateValue();
		bankerHandVal = handList.get(0).calculateValue();
		
		if(!(playerHandVal>7) || !(bankerHandVal>7))
		{
			//Handling the player side first
			if(playerHandVal<6)
			{
				playerDraw = true;
				playerThirdCard = dealCard(handList.get(1), shoe).getPointValue();
			}
			else
			{
				playerDraw = false;
			}
			
			if(playerDraw == false)
			{
				if(bankerHandVal<6)
				{
					bankerDraw =true;
				}
			}
				else
					if( bankerHandVal<3)
					{
						bankerDraw=true;
					}
					else
					{
						switch(bankerHandVal)
						{
						case'3':if(playerThirdCard!=8)
						{
							bankerDraw = true;
							break;
						}
						case '4':
							if(playerThirdCard>1 && playerThirdCard<8)
							{
								bankerDraw =true;
								break;
							}
						case '5':
							if(playerThirdCard>3 && playerThirdCard<8)
							{
								bankerDraw =true;
								break;
							}
						case '6':
							if(playerThirdCard>5 && playerThirdCard<8)
							{
								bankerDraw =true;
								break;
							}
						default:
							break;
							
						}
						
					}
			
		}
		
		if(bankerDraw)
		{
			dealCard(this.handList.get(0), shoe);
		}
		
		for (Hand hand : handList) 
		{
            hand.calculateValue();
        }
		
		
		
	}

}
