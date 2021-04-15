import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

import javax.swing.*;

public class MainGui extends JFrame {
	
	//These parameters are the properties of class MainGui.
	private JPanel panel = new JPanel();
	private JButton button_user = new JButton("Enter User Page");
	private JButton button_infections = new JButton("Show Potentional Infections");
	private JButton button_new_user = new JButton("New User");
	private JButton button_PamakBook = new JButton("Save PamakBook");
	private JTextField textfield = new JTextField("Please enter your name");
	private JTextField textfield_name = new JTextField("user name");
	private JTextField textfield_email = new JTextField("user email");
	private ArrayList<User> Users;
	private ArrayList<Group> Groupsall;
	
	//This method is the constructor of the class MainGui with parameters. 
	public MainGui(ArrayList<User> u, ArrayList<Group> g ) {
		
		Users = u;
		Groupsall = g;
		panel.add(button_new_user);
		panel.add(textfield_name);
		panel.add(textfield_email);
		panel.add(textfield);
		panel.add(button_user);
	    panel.add(button_infections);
	    panel.add(button_PamakBook);
	   
	     setContentPane(panel);
	     
	 	//This code opens the file PamakBook for writing.
	    try {
	    	 File file = new File("PamakBook.ser");
			 FileInputStream fo = new FileInputStream(file);
	    	 
			
		} catch (FileNotFoundException i) {
			
			i.printStackTrace();
		} catch (IOException i) {
			
			i.printStackTrace();
		}
	    
	    
	    //This code reads the file PamakBook.
	    try {
    	    File file = new File("PamakBook.ser");
			FileInputStream fop = new FileInputStream(file);
			ObjectInputStream op = new ObjectInputStream(fop);
		    Users = (ArrayList<User>)op.readObject();
		    Groupsall = (ArrayList<Group>)op.readObject();
			op.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
			
	    //This code is executed when button_user is pressed.
	      button_user.addActionListener( new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				
				boolean find_user = false;
				for(int i=0; i<Users.size(); i++)
				{
				   if(textfield.getText().equals(Users.get(i).getName()))
					{
						find_user = true;
						new UserGui( Users.get(i), Users, Groupsall );
						break;
					}
				}
				if(!find_user)
				{
				    JOptionPane.showMessageDialog(null, "User " + textfield.getText() + " Not found");
				}
			}
	      });
	     
	      //This code is executed when button_infections is pressed.
	      button_infections.addActionListener( new ActionListener() {

				public void actionPerformed(ActionEvent arg0) {
					
					boolean find_user = false;
					for(int i=0; i<Users.size(); i++)
					{
					   if(textfield.getText().equals(Users.get(i).getName()))
						{
							find_user = true;
							new InfectionsGui( Users.get(i));
							break;
						}
					}
					if(!find_user)
					{
					    JOptionPane.showMessageDialog(null, "User " + textfield.getText() + " Not found");
					}
					
				}
		   });
	      
	      //This code is executed when button_new_user is pressed.
	      button_new_user.addActionListener( new ActionListener() {

				public void actionPerformed(ActionEvent arg0) {
					
					
					boolean find_user = false;
					for(int i=0; i<Users.size(); i++)
					{
					   if(textfield_name.getText().equals(Users.get(i).getName()))
						{
							find_user = true;
							break;
						}
					}
					if(!find_user)
					{
					    new User(textfield_name.getText(), textfield_email.getText(), Users);
					   
					}
					else
					{
						JOptionPane.showMessageDialog(null, "User " + textfield_name.getText() + " had founded and cant create again");
					}
				}
		      });
	      
	      //This code is executed when button_PamakBook is pressed. 
	      button_PamakBook.addActionListener( new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				
				try {
					File file = new File("PamakBook.ser");
					FileOutputStream fo = new FileOutputStream(file);
					ObjectOutputStream op = new ObjectOutputStream(fo);
				    op.writeObject(Users);
				    op.writeObject(Groupsall);
				    fo.close();
			        op.close();
					} catch (IOException e) {
					e.printStackTrace();
				}
			}
	     });
	          
	    setSize(300 ,500);
	    setVisible(true);
	    setTitle("Είσοδος Χήστη");
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	}
}