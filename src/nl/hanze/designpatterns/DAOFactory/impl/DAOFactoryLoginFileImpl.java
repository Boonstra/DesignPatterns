package nl.hanze.designpatterns.DAOFactory.impl;

import nl.hanze.designpatterns.DAO.impl.file.crypted.LoginCredentialDAOImplFileCrypted;
import nl.hanze.designpatterns.DAOFactory.DAOFactoryLogin;
import nl.hanze.designpatterns.domain.LoginCredential;

public class DAOFactoryLoginFileImpl extends DAOFactoryLogin
{
	@Override
	public boolean isValid(LoginCredential loginCredential)
	{
		return new LoginCredentialDAOImplFileCrypted().isValid(loginCredential);
	}
	
	@Override
	public String toString()
	{
		return "File";
	}
}
