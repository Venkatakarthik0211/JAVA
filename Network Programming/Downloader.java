import java.io.*;
import java.net.*;

public class Downloader {
    public static void main(String[] args) {
        try {
            URL imageUrl = new URL("http://localhost/1s.php"); // specify the URL of the image to download
            HttpURLConnection connection = (HttpURLConnection) imageUrl.openConnection(); // open an HTTP connection to the image URL
            
            int responseCode = connection.getResponseCode(); // get the HTTP response code
            
            if (responseCode == HttpURLConnection.HTTP_OK) { // if the response code is OK
                InputStream inputStream = connection.getInputStream(); // get an input stream to read the image data
                FileOutputStream outputStream = new FileOutputStream("image.php"); // create an output stream to write the image data to a file
                
                byte[] buffer = new byte[4096];
                int bytesRead = -1;
                
                while ((bytesRead = inputStream.read(buffer)) != -1) { // read data from the input stream in chunks and write it to the output stream
                    outputStream.write(buffer, 0, bytesRead);
                }
                
                outputStream.close(); // close the output stream
                inputStream.close(); // close the input stream
                System.out.println("Image downloaded successfully.");
            } else {
                System.out.println("Failed to download image. HTTP response code: " + responseCode);
            }
            
            connection.disconnect(); // disconnect the HTTP connection
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
