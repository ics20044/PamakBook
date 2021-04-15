import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<User> Users = new ArrayList<User>();
		ArrayList<Group> Groupsall = new ArrayList<Group>();
		
	    //These commands create the objects of Users.
		/*User u1 = new User("Makis", "iis1998@uom.edu.gr", Users);
		User u2 = new User("Petros", "ics1924@uom.edu.gr", Users);
		User u3 = new User("Maria", "iis2012@uom.edu.gr", Users);
		User u4 = new User("Gianna", "iis19133@uom.edu.gr", Users);
		User u5 = new User("Nikos", "dai1758@uom.edu.gr", Users);
		User u6 = new User("Babis", "ics19104@uom.edu.gr", Users);
	    User u7 = new User("Stella", "dai1827@uom.edu.gr", Users);
		User u8 = new User("Eleni", "ics2086@gmail.com", Users);
		
		Group g1 = new Group("WebGurus","A group for web passionates",Groupsall); // This command create the object of  Group.
		ClosedGroup g2 = new ClosedGroup("ExamSolutions","Solutions to common examquestions",Groupsall); // This command create the object of ClosedGroup.
		
		System.out.println("CONSOLE:");
		u1.addFriend(u2);
		u1.addFriend(u5);
		u5.addFriend(u6);
		u3.addFriend(u4);
		u3.addFriend(u2);
		u4.addFriend(u6);
		u5.addFriend(u3);
		u1.addFriend(u6);
		u5.addFriend(u2);
		u7.addFriend(u1);
		CommonFriends.printCommonFriends(u5.commonFriends(u4) ,u5, u4);
		CommonFriends.printCommonFriends(u1.commonFriends(u5) ,u1, u5);
		u1.printFriends();
		u3.printFriends();
		g1.addmember(u4);
		g1.addmember(u3);
		g1.addmember(u2);
		g2.addmember(u4);
		g2.addmember(u5);
		g2.addmember(u6);
		g2.addmember(u5);
		u4.printGroups();
		g1.printMembers();
		g2.printMembers();
		
		ArrayList<User> pvt = u4.possibleVirusTransmission(u4);
		System.out.println("******************************");
		System.out.println(u4.getName() + " has been infected.The following users have to been tested");
		System.out.println("******************************");
		for(int i=0; i<pvt.size(); i ++)
		{
	      	System.out.println(pvt.get(i).getName());
		}
		System.out.println("------------------------------");
		
		Post p3 = new Post("Γνωρίζει κανείς πως γράφουμε εξετάσεις στην Java; ", u5);
		Post p1 = new Post("Ναι.Επίσης ,έχουμαι ανοιχτά βιβλία!", u2);
		Post p2 = new Post("Γράφουμε εξετλασεις στοεργαστήριο.", u3);
		*/
		new MainGui(Users,Groupsall);
}
}