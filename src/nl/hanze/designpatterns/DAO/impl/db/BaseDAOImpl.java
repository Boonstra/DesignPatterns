package nl.hanze.designpatterns.DAO.impl.db;

import nl.hanze.designpatterns.db.Executor;
import nl.hanze.designpatterns.db.Executor.ExecutorException;

public class BaseDAOImpl
{
	protected Executor executor;
	
	protected BaseDAOImpl()
	{
		try
		{
			executor = Executor.getInstance();
		}
		catch (ExecutorException e)
		{
			e.printStackTrace();
		}
	}
}
