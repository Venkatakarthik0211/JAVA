package DSA.Arrays;
import java.util.*;
public class binarysearchapplications {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int n = in.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array: ");
        for(int i=0;i<n;i++)
        {
            arr[i] = in.nextInt();
        }
        System.out.println("Check if the array is sorted: ");
        System.out.println(check(arr,0));
        System.out.println("Enter the target to find ceiling of a number"); 
        int x = in.nextInt();
        System.out.println("The ceiling of the number is: ");
        System.out.println(ceiling(arr,x,0,n-1));
        System.out.println("Enter the target to find floor of a number"); 
        x = in.nextInt();
        System.out.println("The floor of the number is: ");
        System.out.println(floor(arr,x,0,n-1));
        System.out.println("Binary Search iterative Approach");
        System.out.println(search(arr,x,0,n-1));
        in.close();
    }
    public static boolean check(int[] arr, int index) //Linear Search
    {
        if(index==arr.length-1) return true;
        return arr[index]<arr[index+1] && check(arr,index+1);
    }
    public static int search(int[] arr, int x, int start, int end) //Binary Search, iterative approach
    {
        if(x<arr[start] || x>arr[end]) return -1;
        while(start<=end)
        {
            int mid = (start+end)/2;
            if(arr[mid]==x) return mid;
            if(arr[mid]>x) end = mid-1;
            else start = mid+1;
        }
        return -1;
    }
    public static int ceiling(int[] arr, int x, int start, int end) //Binary Check
    {
        if(start>end) return arr[start];
        int mid = (start+end)/2;
        if(arr[mid]==x) return arr[mid];
        if(arr[mid]>x) return ceiling(arr,x,start,mid-1);
        else return ceiling(arr,x,mid+1,end);
    }
    public static int floor(int[] arr, int x, int start, int end) //Binary Check
    {
        if(start>end) return arr[end];
        int mid = (start+end)/2;
        if(arr[mid]==x) return arr[mid];
        if(arr[mid]>x) return floor(arr,x,start,mid-1);
        else return floor(arr,x,mid+1,end);
    }
    
}
