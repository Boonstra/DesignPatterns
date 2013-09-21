package nl.hanze.designpatterns.DAO.main;

import nl.hanze.designpatterns.DAO.impl.db.LoginCredentialDAOImpl;
import nl.hanze.designpatterns.db.Executor;
import nl.hanze.designpatterns.db.Executor.ExecutorException;
import nl.hanze.designpatterns.domain.LoginCredential;

public class Main
{
	public static void main(String[] args)
	{
		try
		{
			Executor executor = Executor.getInstance();
			
			executor.setUrl("jdbc:mysql://localhost:3306/designpatterns");
			executor.setUser("root");
			executor.setPassword("");
			
			new LoginCredentialDAOImpl().isValid(new LoginCredential("admin", "admin"));
		}
		catch (ExecutorException e)
		{
			e.printStackTrace();
		}
	}
}
