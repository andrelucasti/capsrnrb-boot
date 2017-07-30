package br.com.api.capsrnrb.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Component;

@Component
public class LibraryFunctions {
	
	
	public String convertStringToSHA256(String pValue) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		
		MessageDigest msd = MessageDigest.getInstance("SHA-256");
		byte[] msdByte = msd.digest(pValue.getBytes("UTF-8"));
		
		StringBuilder sb = new StringBuilder();
		
		for (byte b : msdByte) {
			sb.append(String.format("%02X", 0xFF & b));
		}
		
		
		return sb.toString().toLowerCase();
		
	}

}
