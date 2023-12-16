import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CacheControlTest {
    public static void main(String[] args) {
        try 
        {
        URL url = new URL("http://localhost/lab.php");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Cache-Control", "max-age=3600");
        int responseCode = connection.getResponseCode();
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = reader.readLine()) != null) {
            response.append(inputLine);
        }
        reader.close();
        System.out.println(response.toString());
    }
    catch(Exception e)
    {
        e.printStackTrace();
        e.getStackTrace();
    }
    }
}
