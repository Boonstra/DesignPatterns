package nl.hanze.designpatterns.DAO.impl.file.crypted;

import java.io.FileReader;
import java.io.IOException;

import nl.hanze.designpatterns.DAO.LoginCredentialDAO;
import nl.hanze.designpatterns.domain.LoginCredential;
import nl.hanze.designpatterns.io.CryptedInputStream;
import nl.hanze.designpatterns.io.CryptedOutputStream;

public class LoginCredentialDAOImplFileCrypted implements LoginCredentialDAO
{
	@Override
	public boolean isValid(LoginCredential logincredential)
	{
		try
		{
			CryptedInputStream cryptedInputStream = new CryptedInputStream(new FileReader("crypted_" + logincredential.getUserName() + ".txt"));
			
			int    character;
			String cryptedPassword = "";
			
			while ((character = cryptedInputStream.read()) >= 0)
			{
				cryptedPassword += (char) character;
			}
			
			cryptedInputStream.close();
			
			if (cryptedPassword.equals(CryptedOutputStream.encrypt(logincredential.getPassword())))
			{
				return true;
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return false;
	}
}
