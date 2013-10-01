package nl.hanze.designpatterns.DAOFactory.impl;

import nl.hanze.designpatterns.DAO.impl.db.LoginCredentialDAOImpl;
import nl.hanze.designpatterns.DAOFactory.DAOFactoryLogin;
import nl.hanze.designpatterns.domain.LoginCredential;

public class DAOFactoryLoginDBImpl extends DAOFactoryLogin
{
	@Override
	public boolean isValid(LoginCredential loginCredential)
	{
		return new LoginCredentialDAOImpl().isValid(loginCredential);
	}
	
	@Override
	public String toString()
	{
		return "Database";
	}
}
