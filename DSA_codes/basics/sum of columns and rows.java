import java.util.Scanner; 
public class Main
{ 
    public static void main(String args[])
    { 
        Scanner sc = new Scanner(System.in);
        int rs=0, cs=0;         
        int r=sc.nextInt();     
        int c=sc.nextInt();     
        int arr[][] = new int[r][c];        
        for(int i = 0; i < r; i++)
        {
            for(int j = 0; j < c; j++)
            {
                arr[i][j] = sc.nextInt();  
            } 
        } 
        for(int i = 0; i < r; i++)
        {
            for(int j = 0; j < c; j++) 
            rs+=arr[i][j]; 
                System.out.println("Row "+i+" "+rs);  
                rs=0; 
        } 
        for(int i = 0; i < c; i++)
        {
            for(int j = 0; j < r; j++)      
            cs+=arr[j][i]; 
                System.out.println("Column "+i+" "+cs);             cs=0; 
        } 
    } 
} 

