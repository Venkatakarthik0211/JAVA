import java.util.Scanner; 
class Main{ 
    public static void main(String args[]) 
    { 
        Scanner sc = new Scanner(System.in);        
        int n =sc.nextInt(); 
        int[] myarray = new int[n];
        for(int i=0; i<n; i++)
        {
            myarray[i]= sc.nextInt(); 
        } 
        int min = 1000;         
        int secondmin = 1000; 
        for(int i =0; i<myarray.length; i++)
        {       
            if(myarray[i]==min)
            { 
                secondmin=min; 
            } 
            else if(myarray[i]<min){       
                secondmin=min;  
                min= myarray[i]; 
            } 
            else if (myarray[i]<secondmin){          
                secondmin=myarray[i]; 
            } 
        } 
        System.out.println(secondmin); 
    } 
} 
