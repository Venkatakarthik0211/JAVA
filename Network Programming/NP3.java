import java.io.*; 
class NP3
{
    public static void main(String args[])throws IOException 
    {
        char[] a = new char[256]; //only chracter array for Unicode
        try 
        {
          //1 - Reader Class
          Reader in = new FileReader("20BCN7028.txt");   
          System.out.println(in.ready());//checks if reader is ready
          System.out.println(in.read(a)); // To read contents - displays number of characters
          System.out.println(a); //contents which are read
          in.close(); //closes the reader class

        }
        catch(Exception e)
        {
            e.getStackTrace();
        }
    }
}