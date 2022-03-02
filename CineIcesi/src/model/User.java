package model;

import java.io.Serializable;

public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;

	

	public User(String name, String userID) {
		this.name = name;
		this.userID = userID;
		password = "000000";
	}

	public User(String name, String userID, String password) {
		this.name = name;
		this.userID = userID;
		this.password = password;
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
	
	@Override
	public String toString() {
		return "| Nombre: "+ getName() + " ID: " + getUserID() + " Pass: " + getPassword() + " |\n";
	}
}
