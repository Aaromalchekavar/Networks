import java.util.*;
import java.math.*;

class rsa{
    public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    int msg;
    System.out.println("Enter the message to be encrypted");
    msg = sc.nextInt();
    System.out.println("Enter two prime numbers");
    int p = sc.nextInt();
    int q = sc.nextInt();
    int n = p*q;
    int phi = (p-1)*(q-1);
    int e;
    for(e=2;e<phi;e++){
        if(gcd(e,phi)==1)break;
    }
    int d=0;
    for(int i=0;i<9;i++){
        int x = 1+i*phi;
        if(x%e==0){
            d=x/e;
            break;
        }
    }
    double c = (Math.pow(msg,e))%n;
    double msgback = (Math.pow(c,d))%n;
    System.out.println(phi);
    System.out.println(e);
    System.out.println(d);
    System.out.println(c);
    System.out.println(msgback);
    }

    static int gcd(int e,int z){
        if(e==0)return z;
        else{return gcd(z%e,e);}
    }
}