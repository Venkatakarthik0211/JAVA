
public class ThreadClass implements Runnable {
    int x=0;
    boolean w=false;
    String tname;

    public void run()
    {

        synchronized(this) {

            try{  
                if(w==false && Thread.currentThread().getName().equals("t1"))
                {
                    write();

                }
                if((Thread.currentThread().getName().equals("t2") || Thread.currentThread().getName().equals("t3") || Thread.currentThread().getName().equals("t4"))) {

                    read();
                }}catch(InterruptedException e) {System.out.println(e);}
        }

    }

    public synchronized void write() throws InterruptedException {
        for(int i=0;i<5;i++) {
            x=x+1;
            System.out.println(Thread.currentThread().getName()+" Updade x value");
            w=true;
            this.notifyAll();
            this.wait(1000);

        }
    }

    public synchronized void read() throws InterruptedException {
        for(int i=0;i<5;i++) {
            System.out.println(Thread.currentThread().getName()+" read x value="+ x);
            w=false;
            this.wait();
            // this.notify(); 

	          
        }
    }

    public static void main(String[] args) throws InterruptedException{
        ThreadClass obj=new ThreadClass();
        Thread th=new Thread(obj,"t1");
        Thread th1=new Thread(obj,"t2");
        Thread th2=new Thread(obj,"t3");
        Thread th3=new Thread(obj,"t4");

        th.start();
        th1.start();
        //th.join();
        th2.start();
        th3.start();

    }
}
