import java.util.Scanner;
class BubbleSort {
  public static void main(String []args) {
    int n, c, d, swap;
    Scanner in = new Scanner(System.in);
    int m = in.nextInt();
    n = in.nextInt();
 
    int a1[] = new int[m];
    int a2[] = new int[n];
    int a3[] = new int[n+m+2];
 
    System.out.println("Enter " + n + " integers");
 
    for (c = 0; c < n; c++)
    {
      a1[c] = in.nextInt();
       a2[c] = in.nextInt();

    }
    for (c = 0; c < m; c++)
    {
        
      a3[c]=a1[c];
    }
    
    for (c = 0; c < n; c++)
    {
        
      a3[c+n]=a2[c];
    }
    for (c = 0; c < ( n - 1 ); c++) {
      for (d = 0; d < n - c - 1; d++) {
        if (a3[d] > a3[d+1]) /* For descending order use < */
        {
          swap       = a3[d];
          a3[d]   = a3[d+1];
          a3[d+1] = swap;
        }
      }
    }
      for (c = n; c < ( n + m- 1 ); c++) {
      for (d = n; d < n + m - c - 1; d++) {
        if (a3[d] > a3[d+1]) /* For descending order use < */
        {
          swap       = a3[d];
          a3[d]   = a3[d+1];
          a3[d+1] = swap;
        }
      }
    }
 
    System.out.println("Sorted list of numbers:");
  for (c = 0; c < n + m; c++)
    {
      System.out.println(a3[c]);
  }
}
}
