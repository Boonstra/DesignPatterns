package nl.hanze.designpatterns.view;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class TicketDetailedView {
	   public static void main(String[] args) {
		      JTextField usernameField = new JTextField(10);
		      JPasswordField passwordField = new JPasswordField(10);

		      JPanel myPanel = new JPanel(new GridLayout(2,2));
		      myPanel.add(new JLabel("Username:"));
		      myPanel.add(usernameField);
		      myPanel.add(new JLabel("Password:"));
		      myPanel.add(passwordField);
		      
		     int result = JOptionPane.showConfirmDialog(null, myPanel, 
		              "Login", JOptionPane.OK_CANCEL_OPTION);
		     if (result == JOptionPane.OK_OPTION) {
		         System.out.println("Username: " + usernameField.getText());
		         System.out.println("Password: " + passwordField.getText());
		      }

		   }
}
