import java.util.*;
public class revisionbitm2 {
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter n value: ");
        int n = in.nextInt();
        System.out.println("Enter i value: ");
        int i = in.nextInt();
        int m = (1 << (i - 1));
        System.out.println("Toggle the ith bit: "+(n^m));
        System.out.println("Count the number of bits: "+Integer.bitCount(n)); //approach 1
        System.out.println("Count the number of set bits: ");  //approach 2
        count(n);
        in.close();
  }
  public static void count(int n)
  {
    int count = 0;
    while (n!=0) {
        n = n & (n-1);
        count++;
    }
    System.out.println(count);
  }
}