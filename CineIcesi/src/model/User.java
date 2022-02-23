package model;

public class User {
	
	public User(String name, String userID) {
		this.name = name;
		this.userID = userID;
		password = "000000";
	}

	public User(String name, String userID, String password) {
		this.name = name;
		this.userID = userID;
		this.password = userID;
	}
	
	private String name;
	
	private String password;
	
	private String userID;

	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}
	
}
