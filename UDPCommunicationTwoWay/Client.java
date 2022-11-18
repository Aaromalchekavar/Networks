import java.io.*;
import java.net.*;

class Client {

  // public static DatagramSocket clientsocket;
  // public static DatagramPacket datagrampacket;
  // public static BufferedReader bufferedreader;
  // public static InetAddress ip;
  public static byte buf[] = new byte[1024];
  public static int cport = 2221, sport = 5552;

  public static void main(String[] args) throws IOException {
    DatagramSocket clientsocket = new DatagramSocket(cport);
    DatagramPacket datagrampacket = new DatagramPacket(buf, buf.length);
    BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(System.in));
    InetAddress ip = InetAddress.getLocalHost();

    System.out.println("Client is Running...");
    System.out.println("Type some text if u want to Quit type 'exit'.");
    while (true) {
      String str1 = new String(bufferedreader.readLine());
      buf = str1.getBytes();
      if (str1.equals("exit")) {
        System.out.println("Terminated..");
        clientsocket.send(new DatagramPacket(buf, str1.length(), ip, sport));
        break;
      }
      clientsocket.send(new DatagramPacket(buf, str1.length(), ip, sport));

      clientsocket.receive(datagrampacket);
      String str4 = new String(datagrampacket.getData(), 0, datagrampacket.getLength());
      System.out.println("Server said : " + str4);
    }
  }
}
