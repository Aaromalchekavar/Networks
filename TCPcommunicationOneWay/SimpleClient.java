import java.io.*;
import java.net.*;

public class SimpleClient {

  public static void main(String args[]) throws IOException {
    // Open your connection to a server, at port 1254
    Socket socket = new Socket("localhost", 1254);
    // Get an input file handle from the socket and read the input
    InputStream inputstream = socket.getInputStream();
    DataInputStream datainputstream = new DataInputStream(inputstream);
    String str = new String(datainputstream.readUTF());
    System.out.println(str); // When done, just close the connection and exit
    datainputstream.close();
    inputstream.close();
    socket.close();
  }
}
