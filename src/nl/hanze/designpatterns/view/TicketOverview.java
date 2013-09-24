package nl.hanze.designpatterns.view;

import java.awt.Component;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JSeparator;

import nl.hanze.designpatterns.DAO.impl.db.TroubleTicketDAOImpl;
import nl.hanze.designpatterns.domain.TroubleTicket;

public class TicketOverview extends JPanel {
	private JList list;
	public TicketOverview(){
		this.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblSearch = new JLabel("Search");
		add(lblSearch);
		
		JComboBox comboBox = new JComboBox();
		add(comboBox);
		
		JLabel lblTickets = new JLabel("Tickets");
		add(lblTickets);
		
		
		ArrayList<TroubleTicket> troubleTickets = (ArrayList<TroubleTicket>) new TroubleTicketDAOImpl().getTroubleTickets();
		ArrayList<String> troubleTicketsTitles = new ArrayList();
		   Iterator<TroubleTicket> troubleTicketsIterator = troubleTickets.iterator();
		   
		   while (troubleTicketsIterator.hasNext())
		   {
			   troubleTicketsTitles.add(troubleTicketsIterator.next().getDescription());
		   }
	   	list = new JList(troubleTicketsTitles.toArray());   
		add(list);
		
		JSeparator separator = new JSeparator();
		add(separator);
		
		JButton btnNewButton = new JButton("Open ticket");
		add(btnNewButton);
	}
}
