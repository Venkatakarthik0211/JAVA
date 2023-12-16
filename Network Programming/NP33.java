import java.io.FileWriter;

public class NP33 {

  public static void main(String args[]) {

    String data = "20BCN7028";

    try {
      // Creates a FileWriter
      FileWriter output = new FileWriter("20BCN7028.txt");
      output.write(data);
      output.close();
    }

    catch (Exception e) {
      e.getStackTrace();
    }
  }
}