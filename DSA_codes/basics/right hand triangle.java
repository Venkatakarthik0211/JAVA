import java.util.Scanner; public class Main
{ 
    public static void main(String args[])
    {     
        int i, j; 
        Scanner in = new Scanner(System.in);     
        int row = in.nextInt();      
        for(i=1;i<=row;i++){         
            for(j=(row-i);j>=0;j--)
            { 
                System.out.print(" "); 
            } 
            for(j=1;j<=i;j++){ 
            System.out.print("@"); 
            } 
            System.out.println(); 
        } 
    } 
} 
