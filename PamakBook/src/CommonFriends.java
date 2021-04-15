import java.util.ArrayList;

public class CommonFriends {
	
	// This method prints the common friends of users.
	public static void printCommonFriends(ArrayList<User> commonfriends, User firstuser,User seconduser)
	{
		System.out.println("************************************************");
		System.out.println("Common friend of " + firstuser.getName() + " and " + seconduser.getName());
		System.out.println("************************************************");
		for(int i=0; i<commonfriends.size(); i++)
		{
			System.out.println((i + 1) + "." +  commonfriends.get(i).getName());
		}
		System.out.println("-------------------------------------------------");
	}

}