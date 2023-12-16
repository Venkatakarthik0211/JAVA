import java.io.*;
class NP32
{
    public static void main(String args[]) throws IOException 
    {
        char[] a = new char[256]; 
        //2 - Bufferreader
        //Creating a Filereader
        FileReader f = new FileReader("20BCN7028.txt");
        BufferedReader in2 = new BufferedReader(f);
        in2.skip(3); //skips the characters 
        //if there are no enough characters input 
        /*Example: Idontcare in file is 9 letters 
         * 
         * 
         */
        in2.read(a); //reads the data 
        System.out.println(a); //displays the contents which are read
        in2.close();   
    }
}