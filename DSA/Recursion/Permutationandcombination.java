import java.util.ArrayList;
import java.util.Scanner;
class permutationandcombination
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine(); 
        ArrayList<String> list = permutate("",str);
        System.out.println(list); // prints all the permutations
        System.out.println(list.size()); // prints the number of permutations
        list = phonepad("",str);
        System.out.println(list); // prints all the permutations
        System.out.println(list.size()); // prints the number of permutations
        sc.close();
    }
    public static ArrayList<String> phonepad(String processed,String unprocessed)
    {
    if (unprocessed.isEmpty()) {
        ArrayList<String> list = new ArrayList<>();
        list.add(processed);
        return list;
    }

    int digit = unprocessed.charAt(0) - '0';
    ArrayList<String> list = new ArrayList<>();

    char startChar = (char) ((digit - 2) * 3 + 'a');
    char endChar = (char) ((digit - 2) * 3 + 2 + 'a');

    if (digit == 7 || digit == 9) {
        endChar += 1; // For digit 7 or 9, add two more characters
    }
    if(digit==8)
    {
        startChar = 't';
        endChar = 'v';
    }

    for (char ch = startChar; ch <= endChar; ch++) {
        list.addAll(permutate(processed + ch, unprocessed.substring(1)));
    }
    return list;
    }
    public static ArrayList<String> permutate(String processed, String unprocessed)
    {
        if(unprocessed.isEmpty())
        {
            ArrayList<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }
        char ch = unprocessed.charAt(0);
        ArrayList<String> list = new ArrayList<>();
        for(int i=0;i<=processed.length();i++)
        {
            String first = processed.substring(0,i);
            String second = processed.substring(i);
            list.addAll(permutate(first+ch+second,unprocessed.substring(1)));
        }
        return list;
    }

}