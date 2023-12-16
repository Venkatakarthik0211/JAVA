//ProxySelecrtor
import java.io.*; 
import java.util.*; 
import java.net.*; 
public class proxy extends ProxySelector 
{
    private final List<Proxy> no = new ArrayList<>(); 
    private final List<Proxy> pro = new ArrayList<>();
    public proxy()
    {
        no.add(Proxy.NO_PROXY);
        InetSocketAddress ISA = new InetSocketAddress("proxy.example.com",443);
        Proxy prohttp = new Proxy(Proxy.Type.HTTP, ISA);
        pro.add(prohttp);
    }

    public List<Proxy> select(URI uri) 
    {
        if(uri.getPath().startsWith("/confidential")) 
        {
            return pro; 
        }
        return no;
    }

    public void connectFailed(URI arg0, SocketAddress arg1, IOException arg2) 
    {
        System.out.println("Connection handler");
    }

}