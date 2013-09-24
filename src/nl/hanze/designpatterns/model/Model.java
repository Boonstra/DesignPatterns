package nl.hanze.designpatterns.model;

import nl.hanze.designpatterns.DAO.impl.db.LoginCredentialDAOImpl;
import nl.hanze.designpatterns.DAO.impl.db.TroubleTicketDAOImpl;
import nl.hanze.designpatterns.domain.LoginCredential;

public class Model {
    
    private LoginCredentialDAOImpl login;
    private TroubleTicketDAOImpl tt;
    
    public Model(){
       
    }
    
    public boolean login(String username, String password){
		LoginCredential l = new LoginCredential(username, password);
		LoginCredentialDAOImpl lo = new LoginCredentialDAOImpl();
		if(lo.isValid(l)){
			return true;
		}
		else{
			return false;
		}
    }
}