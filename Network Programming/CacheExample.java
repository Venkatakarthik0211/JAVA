import java.io.*;
import java.net.*;
import java.util.*;
public class CacheExample {
    public static void main(String[] args) {
        try {
            // Set up the URL and open a connection
            URL url = new URL("https://exa.com");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Enable caching for the request
            connection.setRequestProperty("Cache-Control", "max-age=3600");

            // Send the request and read the response
            connection.connect();
            InputStream in = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Print the response content
            System.out.println("Response content:");
            System.out.println(response.toString());
            
             System.out.println("Response headers:");
            Map<String, List<String>> responseHeaders = connection.getHeaderFields();
            for (Map.Entry<String, List<String>> entry : responseHeaders.entrySet()) {
                if (entry.getKey() != null) {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                }
            }

            // Check if the response was cached
            Map<String, List<String>> headers = connection.getHeaderFields();
            if (headers.containsKey("X-Cache")) {
                System.out.println("Response was served from cache");
            } else {
                System.out.println("Response was not served from cache");
            }

            // Disconnect the connection
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
