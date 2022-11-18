import java.io.*;
import java.net.*;

class Server {

  // public static DatagramSocket serversocket;
  // public static DatagramPacket datagrampacket;
  // public static BufferedReader bufferedreader;
  // public static InetAddress ip;
  public static byte buf[] = new byte[1024];
  public static int cport = 2221, sport = 5552;

  public static void main(String[] args) throws IOException {
    DatagramSocket serversocket = new DatagramSocket(sport);
    DatagramPacket datagrampacket = new DatagramPacket(buf, buf.length);
    BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(System.in));
    InetAddress ip = InetAddress.getLocalHost();

    System.out.println("Server is Running...");
    while (true) {
      serversocket.receive(datagrampacket);
      String str2 = new String(datagrampacket.getData(), 0, datagrampacket.getLength());
      if (str2.equals("exit")) {
        System.out.println("Terminated...");
        break;
      }
      System.out.println("Client said : " + str2);
      String str3 = new String(bufferedreader.readLine());
      buf = str3.getBytes();
      serversocket.send(new DatagramPacket(buf, str3.length(), ip, cport));
    }
  }
}
