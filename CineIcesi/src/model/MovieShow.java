package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 * This class is a movie show that may have various customers, and besides it
 * has additional information such as: date, time of the show, a room and the
 * movie played,
 * 
 *
 */
public class MovieShow implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private LocalDate date;
	private Date time;
	private Customer[][] customers;
	private Movie movie;
	private String durationMovie;
	private String movieName;
	private String viewersCount;
	private String timeString;
	private RoomType type;

	/**
	 * This is the constructor method of the movie class
	 * 
	 * @param date,     LocalDate, this is the date of the movie show
	 * @param time,     Date, this is the time when the movie is played
	 * @param movie,    Movie, this is the movie that is played
	 * @param roomType, String, this is the room where the show takes place
	 */
	public MovieShow(LocalDate date, Date time, Movie movie, String roomType) {
		customers = new Customer[6][7];
		if (roomType.toUpperCase().equals("MINI")) {
			this.type = RoomType.MINI;
		} else if (roomType.toUpperCase().equals("NORMAL")) {
			this.type = RoomType.NORMAL;
		}

		this.date = date;
		this.time = time;
		this.movie = movie;
		this.movieName = this.movie.getName();
		int hours = this.movie.getDuration().getHours();
		int minutes = this.movie.getDuration().getMinutes();
		this.durationMovie = hours + "h " + minutes + "m";
		hours = this.time.getHours();
		minutes = this.time.getMinutes();
		this.timeString = hours + " : " + minutes;
	}

	public MovieShow() {

	}

	public void setViewersCount(String viewersCount) {
		this.viewersCount = viewersCount;
	}

	public String getDurationMovie() {
		return durationMovie;
	}

	/**
	 * Sets the duration of the movie as a String
	 * 
	 * @param durationMovie
	 */
	public void setDurationMovie(String durationMovie) {
		this.durationMovie = durationMovie;
	}

	/**
	 * Gets
	 * 
	 * @return
	 */
	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getTimeString() {
		return timeString;
	}

	public void setTimeString(String timeString) {
		this.timeString = timeString;
	}

	/**
	 * Gets the type of the room where the movie show will take place
	 * 
	 * @return type, RoomType, type of the room
	 */
	public RoomType getType() {
		return type;
	}

	/**
	 * Gets the String of the type of room where the movie show will take place
	 * 
	 * @return type, String, string of the type of room
	 */
	public String getTypeString() {
		return "" + type;
	}

	/**
	 * Sets the type of the room where the movie show will take place
	 * 
	 * @param type, RoomType, type of the room
	 */
	public void setType(RoomType type) {
		this.type = type;
	}

	/**
	 * Gets the date of the movie show @return, date, LocalDate, this is the date of
	 * the movie show
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * Sets the date of the movie show @param, date, LocalDate, this is the date of
	 * the movie show
	 */
	public void setDate(LocalDate date) {
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
	public Customer[][] getCustomers() {
		return customers;
	}

	/**
	 * Sets the array list of the show's customers
	 * 
	 * @param customers, ArrayList(Customer), this is the array list of the
	 *                   customers
	 */
	public void setCustomers(Customer[][] customers) {
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
	 * This method gets the duration of the Movie show
	 * 
	 * @return movie.getDuration()
	 */
	public Date getMovieShowDuration() {
		return movie.getDuration();
	}

	/**
	 * This method adds a new customer into a specific position in the matrix
	 * 
	 * @param position, int [], this is an array with the position of the customer,
	 *                  position[0] will be the row, position[1] will be the column
	 * @param customer, Customer, new customer to add into the matrix
	 */
	public void addCustomer(int[] position, Customer customer) {
		this.customers[position[0]][position[1]] = customer;
	}

	/**
	 * This method gets a String with the basic information about a movie show
	 */
	public String toString() {
		return "Date of the show: " + date + " Time of the show: " + time + " Movie: " + movie.getName();
	}

}
