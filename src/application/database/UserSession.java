// @author becacabe2002

package application.database;

public class UserSession {
	private static UserSession instance;
	private String username;
	private String admin_name;
	
	public UserSession() {}
	
	public static UserSession getInstance() {
		if(instance == null) {
			instance = new UserSession();
		}
		return instance;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String input) {
		this.username = input;
	}
	public String getAdmin_name() {
		return admin_name;
	}
	
	public void setAdmin_name(String input) {
		this.admin_name = input;
	}
}
