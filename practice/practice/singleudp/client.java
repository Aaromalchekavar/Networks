import java.io.*;
import java.net.*;
import java.util.*;

class client{
    public static void main(String args[])throws Exception{
        DatagramSocket s = new DatagramSocket();
        InetAddress ip = InetAddress.getLocalHost();
        byte[] buffer = null;
        Scanner sc = new Scanner(System.in);
        
        while(true){
            String data = sc.nextLine();
        buffer = data.getBytes();
        DatagramPacket packet = new DatagramPacket(buffer,buffer.length,ip,5555);
        s.send(packet);
        if(data.equals("exit"))break;
        }
    }
}