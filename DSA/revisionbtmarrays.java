import java.util.*;
public class revisionbtmarrays {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i<n; i++)
        {
            arr[i] = in.nextInt();
        }
        missing(arr,n);
        in.close();
    }
    public static void missing(int[] a,int n){ // valid to only 0 to n
        int missing = 0;
        for(int i = 0; i<n; i++)
        {
            missing = missing ^ a[i];
        }
        for(int i = 1; i<=n+1; i++)
        {
            missing = missing ^ i;
        }
        System.out.println("Missing number is: "+missing);
    }
}
