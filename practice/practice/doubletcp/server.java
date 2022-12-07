import java.io.*;
import java.net.*;

class server{
    public static void main(String args[])throws Exception{
        ServerSocket ss = new ServerSocket(5555);
        Socket s = ss.accept();
        System.out.println("Connection Established");
        PrintStream ps = new PrintStream(s.getOutputStream());
	BufferedReader bis = new BufferedReader(new InputStreamReader(s.getInputStream()));
	BufferedReader bk = new BufferedReader(new InputStreamReader(System.in));
        
        while(true){
        String sfc,stc;
        sfc=bis.readLine();
        System.out.println(sfc);
        stc = bk.readLine();
        ps.println(stc); }
    }
}