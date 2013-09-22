package nl.hanze.designpatterns.DAO.impl.db;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import nl.hanze.designpatterns.DAO.TroubleTicketDAO;
import nl.hanze.designpatterns.db.Executor.ExecutorException;
import nl.hanze.designpatterns.domain.TroubleTicket;

public class TroubleTicketDAOImpl extends BaseDAOImpl implements TroubleTicketDAO
{
	@Override
	public List<TroubleTicket> getTroubleTicketsByName(String callerName)
	{
		try
		{
			// Select all trouble tickets with the passed caller name
			Iterator<TroubleTicket> troubleTicketsIterator = executor.getIterator("SELECT * FROM troubletickets  WHERE callerName = '" + callerName + "'", TroubleTicket.class);
			
			List<TroubleTicket> troubleTicketsList = new ArrayList<TroubleTicket>();
			
			// Iterate over trouble tickets and place them in a list
			while (troubleTicketsIterator.hasNext())
			{
				troubleTicketsList.add(troubleTicketsIterator.next());
			}
			
			return troubleTicketsList;
		}
		catch (ExecutorException e)
		{
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void saveTroubleTicket(TroubleTicket troubleticket)
	{
		int ID = troubleticket.getID();
		
		String userName    = troubleticket.getUserName();
		String callerName  = troubleticket.getCallerName();
		String description = troubleticket.getDescription();
		String dateTime    = troubleticket.getDateTime();
		
		if (userName == null)
		{
			userName = "";
		}
		
		if (callerName == null)
		{
			callerName = "";
		}
		
		if (description == null)
		{
			description = "";
		}
		
		if (dateTime == null)
		{
			dateTime = "";
		}
		
		try
		{
			// Execute insert or update query
			executor.executeQuery(
				"INSERT INTO troubletickets (ID, userName, callerName, description, dateTime)" +
					"VALUES (" + ID + ", '" + userName + "', '" + callerName + "', '" + description + "', '" + dateTime + "')" +
				"ON DUPLICATE KEY UPDATE" +
					" userName    = '" + userName    + "'," +
					" callerName  = '" + callerName  + "'," +
					" description = '" + description + "'," +
					" dateTime    = '" + dateTime    + "'");
		}
		catch (ExecutorException e)
		{
			e.printStackTrace();
		}
		
		System.out.println(
			"INSERT INTO troubletickets (ID, userName, callerName, description, dateTime)" +
				"VALUES (" + ID + ", '" + userName + "', '" + callerName + "', '" + description + "', '" + dateTime + "')" +
			"ON DUPLICATE KEY UPDATE" +
				" userName    = '" + userName    + "' AND" +
				" callerName  = '" + callerName  + "' AND" +
				" description = '" + description + "' AND" +
				" dateTime    = '" + dateTime    + "'");
	}
}
