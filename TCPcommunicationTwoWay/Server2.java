// Server2 class that
// receives data and sends data

import java.io.*;
import java.net.*;

class Server2 {

  public static void main(String args[]) throws Exception {
    // Create server Socket
    ServerSocket serversocket = new ServerSocket(6969);

    // connect it to client socket
    Socket socket = serversocket.accept();
    System.out.println("Connection established");

    // to send data to the client
    PrintStream printstream = new PrintStream(socket.getOutputStream());

    // to read data coming from the client
    BufferedReader bufferedreaderinputstream = new BufferedReader(new InputStreamReader(socket.getInputStream()));

    // to read data from the keyboard
    BufferedReader bufferedreaderkeyboard = new BufferedReader(new InputStreamReader(System.in));

    // server executes continuously
    while (true) {
      String strfromclient, strtoclient;

      // repeat as long as the client
      // does not send a null string

      // read from client
      while ((strfromclient = bufferedreaderinputstream.readLine()) != null) {
        System.out.println(strfromclient);
        strtoclient = bufferedreaderkeyboard.readLine();

        // send to client
        printstream.println(strtoclient);
      }

      // close connection
      printstream.close();
      bufferedreaderinputstream.close();
      bufferedreaderkeyboard.close();
      serversocket.close();
      socket.close();

      // terminate application
      System.exit(0);
    } // end of while
  }
}
