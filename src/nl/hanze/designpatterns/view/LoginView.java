package nl.hanze.designpatterns.view;
import java.awt.*;
import java.util.Vector;

import javax.swing.*;

import nl.hanze.designpatterns.DAOFactory.DAOFactoryLogin;
import nl.hanze.designpatterns.DAOFactory.impl.DAOFactoryLoginDBImpl;
import nl.hanze.designpatterns.DAOFactory.impl.DAOFactoryLoginFileImpl;

public class LoginView extends JPanel{
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JButton loginButton;
	private JComboBox<DAOFactoryLogin> loginMethodJComboBox;
	
	public LoginView(){
	      this.usernameField = new JTextField(10);
	      this.passwordField = new JPasswordField(10);
	      
	      DAOFactoryLogin[] daoFactoryLoginInstances = {new DAOFactoryLoginDBImpl(), new DAOFactoryLoginFileImpl()};
	      loginMethodJComboBox = new JComboBox<DAOFactoryLogin>(daoFactoryLoginInstances);

	      this.setLayout(new GridLayout(0,2,0,0));
	      this.add(new JLabel("Username:"));
	      this.add(usernameField);
	      this.add(new JLabel("Password:"));
	      this.add(passwordField);
	      this.add(new JLabel("Login method:"));
	      this.add(loginMethodJComboBox);
	      
	      JSeparator separator = new JSeparator();
	      add(separator);
	      loginButton = new JButton("Login");
	      this.add(loginButton);
   }
	
	/**
	 * Get login button for ActionListeners
	 * @return
	 */
	public JButton getLoginButton(){
		return loginButton;
	}
	
	/**
	 * Getter
	 * @return
	 */
	public JTextField getUsername(){
		return usernameField;
	}
	
	public JPasswordField getPassword(){
		return passwordField;
	}
	
	public JComboBox<DAOFactoryLogin> getLoginMethodJComboBox()
	{
		return loginMethodJComboBox;
	}
}