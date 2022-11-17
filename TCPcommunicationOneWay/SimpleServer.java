import java.io.*;
import java.net.*;

public class SimpleServer {

  public static void main(String args[]) throws IOException {
    //  Register service on port 1254
    ServerSocket serversocket = new ServerSocket(1254);
    Socket socket = serversocket.accept();
    // Wait and accept a connection
    // Get a communication stream associated with the socket
    OutputStream outputstream = socket.getOutputStream();
    DataOutputStream dataoutputstream = new DataOutputStream(outputstream);
    // Send a string!
    dataoutputstream.writeUTF("Hi there");
    // Close the connection, but not the server socket
    dataoutputstream.close();
    outputstream.close();
    socket.close();
  }
}

