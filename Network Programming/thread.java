import java.util.*; 
import java.io.*; 
public class thread extends Thread
{
    // Declare a String variable to represent task.
    String task;

    thread(String task)
    {
        this.task = task;
    }

    public void run()
    {
        for(int i = 0; i <= 1; i++)
        {
            System.out.println(task+ " : " +i); 	
            try
            {
                inputS(i*5);
                Thread.sleep(1000); // Pause the thread execution for 1000 milliseconds.
            }
            catch(InterruptedException ie) {
                System.out.println(ie.getMessage());	
            }
        }// end of for loop.
    } // end of run() method.
    public static void main(String[] args) 
    {
        // Create two objects to represent two tasks.
        thread th1 = new thread("Thread 1 "); // Passing task as an argument to its constructor.
        thread th2 = new thread("Thread 2 ");

        // Create two objects of Thread class and pass two objects as parameter to constructor of Thread class.
        Thread t1 = new Thread(th1);
        Thread t2 = new Thread(th2);
        t1.start();
        t2.start();
    }
    public static void inputS(int i)
    { 
        
        //Read and close
        byte[] a = new byte[128];
        int c;
        try 
        {
            InputStream in = new FileInputStream("20BCN7028.txt");
            while ((c = in.read())!= -1) {
                int ch = in.available();
                if(ch!=i)
                break;
            }
            in.read(a);
            String d = new String(a); 
            System.out.println(d);
        }
        catch(Exception e)
        {
            e.getStackTrace(); 
        } 
    }
}