package nl.hanze.designpatterns.DAO.impl.db;

import java.util.Iterator;

import nl.hanze.designpatterns.DAO.LoginCredentialDAO;
import nl.hanze.designpatterns.db.Executor.ExecutorException;
import nl.hanze.designpatterns.domain.LoginCredential;

public class LoginCredentialDAOImpl extends BaseDAOImpl implements LoginCredentialDAO
{
	@Override
	public boolean isValid(LoginCredential loginCredential)
	{
		String userName = loginCredential.getUserName();
		String password = loginCredential.getPassword();
		
		if (executor == null ||
			userName == null ||
			password == null ||
			userName.length() <= 0 ||
			password.length() <= 0)
		{
			return false;
		}
		
		try
		{
			// Get the user with the given userName/password combination from the database
			Iterator<LoginCredential> iterator = executor.getIterator("SELECT * FROM users WHERE userName='" + userName + "' AND password='" + password + "'", LoginCredential.class);
			
			// Only one result is needed
			if (iterator.hasNext())
			{
				LoginCredential returnedLoginCredential = iterator.next();
				
				// Check if returned results match input login credentials
				if (returnedLoginCredential.getUserName() != null &&
					returnedLoginCredential.getPassword() != null &&
					returnedLoginCredential.getUserName().equals(userName) &&
					returnedLoginCredential.getPassword().equals(password))
				{
					return true;
				}
			}
		}
		catch (ExecutorException e)
		{
			e.printStackTrace();
		}
		
		return false;
	}
}
