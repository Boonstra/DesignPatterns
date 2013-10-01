package nl.hanze.designpatterns.io;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

public class CryptedOutputStream extends BufferedWriter
{
	public CryptedOutputStream(Writer writer)
	{
		super(writer);
	}
	
	@Override
	public void write(String string) throws IOException
	{
		super.write(encrypt(string));
	}
	
	/**
	 * Encrypts the passed string with the SHA-256 encrypting algorithm.
	 * 
	 * @param string
	 * @return
	 */
	public static String encrypt(String string)
	{
		MessageDigest messageDigest;
		
		try
		{
			messageDigest = MessageDigest.getInstance("SHA-256");
			//messageDigest = MessageDigest.getInstance("MD5");
			
			messageDigest.update(string.getBytes("UTF-8"));
			
			byte[] digest = messageDigest.digest();
			
			return DatatypeConverter.printHexBinary(digest);
		}
		catch (UnsupportedEncodingException | NoSuchAlgorithmException e)
		{
			e.printStackTrace();
		}

		return null;
	}
}
