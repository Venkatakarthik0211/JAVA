import java.util.Scanner;
public class Main
{ 
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);  
        int r=sc.nextInt(); 
        int c=sc.nextInt();     
        int key=sc.nextInt();  
        int arr[][] = new int[r][c];         
        boolean found = false; 
        for(int i = 0; i < r; i++)
        { 
            for(int j = 0; j < c; j++)
            {
                arr[i][j] = sc.nextInt();  
            } 
        } 
        for(int i = 0; i < r; i++)       
        for(int j = 0; j < c; j++)       
        if(arr[i][j]==key)
        { 
            found = true; 
                       System.out.println(i+","+j); 
                       }                 if(!found) 
                System.out.println("Not found"); 
    } 
} 
