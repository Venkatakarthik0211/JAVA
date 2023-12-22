class test
{
    public static void main(String[] args)
    {
        String s = "abc";
        System.out.println(subseq("","ahbgdc",s));
    }
    
    public static boolean subseq(String newString, String original, String s)
    {
        if(original.isEmpty())
        {
            if(newString.equals(s))
            {
                return true;
            }
            return false;
        }
        
        char c = original.charAt(0);
        return subseq(newString+c, original.substring(1),s) || subseq(newString, original.substring(1),s);
    }
}