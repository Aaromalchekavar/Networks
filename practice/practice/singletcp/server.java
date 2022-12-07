import java.io.*;
import java.net.*;

class server{
    public static void main(String args[])throws Exception{
        ServerSocket ss = new ServerSocket(5555);
        Socket s = ss.accept();
        PrintStream ps = new PrintStream(s.getOutputStream());
        while(true){
        ps.println("Hello");
        } 
    }
}