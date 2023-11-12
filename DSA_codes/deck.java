import java.util.*;
class Main
{
	public static void main(String[] args) {
	    String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
       int[] deck=new int[52];
       int i,s=0,diff=0;
       deck=ini();
       deck=shu(deck);
       for(i=0;i<2;i++)
       {
       s=s+pick(deck,i);
       rank(deck,i);
       suit(deck,i);
       System.out.println();
       }
       if(s<11){
           int index = (int)(Math.random() * 52)%4;
       System.out.println("King" +" of " +suits[index]);
       s=s+13;
        diff=24-s;
        index = (int)(Math.random() * 52)%4;
       System.out.println((24-s) +" of " +suits[index]);
       
       }
        else
       {diff=24-s;
       int m=diff/2;
       int n=diff-m;
       int index = (int)(Math.random() * 52)%4;
       System.out.println(m +" of " +suits[index]);
        index = (int)(Math.random() * 52)%4;
       System.out.println(n +" of " +suits[index]);
       }
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
	{  int[] ranks = {1,2,3,4,5,6,7,8,9,10,11,12,13};
             int rank = ranks[deck[i] % 12];
              return rank;
	}
	static void suit(int[] deck,int i)
	{  String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
          
	         String suit = suits[deck[i] / 13];
              System.out.print(suit);
	}
	static void rank(int[] deck,int i)
	{
         int[] ranks = {1,2,3,4,5,6,7,8,9,10,11,12,13};
             int rank = ranks[deck[i] % 12];
              System.out.print(rank + " of ");
	}
}