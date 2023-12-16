import java.io.*; 
class BISmark
{
    static int i; 
    static char c;
    public static void main(String args[]) 
    {
        inputM();
    }

    public static void inputM()
    {
        try 
        {
            int t = 1;
            InputStream in = new FileInputStream("20BCN7028.txt"); 
            BufferedInputStream bfs = new BufferedInputStream(in);
            boolean b = bfs.markSupported(); //mark amd markSupported supports for BufferedInputStream
            System.out.println("Is mark supported? "+b);
            b = in.markSupported(); 
            System.out.println("Is mark supported? "+b);
            //Place x in even places
            while((i=in.read())!=-1)
            {
                if(t%2==0) 
                {
                    c = (char)i;
                    //Marks 1 position
                    bfs.mark(0);
                    if(c==' ')
                        System.out.print(" ");
                    else
                    {
                        System.out.print("x");
                        bfs.reset(); //resets all accumulated output on buffer
                    }
                }
                else 
                {
                    c = (char)i;
                    System.out.print(c);
                }    
                t++;
            }
            in.close();
            bfs.close();
            //No difference between FileinputStream and FileOutputStream 
            //Instead read we will use write operation
        }
        catch(Exception e) 
        {
            e.printStackTrace(); 
        }
    }
}