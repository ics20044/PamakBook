import java.io.Serializable;
import java.util.ArrayList;

public class Group implements Serializable {
	// These parameters are the properties of class Group.
	protected String name;
	protected String discription;
	protected ArrayList<User> emembers;
	
	// This method is the constructor of class Group with parameters.
	public Group(String n, String d, ArrayList<Group> Groupsall)
	{
		name = n;
		discription = d;
		emembers =  new ArrayList<User>();
		 Groupsall.add(this);
	}
	
	// This method checks if  user(ismember) is a member of this group.
	public boolean memberUser(User ismember)
	{
		boolean ourmember = false;
		for(int i=0; i< emembers.size(); i++)
		{
			if(emembers.get(i).getEmail() == ismember.getEmail())
			{
				ourmember = true;
				break;
			}
		}
		return ourmember;
	}
	
	// This method is the getter of name of class Group.
    public String getName() { return name;}
	
	// This method adds the user in the group ,if he has not been enrolled yet.
	public boolean addmember(User member )
	{
		boolean useradded = false;
		if(!memberUser(member))
		{
			emembers.add(member);
			System.out.println(member.getName() + " has been succesfully enrolled in group " + name);
			member.getEgroups().add(this);
			useradded =true;
		}
		return useradded;
	}
	
	// This method prints the users of the group. 
	public void printMembers()
	{
		System.out.println("****************************");
		System.out.println("Members of group " + name);
		System.out.println("****************************");
	  	for(int i=0; i<emembers.size(); i++)
		{
	  		System.out.println((i+1) + ": " + emembers.get(i).getName());
	    }	
	}	
}