import java.io.*; 
class ISR 
{ 
    static int i; 
    static char c; 
    static InputStream in = null;
    public static void main(String agrs[]) throws IOException
    {
        inputS(); //InputStream 
        inputSloop(); //InputStrean loop 
    }

    public static void inputS() throws IOException
    { 
        //Read and close
        byte[] a = new byte[128];
        OutputS(a);
        try 
        {
            in = new FileInputStream("20BCN7028.txt");
            in.read(a); //reads byte array
            //Byte data converted to string
            String d = new String(a); 
            System.out.println(d);
        }
        catch(Exception e)
        {
            e.getStackTrace(); 
        } finally 
        {
            if(in!=null)
            {
                in.close();
            }
        }
    }

    public static void  inputSloop() throws IOException
    {
        try 
        {
            InputStream in = new FileInputStream("20BCN7028.txt");
            //Using while loop instead of using in.read(byte[] a)
            while((i = in.read())!=-1)
            {
                c = (char)i; 
                //System.out.println("Number of data bytes present"+in.available());
                //Above Print statement Shows how many elements are left to read, if some elements are read before
                //If is.available() is placed before reading data then it will give output full number of bytes
                System.out.print(c);
            }
            in.close();
        }
        catch(Exception e)
        {
            e.getStackTrace(); 
        }
    }

    public static void OutputS(byte[] a) throws IOException
    {
        String s = "Rewritten 20BCN7028 ";
        try
        {
            OutputStream os = new FileOutputStream("20BCN7028.txt");
            //convert string to bytes
            a=s.getBytes();
            os.write(a,0,9); //write(byte[],a,b) - writes specified leength
            // flush the stream but it does nothing
            //if any bytes previously written have been buffered by the implementation of the output stream,
            // such bytes, should immediately be written to their intended destination.
            //In short, flush makes sure all the data is written from buffer 
            os.flush();
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