import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.TreeSet;

public class User implements Serializable  {
	
	// These parameters are the properties of class User.
	private String name;
	private String email;
	private ArrayList<User> efriends;
	private ArrayList<Group> egroups;
	private TreeSet<Post> posts; 
	
	// This method is the constructor of class User with parameters.
	public User(String n, String em, ArrayList<User> Users)
	{
		 String emcopy= em.substring(0, 3); 
	     boolean create = false;
	     
	     if(emcopy.equals("ics") || emcopy.equals("iis") || emcopy.equals("dai"))
	     {
	    	int sum_id = 3;
	    	while(sum_id<em.length() && em.charAt(sum_id)!='@')
	    	{
	    		sum_id++;
	    	}
	    	if(sum_id>=6 || sum_id<=8)
	    	{
	    		emcopy = em.substring(sum_id, em.length());
	    		if( emcopy.equals("@uom.edu.gr") )
	    		{
	    			create = true;
	    			name = n;
		            email = em;
		            efriends = new ArrayList<User>();
		            egroups = new ArrayList<Group>();
		            posts = new TreeSet<Post>();
		            Users.add(this);
		        }
	    	}
	     }
	    if(create == false)
	    {
	    	System.out.println("CONSOLE:");
	    	System.out.println("User " + n + " has not been created.Email format is not acceptable.");
	    }
	}
	
	// These methods are the getters of class User.
	public String getName() { return name;}
	public String getEmail() { return email;}
	public ArrayList<User> getEfriends() { return efriends;}
    public ArrayList<Group> getEgroups(){ return egroups;}
    public TreeSet<Post> getPosts(){return posts;}
  

	// This method checks if another user (other_user) is friend with this user.
	public boolean friendUser(User other_user)
	{
		boolean efriendship = false;
		if( email != other_user.getEmail())
		{
			for(int i=0; i<efriends.size(); i++)
			{
				if(efriends.get(i).getEmail() == other_user.getEmail())
				{
					efriendship = true;
					break;
				}
			}
		}
		return efriendship;
	}
	
	// This method adds the user(friend) in the list of this user, if they are different users  and they are not friends yet.  
	public void addFriend(User friend)
	{
		if( friendUser(friend) == false)
		{
			efriends.add(friend);
			friend.getEfriends().add(this);
			System.out.println(name + " and " + friend.getName() + " are now friends!");
		}
		
	}
	
	// This method finds the common friends between two users and returns them.
	public ArrayList<User> commonFriends(User other_user)
	{
		ArrayList<User> commonfriends = new ArrayList<User>();
	  	for(int i=0; i<efriends.size(); i++)
		{
	  		for(int j=0; j<other_user.getEfriends().size(); j++)
			{
				if(efriends.get(i).getEmail() == other_user.getEfriends().get(j).getEmail())
			    {
				    commonfriends.add(efriends.get(i));
				    
			    }
			}
		}
	  	return commonfriends;
	}
	
	// This method prints the friends of the user.
	public void printFriends()
	{
		System.out.println("*************************");
		System.out.println("Friends of " + name);
		System.out.println("*************************");
		for(int i=0; i< efriends.size(); i++)
		{
			System.out.println((i + 1) + "." + efriends.get(i).getName());
		}
		System.out.println("-------------------------");
	 }
	
	// This method prints the groups that the user has been enrolled.
	public void printGroups()
	{
		System.out.println("************************************************");
		System.out.println("Groups that " + name + " has been enrolled in");
		System.out.println("************************************************");
		for(int i=0; i<egroups.size(); i++)
		{
			System.out.println((i+1) + ": " + egroups.get(i).getName());
		}
	}
	
	// This method finds the contacts of user, that are their friends and the friends of their friends, which are the possible carriers of virus. 	
	public ArrayList<User> possibleVirusTransmission(User our_user)
	{
		ArrayList<User> pvt = new ArrayList<User>();
		for(int i=0; i< efriends.size(); i++)
		{
			
			if(i>0)
			{
				boolean insidepvt = false;
				for(int z=0; z<pvt.size(); z++)
			    {
				 if( pvt.get(z) == efriends.get(i) )
				 {
					insidepvt = true;
					break;
				 }
			    }
				if(!insidepvt)
				{
					pvt.add(efriends.get(i));
				}
			}
			else
			{
				pvt.add(efriends.get(i));
			}
			
			
			for(int j=0; j< efriends.get(i).getEfriends().size(); j++)
			{
				boolean isinside = false;
				for(int k=0; k<pvt.size(); k++)
				{
					if( pvt.get(k) == efriends.get(i).getEfriends().get(j) )
					{
						isinside = true;
						break;
					}
				}
				if(isinside == false && our_user!=efriends.get(i).efriends.get(j) )
				{
					pvt.add(efriends.get(i).efriends.get(j));
				}
	       }
		}
		return pvt;
    }
  
    //This method adds a post in the posts of user.
    public void addPost(Post p)
    {
       posts.add(p);
    }
    
    //This method returns the posts of user and the posts of their friends
    public TreeSet<Post> PostAll()
    {
    	TreeSet<Post> postsAll = new TreeSet<Post>();
		postsAll.addAll(posts);
		for(int i=0; i<efriends.size(); i++)
    	{
    		postsAll.addAll(efriends.get(i).getPosts());
    	}
    	return postsAll;
    }
    
    //This method returns the suggested friends of user.
    public HashSet<User> suggestedFriends()
    {
    	HashSet<User> SuggestedFriends = new HashSet<User>();
    	for(int i=0; i<efriends.size(); i++)
    	{
    	    for(int j=0;j<efriends.get(i).getEfriends().size(); j++)
    		{
    			if(!friendUser(efriends.get(i).getEfriends().get(j)) && efriends.get(i).getEfriends().get(j).getName() != name)
    			{
    				 SuggestedFriends.add(efriends.get(i).getEfriends().get(j));
    			}
    		}
    	}
    	return SuggestedFriends;
    }       
}