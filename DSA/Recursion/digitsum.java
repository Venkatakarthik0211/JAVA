import java.util.Scanner;
public class digitsum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int n = in.nextInt();
        System.out.println("The sum of digits is: ");
        System.out.println(sum(n));
        System.out.println(product(n));
        System.out.println("Count of zeros is:   ");
        System.out.println(count(n,0));
        System.out.println("Print the reverse of the number: ");
        int rev = reverse(n,0);
        System.out.println(rev);
        System.out.println("Is the number palindrome? ");
        System.out.println(rev==n);
        in.close();
    }
    public static int reverse(int n, int temp)
    {
        if(n==0) return temp;
        return reverse(n/10, temp*10 + n%10);
    }
    public static int count(int n, int c)
    {
        if(n==0) return c; 
        if(n%10==0) return count(n/10, c+1);
        else return count(n/10, c);
    }
    public static int product(int n)
    {
        if(n%10==0) return n;
        return n%10 * product(n/10);
    }
    public static int sum(int n){
        if(n==0) return 0;
        return n%10 + sum(n/10);
    }
}
