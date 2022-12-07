import java.io.*;
import java.net.*;

class client{
public static void main(String args[]) throws IOException{
	Socket s = new Socket("localhost",9999);
	DataInputStream ds = new DataInputStream(s.getInputStream());
	String str = ds.readUTF();
	System.out.println(str);
}
}
