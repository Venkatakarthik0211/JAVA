
import java.util.ArrayList;
import java.util.Collections;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.net.InetAddress;
import java.util.Enumeration;

public class InterfaceIF {
    public static void main(String[] args) throws SocketException {
        NetworkInterface netif=NetworkInterface.getByIndex(4);

        ArrayList<NetworkInterface> netifall=Collections.list(NetworkInterface.getNetworkInterfaces());

        for(NetworkInterface nf:netifall) {
            if(nf.isUp()) {
                System.out.println(nf.getName());
                System.out.println(nf.isVirtual());
                System.out.println(nf.isLoopback());
                Enumeration<InetAddress> netids=nf.getInetAddresses();

                while(netids.hasMoreElements()) {

                    System.out.println(netids.nextElement().toString());

                }
            }

        }
    }
}
