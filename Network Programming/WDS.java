import java.util.*; 
import java.net.*; 
import java.io.*; 
class WDS
{
    public static void main(String args[]) 
    {
        try {
            URL u = new URL("https://startling-crumble-15f083.netlify.app/");
            // open the connection and prepare it to POST
            URLConnection uc = u.openConnection( );
            uc.setDoOutput(true);
            OutputStream raw = uc.getOutputStream( );
            OutputStream buffered = new BufferedOutputStream(raw);
            OutputStreamWriter out = new OutputStreamWriter(buffered, "8859_1");
            out.write("first=Julie&middle=&last=Harting&work=String+Quartet\r\n");
            out.flush( );
            out.close( );
        }
        catch (IOException ex) {
            System.err.println(ex);
        }
    }
}