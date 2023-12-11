import java.util.*;
class Recursion 
{
public static void main(String args[]) 
{
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int arr[] = new int[n]; 
    for(int i=0; i<n; i++)
    {
        arr[i] = in.nextInt(); 
    }
    if(check(arr,n)==true)
    {
        System.out.println("They are in order");
    }
    else 
    {
        System.out.println("They are not in order");
    }
    in.close();
}
public static boolean check(int[] arr,int n)
{
    if(n==1 || n == 0 ) return true; 
    else return arr[n-1]>arr[n-2]?false:check(arr,n-1);
}
}