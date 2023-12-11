import java.util.*; 
class Main 
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int base = in.nextInt();
        int ans = 0, last = 0;
        while(n>0)
        {
            last = n & 1; 
            n = n >> 1;
            ans = ans + last * base;
            base = base * 5;
        }
        System.out.println(ans);
        in.close();
        }
}