import java.io.*;
public class IS2{
   public static void main(String[] args) throws Exception {
      InputStream IS = null;
            
      try {
         IS = new FileInputStream("20BCN7028.txt");
         System.out.println("Char : "+(char)IS.read());
         System.out.println("Char : "+(char)IS.read());
         System.out.println("Char : "+(char)IS.read());
         IS.skip(2);
         System.out.println("Char : "+(char)IS.read());
         System.out.println("Char : "+(char)IS.read());
      } catch(Exception e) {
         e.printStackTrace();
      } finally {
         if(IS!=null)
            IS.close();
      }
   }
}