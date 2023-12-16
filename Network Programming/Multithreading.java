import java.io.*;
class Multithreading 
{
    static int i; 
    static char c; 
    static InputStream in = null;
    public static void main(String args[]) throws InterruptedException
    {
        s1 t1 = new s1(); 
        s2 t2 = new s2(); 
        t1.start();
        t1.join();
        t2.start(); 
    }

    public static void inputS() throws IOException
    { 
         try 
        {
            int count = 0; 
            InputStream in = new FileInputStream("20BCN7028.txt");
            //Using while loop instead of using in.read(byte[] a)
            while((i = in.read())!=-1 && count == 5)
            {
                c = (char)i; 
                //System.out.println("Number of data bytes present"+in.available());
                //Above Print statement Shows how many elements are left to read, if some elements are read before
                //If is.available() is placed before reading data then it will give output full number of bytes
                System.out.print(c);
                count++; 
            }
            in.close();
        }
        catch(Exception e)
        {
            e.getStackTrace(); 
        }
    }
}
class s1 extends Thread 
{
    public void run()
    {
        try 
        {
            System.out.println("Thread 1");
            Multithreading a = new Multithreading(); 
            a.inputS();
        }
        catch(Exception e) 
        {
            e.printStackTrace(); 
        }
    }
}
class s2 extends Thread 
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
}