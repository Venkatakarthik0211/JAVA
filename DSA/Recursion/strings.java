import java.util.*; 
class strings
{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        removeacharacter1("",s);
        System.out.println(removeacharacter(s));
        System.out.println(removeaword(s));
        in.close();
    }
    public static String removeaword(String s)
    {
        if(s.isEmpty())
        {
            return "";
        }

        if(s.startsWith("CRAZY"))
        {
            return removeaword(s.substring(5));
        }
        else
        {
           return s.charAt(0)+removeaword(s.substring(1));
        }

    }
    public static void removeacharacter1(String processed, String original)
    {
        if(original.isEmpty())
        {
            System.out.println(processed);
            return;
        }
        char c = original.charAt(0);
        if(c == 'a')
        {
            removeacharacter1(processed, original.substring(1));
        }
        else
        {
        removeacharacter1(processed+c, original.substring(1));
        }
    }
    public static String removeacharacter(String s)
    {
        if(s.isEmpty())
        {
            return "";
        }
        char c = s.charAt(0);
        if(c == 'a')
        {
            return removeacharacter(s.substring(1));
        }
        else
        {
            return c + removeacharacter(s.substring(1));
        }
    }
}