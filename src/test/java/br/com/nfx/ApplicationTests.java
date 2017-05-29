package br.com.nfx;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	
	public static void main(String[] args){
		 String senha = EncryptDecryptUtil.decrypt("SfDzqXrqfNb5/bBjM1Q98w==");
		 
		 System.out.println("SENHA:  " + senha);
	}
	
	@Test
	public void contextLoads() {
		
		String password = "nfx";
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(password);
		
		System.out.println("============================================================");
		System.out.println("Senha crypt: " + hashedPassword);
		System.out.println("============================================================");
		
	}
	
}
