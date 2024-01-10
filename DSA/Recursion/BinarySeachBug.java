import java.util.Scanner;

public class BinarySeachBug {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");    
        int n = in.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array: ");
        for(int i=0;i<n;i++)
        {
            arr[i] = i; 
        }
        System.out.println("Enter the element to be searched: ");
        int x = in.nextInt();
        System.out.println("The element is present at index: ");
        System.out.println(search(arr,x));
        in.close();
    }
    public static int search(int[] nums, int target) { //Binary Search
        int n = nums.length-1;
        return check(nums,target,0,n);

    }
    public static int check(int[] arr, int x, int start, int end) //Binary Check
    {
        if(start>end) return -1;
        int mid = end - (end - start)/2;
        if(arr[mid]==x) return mid;
        if(arr[mid]>x) return check(arr,x,start,mid-1);
        else return check(arr,x,mid+1,end);

    }
}
