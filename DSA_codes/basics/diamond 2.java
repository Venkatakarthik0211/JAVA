import java.util.Scanner; public class Main{ 
    public static void main(String args[])
    {    
        Scanner in = new Scanner(System.in);      
        int row = in.nextInt();       
        for(int i=1;i<=row;i++)
        {       
            for(int j=1;j<=row-i;j++)
            { 
            System.out.print(" "); 
            } 
            for(int k=i;k>=1;k--){ 
                System.out.print("*"); 
            } 
            for(int l=2;l<=i;l++){ 
                System.out.print("*"); 
            } 
            System.out.println(); 
        } 
        for(int i=row-1;i>=1;i--){            
            for(int j=0;j<=row-1-i;j++){ 
                System.out.print(" "); 
            } 
            for (int k=i;k>=1;k--){ 
                System.out.print("*"); 
            } 
            for(int l=2;l<=i;l++){ 
                System.out.print("*"); 
            } 
            System.out.println(); 
        } 
    } 
} 

