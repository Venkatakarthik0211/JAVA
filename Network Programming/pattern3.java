import java.util.*;
class pattern3
{
    public static void main(String args[]) 
    {
        Scanner in = new Scanner(System.in);
        {
            int n = in.nextInt(); 
            for(int i = 1; i<=n-1; i++)
            {
                for(int k = n -i; k>=1; k--)
                {
                        System.out.print(" ");
                }
                for(int j = 1; j<=i; j++)
                {
                    System.out.print((char)(64+j));
                }
                 for(int j = 1; j<i; j++)
                {
                    System.out.print((char)(64+j));
                }
                 System.out.println();
            }
            }
        }
    }
