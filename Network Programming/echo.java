import java.net.*; 
import java.io.*; 
class echo 
{
    public static void main(String args[]) 
    { 
        //ECHO request is an ICMP protocol
        //echo request and repy are type 0 and type 8 codes 
        //These messages are used for network diagnoistic purposes
        String host = "localhost";
        if(args.length > 0) 
        {
            host = args[0];
        }
        try 
        {
            //Assuming port 7 is listening to request
            Socket s = new Socket(host,7);
            BufferedReader ni = new BufferedReader(new InputStreamReader(s.getInputStream()));
            BufferedReader ui = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter p = new PrintWriter(s.getOutputStream());
            while(true)
            {
                String str = ui.readLine(); 
                if(str.equals("."))
                {
                    break;
                }
                p.println(str);
            }
            p.flush(); 
            System.out.println(ni.readLine());

            s.close(); 
            ni.close();
            ui.close();
            p.close(); 
        }
        catch(Exception e) 
        {
            e.printStackTrace(); 
        }
    }
}