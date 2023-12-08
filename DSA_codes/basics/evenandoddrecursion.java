import java.util.*;
class fun 
{
	public static void main(String[] args) 
	{
		System.out.println("Please enter the value of n in between 1 to 10");
		Scanner s = new Scanner(System.in);
		int num = s.nextInt();
		if(num%2==0)
		{
		  evennumrecursion(num); 
		}
		else
		{
		  oddnumrecursion(num);
		}
	}
    public static void oddnumrecursion(int num)
    {
    	num = 3*num+1;
    	if(num%2==0)
    	{
    		System.out.println(num);
    		evennumrecursion(num);
    	}
    	else if(num==1)
    	{
    		System.out.println(num);
    	}
    	else
    	{
    		System.out.println(num);
    		oddnumrecursion(num);
    	}
    }
    public static void evennumrecursion(int num)
    {
    	num = num/2;
    	if(num%2==0)
    	{
    		System.out.println(num);
    		evennumrecursion(num);
    	}
    	else if(num==1)
    	{
    		System.out.println(num);
    	}
    	else
    	{
    		System.out.println(num);
    		oddnumrecursion(num);
    	}
    }
}

