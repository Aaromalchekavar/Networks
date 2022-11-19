import java.io.*;
import java.util.*;
import java.security.*;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AES {

  private static SecretKeySpec secretKey;
  private static byte[] key;

  public static void setKey(String myKey) {
    MessageDigest sha = null;
    try {
      key = myKey.getBytes("UTF-8");//Key bye aaki
      sha = MessageDigest.getInstance("SHA-1");//sha messagedigest il ninne eduth
      key = sha.digest(key);//key sha vech hash cheyth
      key = Arrays.copyOf(key, 16);//16 bit key akki
      secretKey = new SecretKeySpec(key, "AES");//Secrect key ondakki
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
  }

  public static String encrypt(String strToEncrypt, String secret) {
    try {
      setKey(secret);//setkey nne paranja odakkiya function vech key ondakki
      Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");//cipher text ondakkan olla first step - Cipher instance eduth
      cipher.init(Cipher.ENCRYPT_MODE, secretKey);//cipher initialize cheyyunnu (encrypt mode set akki)
      return Base64
        .getEncoder()
        .encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));//Encrypt cheyyun
    } catch (Exception e) {
      System.out.println("Error while encrypting: " + e.toString());
    }
    return null;
  }

  public static String decrypt(String strToDecrypt, String secret) {
    try {
      setKey(secret);//setkey nne paranja odakkiya function vech key ondakki
      Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");//cipher text ondakkan olla first step - Cipher instance eduth
      cipher.init(Cipher.DECRYPT_MODE, secretKey);//cipher initialize cheyyunnu (decrypt mode set akki)
      return new String(
        cipher.doFinal(Base64.getDecoder().decode(strToDecrypt))//Decrypt cheyyun
      );
    } catch (Exception e) {
      System.out.println("Error while decrypting: " + e.toString());
    }
    return null;
  }

  public static void main(String[] args) {
    final String secretKey = "wwwwww@";
    String originalString = "Hello Everyone!!";
    String encryptedString = AES.encrypt(originalString, secretKey);
    String decryptedString = AES.decrypt(encryptedString, secretKey);

    System.out.println(originalString);
    System.out.println(encryptedString);
    System.out.println(decryptedString);
  }
}
