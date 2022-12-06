import java.io.*;
import java.net.*;
import java.util.*;

class server{
public static void main(String args[]) throws IOException{
    DatagramSocket s = new DatagramSocket(3601);
    byte[] buffer = new byte[65535];
    while(true){
        DatagramPacket packet =  new DatagramPacket(buffer,buffer.length);
        s.receive(packet);
        String data = new String(packet.getData(),0,packet.getLength());
        System.out.println(data);
        }
      } 
}
