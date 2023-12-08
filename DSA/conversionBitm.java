import java.util.Scanner;
public class conversionBitm {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a character: ");
        char c = in.next().charAt(0);
        convert(c);
        in.close();
    }
    public static void convert(char c)
    {
        //Using Bit manipulation - Apporach 1
        if(c>=97 && c<=122)
        System.out.println("Uppercae: "+(char)(c & '_'));
        else if(c>=65 && c<=90)
        System.out.println("Lowercase: "+(char)(c | ' '));
        else
        System.out.println("Invalid input");

        //Using Bit manipulation - Apporach 2
        System.out.println("Toogle: "+(char)(c ^ ' '));
        System.out.println("Alphabetical position is: "+(c & 31)); //Case doesn't matter

    }
    
}
