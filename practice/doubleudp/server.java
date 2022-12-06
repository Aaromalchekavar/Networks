import java.io.*;
import java.net.*;

class server{
public static void main(String args[]) throws IOException{
    int serverport = 4050;
    int clientport = 4051;
    byte[] buffer =  new byte[66635];
    DatagramSocket s = new DatagramSocket(serverport);
    DatagramPacket packet = new DatagramPacket(buffer,buffer.length);
    BufferedReader bk = new BufferedReader(new InputStreamReader(System.in));
    InetAddress ip = InetAddress.getLocalHost();
    while(true){
        s.receive(packet);
        String sfc = new String(packet.getData(),0,packet.getLength());
        System.out.println(sfc);
        String stc = bk.readLine();
        buffer = stc.getBytes();
        s.send(new DatagramPacket(buffer,stc.length(),ip,clientport));
    }
}
}