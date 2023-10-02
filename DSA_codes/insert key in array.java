import java.util.Scanner;
public class something
{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int i,p=0,in;
        System.out.println("Input The Size Of Array :");
        int n = sc.nextInt();
        System.out.println("Enter The Array Elements In Ascending Order: ");
        int [] arr = new int[n+1];
        for(i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter The Element For Insertion");
        in = sc.nextInt();
        for(i=0;i<n;i++)
        if(in<arr[i]){
            p = i;
            break;
        }
        for(i=n;i>=p;i--)
        arr[i]= arr[i-1];
        arr[p]=in;
        System.out.println("After Insertion Array Is :");
        for(i=0; i<=n; i++){
            System.out.println(arr[i]);
        }
    }
}
