import java.io.*;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DownloadManager {
    private static final int n = 4;
    private static final String fn = "output.txt";
    private static final String URL = "http://www.testingmcafeesites.com/testcat_ac.html";

    public static void main(String[] args) throws IOException {
        URL url = new URL(URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        int contentLength = connection.getContentLength();
        int x = contentLength / n;

        ExecutorService executorService = Executors.newFixedThreadPool(n);
        for (int i = 0; i < n; i++) {
            int start = i * x;
            int end = (i + 1) * x - 1;
            if (i == n - 1) {
                end = contentLength - 1;
            }
            executorService.submit(new DownloadThread(start, end, url, i));
        }
        executorService.shutdown();
    }

    private static class DownloadThread implements Runnable {
        private int start;
        private int end;
        private URL url;
        private int threadNum;

        public DownloadThread(int start, int end, URL url, int threadNum) {
            this.start = start;
            this.end = end;
            this.url = url;
            this.threadNum = threadNum;
        }

        @Override
        public void run() {
            try {
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestProperty("Range", "bytes=" + start + "-" + end);
                InputStream inputStream = connection.getInputStream();
                FileOutputStream outputStream = new FileOutputStream(fn + "_" + threadNum);

                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }

                outputStream.close();
                inputStream.close();
                System.out.println("Thread " + threadNum + " finished downloading.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
