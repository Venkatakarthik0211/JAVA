import java.io.*; 
import java.net.*; 
import java.util.*;
public class HTTPmethods 
{
    public static void main(String args[])
    {
        try 
        {
            call();
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
    }

    public static void call()
    {
        try 
        {
            Scanner in = new Scanner(System.in);
            String url = in.nextLine();
            URL u = new URL(url);
            HttpURLConnection c = (HttpURLConnection)u.openConnection();
            c.setRequestMethod("GET");
            //c.setRequestProperty();

        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }

    }
}