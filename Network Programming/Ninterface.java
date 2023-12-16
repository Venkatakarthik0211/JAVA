import java.net.*; 
import java.util.*;
class Ninterface
{
    public static void main(String args[]) 
    {
        //These objects represents physical hardware and virtual addresses
        //which represents local IP
        try 
        {
            //To know Socket exists
            InetAddress ad = InetAddress.getByName("127.0.0.1");
            NetworkInterface ni = NetworkInterface.getByName("wlan0");
            if(ni==null)
                System.out.println("No interface found");
            System.out.println(ni);
            //To know if list of sockets exits,
            //By SocketException - No socket
            //By UnknowHostException - No local loop back IP
            ni = NetworkInterface.getByInetAddress(ad);
            if(ni==null)
                System.out.println("No interface found");
            System.out.println(ni);
            //For enumeration
            System.out.println("---Enumeration---");
            Enumeration i = NetworkInterface.getNetworkInterfaces();
            while (i.hasMoreElements( )) {
                ni = (NetworkInterface) i.nextElement( );
                System.out.println(ni);
            }
        }
        //SocketException e
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}