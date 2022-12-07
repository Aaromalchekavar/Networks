import java.io.*;
import java.net.*;

class client{
    public static void main(String args[])throws Exception{
        Socket s = new Socket("localhost",5555);
        BufferedReader bis = new BufferedReader(new InputStreamReader(s.getInputStream()));
        while(true){
        System.out.println(bis.readLine());}
    }
}