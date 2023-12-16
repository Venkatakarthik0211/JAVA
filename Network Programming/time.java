import java.net.*; 
import java.io.*; 
import java.util.*;
class time
{
    public static void main(String args[]) 
    {
        server(); 
        client(); 
    }
    public static void server() 
    {
        int port = 13; //If need traverse each port
        try
        {
            ServerSocket s = new ServerSocket(port);
            while(true) 
            {
                Socket conn = s.accept(); //To accept new connections 
                Writer out = new OutputStreamWriter(conn.getOutputStream());
                Date d = new Date();
                out.write(d.toString()+"\r\n");
                out.flush(); 
                conn.close(); //Connection close
            }
        }
        catch(Exception e) 
        {
            
        }
    }

    public static void client() 
    {
        String host;
        host = "time.nist.gov";
        try 
        {
            Socket s = new Socket(host,13 );
            InputStream ts = s.getInputStream(); 
            StringBuffer t = new StringBuffer();
            int c; 
            while ((c=ts.read())!=-1) 
            {
                t.append((char)c);
            }
            String st = t.toString().trim(); 
            System.out.println("Time Stamp "+st+" at Host "+host ); 
            s.close();
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
    }
}

/*import java.io.*;
import java.net.*; 
class time 
{
public static void main(String args[])
{
String w1 = "time.nist.gov";
String w2 = "time.windows.com";
//Why we use port 13? 
/*By convention, the Daytime Protocol listens on TCP port 13.
 * Therefore, to connect to a server using the Daytime Protocol,
 * you need to use port 13 as the destination port. 
 * When you establish a connection to a server on port 13, 
 * the server will automatically send the current date and time as a response.
 * This is why we use port 13 in this example to retrieve the daytime stamp from the websites.

try 
{
Socket s1 = new Socket(w1,13);  
BufferedReader r1 = new BufferedReader(new InputStreamReader(s1.getInputStream()));
String l1 = r1.readLine();
System.out.println("Datetime Stamp of = " + w1 + " is :"+ l1);

Socket s2 = new Socket(w2,13);  
BufferedReader r2 = new BufferedReader(new InputStreamReader(s1.getInputStream()));
String l2 = r1.readLine();
System.out.println("Datetime Stamp of = " + w2 + " is :"+ l2);

if(l1.equals(l2))
{
System.out.println("Time stamps are same");
}
}
catch(Exception e)
{

}
}*/
