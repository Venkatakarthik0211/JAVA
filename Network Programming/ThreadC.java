
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import java.util.Vector;

public class ThreadC extends Thread{
    boolean state;
    @SuppressWarnings("rawtypes")

       
        // create a new synchronized list to be used
    static Object[] obj=new Object[10];
    static int count;

    ThreadC(boolean state1){
        state=state1;
        obj[count]=this;
        System.out.println(obj[count]+""+count);
        count++;

    }
    synchronized void add()
    {
        try {
            while(state==false)
            {
                this.wait();
            }
            while(state) {
                System.out.println("elements are added"+""+Thread.currentThread().getName());
                state = true;
                //notifyAll();
                this.wait();
            }

        
        }catch(Exception e)
        { System.out.println(e);}
        //state=false;

        //notify();
    }

    public void run()
    {
        synchronized(this){

            this.add();
        }

    }

    public static void main(String[] args) throws IllegalMonitorStateException {

        ThreadC obj1=new ThreadC(true);

        Thread objt=new Thread(obj1);
        Thread objt1=new Thread(obj1);
        objt.start();
        objt1.start();

    }
}

