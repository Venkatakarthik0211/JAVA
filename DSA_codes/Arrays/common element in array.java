import java.util.Scanner; public class Main
{   
    public static void main(String args[])
    {  
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();    
        int[] array1 = new int[n]; 
        int[] array2 = new int[n];       
        for(int i=0; i<n; i++)
        {         
            array1[i]= sc.nextInt(); 
        }         for (int i=0; i<n; i++)
        {             
            array2[i]=sc.nextInt();             
            }         for(int i=0; i<array1.length; i++ )
            { 
                for(int j=0; j<array2.length; j++)
                {   
                    if(array1[i]==(array2[j])){ 
                   System.out.print((array1[i]+" ")); 
                } 
            } 
        } 
    } 
} 
