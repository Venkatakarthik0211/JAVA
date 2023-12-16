//Socket Options 
/*To rectify the problem of nagle'salgorithm problem of bragging down network sending datagrams, 
 * TCP_NODELAY is used - set and get of TcpNoDelay 
 * 
 * SO_LINGER throws the remaining datagrams once it has set to 0, (During socket closing)
 * if positive, it waits until those to oomplete. 
 * setSoLiinger(true,+ve) and getSoLinger()
 * 
 * SO_TIMEOUT limits the time required to read the bytes without any obstruction. (During socket connection)
 * 0 is infinite time, +ve - limited, -ve illegalArguement
 * setSoTimeout(a)
 * 
 * SO_RCVBUF, setRecieveBufferSize(a), get() suggests number of bytes to use for buffering output on reciving side
 * >0, sets the size, <=0 illegalArguement 
 * 
 * SO_SNDBUF, setSendBufferSizw(a), get() suggests number of bytes used for bufferSize output on sendder side
 * >0, sets the size, <=0 illegalArguement 
 *
 *Without SO_KEEPALIVE, an inactive client could live more or less forever without noticing that the server had crashed.
 *setKeepAlive(boolean on)
 *
 *setOOBInline(boolean on), get() allows to send the urgent data
 *
 * If the SO_REUSEADDR is turned on (it’s turned off by default), 
 * another socket is allowed to bind to the port even while data may be outstanding for the previous socket.
 * setReuseAddress(boolean on)
 */ 

import java.net.*; 
import java.io.*; 
class socketoptions 
{
    public static void main(String args[]) 
    {
        try 
        {
            Socket s = new Socket();
            System.out.println("is TCP set to No delau? "+s.getTcpNoDelay());
            s.setTcpNoDelay(true);
            System.out.println("is TCP set to No delau? "+s.getTcpNoDelay());

            //To bind a socket to specific local address
            InetAddress a = InetAddress.getByName("https://telnet.org/");
            int port = 8080; //http web server
            s.bind(new InetSocketAddress(a,port));

            int timeout = 1000; // 1 second 
            System.out.println("Is there any time delay? "+s.getSoTimeout());
            s.setSoTimeout(timeout);
            System.out.println("Is there any time delay? "+s.getSoTimeout());

            System.out.println("Is the connection is broken? "+s.getKeepAlive());
            s.setKeepAlive(true);

            //Buffer size of SUN OS of 8KB 
            int bs = 8 * 1024; 
            System.out.println("Present SendBuffer Size = "+ s.getSendBufferSize());
            s.setSendBufferSize(bs);
            System.out.println("Present SendBuffer Size = "+ s.getSendBufferSize());

            System.out.println("Present RecievedBuffer Size = "+ s.getReceiveBufferSize());
            s.setReceiveBufferSize(bs);
            System.out.println("Present RecievedBuffer Size = "+ s.getReceiveBufferSize());

            //Connecting to remote Host Address 
            InetAddress ad = InetAddress.getByName("https://telnet.org/");
            int port2 = 3306;
            s.connect(new InetSocketAddress(ad,port2));

            //For sending and recieveing data over socket
            // use the socket to send and receive data
            InputStream in = s.getInputStream();
            OutputStream out = s.getOutputStream();
            String message = "Hello, server!";
            out.write(message.getBytes());
            byte[] buffer = new byte[1024];
            int len = in.read(buffer);
            String response = new String(buffer, 0, len);
            System.out.println("Received from server: " + response);

            //1) socket closes automatically 
            //2) isClosed() returns if socket closed or not - returns falsw for socket open
            //3) isConnected() tells you if socket connected to remoted host - returns true for socket open
            //4) isBound() tells about local end unlike 3) 
            //5) Halfclosed sockets can be achieved by 
            // shutdownInput(). shutdownOutput() 
            // isInputShutdown(), isOutputShutdown() allows to check status of half closed sockets
            if (!s.isClosed() && s.isConnected()) {
                System.out.println("Socket Closed!!");
            }
            else 
            {
                System.out.println("Socket is Opened");
                s.close();
                System.out.println("Socket Closed!! successfully");
            }
            if(!s.isBound()) 
            {
                System.out.println("Local end Socket is Opened");
            }
            System.out.println("Local end Socket is Opened");
            if(s.isInputShutdown() || s.isOutputShutdown())
            {
                System.out.println("Streams are Open, shutdown Input and Output");
                s.shutdownOutput();
                s.shutdownInput(); 
                System.out.println("Both are closed"); //Can Control respectively
            }

        }
        catch(Exception e) 
        {

        }
    }
}

