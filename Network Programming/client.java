import java.io.*; 
import java.net.*; 
import java.util.*; 
class client
{
    public static void main(String args[]) throws Exception
    {
       Socket s = null; 
       InputStreamReader in = null; 
       OutputStreamWriter os = null; 
       BufferedReader r = null; 
       BufferedWriter w = null; 
       try 
       {
         s = new Socket("localhost",8080);
         in = new InputStreamReader(s.getInputStream());
         os = new OutputStreamWriter(s.getOutputStream());
         r = new BufferedReader(in);
         w = new BufferedWriter(os);
         Scanner sc = new Scanner(System.in);
         while(true) 
         {
             String msg = sc.nextLine();
             w.write(msg);
             w.newLine();
             w.flush(); //Flushed when enter key is entered
             System.out.println("Server: " + r.readLine());
             if(msg.equalsIgnoreCase("bye"))
             {
                 break; 
             }
         }
       }
       catch(Exception e) 
       {
           e.printStackTrace(); 
       }
       finally 
       {
           if(s!=null)  s.close(); 
           if(in!=null) in.close(); 
           if(os!=null) os.close(); 
           if(r!=null) r.close();
           if(w!=null) w.close(); 
        }
    }
}
