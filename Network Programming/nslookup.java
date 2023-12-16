import java.util.*; 
import java.net.*; 
import java.io.*;
class nslookup 
{
    public static void main(String args[]) throws UnknownHostException
    {
        if(args.length > 0) 
        {
            for(int i = 0; i < args.length; i++)
            {
                System.out.print(lookup(args[i]));
            }
        }
        else 
        {
            BufferedReader bs = new BufferedReader(new InputStreamReader(System.in)); 
            System.out.println("Enter name and IP addresses");
            try 
            {
                while(true)
                {
                    String host = bs.readLine(); 
                    if(host.equalsIgnoreCase("exit")|| host.equalsIgnoreCase("quit")) 
                    {
                        break; 
                    }
                    System.out.println(lookup(host));
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
    }

    public static String lookup(String host) throws UnknownHostException
    {
        InetAddress ad; 
        try 
        {
        ad = InetAddress.getByName(host);
        }
        catch(Exception e)
        {
            return "Cannot find" + host;
        }
        if(isHostname(host))
        {
            return ad.getHostAddress(); 
        }
        else 
        {
            return ad.getHostName();
        }
    }

    public static boolean isHostname(String host) 
    {
        if(host.indexOf(':')!=-1) 
        {
            return false;
        }
        char[] c = host.toCharArray(); 
        for(int i = 0; i < c.length; i++) 
        {
            if(!Character.isDigit(c[i])) 
            {
                if(c[i]!='.')
                {
                    return true;
                }
            }
        }
        return false;
    }
}