//proxy example1
import java.io.*; 
import java.util.*; 
import java.net.*; 
class NP5
{
    public static void main(String args[]) 
    {
        try 
        {
            //proxy 
            proxy data = new proxy();
            ProxySelector.setDefault(data);
            System.out.println("Default value: "+ProxySelector.getDefault());
            System.out.println("Getting proxy");
            QueryString qs = new QueryString("pg", "q");
            String url = "http://www.testingmcafeesites.com/testcat_ac.html";
            System.out.println("Original URL: "+url);
            qs.add("search.x", "38");

            //encoded url
            String urle = url + qs;
            System.out.println("Encoded URL: " + urle);
            
            URL c = new URL(url);
            List<Proxy> cp = data.select(c.toURI());
            System.out.println("Proxy to use: "+cp.get(0)); 

            //Connecred to proxy downloading webpage
            InputStream in = c.openStream();
            in = new BufferedInputStream(in);
            Reader r = new InputStreamReader(in);
            int x;
            while((x = r.read())!=-1)
            {
                System.out.print((char) x);
            }
        }
        catch(Exception e) 
        {
            e.getStackTrace();
        }

    }
}
class QueryString
{
    private StringBuffer q = new StringBuffer(); 
    public QueryString(String name, String value) 
    {
        encode(name,value);
    }

    public synchronized void add(String name, String value) 
    {
        q.append('&');
        encode(name,value);
    }

    public synchronized void encode(String name, String value) 
    {
        try 
        {
            q.append(URLEncoder.encode(name,"UTF-"));
            q.append('=');
            q.append(URLEncoder.encode(value,"UTF-"));
        }
        catch(Exception e) 
        {
            e.getStackTrace(); 
        }
    }

    public String getQuery() 
    {
        return q.toString();
    }

    public String toString() 
    {
        return getQuery();
    }
}
