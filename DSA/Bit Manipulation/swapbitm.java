import java.util.*;
class swapbitm{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter n value: ");
        int n = in.nextInt();
        System.out.println("Enter i value: ");
        int i = in.nextInt();
        System.out.println("Enter j value: ");
        int j = in.nextInt();
        swap(n,i,j);
        EOswap(n);
        counteven(n);
        findalternative(n);
        in.close();
    }
    public static void findalternative(int n)
    {
        int even = n & 0xAAAAAAAA; // 0xAAAAAAAA is 10101010101010101010101010101010
        int odd = n & 0x55555555; // 0x55555555 is 01010101010101010101010101010101
        int arr[] = new int[2];
        for (int i = 0; i < 32; i++) {
            if ((even & (1 << i)) != 0) {
                arr[0]++;
            }
            if ((odd & (1 << i)) != 0) {
                arr[1]++;
            }
        }
    }
    public static void counteven(int n)
    {
        int even = n & 0xAAAAAAAA; // 0xAAAAAAAA is 10101010101010101010101010101010
        int odd = n & 0x55555555; // 0x55555555 is 01010101010101010101010101010101
        int arr[] = new int[2];
        for (int i = 0; i < 32; i++) {
            if ((even & (1 << i)) != 0) {
                arr[0]++;
            }
            if ((odd & (1 << i)) != 0) {
                arr[1]++;
            }
        }
    }
    public static void EOswap(int n)
    {
        int even = n & 0xAAAAAAAA; // 0xAAAAAAAA is 10101010101010101010101010101010
        int odd = n & 0x55555555; // 0x55555555 is 01010101010101010101010101010101
        even >>= 1;
        odd <<= 1;
        System.out.println("Even: "+even+" Odd: "+odd);
        System.out.println("Even | Odd: "+(even|odd));
    }
    public static void swap(int n, int i, int j)
    {
        int x = ((n>>i-1)&1);
        int y = ((n>>j-1)&1);
        int z = x^y;
        System.out.println("x: "+x+" y: "+y+" z: "+z);
        n = n^(z<<i-1);
        n = n^(z<<j-1);
        System.out.println("n: "+n);
    }
}