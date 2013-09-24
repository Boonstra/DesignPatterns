package nl.hanze.designpatterns.view;
import java.awt.*;

import javax.swing.*;

public class LoginView extends JPanel {
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JButton loginButton;
	
	public LoginView(){
	      this.usernameField = new JTextField(10);
	      this.passwordField = new JPasswordField(10);

	      this.setLayout(new GridLayout(0,2,0,0));
	      this.add(new JLabel("Username:"));
	      this.add(usernameField);
	      this.add(new JLabel("Password:"));
	      this.add(passwordField);
	      
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
}