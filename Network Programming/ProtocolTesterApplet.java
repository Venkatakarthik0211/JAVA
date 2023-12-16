import java.net.*;
import java.applet.*;
import java.awt.*;
import java.io.*; 
public class ProtocolTesterApplet extends Applet {
    static TextArea results = new TextArea( );
    static URL url = null;
    public  void init( ) {
        this.setLayout(new BorderLayout( ));
        this.add("Center", results);
    }

    public static void main(String args[]) throws IOException
    {
        try 
        {
            String host = "http://www.ncsa.uiuc.edu/demoweb/html-primer.html";
            String file = "/bypass/SurfWatch/";
            String[] schemes = {"http", "https", "ftp", "telnet"};
            for (int i = 0; i < schemes.length; i++) {
                try {
                    URL u = new URL(schemes[i], host, file);
                    System.out.println(schemes[i] + " is supported\r\n");
                }
                catch (MalformedURLException ex) {
                    System.out.println(schemes[i] + " is not supported\r\n");
                }
            }
            /*url = new URL("http://www.testingmcafeesites.com/testcat_ac.html");
            URI uri = new URI("http://www.testingmcafeesites.com/testcat_ac.html");
            String Protocol = url.getProtocol();
            String h = url.getHost();
            //System.out.println("The applet has a Default host or not"+url.getDefaulPort());
            /*System.out.println("The path of the page is "+url.getPath());
            System.out.println("This applet was downloaded has port " + url.getPort());
            System.out.println("This applet was downloaded via " + Protocol);
            System.out.println("This appl;et was downloaded from " + h);
            System.out.println("Fragement ID if it has any "+url.getRef());//If no fragement ID it returns NULL
            System.out.println("Query String if it has any "+url.getQuery());//If no Query Strog it returns NULL
            System.out.println("User Info "+url.getUserInfo());//If no fragement ID it returns NULL
            System.out.println("-------URL ended---- URI methods");
            System.out.println("getScheme(): "+uri.getScheme());
            System.out.println("getFragment(): "+uri.getFragment());
            System.out.println("getAuthority(): "+uri.getAuthority());
            System.out.println("getRawAuthority(): "+uri.getRawAuthority());
            System.out.println("getRawFragment(): "+uri.getRawFragment());
            System.out.println("The query string is " + uri.getQuery( ));
            //From above methods we can say URI is a superset of URL*/
        }
        catch(Exception e)
        {
            e.getStackTrace(); 
        }
    }
}