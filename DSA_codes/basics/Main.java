import java.util.Scanner;
class Main
{ 
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);     
        int r=sc.nextInt();     
        int c=sc.nextInt(); 
        int matrix1[][] = new int[r][c]; 
        int matrix2[][] = new int[r][c];       
        int result[][] = new int[r][c];
        for(int i = 0; i < r; i++)
        {
            for(int j = 0; j < c; j++)
            {
                matrix1[i][j] = sc.nextInt();  
            } 
        } 
        for(int i = 0; i < r; i++)
        {
            for(int j = 0; j < c; j++)
            {
                matrix2[i][j] = sc.nextInt();  
            } 
        } 
        for(int i = 0; i < r; i++)
        {
            for(int j = 0; j < c; j++) 
                result[i][j]=matrix1[i][j] - matrix2[i][j]; 
        } 
        for(int i = 0; i < c; i++){         
            for(int j = 0; j < r; j++){ 
                System.out.print(result[i][j]+" "); 
            } 
            System.out.println(); 
        } 
    } 
} 
