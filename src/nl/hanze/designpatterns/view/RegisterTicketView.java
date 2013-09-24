package nl.hanze.designpatterns.view;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class RegisterTicketView extends JPanel {
	private static JTextField textField;
	private static JTextField textField_1;
	private static JTextField textField_2;
	
	public RegisterTicketView(){
	      JTextField usernameField = new JTextField(10);

	      JPanel myPanel = new JPanel();
	      this.setLayout(new GridLayout(8, 2, 0, 0));
	      this.add(new JLabel("Username user:"));
	      this.add(usernameField);
	      JLabel label = new JLabel("Username reporter");
	      this.add(label);
	      
	     //int result = JOptionPane.showConfirmDialog(null, myPanel, "Login", JOptionPane.OK_CANCEL_OPTION);
	     
	     textField = new JTextField();
	     this.add(textField);
	     textField.setColumns(10);
	     
	     JLabel lblNewLabel_0 = new JLabel("Ticket title:");
	     this.add(lblNewLabel_0);
	     
	     textField_1 = new JTextField();
	     this.add(textField_1);
	     textField_1.setColumns(10);
	     
	     JLabel lblNewLabel_1 = new JLabel("Ticket description");
	     this.add(lblNewLabel_1);
	     
	     textField_2 = new JTextField();
	     this.add(textField_2);
	     textField_2.setColumns(10);
	     
	     JLabel lblNewLabel_2 = new JLabel("Solution:");
	     this.add(lblNewLabel_2);
	     
	     JComboBox comboBox = new JComboBox();
	     this.add(comboBox);
	}
	
	   public static void main(String[] args) {

		     
		     /*if (result == JOptionPane.OK_OPTION) {
		         System.out.println("Username employee: " + usernameField.getText());
		         System.out.println("Username reporter: " + textField.getText());
		      }*/

		   }
}
