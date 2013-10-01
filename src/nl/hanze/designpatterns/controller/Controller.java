package nl.hanze.designpatterns.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

import nl.hanze.designpatterns.DAO.LoginCredentialDAO;
import nl.hanze.designpatterns.DAO.impl.db.LoginCredentialDAOImpl;
import nl.hanze.designpatterns.DAO.impl.db.TroubleTicketDAOImpl;
import nl.hanze.designpatterns.DAOFactory.DAOFactoryLogin;
import nl.hanze.designpatterns.domain.LoginCredential;
import nl.hanze.designpatterns.domain.TroubleTicket;
import nl.hanze.designpatterns.model.Model;
import nl.hanze.designpatterns.view.LoginView;
import nl.hanze.designpatterns.view.View;

public class Controller implements ActionListener{

    private Model model;
    private View view;
    private LoginView loginView;
    
    public Controller(Model model, View view){
        this.model = model;
        this.view = view;
        view.getLoginView().getLoginButton().addActionListener(this);
    }
    
    private void linkBtnAndLabel(){
    	//JOptionPane.showMessageDialog(null, "My Goodness, this is so concise");
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == view.getLoginView().getLoginButton()){
			try{
				String username = view.getLoginView().getUsername().getText();
				String password = view.getLoginView().getPassword().getText();
				
				DAOFactoryLogin daoFactoryLogin = (DAOFactoryLogin) view.getLoginView().getLoginMethodJComboBox().getSelectedItem();
				
				if(model.login(username, password, daoFactoryLogin)){
					view.getFormsWindow().setVisible(false);
					view.getMainWindow().setVisible(true);
				}
				else{
					JOptionPane.showMessageDialog(null, "Username/Password incorrect");	
				}
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
				
		}
		else{
			JOptionPane.showMessageDialog(null, "Unimplemented function");
		}
		
	}
}
