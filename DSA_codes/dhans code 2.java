public class Main
{
	public static void main(String[] args) {
	    String[] suits = {"Spades", "Clubs", "Diamonds", "Hearts"};
       int[] deck=new int[52];
       int i,diff=0,c=0;
       deck=ini();
       
      while(true)
       { int s=0;
       for(i=0;i<4;i++)
          {  deck=shu(deck);
              s=s+pick(deck,i);
      card(deck,i);
       suit(deck,i);
       c++;
          }
          if(s!=24)
          {System.out.println("the sum i s" +s);
          s=0;
          }
          else
          {System.out.println("the sum is " +s);
          break;
          }
       }
       System.out.println("the number of picks = " +c );
	}
	static int[] ini()
	{int[] deck=new int[52];
	    for(int i = 0; i<52; i ++)
            deck[i] = i;
            return deck;
	}
	static int[] shu(int[] deck)
	{for(int i=0;i<52;i++)
	    {int index = (int)(Math.random() * 52);
	    int temp = deck[i];
             deck[i] = deck[index];
             deck[index] = temp;
	    }
	    return deck;
	}
	static int pick(int[] deck,int i)
	{  int[] cards = {1,2,3,4,5,6,7,8,9,10,11,12,13};
             int card = cards[deck[i] % 13];
              return card;
	}
	static void suit(int[] deck,int i)
	{  String[] suits = {"Spades", "Clubs", "Diamonds", "Hearts"};
          
	         String suit = suits[deck[i] / 13];
              System.out.print(suit);
	}
	static void card(int[] deck,int i)
	{
         String[] cards = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
             String card = cards[deck[i] % 13];
              System.out.print(card + " of ");
	}
}