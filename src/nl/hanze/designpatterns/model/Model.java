package nl.hanze.designpatterns.model;

import nl.hanze.designpatterns.DAO.impl.db.LoginCredentialDAOImpl;
import nl.hanze.designpatterns.DAO.impl.db.TroubleTicketDAOImpl;
import nl.hanze.designpatterns.DAO.impl.file.crypted.LoginCredentialDAOImplFileCrypted;
import nl.hanze.designpatterns.DAOFactory.DAOFactoryLogin;
import nl.hanze.designpatterns.domain.LoginCredential;

public class Model
{    
    private LoginCredentialDAOImpl login;
    private TroubleTicketDAOImpl tt;
    
    public boolean login(String username, String password, DAOFactoryLogin daoFactoryLogin)
    {
    	if (daoFactoryLogin.isValid(new LoginCredential(username, password)))
    	{
    		return true;
    	}
    	
    	return true;
    	
//		LoginCredential l = new LoginCredential(username, password);
//		//LoginCredentialDAOImpl lo = new LoginCredentialDAOImpl();
//		LoginCredentialDAOImplFileCrypted lo = new LoginCredentialDAOImplFileCrypted();
//		if(lo.isValid(l)){
//			return true;
//		}
//		else{
//			return false;
//		}
    }
}