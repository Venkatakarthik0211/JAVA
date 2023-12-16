import java.io.*;
import java.net.*; 
class threaddownload 
{
    static int i; 
    static char c; 
    static InputStream in = null;
    public static void main(String args[]) throws InterruptedException
    {
        x1 t1 = new x1(); 
        x1 t2 = new x1(); 
        x1 t3 = new x1(); 
        x1 t4 = new x1(); 
        t1.start();
        t1.join();
        t2.start(); 
        t2.join();
        t3.start(); 
        t3.join(); 
        t4.start(); 
        t4.join();
    }
}
class x1 extends Thread 
{
    int count = 0; 
    public void run()
    {
        try 
        {
            System.out.println(Thread.currentThread().getId()+"thread");
            try 
            {
                URL u = new URL("http://www.testingmcafeesites.com/testcat_ac.html");
                InputStream in = u.openStream();
                in = new BufferedInputStream(in);
                Reader r = new InputStreamReader(in);
                int c;
                while ((c = r.read( )) != -1 && count == 5)  {
                    System.out.print((char) c);
                    count++;
                }
                System.out.println();
            }
            catch(Exception e)
            {
                e.getStackTrace(); 
            }

        }
        catch(Exception e) 
        {
            e.printStackTrace(); 
        }
    }
}
/*class s2 extends Thread 
{
public void run() 
{
System.out.println("Thread 2");   
try 
{
Multithreading b = new Multithreading(); 
b.inputS();
}
catch(Exception e) 
{
e.printStackTrace(); 
}
}
}*/