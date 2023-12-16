import java.io.*; 
class DS
{
    public static void main(String args[])
    {
        byte[] a = DOS();
        DISA(a);
        System.out.println();
        DIS();
    }

    public static void DIS()
    {
        try 
        {
            InputStream in = new FileInputStream("20BCN7028.txt");
            DataInputStream ds = new DataInputStream(in);
            int c = in.available();
            byte []a = new byte[c];
            ds.read(a);
            for(byte b:a)
            {
                char d = (char)b;
                System.out.print(d);
            }
            //ds.read(a, 4, 3);
            in.close();
            ds.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void DISA(byte[] a)
    {
        try
        {
            InputStream in = new ByteArrayInputStream(a);
            DataInputStream ds = new DataInputStream(in);
            while(ds.available()>0) 
            {
                //System.out.println(ds.readBoolean()); //read Boolean
                byte b = ds.readByte();//Single Byte reading
                System.out.println("Byte: "+(char)b+" ");
                /*char c = ds.readChar();//Single Char read
                System.out.println("Char: " + c);
                Double d = ds.readDouble();
                System.out.println("Double: " + d);
                */
            }
            in.close();
            ds.close();
        }
        catch(Exception e) 
        {
            e.getStackTrace(); 
        }

    }

    public static byte[] DOS()
    {
        byte[] a = {65,66,67,68,69,70,71,72};
        try 
        {
            OutputStream os = new FileOutputStream("20BCN7028.txt");
            DataOutputStream dos = new DataOutputStream(os);
            //With DataIputStream we can read unsigned data types
            //Ex: k = ds.readUnsignedByte/readUnsignedChar();
            //Can read encoded as well such as UTF
            //We can skip Bytes using ds.skipBytes like in InputStream
            for (byte d:a) 
            {
                dos.writeByte(d);
                dos.write(' ');
                //dos.writeChar(d);
                //dos.write(' ');
                //dos.writeInt(d);
                //dos.write(' ');
                //dos.writeDouble(d);
                //dos.write(' ');
            }
            String s = "Successful!! ";
            dos.writeBytes(s); //writing string - can be taken as Chars as well
            dos.writeBoolean(true); //writing boolean 
            dos.flush();
            os.close();
            dos.close();
        }
        catch(Exception e)
        {
            e.getStackTrace();
        }
        return a;
    }
}