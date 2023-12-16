import java.util.*; 
class Q5 
{
    public static String temp = "";
    public static void main(String args[]) 
    {
        Scanner in = new Scanner(System.in);
        int l = in.nextInt();
        String s = in.next();
        System.out.println(f(s,0).length());
    }
    public static String f(String s, int n) 
    {
        if(s.length()==n)
        return temp;
        if(n>=1&&s.charAt(n)==s.charAt(temp.length()-1)&&n!=s.length()-1)
        f(s,n+1);
        else
        {
            temp = temp + s.charAt(n);
            f(s,n+1);
        }
        return temp;
    }
}