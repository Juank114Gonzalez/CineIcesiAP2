package model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This is the movie class, a movie has a name and a duration
 *
 */
public class Movie implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name; 
	private Date duration;
	
	/**
	 * This is the constructor method of a movie
	 * @param name, String, this is the name of the movie
	 * @param duration, Date, this is the duration of the movie
	 */
	public Movie (String name, Date duration) {
		this.name = name;
		this.duration = duration;
	}
	
	/**
	 * Gets the name of the movie
	 * @return name, String, this is the name of the movie
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name of the movie
	 * @param name, String, this is the name of the movie
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the duration of the movie
	 * @return duration, Date, this is the duration of the movie
	 */
	public Date getDuration() {
		return duration;
	}
	
	/**
	 * Gets the duration of the movie
	 * @param duration, Date, this is the duration of the movie
	 */
	public void setDuration(Date duration) {
		this.duration = duration;
	}
	
	/**
	 * Returns a String with the basic information of the movie
	 */
	public String toString() {
		
		return  "Name: " + name + " Date: " + duration ;
	}
	
	
}
