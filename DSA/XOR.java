import java.util.Scanner;
public class XOR {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter n value: ");
        int n = in.nextInt();
        System.out.println("Enter i value: ");
        int i = in.nextInt();
        //int m = (1 << (i - 1));
        System.out.println("Swap two numbwes without using third variable");
        swap(n,i);
        System.out.println("Compute the XOR from 1 to n");
        compute(n);
        System.out.println("Compute the XOR between two numbers");
        compute(n,i); 
        System.out.println("Enter two numbers: ");
        int a = in.nextInt();
        int b = in.nextInt();
        int x = a^b;
        count(x);
        in.close();
    }
    public static void swap(int a, int b)
    {
        a = a ^ b; // 5 ^ 6 = 3
        b = a ^ b; // 3 ^ 6 = 5
        a = a ^ b; // 3 ^ 5 = 6
        System.out.println("a: "+a+" b: "+b);
    }
    public static int compute(int n)
    {
        int rem = n % 4;
        if(rem == 0)
        {
            System.out.println("XOR: "+n);
            return n;
        }
        else if(rem == 1)
        {
            System.out.println("XOR: "+1);
            return 1;
        }
        else if(rem == 2)
        {
            System.out.println("XOR: "+(n+1));
            return (n+1);
        }
        else
        {
            System.out.println("XOR: "+0);
            return 0;
        }
    }
    public static void compute(int a, int b)
    {
        System.out.println("Compute XOR between n: "+(compute(a-1) ^ compute(b)));
    }
    public static void count(int n){
        int count = 0;
        while(n!=0){
            n = n & (n-1);
            count++;
        }
        System.out.println("Number of bits to be flipped before converting A to B: "+count);
    }
}
