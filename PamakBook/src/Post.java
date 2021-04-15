import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Post implements Comparable<Post>, Serializable{
	
	//These parameters are the properties of class Post.
	private Date timestamp;
	private String text_post;
	private User user_post;
	private String time_post;
	
    //This method is the constructor of class Post with parameters.
	public Post( String tp, User u)
	{
		SimpleDateFormat f = new SimpleDateFormat(" dd/MM/yyyy  HH:mm:ss ");
		timestamp = new Date(System.currentTimeMillis());
		time_post = f.format(timestamp);
		text_post = tp;
		user_post = u;
		user_post.addPost(this);
	}
	
	//These methods are the getters of class Post. 
	public Date getTimestamp() {return timestamp;}
	public String getText_post() {return text_post;}
	public User getUser_post() {return user_post;}
	public String getTime_post() {return time_post;}

	//This method overrides the method compareTo and sorts posts by the most recently added posts.. 
	public int compareTo(Post p) {
		
		if(timestamp.before(p.getTimestamp()))
	    {
	    	 return 1;
	    }
	    else
	    {
	    	 return -1;
	    }
	}	
}