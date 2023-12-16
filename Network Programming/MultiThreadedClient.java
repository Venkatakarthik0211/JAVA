import java.io.*;
import java.net.*;

public class MultiThreadedClient {
    public static void main(String[] args) throws IOException {
        // create a new socket and connect to the server
        Socket socket = new Socket("localhost", 8080);

        // send a message to the server
        String message = "Hello, server!";
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(message.getBytes());

        // receive a response from the server
        InputStream inputStream = socket.getInputStream();
        byte[] buffer = new byte[1024];
        int bytesRead = inputStream.read(buffer);
        String response = new String(buffer, 0, bytesRead);
        System.out.println("Server response: " + response);

        // close the socket and free up resources
        socket.close();
    }
}
