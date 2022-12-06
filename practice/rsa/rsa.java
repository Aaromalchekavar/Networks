import java.math.*;
import java.util.*;

class rsa{
public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    int p,q,n,phi,d=0,e;
    System.out.println("Enter the no to be Encrypted");
    int msg = sc.nextInt();
    BigInteger msgback;
    System.out.println("Enter two prime no");
    p = sc.nextInt();
    q = sc.nextInt();
    n = p*q;
    phi=(p-1)*(q-1);
    System.out.println("the value of phi = " + phi);
    for(e=2;e<phi;e++){
        if(gcd(e,phi)==1){break;}
    }
    System.out.println("the value of e = " + e);
    for(int i=0;i<9;i++){
        int x = 1+(i*phi);
        if(x%e==0){
            d=x/e;
            break;
        }
    }
    System.out.println("the value of d = " + d);
    double c = (Math.pow(msg,e)) % n;
    System.out.println("Encrypted message is : " + c);

    double mback = Math.pow(c,d) % n;
    System.out.println("Decrypted message is : " + mback);
}

  static int gcd(int e, int z) {
    if (e == 0) return z; else return gcd(z % e, e);
  }
}