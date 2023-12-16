import java.io.*; 
import java.util.*; 
class BAIS
{
    static String str = "";
    static int size = 0; 
    public static void main(String args[]) 
    {
        Scanner in = new Scanner(System.in); 
        int n = in.nextInt();
        byte a[] = new byte[n];
        System.out.println("Enter elements of array");
        for(int i = 0; i<n; i++)
            a[i] = in.nextByte();
        bais(a,n);
        baiskip(a,n);
        System.out.println();
        baos(a,n);
    }

    public static void bais(byte a[],int n)
    {
        try 
        {
            ByteArrayInputStream in = new ByteArrayInputStream(a);
            //Reading byte array
            for(int i=0;i<n;i++)
            {
                int d = in.read(); 
                System.out.print(d+" ");
            }
            System.out.println();
            in.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void baiskip(byte a[],int n)
    {
        try 
        {
            ByteArrayInputStream in = new ByteArrayInputStream(a);
            //Reading byte array
            //skip even elemennts
            for(int i=0;i<n;i++)
            {
                int d = in.read(); 
                if(d==-1)
                    break; 
                if(i%2==0)
                {
                    in.skip(1);//Skips n Number of elements
                }
                System.out.print(d+" ");
            }
            in.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void baos(byte a[],int n)
    {
        try 
        {
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            byte[] x = {49, 50, 51, 52, 53};
            for (byte b : x) {
                os.write(b);
                str = os.toString();
                size = os.size(); //returns size
                System.out.print(size+":");
                System.out.println(str);

            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}