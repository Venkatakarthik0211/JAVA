import java.io.*;
import java.util.*;
class Pattern9
{
    public static void main (String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x = 2 * n - 1;
        for (int i = 0;i < (x / 2) + 1; i++)
        {
            int m = n;
            for (int j = 0; j < i; j++)
            {
                System.out.print(m + " ");
                m--;
            }
            for (int k = 0;
            k < x - 2 * i; k++)
            {
                System.out.print(n - i + " ");
            }
            m = n - i + 1;
            for (int l = 0; l < i; l++)
            {
                System.out.print(m + " ");
                m++;
            }
            System.out.println();
        }
        for (int i = x / 2 - 1;
        i >= 0; i--)
        {
            int m = n;
            for (int j = 0; j < i; j++)
            {
                System.out.print(m + " ");
                m--;
            }
            for (int k = 0;k < x - 2 * i; k++)
            {
                System.out.print(n - i + " ");
            }
            m = n - i + 1;
            for (int l = 0; l < i; l++)
            {
                System.out.print(m + " ");
                m++;
            }
            System.out.println();
        }
    }
}