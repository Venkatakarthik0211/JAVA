import java.io.*;
import java.net.*;

public class MultiThreadedServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started. Waiting for connections...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected.");

            // create a new thread to handle client requests
            ClientHandler clientHandler = new ClientHandler(socket);
            Thread thread = new Thread(clientHandler);
            thread.start();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // receive a message from the client
            InputStream inputStream = socket.getInputStream();
            byte[] buffer = new byte[1024];
            int bytesRead = inputStream.read(buffer);
            String message = new String(buffer, 0, bytesRead);
            System.out.println("Received message: " + message);

            // send a response to the client
            String response = "Hello, client!";
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(response.getBytes());

            // close the socket and free up resources
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
