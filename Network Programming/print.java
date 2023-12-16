import java.io.*;
class print 
{
    public static void main(String[] args)
    {
        printS();  
    }

    public static void printS()
    {
        try
        {
            //Create, write and append using PrintStream
            byte c = 70;
            PrintStream ps = new PrintStream(System.out,true);
            ps.write(c);
            char ca = 'U';
            ps.append(ca);
            String s= " It is not what you think";
            //appending a string, limited string
            ps.append(s);
            System.out.println();
            ps.append("Ok, i understood",0,2);
            System.out.println();
            System.out.println("Is there are any errors?");
            ps.println(ps.checkError()); //to flush and check errors
            //ps.print() - can print primitive data types, char a[],...,objects
            Object o = "New text";
            ps.println(o);
            //ps.clearError(); //clears any stream errors present
        }
        catch(Exception e )
        {
            e.printStackTrace();
        }
    }
}