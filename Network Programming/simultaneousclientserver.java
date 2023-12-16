import java.net.*; 
import java.io.*; 
class simultaneousclientserver
{
    public static void main(String args[]) 
    {
        int port = 8080; 
        try 
        {
            ServerSocket ss = new ServerSocket(port,1);//QueueLength = 1
            System.out.println("Listening on: "+ss.getLocalPort()); 
            while(true) 
            {
                Socket con = ss.accept();
                try 
                {
                    System.out.println("Connection established "+con);
                    Thread in = new Input(con.getInputStream());
                    in.start(); 
                    Thread out = new Output(con.getOutputStream());
                    out.start();
                    try 
                    {
                        in.join(); out.join(); 

                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                    if (con != null) con.close( );
                }
                catch(Exception e) 
                {
                    e.printStackTrace();
                }
                ss.close();

            }
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
    }
}
class Input extends Thread 
{
    InputStream in; 
    public Input(InputStream in) 
    {
        this.in = in;
    }

    public void run()
    {
        try 
        {
            while(true)
            {
                int i = in.read();
                if(i==-1) 
                {
                    break; 
                }
                System.out.write(i);
            }
            in.close(); 
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
    }
}
class Output extends Thread 
{
    private Writer out; 
    public Output(OutputStream out)
    {
        this.out = new OutputStreamWriter(out);
    }
    public void run() 
    {
        String line; 
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        try 
        {
            while(true) 
            {
                line = b.readLine();
                if(line.equals(".")) 
                {
                    break;
                }
                out.write(line + "\r\n");
                out.flush(); 
                out.close();
            }
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
    }
}
