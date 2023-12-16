import java.util.*; 
import java.net.*; 
import java.io.*; 
import java.net.ServerSocket;

public class server 
{
    public static void main(String args[]) throws Exception
    {
        Socket s = null; 
        InputStreamReader in = null; 
        OutputStreamWriter os = null; 
        BufferedReader r = null; 
        BufferedWriter w = null; 
        ServerSocket ss = null;
        ss= new ServerSocket(4);
        while(true) 
        {
            try 
            {
                s = ss.accept();
                in = new InputStreamReader(s.getInputStream());
                os = new OutputStreamWriter(s.getOutputStream());
                r = new BufferedReader(in);
                w = new BufferedWriter(os);
                while(true) 
                {
                    String msg = r.readLine(); 
                    System.out.println("Client: "+msg);
                    w.write("Message Recieved");
                    w.newLine();
                    w.flush(); 
                    if(msg.equalsIgnoreCase("bye")) 
                    {
                        break;
                    }
                }
            }
            catch(Exception e){e.printStackTrace(); }
            finally 
            {
                if(s!=null)  s.close(); 
                if(in!=null) in.close(); 
                if(os!=null) os.close(); 
                if(r!=null) r.close();
                if(w!=null) w.close(); 
                 if(ss!=null) ss.close(); 
            }
        }
    }
}