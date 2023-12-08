import java.util.Scanner;
public class Main
{ 
public static void main(String args[])
{ 
    Scanner sc = new Scanner(System.in);        
    int n=sc.nextInt(); 
        int arr[][] = new int[n][n];
        boolean upper = true;   
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                arr[i][j] = sc.nextInt();  
            } 
        } 
        for(int i = 0; i < n; i++)      
        for(int j = 0; j < n; j++)    
        if((j<i)&&(arr[i][j]!=0))     
        upper = false;       
        if(upper) 
                       System.out.println("Matrix is upper triangular"); 
                   else 
                       System.out.println("Matrix is not upper triangular"); 
    } 
} 

