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
        System.out.println(data(buffer));
        if (data(buffer).toString().equals("bye")) {
            buffer = new byte[65535];
        break;
        }
      } 
}

 public static StringBuilder data(byte[] buffer) {
    if (buffer == null) return null;
    StringBuilder ret = new StringBuilder();
    int i = 0;
    while (buffer[i] != 0) {
      ret.append((char) buffer[i]);
      i++;
    }
    return ret;
  }
}