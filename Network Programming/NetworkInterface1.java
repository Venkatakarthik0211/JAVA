
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.net.InetAddress;
public class NetworkInterface1 {

    public static void main(String[] args) throws SocketException
    {
        ArrayList<NetworkInterface> obj=Collections.list(NetworkInterface.getNetworkInterfaces());

        for(NetworkInterface nf:obj) {
            if(nf.isUp()) {
                System.out.println(nf.getName()+" "+nf.isLoopback()+"r/v" +nf.getHardwareAddress());
                Enumeration<InetAddress> en=nf.getInetAddresses();
                while(en.hasMoreElements()) {

                    System.out.println(en.nextElement().toString());
                }
            }
        }

		
    }

}
