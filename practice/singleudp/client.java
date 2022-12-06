import java.io.*;
import java.net.*;
import java.util.*;

class client{
public static void main(String args[]) throws IOException{
  Scanner sc = new Scanner(System.in);
  DatagramSocket s = new DatagramSocket();
  InetAddress ip = InetAddress.getLocalHost();
  byte[] buffer = null;
  while(true){
    String input = sc.nextLine();
    buffer = input.getBytes();
    DatagramPacket packet = new DatagramPacket(buffer,buffer.length,ip,3601);
    s.send(packet);
    if(input.equals("exit")) break;
  }
}
}