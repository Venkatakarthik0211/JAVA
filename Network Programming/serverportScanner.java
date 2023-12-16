import java.io.IOException;
import java.net.*;

public class serverportScanner {

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
                    ServerSocket s = new ServerSocket(port);
                    System.out.println("Port " + port + " is open");
                    s.close();
                } catch (IOException e) {
                    
                }
            }
        }
    }
}