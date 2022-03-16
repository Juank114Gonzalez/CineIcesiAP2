package model;

import java.io.Serializable;

/**
 * This is the user class, an user has a name, a password and an ID
 * @author gabri
 *
 */
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String password;
	private String userID;
	
	/**
	 * This is a constructor for the user can be also null
	 */
	public User() {}
	
	/**
	 * This is a constructor method of user, without the password
	 * @param name, String, this is the name of the user
	 * @param userID, String, this is the ID of the user
	 */
	public User(String name, String userID) {
		this.name = name;
		this.userID = userID;
		password = "000000";
	}
	
	/**
	 * This is the constructor method of user with all of its attributes
	 * @param name, String, this is the name of the user
	 * @param userID, String, this is the ID of the user
	 * @param password, String, this is the password of the user
	 */
	public User(String name, String userID, String password) {
		this.name = name;
		this.userID = userID;
		this.password = password;
	}

	
	/**
	 * Gets the name of the user
	 * @return name, String, this is the name of the user
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name of the user
	 * @param name, String, this is the name of the user
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the password of the user
	 * @return password, String, this is the password of the user
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Sets the password of the user
	 * @param password, String, this is the password of the user
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Gets the user ID
	 * @return userID, String, this is the user ID
	 */
	public String getUserID() {
		return userID;
	}
	
	/**
	 * Sets the user ID
	 * @param userID, String, this is the user ID
	 */
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	/**
	 * Returns a String with the information of the user
	 */
	@Override
	public String toString() {
		return "| Nombre: "+ getName() + " ID: " + getUserID() + " Pass: " + getPassword() + " |\n";
	}
}
