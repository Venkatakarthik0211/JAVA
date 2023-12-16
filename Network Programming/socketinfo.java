import java.net.*;
import java.io.*; 
class socketinfo
{
    public static void main(String args[]) 
    {
        //From Port - local Port 
        int port = 80;
            try 
            {
                Socket s = new Socket("www.vitap.ac.in",port);
                System.out.println(
                " Connected to "+s.getInetAddress()+ 
                " \nOn Port"+ s.getPort() + 
                " \nFrom Port " + s.getLocalPort() + 
                " \nOf Address " + s.getLocalAddress()
                );
            }
            catch(Exception e) 
            {
                
            }
        }
    }