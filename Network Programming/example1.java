//proxy example1
import java.io.*; 
import java.util.*; 
import java.net.*; 
class example1
{
    public static void main(String args[]) 
    {
        try 
        {
            proxy data = new proxy();
            ProxySelector.setDefault(data);
            System.out.println("Default value: "+ProxySelector.getDefault());
            System.out.println("Getting proxy");
            String uri = "http://www.testingmcafeesites.com/testcat_ac.html";
            URL c = new URL(uri);
            List<Proxy> cp = data.select(c.toURI());
            System.out.println("Proxy to use: "+cp.get(0));
            System.out.println("Getting proxy for /non-confidential");
            String ncURL = "https://www.download.com/non-confidential";
            URL nc = new URL(ncURL);
            List<Proxy> ncp = data.select(nc.toURI());
            System.out.println("Proxy to use : "+ ncp .get(0));
        }
        catch(Exception e) 
        {
            e.getStackTrace();
        }

    }

}