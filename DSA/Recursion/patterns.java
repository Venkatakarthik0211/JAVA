import java.util.Scanner;
class patterns 
{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of rows: ");
        int n = in.nextInt();
        pattern3(n,1);
        pattern1(n,1);
        pattern4(n,1);
        pattern2(n,1);
        in.close();
    }
    public static void pattern4(int n,int i)
    {
        if(n==0) return;
        space(i-1);
        characters(n);
        System.out.println();
        pattern4(n-1,i+1);
    }
    public static void pattern3(int n,int i)
    {
        if(n==0) return;
        space(n-1);
        characters(i);
        System.out.println();
        pattern3(n-1,i+1);
    }
    public static void characters(int n)
    {
        if(n==0) return;
        System.out.print(" * ");
        characters(n-1);
    }
    public static void space(int n)
    {
        if(n==0) return;
        System.out.print("   ");
        space(n-1);
    }
    public static void pattern2(int n,int i)
    {
        if(n==0) return;
        printrow(n);
        System.out.println();
        pattern2(n-1,i-1);
    }
    public static void pattern1(int n,int i) 
    {
        if(n==0) return;
        printrow(i);  
        System.out.println();
        pattern1(n-1,i+1); 
    }
    public static void printrow(int i)
    {
        if(i==0) return;
        System.out.print(" * ");
        printrow(i-1);
    }

}