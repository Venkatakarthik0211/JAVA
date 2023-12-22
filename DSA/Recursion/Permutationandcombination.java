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
        sc.close();
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