import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class UserGui extends JFrame  {
	
	//These parameters are the properties of class UserGui.
	private JPanel panelmain = new JPanel();
	private JPanel paneldata = new JPanel();
	private JPanel panelpost = new JPanel();
	private JPanel panelposts = new JPanel();
	private JPanel panelsf = new JPanel();
	private JPanel panelgroup = new JPanel();
	private JButton button_back = new JButton("Back to login Screen");
	private JButton button_post;
	private JButton button_add_Friend = new JButton("add Friend");
	private JButton button_add_Group = new JButton("add Group");
	private JTextArea textareaname;
	private JTextArea textareaemail;
	private JTextArea Postfield;
	private JTextArea postall;
	private JScrollPane scroll_pane;
	private Label label_post_friends;
	private Label label_suggested_friends;
	private JList listfield;
	private JList<String> listfieldgroup;
	private DefaultListModel model;
	private DefaultListModel<String> modelg;
	private User userc;
	private JTextField textfield_name = new JTextField("Friends name");
	private ArrayList<User> Users;
	private ArrayList<Group> Groupsall;

	
	//This method is the constructor of class UserGui with parameters.
	public UserGui( User user, ArrayList<User> users, ArrayList<Group> g)
	{
		Users = users;
		userc = user;
		Groupsall = g;
		textareaname = new JTextArea(userc.getName());
		textareaname.setEditable(false);
		textareaemail = new JTextArea(userc.getEmail());
		textareaemail.setEditable(false);
		button_post = new JButton("Post");
		Postfield = new JTextArea(10,20);
		Postfield.setEditable(true);
	    Postfield.setLineWrap(true);
	    Postfield.setWrapStyleWord(true);
		scroll_pane = new JScrollPane(Postfield);
		label_post_friends = new Label("Recent Post By Friends");
	    postall =new JTextArea(10,20);
	    postall.setEditable(false);
	    scroll_pane = new JScrollPane(postall);
	    postall.setLineWrap(true);
	    postall.setWrapStyleWord(true);
	    for(Post post : userc.PostAll())
	    {
	    	postall.append(post.getUser_post().getName() + " , " + post.getTime_post() + " , " + post.getText_post() + " \n ");
	    }
	    label_suggested_friends = new Label("Suggested Friends");
	    model = new DefaultListModel();
	    for(User u : userc.suggestedFriends())
	    {
	    	model.addElement(u.getName());
	    }
	    listfield = new JList(model);
        paneldata.add(textareaname);
        paneldata.add(textareaemail);
		paneldata.add(button_back);
		panelpost.setLayout(new FlowLayout(FlowLayout.CENTER,10,35));
		panelpost.add(Postfield);
		panelpost.add(button_post);
		panelposts.add(label_post_friends);
		panelposts.add(postall);
		panelsf.add(label_suggested_friends);
		panelsf.add(listfield);
		panelsf.add(textfield_name);
		panelsf.add(button_add_Friend);
		modelg = new DefaultListModel<String>();
		for(Group gr : Groupsall )
		{
		    modelg.addElement(gr.getName());
		}
		listfieldgroup = new JList<String>(modelg);
		panelgroup.add(listfieldgroup);
		panelgroup.add(button_add_Group);
		panelmain.add(paneldata);
		panelmain.add(panelpost);
		panelmain.add(panelposts);
		panelmain.add(panelsf);
		panelmain.add(panelgroup);
		
		setContentPane(panelmain);
		 
		//This code is executing when button_back has been pressed.
		 button_back.addActionListener( new ActionListener() {

				public void actionPerformed(ActionEvent arg0) {
					
					UserGui.this.dispose();
				}
		});
		 
		 //This code is executed when button_post is pressed and prints the sorted posts on the screen.
		 button_post.addActionListener( new ActionListener() {

	           public void actionPerformed(ActionEvent arg0) {
					
	        	  if(!Postfield.getText().equals(""))
				   {
	                   new Post(Postfield.getText(), userc);
					   Postfield.setText("");  
					   postall.setText("");
				       for(Post post : userc.PostAll())
				       {
				    	 postall.append(post.getUser_post().getName() + " , " + post.getTime_post() + " , " + post.getText_post() + " \n ");
				       }
				   }
			 }
		 });
		 
		 //This code is executed when button_add_Friend is pressed.
		 button_add_Friend.addActionListener( new ActionListener() {

				public void actionPerformed(ActionEvent arg0) {
					
			        boolean find_user = false;
					User useradd = null;
					for(int i=0; i<Users.size(); i++)
					{
					   if(textfield_name.getText().equals(Users.get(i).getName()))
						{
							find_user = true;
							useradd = Users.get(i);
							user.addFriend(useradd);
							break;
						}
					}
					if(!find_user)
					{
					    JOptionPane.showMessageDialog(null, "User " + textfield_name.getText() + " Not found");
					}
					else if(user.friendUser(useradd))
					{
						JOptionPane.showMessageDialog(null, "User " + textfield_name.getText() + " is friend with User " + user.getName() + " by before");
					}
				}
		});
		 
		 button_add_Group.addActionListener( new ActionListener() {

				public void actionPerformed(ActionEvent arg0) {
					if(listfieldgroup.getSelectedValue()!= null)
					{
						for(int i=0; i<Groupsall.size(); i++)
				       {
				    	   if(listfieldgroup.getSelectedValue().equals(Groupsall.get(i).getName()))
				    	   {
				    		   if(Groupsall.get(i).memberUser(userc))
				    		   {
				    			   JOptionPane.showMessageDialog(null, "User " + user.getName()+ " had been enrolled in the group " + listfieldgroup.getSelectedValue() + " by before");
				    		   }
				    		   else if(!Groupsall.get(i).addmember(userc))
				    		   {
				    			   JOptionPane.showMessageDialog(null, "User " + user.getName() + " can not been  enrolled yet");
				    		   }
				    		   else
				    		   {
				    			    Groupsall.get(i).addmember(userc);
				    		   }
				    		   break;
				    	   }
				       }
				  }
			  }
		});

		
		
			
	    setSize(500 , 700);
	    setVisible(true);
	    setTitle("Σελίδα Χρήστη");
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 }
}