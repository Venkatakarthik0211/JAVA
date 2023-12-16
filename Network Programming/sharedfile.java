import java.io.*;
import java.util.*;
public class sharedfile implements Runnable {
    private String fileName;
    private int i,j;
    public sharedfile(String fileName,int i, int j) {
        this.fileName = fileName;
        this.i = i;
        this.j = j;
    }
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            char[] a = new char[128];
            reader.read(a,i,j);
            String d = new String(a); 
            System.out.println(d);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String fileName = "20BCN7028.txt";
        sharedfile reader1 = new sharedfile(fileName,0,n);
        sharedfile reader2 = new sharedfile(fileName,n,n*2);
        Thread thread1 = new Thread(reader1);
        Thread thread2 = new Thread(reader2);
        thread1.start();
        thread2.start();
    }
}
