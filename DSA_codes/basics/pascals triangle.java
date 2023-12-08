import java.util.Scanner; 
public class Main
{ 
    public static void main(String args[])
    {       
        int norow, c=1, blk, i, j; 
        Scanner in = new Scanner(System.in);     
        norow = in.nextInt();       
        for(i=0;i<norow;i++){ 
            for(blk=1;blk<=norow-i;blk++)        
            System.out.print(" ");        
            for(j=0;j<=i;j++)
            {          
                if(j==0||i==0)         
                c=1;             
                else          
                c=c*(i-j+1)/j;         
                System.out.print(" "+c); 
            } 
            System.out.print("\n"); 
        } 
    } 
} 
