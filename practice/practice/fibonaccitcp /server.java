import java.io.*;
import java.net.*;

class server{
    // static int fib(int n)
    // {
    //     if (n <= 1)
    //         return n;
    //     return fib(n - 1) + fib(n - 2);
    // }
    static String fib(int n){
        int n1=0,n2=1,n3,i,count=n;    
        String series = "";
        series = series + n1;
        series = series + n2; 
    
 for(i=2;i<count;++i)//loop starts from 2 because 0 and 1 are already printed    
 {n3=n1+n2;    
  series = series + n3;   
  n1=n2;    
  n2=n3;    
 }    
 return series;
    }
    public static void main(String args[])throws Exception{
        ServerSocket ss = new ServerSocket(5555);
        Socket s = ss.accept();
        System.out.println("Connection Established");
        PrintStream ps = new PrintStream(s.getOutputStream());
	BufferedReader bis = new BufferedReader(new InputStreamReader(s.getInputStream()));
	BufferedReader bk = new BufferedReader(new InputStreamReader(System.in));
        ps.println("Enter the number ;");
        int num = Integer.parseInt(bis.readLine());
        ps.println("Fibonacci series is : " +fib(num));
    }
}