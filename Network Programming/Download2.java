import java.net.*; 
import java.io.*;
class Download2 
/*Difference between URL and URLConnection 
1) Provides access to HTTP header 
2) Configure request parameters sent to the server 
3) Write amd read Data from the server
*/
{
    public static void main(String args[]) 
    {
        try 
        {
            String s = "http://www.testingmcafeesites.com/testcat_ac.html";
            URL u = new URL(s);
            URLConnection uc = u.openConnection(); 
            InputStream in = uc.getInputStream();
            InputStream b = new BufferedInputStream(in);
            //FilterStream or simpliy chaining InputStream to the Reader 
            Reader r = new InputStreamReader(b);
            int c;
            while((c=r.read())!=-1)
            {
                System.out.print((char)c);
            }
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
    }
}