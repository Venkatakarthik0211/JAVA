import java.net.*; 
import java.io.*; 
class urlencoder 
{
    public static void main(String args[]) 
    {
        try 
        {
            for(int i = 0; i<=90;i++)
            {
                System.out.println(URLEncoder.encode("This string "+(char)i+" has encoded"));
            }
        }
        catch(Exception e) 
        {
            System.out.println(e);
        }
    }
}