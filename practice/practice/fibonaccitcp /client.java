import java.io.*;
import java.net.*;

class client{
    public static void main(String args[])throws Exception{
        Socket s = new Socket("localhost",5555);
        PrintStream ps = new PrintStream(s.getOutputStream());
        BufferedReader bis = new BufferedReader(new InputStreamReader(s.getInputStream()));
        BufferedReader bk = new BufferedReader(new InputStreamReader(System.in));
        String sfs,sts;

            String message = bis.readLine();
            System.out.println(message);
            String num = bk.readLine();
            ps.println(num);
            String output = bis.readLine();
            System.out.println(output);
        
    }
}