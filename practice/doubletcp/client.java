import java.io.*;
import java.net.*;
class client{
public static void main(String args[]) throws IOException{
	Socket s = new Socket("localhost",3504);
	DataOutputStream ds = new DataOutputStream(s.getOutputStream());
	BufferedReader bis = new BufferedReader(new InputStreamReader(s.getInputStream()));
	BufferedReader bk = new BufferedReader(new InputStreamReader(System.in));
	
		String sfs,sts;
		while(!(sts = bk.readLine()).equals("exit")){
			ds.writeBytes(sts);
			sfs = bis.readLine();
			System.out.println(sfs);
		}
	
}
}
