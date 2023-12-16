import java.net.*;
import java.io.*;
public class Download {
    public static void main (String[] args) {
            try {
                URL u = new URL("http://www.testingmcafeesites.com/testcat_ac.html");
                InputStream in = u.openStream();
                in = new BufferedInputStream(in);
                Reader r = new InputStreamReader(in);
                int c;
                while ((c = r.read( )) != -1) {
                    System.out.print((char) c);
                }
            }
            catch (Exception e) {
            e.printStackTrace();
        } 
    } 
}