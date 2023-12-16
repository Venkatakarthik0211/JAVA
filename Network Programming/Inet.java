import java.net.*; 
class Inet 
{
    public static void main(String args[]) 
    {
        try 
        {
            InetAddress ad = InetAddress.getByName("127.0.0.1");
            inet(ad);
            System.out.println("----------Determine type of Inet------"); 
            type(ad); //To determine type of address 
        }
        //UnknowHostException e
        catch(Exception e)
        {
            e.printStackTrace(); 
        }
        //inet(); //Insecure and risky to use

    }

    public static void type(InetAddress ad) 
    {
        byte[] a = ad.getAddress();
        if(a.length==4)
            System.out.println("IPV4");
        else if(a.length==6) 
            System.out.println("IPV6");
        else 
            return ; 
        if (ad.isAnyLocalAddress( )) {
            System.out.println(ad + " is a wildcard address.");
        }
        if (ad.isLoopbackAddress( )) {
            System.out.println(ad + " is loopback address.");
        }
        if (ad.isLinkLocalAddress( )) {
            System.out.println(ad + " is a link-local address.");
        }
        else if (ad.isSiteLocalAddress( )) {
            System.out.println(ad + " is a site-local address.");
        }
        else {
            System.out.println(ad + " is a global address.");
        }
        if (ad.isMulticastAddress( )) {
            if (ad.isMCGlobal( )) {
                System.out.println(ad + " is a global multicast address.");
            }
            else if (ad.isMCOrgLocal( )) {
                System.out.println(ad
                    + " is an organization wide multicast address.");
            }
            else if (ad.isMCSiteLocal( )) {
                System.out.println(ad + " is a site wide multicast address.");
            }
            else if (ad.isMCLinkLocal( )) {
                System.out.println(ad + " is a subnet wide multicast address.");
            }
            else if (ad.isMCNodeLocal( )) {
                System.out.println(ad
                    + " is an interface-local multicast address.");
            }
            else {
                System.out.println(ad + " is an unknown multicast address type.");
            }
        }
        else {
            System.out.println(ad + " is a unicast address.");
        }
    }

    public static void inet(InetAddress ad)
    {
        try 
        {
            //Address either by using site or IP 
            System.out.println(ad);
            //null returns localhost
            InetAddress ad1 = InetAddress.getByName("23.50.21.231");
            System.out.println(ad1);
            //For Hostname
            System.out.println(ad1.getHostName());
            //To get all addresses
            InetAddress[] ad2 = InetAddress.getAllByName("www.microsoft.com");
            for(int i = 0; i<ad2.length; i++)
            {
                System.out.println(ad2[i]); 
            }
            //To find address of the machine we run 
            InetAddress ad3 = InetAddress.getLocalHost();
            System.out.println(ad3);
            String myad = ad3.getHostAddress();
            System.out.println("Local machine address "+myad);
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
    }
}