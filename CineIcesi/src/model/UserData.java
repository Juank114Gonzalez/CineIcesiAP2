package model;

import java.io.Serializable;
import java.util.ArrayList;

public class UserData implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public static ArrayList<User> data = new ArrayList<>();
	
	public UserData() {
		
	}
	
	public void addUsers(User genericUser) {
		data.add(genericUser);
	}
	
	@Override
	public String toString() {
		String out = "";
		for(User a : data) {
			out += a.toString() +"\n";
		}
		return out;
	}
}