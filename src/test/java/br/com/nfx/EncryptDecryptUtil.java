package br.com.nfx;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class EncryptDecryptUtil
{
  private static final String ALGORITMO = "AES";
  private static final char[] SENHA = "dB7EEP&/D$:@*b4D)`sBgAs:rZW8?`DeU;nNni)g@yaEB?z(;$ YqlW-+!=Z) ZntqGM}zr-v:-I!L$1?Jd~&g);ih%cL/XTf1Hv#AaYh4b QU{+*8Bv|n%[:[?{{0$<eR}{sZ9,PPK&=x@N,[mY1-BKLoCE+RJD~%OvyeL(~mCb{0sk4bC{={U9Eamub8y?%sF{+X'<".toCharArray();

  private static final byte[] SALT = { 56, 80, 88, 43, 32, 74, -32, -55, 22, -48, 90, 99, -80, -64, -46, 25, 3, 59, 70, 67, 9, -123, 6, 38, 16, 115, 84, 93, -95, 93, 64, 36 };

  
  
  private static Key getKey()
  {
    try
    {
      SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
      KeySpec spec = new PBEKeySpec(SENHA, SALT, 1024, 128);
      SecretKey tmp = factory.generateSecret(spec);
      SecretKey secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");
      return secretKey;
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException("Bug: ", e); } catch (InvalidKeySpecException e) {
    }
	return null;
    
  }

  public static String encrypt(String message)
  {
	  
	  byte[] encrypted = null;
    try {
      Cipher cipher = getCipherInstance("AES");
      cipher.init(1, getKey());

      encrypted = cipher.doFinal(message.getBytes());
      return new Base64().encodeToString(encrypted); } catch (Exception e) {
    }
    return new Base64().encodeToString(encrypted); 
  }

  public static String encryptBase64(String message) 
  {
	  byte[] encrypted = null;
    try {
      encrypted = message.getBytes();
      return new Base64().encodeToString(encrypted); } catch (Exception e) {
    }
	return new Base64().encodeToString(encrypted);
    
  }

  public static String decrypt(String decrypt) 
  {
    try {
      Cipher cipher = getCipherInstance("AES");
      cipher.init(2, getKey());

      byte[] original = cipher.doFinal(new Base64().decode(decrypt));

      String originalString = new String(original);

      return originalString; } catch (Exception e) {
    }
	return decrypt;
   
  }

  public static String decryptBase64(String decrypt)
  {
    try {
      byte[] original = new Base64().decode(decrypt);

      String originalString = new String(original);

      return originalString; } catch (Exception e) {
    }
	return decrypt;
   
  }

  private static Cipher getCipherInstance(String algoritmo) 
  {
	  try {
		return Cipher.getInstance(algoritmo);
	} catch (NoSuchAlgorithmException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (NoSuchPaddingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
    
  }
}
