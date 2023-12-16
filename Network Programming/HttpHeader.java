import java.io.*; 
import java.net.*; 
import java.util.*;
import java.net.URLConnection;
//Using proper charset - HTTP header - 1
// The program done is the HTTP header where the client sends to the server
class HttpHeader
{
    public static String e = "UTF-8"; //encoding
    public static void main(String args[]) 
    {
        try 
        {

            String s = "file:///C:/xampp/htdocs/project/forms.html";
            URL u = new URL(s);

            //Configure and check the connection 
            configure(u); 

            //Read Data of the header
            System.out.println("-------Header information--------");
            info(u);

            //Read Data From the server
            System.out.println("---------Download the page-------");

            download(u); // To download content ---
            System.out.println("------------If it is Binary File, Saving the file from url---------");
            save(u); //save binary file tp disk 
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void configure(URL u) 
    {
        try 
        {
            URLConnection uc = u.openConnection();
            System.out.println(uc.getURL());
            if (!uc.getDoInput()) 
            {
                //boolean field doInput is true if the URLConnection can be used for input
                System.out.println("DoInput has set to true");
                uc.setDoInput(true);
            }
            if (!uc.getDoOutput()) 
            {
                //boolean field doOutput is true if the URLConnection can be used for output
                System.out.println("DoOutput has set to true");
                uc.setDoOutput(true);
            }
            if (uc.getUseCaches()) 
            {
                //disables caching to ensure that the most recent version of the document is retrieved
                System.out.println("UseCache has set to false");
                uc.setUseCaches(false);
            }
            if (!uc.getDefaultAllowUserInteraction())
            {
                System.out.println("DefaultAllowUserInteraction has set to true");
                uc.setDefaultAllowUserInteraction(true);
            }
            
            //For setting and know/ing the time out of the connecrion
            System.out.println("Connection time out: "+uc.getConnectTimeout());
            System.out.println("Read = time out: "+uc.getReadTimeout());
            uc.setConnectTimeout(1000);
            uc.setReadTimeout(1000);
            System.out.println("Connection time out: "+uc.getConnectTimeout());
            System.out.println("Read = time out: "+uc.getReadTimeout());

            //If page is modified in 1 hour - download the content
            Date t = new Date(); 
            long ms = 60*60*1000; //Can set or take a user input
            System.out.println("Will retrieve file if it's modified since " + new Date(uc.getIfModifiedSince()));
            uc.setIfModifiedSince((new Date(t.getTime()-ms)).getTime( ));
            System.out.println("Will retrieve file if it's modified since " + new Date(uc.getIfModifiedSince()));
            InputStream in = new BufferedInputStream(uc.getInputStream());
            Reader r = new InputStreamReader(in);
            int c; 
            while((c=r.read())!= -1)
            {
                System.out.print((char)c);
            }
            System.out.println(); 
        }
        catch(Exception e) 
        {
            e.printStackTrace(); 
        }
    }

    public static void info(URL u) 
    {
        //header methods
        try 
        {
            //We can configure connections such as usecaches etc before URLConnection 

            URLConnection uc = u.openConnection();
            System.out.println("Content-type: " + uc.getContentType( ));
            System.out.println("Content-encoding: " + uc.getContentEncoding());
            System.out.println("Date: " + new Date(uc.getDate( )));
            System.out.println("Last modified: " + new Date(uc.getLastModified( )));
            System.out.println("Expiration date: " + new Date(uc.getExpiration( )));
            System.out.println("Content-length: " + uc.getContentLength( ));

            System.out.println("------------------- Printing entire header:  ----------------------");

            //HeaderFiled(int) , HeaderField(String), HeaderFieldKey(int)
            for (int j = 1; ; j++) {
                String header = uc.getHeaderField(j);
                if (header == null) break;
                System.out.println(uc.getHeaderFieldKey(j) + ": " + header);
            }
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
    }

    public static void download(URL u)
    {
        try 
        {
            URLConnection uc = u.openConnection(); 
            String type = uc.getContentType(); 
            int es = type.indexOf("charset =");
            if(es!=-1) 
            {
                e = type.substring(es);
            }
            InputStream in = new BufferedInputStream(uc.getInputStream());
            Reader r = new InputStreamReader(in, e);
            int c; 
            while((c=r.read())!=-1)
            {
                System.out.print((char)c );
            }
        }
        catch(Exception e) 
        {
            e.getStackTrace(); 
        }
    }

    public static void save(URL u) 
    {
        try 
        {
            URLConnection uc = u.openConnection(); 
            String type = uc.getContentType(); 
            int length = uc.getContentLength(); 
            if(type.startsWith("text/")|| length == -1) 
            {
                System.out.println("Not a binary file");
                System.exit(0);
            }
            InputStream r  = uc.getInputStream();
            InputStream in = new BufferedInputStream(r);
            byte[] d = new byte[length];
            int read = 0; 
            int ox = 0; //Offset value
            while(ox<length) 
            {
                read = in.read(d,ox,d.length-ox);
                if(read == -1)
                {
                    break;
                }
                ox += read;
            }
            in.close();
            if(ox!=length)
            {
                System.out.println("Only read: "+ ox + 
                    "Bytes expected "+ length + " Bytes");
            }
            String file = u.getFile(); 
            file = file.substring(file.lastIndexOf('/'+1));
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(d);
            fos.flush();
            fos.close();
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
    }

}