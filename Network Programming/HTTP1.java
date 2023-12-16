//HTTPMethods - GET,POST,HEAD,PUT,OPTIONS,DELETE,TRACE 
//Head returns HTTP header, similar tp GET method
import java.net.*; 
import java.io.*; 
import java.util.*; 
class HTTP1 
{
    public static String UA = "Mozilla/5.0";
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine(); 
        try 
        {
            URL u = new URL(s); //local.html
            HttpURLConnection http = (HttpURLConnection) u.openConnection();
            head(u);
            System.out.println("Head done");
            get(u);
            System.out.println("Get done");
            post(u);
            System.out.println("Post done");
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }

    }

    public static void get(URL u) 
    {
        try
        {
            HttpURLConnection h = (HttpURLConnection) u.openConnection();
            h.setRequestMethod("GET");
            h.setRequestProperty("User-Agent",UA);
            int rc = h.getResponseCode();
            System.out.println("GET Response Code:: "+rc);
            if(rc == HttpURLConnection.HTTP_OK)
            {
                BufferedReader in = new BufferedReader(new InputStreamReader(h.getInputStream()));
                String input;
                StringBuffer response = new StringBuffer();
                while((input = in.readLine())!=null)
                {
                    response.append(input);
                }
                in.close(); 
                System.out.println(response.toString());
            }
            else 
            {
                System.out.println("GET request did not work");
            }
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
    }

    public static void post(URL u) 
    {
        String parameters = "userName=Alex";
        try 
        {
            HttpURLConnection h = (HttpURLConnection) u.openConnection();
            System.out.println("POST STARTED");
            h.setRequestMethod("POST");
            h.setRequestProperty("User-Agent",UA);
            h.setDoOutput(true);
            OutputStream os = h.getOutputStream(); 
            os.write(parameters.getBytes());
            os.flush();
            os.close();
            System.out.println("POST ENDED");

            int rc = h.getResponseCode();
            System.out.println("POST Response Code:: "+rc);
            if(rc == HttpURLConnection.HTTP_OK)
            {
                BufferedReader in = new BufferedReader(new InputStreamReader(h.getInputStream()));
                String input;
                StringBuffer response = new StringBuffer();
                while((input = in.readLine())!=null)
                {
                    response.append(input);
                }
                in.close(); 
                System.out.println(response.toString());
            }
            else 
            {
                System.out.println("POST request did not work");
            }
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
    }

    public static void head(URL u) throws Exception
    {
        HttpURLConnection h = (HttpURLConnection) u.openConnection();
        h.setRequestMethod("HEAD");
        System.out.println(u + "was last modified at " + new Date(h.getLastModified( )));
           int responseCode = h.getResponseCode();
        if (responseCode == h.HTTP_OK) {
            
            String contentType = h.getHeaderField("Content-Type");
            int contentLength = h.getContentLength();
            System.out.println(contentType);
            System.out.println(contentLength);
        } else {
            
            System.out.println("Error response code: " + responseCode);
        }
    }
}