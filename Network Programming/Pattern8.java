import java.util.*; 
class Pattern8
{
    public static void main(String args[]) 
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 1; i<=n; i++)
            {
                int count = 1;
                for(int j=i;j>=1; j--) 
                {
                    System.out.print(count);
                    count++;
                }
                for(int j = 1; j<=2*(n-i); j++)
                {
                  System.out.print(" ");
                }
                count = 1;
                for(int j=i;j>=1; j--) 
                {
                    System.out.print(count);
                    count++;
                }
                System.out.println();
            }
    }
}