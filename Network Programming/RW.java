
import java.io.*;
import java.nio.charset.Charset;
class RW
{
    public static void main(String args[])
    {
        char[] a = new char[40];
        W(a);
        R(a); 
        BR(a);
    }

    public static void R(char[] a)
    {
        try 
        {
            FileInputStream fs = new FileInputStream("20BCN7028.txt");
            InputStreamReader r1 = new InputStreamReader(fs);
            System.out.println("Character encoding of r1: " + r1.getEncoding());
            r1.read(a);
            System.out.println(a);
            InputStreamReader r2 = new InputStreamReader(fs,Charset.forName("UTF16"));
            r2.read(a);
            System.out.println(a);
            System.out.println("Character encoding of r2: " + r2.getEncoding());
            r1.close();
            r2.close();
            fs.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void BR(char[] a) 
    {
        try {
            FileInputStream is = new FileInputStream("20BCN7028.txt");
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            System.out.println((char)br.read());
            System.out.println((char)br.read());
            br.mark(2);
            System.out.println("mark() invoked");
            System.out.println((char)br.read());
            System.out.println((char)br.read());
            br.reset();
            System.out.println("reset() invoked");
            System.out.println((char)br.read());
            System.out.println((char)br.read());
            is.close();
            isr.close();
            br.close();
        } catch (Exception e) {
            // exception occurred.
            e.printStackTrace();
        }
    }

    public static void W(char[] a)
    {
        try {
            String s = "I am Disappointed";
            OutputStream os = new FileOutputStream("20BCN7028.txt");
            OutputStreamWriter w = new OutputStreamWriter(os);
            w.write(70);
            w.write(85);
            w.write(67);
            w.write(75);
            w.write(' ');
            w.write(s);
            w.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}