import java.util.*;
class test {
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
        int pivot = peak(arr,0,arr.length-1);
        System.out.println("The pivot is at index: ");
        System.out.println(pivot);

    }
    public static int peak(int[] arr, int start, int end)
    {
        int mid = start + (end - start)/2;
        if(mid < end && arr[mid] < arr[mid+1]) return mid;
        if(mid > start && arr[mid] < arr[mid-1]) return mid;
        if(arr[mid] <= arr[start]) return peak(arr,start,mid-1);
        else if(arr[mid] > arr[end]) return peak(arr,mid+1,end);
        else return -1;

    }
    public static int check(int[] arr, int x, int start, int end) //Binary Check
    {
        if(start>end) return -1;
        int mid = (start+end)/2;
        if(arr[mid]==x) return mid;
        if(arr[mid]>x) return check(arr,x,start,mid-1);
        else return check(arr,x,mid+1,end);
    }
}