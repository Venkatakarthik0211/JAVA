import java.util.Scanner;
public class Main
{ 
    public static void main(String args[])
    {   
        Scanner sc = new Scanner(System.in);         
        int r=sc.nextInt();     
        int arr[][] = new int[r][r];         
        int temp=0; 
        for(int i = 0; i < r; i++)
        {  
            for(int j = 0; j < r; j++)
            {
                arr[i][j] = sc.nextInt();  
            }    
            } 
                for(int i = 0; i < r; i++)
                {
                    for(int j = i+1; j < r; j++)
                    { 
                        temp = arr[i][j];  
                        arr[i][j] = arr[j][i];
                        arr[j][i] = temp; 
                    } 
                } 
                for(int[]ro:arr)
                {  
                    for(int e:ro)
                    { 
                       System.out.print(e+" "); 
                   } 
                   System.out.println(); 
                } 
    } 
} 

