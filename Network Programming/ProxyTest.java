
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.*;
import java.io.BufferedInputStream;
import java.io.IOException;
public class ProxyTest {

    public static void main(String[] args) {
        //InputStream in=null;
        try {
            URL url=new URL("https://google.com/");
            URLConnection urlc=url.openConnection();
            InputStream in=urlc.getInputStream();
            InputStream buff=new BufferedInputStream(in);
            Reader read1=new InputStreamReader(buff);
            //in=url.openStream();

			    
            int i;
            int count=0;

            while((i=read1.read())!=-1) {
                System.out.print((char)i);
                count++;
                if(count>100) {
                    break;
                }

            }
        }catch(IOException e) {
            System.out.println(e);
        }
    }
}
