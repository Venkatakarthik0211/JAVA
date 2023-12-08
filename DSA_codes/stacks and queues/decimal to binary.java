
// Java Program to Convert a Decimal Number
// to Binary Number using Stacks
  
import java.util.*;
 class Main {
    static int arr[] = new int[1000];
  
    // maintaining count variable as the top
    // of the stack
    static int count;
  
    // push at the count index and increment the count
    public static void push(int n) { arr[count++] = n; }
  
    // pop all the elements starting from count-1
    // till 0
    public static void pop()
    {
        for (int i = count - 1; i >= 0; i--) {
            System.out.print(arr[i]);
        }
    }
  
    public static void main(String args[])
    {
        System.out.println("Enter a decimal number: ");
        int num = 1;
  
        while (num > 0) {
            int r = num % 2;
            push(r);
            num /= 2;
        }
  
        System.out.print("Binary equivalent: ");
  
        pop();
    }
}