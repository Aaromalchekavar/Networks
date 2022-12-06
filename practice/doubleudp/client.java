import java.io.*;
import java.net.*;

class client{
public static void main(String args[]) throws IOException{
    int serverport = 4050;
    int clientport = 4051;
    byte[] buffer =  new byte[66635];
    DatagramSocket s = new DatagramSocket(clientport);
    DatagramPacket packet = new DatagramPacket(buffer,buffer.length);
    BufferedReader bk = new BufferedReader(new InputStreamReader(System.in));
    InetAddress ip = InetAddress.getLocalHost();
    while(true){
        String sts = bk.readLine();
        buffer = sts.getBytes();
        s.send(new DatagramPacket(buffer,sts.length(),ip,serverport));
        s.receive(packet);
        String sfs = new String(packet.getData(),0,packet.getLength());
        System.out.println(sfs);
    }
}
}