package nl.hanze.designpatterns.DAO.impl.db;

import java.util.List;

import nl.hanze.designpatterns.DAO.TroubleTicketDAO;
import nl.hanze.designpatterns.domain.TroubleTicket;

public class TroubleTicketDAOImpl implements TroubleTicketDAO
{
	@Override
	public List<TroubleTicket> getTroubleTicketsByName(String callerName)
	{
		return null;
	}

	@Override
	public void saveTroubleTicket(TroubleTicket troubleticket)
	{
		
	}
}
