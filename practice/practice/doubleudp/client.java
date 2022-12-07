import java.io.*;
import java.net.*;

class server{
    public static void main(String args[]) throws Exception{
        int clientport = 5555,serverport = 5551;
        DatagramSocket s = new DatagramSocket(clientport);
        byte[] buffer = new byte[65535];
        InetAddress ip = InetAddress.getLocalHost();
        DatagramPacket packet = new DatagramPacket(buffer,buffer.length);
        BufferedReader bk = new BufferedReader(new InputStreamReader(System.in));
        while(true){
        String stc = bk.readLine();
        buffer = stc.getBytes();
        s.send(new DatagramPacket(buffer,stc.length(),ip,serverport));
        s.receive(packet);
        String data = new String(packet.getData(),0,packet.getLength());
        System.out.println(data);
        }
    }
}