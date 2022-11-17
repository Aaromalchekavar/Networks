// Client2 class that
// sends data and receives also

import java.io.*;
import java.net.*;

class Client2 {

  public static void main(String args[]) throws Exception {
    // Create client socket
    Socket socket = new Socket("localhost", 6969);

    // to send data to the server
    OutputStream outputstream = socket.getOutputStream();
    DataOutputStream dataoutputstream = new DataOutputStream(outputstream);

    // to read data coming from the server
    InputStream inputstream = socket.getInputStream();
    BufferedReader bufferedreaderinputstream = new BufferedReader(new InputStreamReader(inputstream));

    // to read data from the keyboard
    BufferedReader bufferedreaderkeyboard = new BufferedReader(new InputStreamReader(System.in));
    String strtoserver, strfromserver;

    // repeat as long as exit
    // is not typed at client
    while (!(strtoserver = bufferedreaderkeyboard.readLine()).equals("exit")) {
      // send to the server
      dataoutputstream.writeBytes(strtoserver + "\n");

      // receive from the server
      strfromserver = bufferedreaderinputstream.readLine();

      System.out.println(strfromserver);
    }

    // close connection.
    dataoutputstream.close();
    bufferedreaderinputstream.close();
    bufferedreaderkeyboard.close();
    socket.close();
  }
}
