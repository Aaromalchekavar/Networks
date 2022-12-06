import java.io.*;
import java.net.*;
class server{
public static void main(String args[]) throws IOException 
{
	ServerSocket ss = new ServerSocket(3504);
	Socket s = ss.accept();
	PrintStream ps = new PrintStream(s.getOutputStream());
	BufferedReader bis = new BufferedReader(new InputStreamReader(s.getInputStream()));
	BufferedReader bk = new BufferedReader(new InputStreamReader(System.in));
	while(true){
		String sfc,stc;
		while((sfc=bis.readLine())!=null){
			System.out.println(sfc);
			stc = bk.readLine();
			ps.println(stc);
		}
	}
}
}
