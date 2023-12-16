import java.io.IOException;
import java.net.Socket;

public class PortScanner {

    public static void main(String[] args) {
        String host = "localhost"; 
        int minPort = 1;
        int maxPort = 1024;
        int numThreads = 100; 
        int portsPerThread = (maxPort - minPort + 1) / numThreads;
        for (int i = 0; i < numThreads; i++) {
            int startPort = minPort + i * portsPerThread;
            int endPort = (i == numThreads - 1) ? maxPort : (startPort + portsPerThread - 1);
            Thread thread = new PortScannerThread(host, startPort, endPort);
            thread.start();
        }
    }
    
    private static class PortScannerThread extends Thread {
        private String host;
        private int startPort;
        private int endPort;        
        public PortScannerThread(String host, int startPort, int endPort) {
            this.host = host;
            this.startPort = startPort;
            this.endPort = endPort;
        }
        @Override
        public void run() {
            for (int port = startPort; port <= endPort; port++) {
                try {
                    Socket socket = new Socket(host, port);
                    System.out.println("Port " + port + " is open");
                    socket.close();
                } catch (IOException e) {
                    
                }
            }
        }
    }
}

//Naive Approach
/*import java.io.*; 
import java.net.*;
class portscanner
{
    public static void main(String args[]) 
    {
        String host = "localhost";
        for(int i = 0; i<=1024; i++) 
        {
            try 
            {
                Socket s = new Socket(host,i);
                System.out.println("There is a server on port " + i + " of "+ host);
                s.close();
            }
            catch(Exception e) 
            {
               
            }
        }
    }
}*/