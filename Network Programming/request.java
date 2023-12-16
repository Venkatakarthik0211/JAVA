import java.util.*; 
import java.net.*; 
import java.io.*; 
public class request extends CacheRequest 
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