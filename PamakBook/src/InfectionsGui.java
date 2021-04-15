import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class InfectionsGui extends JFrame {
	
	//These parameters are the properties of class InfectionsGui.
	private JPanel panel;
	private JButton button_back; 
	private JTextArea text_area;  
	private JScrollPane scroll_pane;
	private User userc;
	
	//This method is the constructor of class InfectionsGui with parameter. 
	public InfectionsGui( User user)
	{
		userc = user;
		panel = new JPanel();
		button_back = new JButton("Back to login Screen");
		text_area = new JTextArea(10,20);
	    text_area.setText( "***************************** \n " + userc.getName() + " has been infected.The following users have to been tested \n ******************************");
	    text_area.append("\n");
	    ArrayList<User> pvt = userc.possibleVirusTransmission(userc);
	    for(int i=0; i<pvt.size(); i ++)
		{
			text_area.append(pvt.get(i).getName() + "\n");
		}
	    scroll_pane = new JScrollPane(text_area);
	    text_area.setEditable(false);
	    panel.add(text_area);
	    panel.add(button_back);
	    
	    //This code is executed when button_back is pressed.
	    button_back.addActionListener( new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				
				InfectionsGui.this.dispose();
			}
	    });
		
		setContentPane(panel);
		
		setSize(500 ,600);
	    setVisible(true);
	    setTitle("Πιθανή Μετάδωση Ιού");
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}