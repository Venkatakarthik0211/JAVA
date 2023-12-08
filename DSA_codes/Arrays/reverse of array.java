import java.util.Scanner;  
public class Main
{ 
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);    
        int n =sc.nextInt();     
        int[] numbers = new int[n]; 
        for(int i=0; i<n; i++)
        {   
            numbers[i]= sc.nextInt(); 
    } 
    for (int i=0; i<numbers.length/2; i++){     
        int temp = numbers[i]; 
        numbers[i]=numbers[numbers.length-1-i]; 
        numbers[numbers.length-1-i] = temp; 
    } 
    for(int i=0; i<numbers.length; i++ ){ 
        System.out.print(numbers[i]+" "); 
    } 
    }   
} 
