package model;

import java.util.ArrayList;
import java.util.Date;

/**
 * This class is a movie show that may have various customers, and besides it
 * has additional information such as: date, time of the show, a room and the
 * movie played,
 * 
 *
 */
public class MovieShow {
	private Date date;
	private Date time;
	private ArrayList<Customer> customers = new ArrayList<>();
	private Movie movie;
	private Room room;
	
	/**
	 * This is the constructor method of the movie class
	 * @param date, Date, this is the date of the
	 * movie show
	 * @param time, Date, this is the time when the movie is played
	 * @param movie, Movie, this is the movie that is played
	 * @param room, Room, this is the room where the show takes place
	 */
	public MovieShow(Date date, Date time, Movie movie, Room room) {
		this.date = date;
		this.time = time;
		this.movie = movie;
		this.room = room;
	}

	/**
	 * Gets the date of the movie show 
	 * @return, date, Date, this is the date of the
	 * movie show
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Sets the date of the movie show @param, date, Date, this is the date of the
	 * movie show
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * Gets the time of the show
	 * 
	 * @return time, Date, this is the time when the movie is played
	 */
	public Date getTime() {
		return time;
	}

	/**
	 * Sets the time of the show
	 * 
	 * @param time, Date, this is the time when the movie is played
	 */
	public void setTime(Date time) {
		this.time = time;
	}

	/**
	 * Gets the array list of the show's customers
	 * 
	 * @return customers, ArrayList(Customer), this is the array list of the
	 *         customers
	 */
	public ArrayList<Customer> getCustomers() {
		return customers;
	}

	/**
	 * Sets the array list of the show's customers
	 * 
	 * @param customers, ArrayList(Customer), this is the array list of the
	 *                   customers
	 */
	public void setCustomers(ArrayList<Customer> customers) {
		this.customers = customers;
	}

	/**
	 * Gets the movie of the show
	 * 
	 * @return movie, Movie, this is the movie that is played in the show
	 */
	public Movie getMovie() {
		return movie;
	}

	/**
	 * Sets the movie of the show
	 * 
	 * @param movie, Movie, this is the movie that is played in the show
	 */
	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	/**
	 * Gets the room where the show takes place
	 * 
	 * @return room, Room, this is the room where the show takes place
	 */
	public Room getRoom() {
		return room;
	}

	/**
	 * Sets the room where the show takes place
	 * 
	 * @param room, Room, this is the room where the show takes place
	 */
	public void setRoom(Room room) {
		this.room = room;
	}

}
