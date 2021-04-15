import java.util.ArrayList;

public class ClosedGroup extends Group {
	
	// This method is the constructor of the class ClosedGroup with parameters.
	public ClosedGroup(String n, String d, ArrayList<Group> Groupsall)
	{
		super(n,d, Groupsall);
	}
	
	// This method adds the user in the group, if he is friend with another user who is enrolled in this group.
	public boolean addmember(User member)
	{
		boolean friends = false ;
		if(emembers.size() == 0)
		{
			super.addmember(member);
		}
		else
		{
			for(int i=0; i< emembers.size(); i++)
		    {
			    friends = emembers.get(i).friendUser(member);
				if(friends)
				{
					super.addmember(member);
					friends = true;
					break;
				}
			}
			if(friends == false)
		    {
			   System.out.println("FAILED " + member.getName() + " can not been enolled in group" + name);
		    }
		}
       return friends;
}
}
