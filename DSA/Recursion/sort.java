import java.util.Arrays;
import java.util.Scanner;

public class sort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Quick Sort is: ");
        quicksort(arr,0,n-1);
        System.out.println(Arrays.toString(arr));
        System.out.println("Selection Sort is: ");
        System.out.println(Arrays.toString(selection(arr,arr.length,0,0)));
        int[] aux =  Arrays.copyOfRange(arr, 0, n);
        System.out.println("Merge Sort is: ");
        System.out.println(Arrays.toString(mergesort(arr,aux,0,n-1)));
        //bubblesort(arr, 0, n - 1);
        //System.out.println("Bubble Sort is: ");
        //System.out.println(Arrays.toString(arr));
        sc.close();
    }
    public static void quicksort(int[] arr, int low, int high)
    {
        if(low>=high) return;
        int mid = low + ((high - low)>>1);
        int start = low, end = high;
        int pivot = arr[mid];

        //Fix the pivot element
        while(start<end)
        {
            while(arr[start]<pivot) start++;
            while(arr[end]>pivot) end--;
            if(start<=end)
            {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }

            //Recursively sort the two sub parts
            quicksort(arr, low, end);
            quicksort(arr, start, high);

        }
    }
    public static int[] mergesort(int[] arr, int[] aux, int low, int high)
    {
        if(low == high) return arr;
        int mid = low + ((high - low)>>1);
        mergesort(aux, arr, low, mid);
        mergesort(aux, arr, mid+1, high);
        merge(arr, aux, low, mid, high);
        return arr;
    }
    public static int[] merge(int[] arr, int[] aux, int low, int mid, int high)
    {
        int i = low, j = mid+1, k = low;
        while(i<=mid && j<=high)
        {
            if(aux[i]<=aux[j])
            {
                arr[k] = aux[i];
                i++;
            }
            else
            {
                arr[k] = aux[j];
                j++;
            }
            k++;
        }
        while(i<=mid)
        {
            arr[k] = aux[i];
            i++;
            k++;
        }
        while(j<=high)
        {
            arr[k] = aux[j];
            j++;
            k++;
        }
        return arr;
    }
    public static void bubblesort(int[] arr, int c, int r)
    {
        if(c==r) return; 
        if(arr[c]>arr[c+1]){
            int temp = arr[c];
            arr[c] = arr[c+1];
            arr[c+1] = temp;
        }
        bubblesort(arr, c+1, r);
        bubblesort(arr, 0, r-1); 
    }
    public static int[] selection(int[] arr, int r, int c, int max) {
        if(r==0) return arr;
        if (c < r) {
            if (arr[c] > arr[max]) {
                selection(arr, r, c + 1, c);
            } else {
                selection(arr, r, c + 1, max);
            }
        } else {
            int temp = arr[max];
            arr[max] = arr[r - 1];
            arr[r - 1] = temp;
            selection(arr, r - 1, 0, 0);
        }
        return arr;
    }
}
