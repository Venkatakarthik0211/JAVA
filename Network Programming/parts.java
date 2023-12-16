import java.net.*;
public class parts {
    public static void main(String args[])
    {
        System.out.println("---URL---");
        URL();
        System.out.println("---URI---");
        URI(); 
    } 

    public static void URI() 
    {
        try {
            URI u = new URI("http://www.testingmcafeesites.com/testcat_ac.html");
            System.out.println("The URI is " + u);
            if (u.isOpaque()) {
                System.out.println("This is an opaque URI.");
                System.out.println("The scheme is " + u.getScheme( ));
                System.out.println("The scheme specific part is "
                    + u.getSchemeSpecificPart( ));
                System.out.println("The fragment ID is " + u.getFragment( ));
            }
            else {
                System.out.println("This is a hierarchical URI.");
                System.out.println("The scheme is " + u.getScheme( ));
                try {
                    u = u.parseServerAuthority( );
                    System.out.println("The host is " + u.getHost());
                    System.out.println("The user info is " + u.getUserInfo( ));
                    System.out.println("The port is " + u.getPort( ));
                }
                catch (URISyntaxException ex) {
                    System.out.println("The authority is " + u.getAuthority( ));
                }
                System.out.println("The path is " + u.getPath( ));
                System.out.println("The query string is " + u.getQuery( ));
                System.out.println("The fragment ID is " + u.getFragment( ));
            } 
        } 
        catch(Exception e) {
            e.getStackTrace(); 
            System.err.println(" is not a URIL I understand.");
        }
    }

    public static void URL() 
    {
        try {
            URL u = new URL("http://www.testingmcafeesites.com/testcat_ac.html");
            System.out.println("The URL is " + u);
            System.out.println("The scheme is " + u.getProtocol());
            System.out.println("The user info is " + u.getUserInfo( ));
            String host = u.getHost( );
            if (host != null) {
                int atSign = host.indexOf('@');
                if (atSign != -1)
                host = host.substring(atSign+1);
                System.out.println("The host is " + host);
            }
            else {
                System.out.println("The host is null.");
            }
            System.out.println("The port is " + u.getPort( ));
            System.out.println("The path is " + u.getPath( ));
            System.out.println("The ref is " + u.getRef( ));
            System.out.println("The query string is " + u.getQuery( ));
        } 

        catch(Exception e) {
            e.getStackTrace(); 
            System.err.println(" is not a URL I understand.");
        }
        System.out.println();
    }
}