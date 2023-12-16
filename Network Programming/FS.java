import java.io.*; 
import java.nio.channels.FileChannel;
class FS
{
    static int i;
    static char c;
    static long pos;
    public static void main(String args[]) 
    {
        byte[] a = new byte[128]; 
        FOS(a);
        System.out.println();
        System.out.println("End of inputStream");
        FIS();
    }

    public static void FIS() 
    {        
        try
        {
            FileInputStream fin = new FileInputStream("20BCN7028.txt");
            while((i = fin.read())!=-1)
            {
                c = (char)i;  
                //Get filechannel and see how many byte are read
                FileChannel fc = fin.getChannel();
                pos = fc.position();
                System.out.print(" "+c+" ");
                System.out.print("No of bytes read = "+pos);
                System.out.println();
                //FileDescriptor left

            }
            fin.close();
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
    }

    public static void FOS(byte[] a)
    {
        String s = "Rewritten again 20BCN7028 ";
        try
        {
            FileOutputStream os = new FileOutputStream("20BCN7028.txt");
            //convert string to bytes
            a=s.getBytes();
            os.write(a,0,9); //write(byte[],a,b) - writes specified leength
            // flush the stream but it does nothing
            //if any bytes previously written have been buffered by the implementation of the output stream,
            // such bytes, should immediately be written to their intended destination.
            //In short, flush makes sure all the data is written from buffer 
            os.flush();
            //Get filechannel and see how many byte are read
            FileChannel fc = os.getChannel();
            pos = fc.position();
            System.out.print("No of bytes read = "+pos);
            os.write('\n');
            os.write(a); //write(byte[] a) 
            char c = 's';
            os.write(c); //write() - specified byte   
            os.close();
        }
        catch(Exception e)
        {
            e.printStackTrace(); 
        }
    }
}