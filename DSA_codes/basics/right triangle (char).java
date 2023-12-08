import java.util.Scanner;
public class Main
{ 
    public static void main(String args[]){ 
        int i, j; 
        int letter=64; 
        Scanner in = new Scanner(System.in);      
        int row = in.nextInt(); 
        for(i=1;i<=row;i++)
        {           
            for(j=1;j<=i;j++)
            { 
            System.out.print((char)(j+letter)); 
            } 
            System.out.println(); 
        } 
    } 
}
