import java.io.*;
import java.net.*;

class server{
public static void main(String args[]) throws IOException{
	ServerSocket ss = new ServerSocket(9999); 
	Socket s = ss.accept();
	DataOutputStream ds = new DataOutputStream(s.getOutputStream());
	ds.writeUTF("Hello me");
}
}

