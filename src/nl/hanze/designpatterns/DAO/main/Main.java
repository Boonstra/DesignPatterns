package nl.hanze.designpatterns.DAO.main;

import java.util.ArrayList;
import java.util.Iterator;

import nl.hanze.designpatterns.DAO.impl.db.TroubleTicketDAOImpl;
import nl.hanze.designpatterns.db.Executor;
import nl.hanze.designpatterns.db.Executor.ExecutorException;
import nl.hanze.designpatterns.domain.TroubleTicket;

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
			e.printStackTrace();
		}
	}
}
