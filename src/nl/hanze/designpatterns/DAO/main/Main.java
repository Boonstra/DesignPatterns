package nl.hanze.designpatterns.DAO.main;

import nl.hanze.designpatterns.db.Executor;
import nl.hanze.designpatterns.db.Executor.ExecutorException;

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
		}
		catch (ExecutorException e)
		{
			System.err.println(e.getMessage());
		}
	}
}
