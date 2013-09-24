package nl.hanze.designpatterns.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class View {
    private JFrame mainWindow, forms;
    private LoginView login;
    private JLabel label;
    private JButton button;

    
    public View(String text){
        mainWindow = new JFrame("Helpdesk");                             
        forms = new JFrame("Login");
        forms.getContentPane().setLayout(new BorderLayout());
        mainWindow.getContentPane().setLayout(new BorderLayout());                                          
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);           
        mainWindow.setSize(800,600);        
        mainWindow.setVisible(false);
        forms.setSize(400,150);
        forms.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        TicketOverview r = new TicketOverview();
        mainWindow.getContentPane().add(r, BorderLayout.CENTER);
        
      //Where the GUI is created:
        JMenuBar menuBar;
        JMenu menu, submenu;
        JMenuItem menuItem;
        JRadioButtonMenuItem rbMenuItem;
        JCheckBoxMenuItem cbMenuItem;

        //Create the menu bar.
        menuBar = new JMenuBar();

        //Build the first menu.
        menu = new JMenu("File");
        menuBar.add(menu);

        //a group of JMenuItems
        menuItem = new JMenuItem("New Ticket", KeyEvent.VK_T);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_1, ActionEvent.ALT_MASK));
        menu.add(menuItem);
        
        mainWindow.setJMenuBar(menuBar);
        
        // Tabs
        JTabbedPane tabbedPane = new JTabbedPane();
        ImageIcon icon = createImageIcon("images/middle.gif");

        JComponent panel5 = makeTextPanel("Open tickets");
        tabbedPane.addTab("Open tickets", icon, panel5,
                          "Show unhandled trouble tickets");
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

        JComponent panel6 = makeTextPanel("Solutions");
        tabbedPane.addTab("Solutions", icon, panel6,
                          "Show previous solutions to problems");
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
        
        mainWindow.add(tabbedPane);
        
        login = new LoginView();
        forms.getContentPane().add(login, BorderLayout.CENTER);
        forms.setVisible(true);
    }
    
    protected JComponent makeTextPanel(String text) {
    	JPanel panel;
    	if(text.equals("Open tickets")){
    		panel = new TicketOverview();
    	}
    	else if(text.equals("Solutions")){
    		//panel = new QAThesaurusView();
    		panel = new JPanel(false);
            JLabel filler = new JLabel(text);
            filler.setHorizontalAlignment(JLabel.CENTER);
            panel.setLayout(new GridLayout(1, 1));
            panel.add(filler);
    	}
    	else{
    		panel = new JPanel(false);
            JLabel filler = new JLabel(text);
            filler.setHorizontalAlignment(JLabel.CENTER);
            panel.setLayout(new GridLayout(1, 1));
            panel.add(filler);
    	}
        return panel;
    }
     
    /** Returns an ImageIcon, or null if the path was invalid. */
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = View.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
    
    /**
     *     
     * @return
     */
    public JButton getButton(){
        return button;
    }
    
    /**
     * 
     * @param text
     */
    public void setText(String text){
        label.setText(text);
    }
    
    /**
     * Get main window frame
     * @return
     */
    public JFrame getMainWindow(){
    	return mainWindow;
    }
    
    /**
     * 
     * @return
     */
    public JFrame getFormsWindow(){
    	return forms;
    }
    
    public LoginView getLoginView(){
    	return login;
    }
}
