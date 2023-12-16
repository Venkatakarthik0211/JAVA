import java.io.*;
import java.net.*;

public class downloadthread {
    private static final int NUM_THREADS = 4;

    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.testingmcafeesites.com/testcat_ac.html");
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuilder content = new StringBuilder();
            String inputLine;
            Thread[] threads = new Thread[NUM_THREADS];
            for (int i = 0; i < threads.length; i++) {
                threads[i] = new DownloadThread(content, in);
                threads[i].start();
                System.out.println(Thread.currentThread().getId()+"thread");
            }
            for (int i = 0; i < threads.length; i++)
            {
                threads[i].join();
            }
            in.close();
            FileWriter writer = new FileWriter("20BCN7028.txt");
            writer.write(content.toString());
            writer.close();
            System.out.println("Webpage downloaded successfully.");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static class DownloadThread extends Thread {
        private StringBuilder content;
        private BufferedReader in;
        public DownloadThread(StringBuilder content, BufferedReader in) {
            this.content = content;
            this.in = in;
        }

        public void run() {
            try {
                String inputLine;
                while ((inputLine = getNextLine()) != null) {
                    synchronized (content) {
                        content.append(inputLine);
                        System.out.println(inputLine);
                        content.append("\n");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        private String getNextLine() throws IOException {
            synchronized (in) {
                return in.readLine();
            }
        }
    }
}

/*import java.io.*;
import java.net.*;

public class DownloadWebpage {
public static void main(String[] args) {
try {
URL url = new URL("https://example.com");
BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
String inputLine;
StringBuilder content = new StringBuilder();
while ((inputLine = in.readLine()) != null) {
content.append(inputLine);
}
in.close();
FileWriter writer = new FileWriter("example.html");
writer.write(content.toString());
writer.close();
System.out.println("Webpage downloaded successfully.");
} catch (IOException e) {
e.printStackTrace();
}
}
}*/
