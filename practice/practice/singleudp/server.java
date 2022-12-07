import java.io.*;
import java.net.*;

class server{
    public static void main(String args[]) throws Exception{
        DatagramSocket s = new DatagramSocket(5555);
        byte[] buffer = new byte[65535];
        DatagramPacket packet = new DatagramPacket(buffer,buffer.length);
        while(true){
            s.receive(packet);
        String data =new String(packet.getData(),0,packet.getLength());
        System.out.println(data);
        }
    }
}