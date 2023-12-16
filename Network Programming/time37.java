import java.net.*;
import java.io.*; 
import java.util.*; 
class time37 
{
    public static void main(String args[]) throws Exception 
    {
        server(); 
        client();

    }

    public static void client() 
    {
        String host="time.nist.gov"; int port=37;
        long d = 2208988800L;
        try 
        {
            InputStream r = null;
            Socket s = new Socket(host,port);
            r = s.getInputStream();
            long ss00 = 0; 
            for(int i = 0; i < 4; i++) //32 Bit value which is 4 bytes
            {
                ss00 = (ss00<<8) | r.read(); 
            }
            long ss70 = ss00 - d;
            long ms70 = ss70*1000; 
            Date time = new Date(ms70);
            System.out.println("Time is "+time + " Host "+host); 
            r.close();
            s.close(); 
        }
        catch(Exception e) 
        {

        }

    }

    public static void server() throws Exception 
    {
        int port=37;
        long diff = 2208988800L; 
        Socket conn = null;
        try
        {
            ServerSocket s = new ServerSocket(port);
            while(true) 
            {
                conn = s.accept(); //Accept connections
                OutputStream os = conn.getOutputStream(); 
                Date d = new Date(); 
                long ms70 = d.getTime();
                long ss70 = ms70/1000; 
                long ss00 = ss70+diff; 
                byte[] time = new byte[4]; //32 bit Integer Representation
                time[0] = (byte) ((ss00 & 0x00000000FF000000L) >> 24);
                time[1] = (byte) ((ss00 & 0x0000000000FF0000L) >> 16);
                time[2] = (byte) ((ss00 & 0x000000000000FF00L) >> 8);
                time[3] = (byte) (ss00 & 0x00000000000000FFL);
                os.write(time);
                os.flush( );
            }
        }
        catch(Exception e) {

        }
        conn.close();
    }

}