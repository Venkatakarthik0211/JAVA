import java.util.ArrayList;
import java.util.Scanner;

public class arrayrec {
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
        System.out.println("Enter the element to be searched: ");
        int x = in.nextInt();
        System.out.println("The element is present at index: ");
        System.out.println(search(arr,0,x));
        System.out.println(search(arr,x));
        System.out.println("Multiple occurences of the element are present at index: ");
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println(searchall(arr,0,x,list));
        System.out.println(searchall2(arr,0,x));
        in.close();
    }
    public static ArrayList<Integer> searchall2(int[] arr, int index, int x) //Linear Search
    {
        ArrayList<Integer> list = new ArrayList<>();
        if(index==arr.length) return list;
        if(arr[index]==x) list.add(index); //If the element is found, add the index to the list
        list.addAll(searchall2(arr,index+1,x)); //Add all the elements of the list to the list  
        return list;
    }
    public static ArrayList<Integer> searchall(int[] arr, int index, int x, ArrayList<Integer> list) //Linear Search
    {
        if(index==arr.length) return list;
        if(arr[index]==x) list.add(index);
        return searchall(arr,index+1,x,list);
    }   
    public static int search(int[] nums, int target) { //Binary Search
        int n = nums.length-1;
        return check(nums,target,0,n);

    }
    public static int check(int[] arr, int x, int start, int end) //Binary Check
    {
        if(start>end) return -1;
        int mid = (start+end)/2;
        if(arr[mid]==x) return mid;
        if(arr[mid]>x) return check(arr,x,start,mid-1);
        else return check(arr,x,mid+1,end);

    }
    public static int search(int[] arr, int index, int x) // Linear Search
    {
        if(index==arr.length) return -1;
        return arr[index]==x?index:search(arr,index+1,x);

    }
    public static boolean check(int[] arr, int index) // Check if array is sorted - Linear Search
    {
        if(arr.length==1 || arr.length==0) return true;
        return arr[index]<=arr[index+1] && check(arr,index+1);
    }
}
