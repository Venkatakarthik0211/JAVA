import java.util.*;
public class revisionbitm {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter n value: ");
        int n = in.nextInt();
        System.out.println("Enter i value: ");
        int i = in.nextInt();
        representationANDreverse(n);
        int m = (1 << (i - 1));
        System.out.println("Find the position and delete right most set bit");                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
        last(n,i,m);
        System.out.println("Check the ith bit and unset the value: "+reset(n,i,m));
        in.close();
    }
    public static void representationANDreverse(int n)
    {
        for(int i = 7; i>=0; i--) // 8 bit representation
        {
            int mask = (1 << i);
            if((n & mask) != 0)
            {
                System.out.print("1");
            }
            else
            {
                System.out.print("0");
            }
        }
        System.out.println();
        System.out.println("Reverse the bits");
        int ans = 0;    
        for(int i = 7; i>=0; i--) // 8 bit representation
        {
            ans<<= 1;
            ans = ans|(n&1);
            n>>=1;
        }
        System.out.println(ans);
    }
    public static int reset(int n, int i, int m)
    {
        if ((n & m) != 0) {
        System.out.println("SET");
        System.out.println("RESET THE VALUE");
        m = ~m;
        }
        return (n&m); // mask with OR is SET, negation of mask with AND is RESET and mask with XOR is TOGGLE
    }
    public static void last(int n, int i, int m)
    {
        System.out.println("Position of rightmost bit: "+(n&(~(n-1))));
        System.out.println("Remove rightmost bit: "+(n&(n-1))); //if n&(n-1)==0 then it is power of 2    
        if (n > 0 && (n & (n - 1)) == 0 && (n & 0xAAAAAAA) == 0) { //0xAAAAAAA for power of 4, 0xB6DB6DB6 for power of 8 - observe pattern
        System.out.println(n + " is a power of 8");
        } else {
        System.out.println(n + " is not a power of 8");
        }
    }
}
