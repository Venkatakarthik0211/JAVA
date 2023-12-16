import java.io.*; 
import java.net.*; 
import java.util.*;
class request extends CacheRequest 
{ 
    //The put( ) method returns a CacheRequest object that wraps an OutputStream into which the protocol handler will write the data it reads
    //The get( ) method retrieves the data and headers from the cache and returns them wrapped in a CacheResponse object.
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    public OutputStream getBody() throws IOException 
    {
        return baos;
    }

    public void abort() 
    {
        baos = null; 
    }

    public byte[] getData() 
    {
        if(baos == null)
        {
            return null; 
        }
        else
        {
            return baos.toByteArray();
        }
    }
}
public class  response{  
    public static void main(String args[]) throws Exception {  

        String uri = "https://www.javatpoint.com";  

        URI uri1 = new URI(uri);  

        URL url = new URL("http://www.javatpoint.com/java-tutorial");  

        URLConnection urlcon = url.openConnection();  
        ResponseCache responseCache = new ResponseCache() {  
                //calling the abstract methods  
                @Override  
                public CacheResponse get(URI uri, String rqstMethod, Map<String, List<String>> rqstHeaders) throws IOException {  
                    return null;  
                }  

                @Override  
                public CacheRequest put(URI uri, URLConnection conn) throws IOException {  
                    return null;  
                }  
            };  

        ResponseCache.setDefault(responseCache);  
        System.out.println("Default value: "+ResponseCache.getDefault());  
        Map<String,List<String>> maps= new HashMap<String, List<String>>();  
        List<String> list= new LinkedList<String>();  
        list.add("REema");   
        maps.put("1", list);  
        System.out.println("The put() method has been called...");  
        System.out.println("The put() method returns: " + responseCache.put(uri1, urlcon));  
        System.out.println("The get() method has been called...");  
        System.out.println("The get() method returns: "+responseCache.get(uri1,uri,maps));  
    }  
}  
