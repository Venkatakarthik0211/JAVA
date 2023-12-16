import java.util.*;
class T1 extends Thread //Interface class T1 implements Runnable
{
    //private static Object o = new Object();
    public static void main(String args[]) throws InterruptedException
    {
        Scanner in = new Scanner(System.in); 
        int n = in.nextInt();
        System.out.println("Even/odd number will have even/odd numbers");
        Thread t1 = new Thread(new ER(n)); 
        //If runnable Interface 
        //T1 m1 = new T1();
        //Thread t1 = new Thread(m1);
        Thread t2 = new Thread(new OR(n));
        t1.start();
        t1.join();
        t2.start();
        
        //Thread(String)
        //Start,join, sleep, synchronized, wait
        /*if(n%2==1) 
        {
            t1.start();  
            try  
            {  
                System.out.println("The current thread name is: "+ Thread.currentThread().getName());  
                t1.stop();
                t1.join();
            }   
            catch(Exception e)  
            {  
                System.out.println("The exception has been caught " + e);  
            }  
            t2.start();  
            synchronized(t1)
            {
                synchronized(t2)
                {
                    try 
                    {
                        t1.wait(1000);
                        //t1.notify(); - first odd thread will revoked 
                       t2.wait(500);
                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            }
            try  
            {  
                System.out.println("The current thread name is: " + Thread.currentThread().getName());  
                t2.join();  
            }  
            catch(Exception e)  
            {  
                System.out.println("The exception has been caught " + e);  
            }  
        }
        else 
        {
            t2.start();  
            try  
            {  
                System.out.println("The current thread name is: "+ Thread.currentThread().getName());  
                t2.join();
            }   
            catch(Exception e)  
            {  
                System.out.println("The exception has been caught " + e);  
            }  
            t1.start();  
            try  
            {  
                System.out.println("The current thread name is: " + Thread.currentThread().getName());  
                t1.stop();
                t1.join();  
            }  
            catch(Exception e)  
            {  
                System.out.println("The exception has been caught " + e);  
            }  
        }
        //String s = t1.getName(); //to invoke Thread(String)
        //System.out.println(s); */ 
    }
}
class OR implements Runnable
{
    int n; 
    public OR(int n)
    {
        this.n = n;
    }

    public void run() {
        for (int even =2;even <= n;even+=2) {
            System.out.println("Even thread : " + even);
            try 
            {
                Thread.sleep(200);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
class ER implements Runnable
{
    int n; 
    public ER(int n)
    {
        this.n = n;
    }

    public void run() {
        for (int odd =1;odd <= n;odd+=2) {
            System.out.println("odd thread : " + odd);
            try 
            {
                Thread.sleep(100);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}