package model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import control.MainController;
import exceptions.EmptyFieldsException;
import exceptions.ExistingFilmException;
import exceptions.ExistingUserException;
import exceptions.MissmatchPasswordException;
import exceptions.OverlappedShowsException;
import exceptions.SpaceCharactersException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import main.Main;

/**
 * This is the controller class of the cinema, this class have a static
 * ArrayList of the class MovieShow
 *
 */
public class CineController implements Serializable {

	public CineController() {

	}

	/**
	 * Default version of the serialization of this class
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * This ArrayList contains all the movie shows registered by the user
	 */
	public ObservableList<MovieShow> shows = FXCollections.observableArrayList();

	/*
	 * This ArrayList contains all the movies registered by the user
	 */
	public ArrayList<Movie> catalogue = new ArrayList<>();

	/**
	 * This ArrayList contains all the registered users
	 */
	public ArrayList<User> userData = new ArrayList<>();

	public String report;

	/**
	 * Adds a new user with the information given as parameters
	 * 
	 * @param name,     String, this is the name of the user to be added
	 * @param id,       String, this is the id of the user to be added
	 * @param password, String, this is the password of the user to be added
	 */
	public void registerUser(String name, String id, String password) {
		userData.add(new User(name, id, password));
		saveUsersAsJavaByteCode();
	}

	/**
	 * This method validates if a new user can be added with all the restrictions
	 * 
	 * @param name,            String, this is the name of the user
	 * @param id,              String, this is the id of the user
	 * @param password,        String, this is the password of the user
	 * @param confirmPassword, String, this is the password of the user typed a
	 *                         second time
	 * @return
	 */
	public boolean validateUser(String name, String id, String password, String confirmPassword)
			throws EmptyFieldsException, ExistingUserException, SpaceCharactersException, MissmatchPasswordException {
		boolean validReg = true;
		if (name.equals("") || id.equals("") || password.equals("")) {
			new EmptyFieldsException();
			validReg = false;
		}
		if (checkUserExists(id)) {
			validReg = false;
			new ExistingUserException(id);
		}
		if (detectSpaces(id) || detectSpaces(password)) {
			validReg = false;
			new SpaceCharactersException();
		}
		if (!password.equals(confirmPassword)) {
			validReg = false;
			new MissmatchPasswordException();
		}

		return validReg;
	}

	/**
	 * This method checks if any user has the id entered as parameter
	 * 
	 * @param id, String, id of the user
	 * @return out, boolean, true if there is any user
	 */
	public boolean checkUserExists(String id) {
		boolean out = false;
		for (User user : userData) {
			if (user.getUserID().equals(id)) {
				out = true;
				break;
			}
		}
		return out;
	}

	/**
	 * This method detects spaces in a string and returns a boolean
	 * 
	 * @param parameter, String, it is the string that may have a space
	 * @return out, Boolean, it is true if there is any space into the string, false
	 *         otherwise
	 */
	public boolean detectSpaces(String parameter) {
		boolean out = false;
		for (int i = 0; i < parameter.length(); i++) {
			if (parameter.charAt(i) == ' ') {
				out = true;
				break;
			}
		}
		return out;
	}

	/**
	 * This method saves all the data contained on the ArrayList
	 * "CineController.userData"
	 */
	public void saveUsersAsJavaByteCode() {
		try {
			ArrayList<User> userList = userData;
			File ref = new File(MainController.userDataPath);
			FileOutputStream fos = new FileOutputStream(ref);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(userList);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method verifies if the password is correct or not
	 */
	public boolean wrongPassword(String id, String pass) {
		boolean out = false;

		for (User user : userData) {
			if (user.getUserID().equals(id) && !user.getPassword().equals(pass)) {
				out = true;
				break;
			}
		}

		return out;
	}

	/**
	 * This method checks if an user exists
	 * 
	 * @param id
	 * @param pass
	 * @return
	 */
	public boolean checkUserExists(String id, String pass) {
		boolean out = false;
		for (User user : userData) {
			if (user.getUserID().equals(id) && user.getPassword().equals(pass)) {
				MainController.loggedUser = user;
				out = true;
				break;
			}
		}
		return out;
	}

	// -----------------------------------------------------------------------Films

	/**
	 * This method verifies if a movie can be added taking in count restrictions
	 * 
	 * @param movieName, String, this is the name of the movie
	 * @param hours,     String, this is the hours number of the duration of the
	 *                   movie
	 * @param minutes,   String, this is the minutes number of the duration of the
	 *                   movie
	 * @return validReg, Boolean, it is true if the film is valid, false otherwise
	 * @throws EmptyFieldsException
	 * @throws ExistingFilmException
	 */
	public boolean validateFilm(String movieName, String hours, String minutes)
			throws EmptyFieldsException, ExistingFilmException {
		boolean validReg = true;
		if (movieName.equals("") || hours.equals("") || minutes.equals("")) {
			new EmptyFieldsException();
			validReg = false;
		} else if (checkMovieExists(movieName)) {
			validReg = false;
			new ExistingFilmException(movieName);
		}
		return validReg;
	}

	/**
	 * This method checks if a movie is currently registered
	 * 
	 * @param a
	 * @return
	 */
	public boolean checkMovieExists(String movieName) {
		boolean out = false;
		for (Movie film : catalogue) {
			if (film.getName().equals(movieName)) {
				out = true;
				break;
			}
		}
		return out;

	}

	/**
	 * Adds a new movie to the catalogue arraylist
	 * 
	 * @param movieName, String, this is the name of the movie to be added
	 * @param hours,     String, this the hours number of the duration of the movie
	 * @param minutes,   String, this is the minutes number of the duration
	 */
	public void registerFilm(String movieName, String hours, String minutes) {
		String time = hours + ":" + minutes + ":00";
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		Date duration = null;
		try {
			duration = sdf.parse(time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catalogue.add(new Movie(movieName, duration));
		saveMoviesAsJavaByteCode();
	}

	/**
	 * This method saves all the data contained on the ArrayList
	 * "CineController.catalogue"
	 */
	public void saveMoviesAsJavaByteCode() {
		try {
			ArrayList<Movie> movieList = catalogue;
			File ref = new File(MainController.movieDataPath);
			FileOutputStream fos = new FileOutputStream(ref);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(movieList);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// ------------------------------------------------Shows

	/**
	 * This method validates if a show can be added taking in count all the
	 * restrictions
	 * 
	 * @param film,     String, this is the name of the film that will be played on
	 *                  the show
	 * @param hours,    String, this is the hours number of the time of the show
	 * @param minutes,  String, this is the minutes number of the time of the show
	 * @param room,     String, this is the type of room of the show
	 * @param duration, String, this is the duration of the show
	 * @param date,     LocalDate, this is the date of the show
	 * @return validReg, Boolean, true if the show can be added, false otherwise
	 * @throws EmptyFieldsException
	 * @throws OverlappedShowsException
	 */
	public boolean validateShow(String film, String hours, String minutes, String room, String duration, LocalDate date)
			throws EmptyFieldsException, OverlappedShowsException {
		boolean validReg = true;
		if (film.equals("") || hours.equals("") || room.equals("") || minutes.equals("") || duration.equals("")
				|| date.equals(null)) {
			new EmptyFieldsException();
			validReg = false;
		} else {
			Movie movie = getMovie(film);
			String timeS = hours + ":" + minutes + ":00";
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			Date time = null;
			try {
				time = sdf.parse(timeS);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (verifyOverlap(movie, date, time, room.toUpperCase())) {
				new OverlappedShowsException();
				validReg = false;
			}

		}
		return validReg;
	}

	/**
	 * This method adds a new show to the arraylist shows
	 * 
	 * @param film,    String, this is the name of the movie that will be played in
	 *                 the show to add
	 * @param hours,   String, this is the hours number of the time of the show to
	 *                 add
	 * @param minutes, String, this is the minutes number of the time of the show to
	 *                 add
	 * @param room,    String, this is the type of room of the show to add
	 * @param date,    LocalDate, this is the date of the show to add
	 */
	public void registerShow(String film, String hours, String minutes, String room, LocalDate date) {
		Movie movie = getMovie(film);
		String timeS = hours + ":" + minutes + ":00";
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		Date time = null;
		try {
			time = sdf.parse(timeS);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Date date, Date time, Movie movie, String roomType
		shows.add(new MovieShow(date, time, movie, room.toUpperCase()));
		saveShowsAsJavaByteCode();
	}

	/**
	 * This method verifies if the new show will overlap with another registered
	 * show
	 * 
	 * @param movie,     Movie, this is the movie of the new show
	 * @param date,      LocalDate, this is the date when the new show will happen
	 * @param startTime, this is the time when the new show will start
	 * @param roomType,  this is the type of room where the new show will take place
	 * @return out, Boolean, out will be true if the new show overlaps with another
	 *         registered show, false otherwise
	 */
	public boolean verifyOverlap(Movie movie, LocalDate date, Date startTime, String roomType) {
		boolean out = false;
		Date duration = movie.getDuration();
		for (MovieShow mS : shows) {
			if (mS.getDate().equals(date) && mS.getTypeString().equals(roomType)) {
				int[] newMovieTime = startAndEndTime(startTime, duration);
				int[] movieToCompare = startAndEndTime(mS.getTime(), mS.getMovieShowDuration());
				if (newMovieTime[0] >= movieToCompare[0] && newMovieTime[0] < movieToCompare[1]
						|| newMovieTime[1] <= movieToCompare[1] && movieToCompare[1] >= movieToCompare[0]) {
					out = true;
					break;
				}
			}
		}
		return out;
	}

	/**
	 * This method returns the start and the end time of a movie show by receiving
	 * the start time and the duration of the movie played on the show
	 * 
	 * @param startTime, Date, this is the time when the show starts
	 * @param duration,  Date, this is the duration of the movie show
	 * @return out, int [], this is an array that represents the start and end time,
	 *         the 0 position of the array will be the start time, the 1 position of
	 *         the array will be the end time
	 */
	public int[] startAndEndTime(Date startTime, Date duration) {
		int[] out = new int[2];

		int startTimeMinutes = parseHoursToMinutes(startTime.getHours()) + startTime.getMinutes();
		int durationMinutes = parseHoursToMinutes(duration.getHours()) + duration.getMinutes();
		int endTimeMinutes = startTimeMinutes + durationMinutes;

		out[0] = startTimeMinutes;
		out[1] = endTimeMinutes;

		return out;
	}

	/**
	 * This method parses a quantity of hours to minutes
	 * 
	 * @param hours
	 * @return hours * 60, int, this is the equivalent of the hours in minutes
	 */
	public int parseHoursToMinutes(int hours) {
		return hours * 60;
	}

	/**
	 * This method gets a movie depending on its name
	 * 
	 * @param event
	 * @param movieName
	 */
	public Movie getMovie(String movieName) {
		Movie out = null;
		for (Movie mv : Main.cine.catalogue) {
			if (mv.getName().equals(movieName)) {
				out = mv;
				break;
			}
		}

		return out;
	}

	/**
	 * This method saves all the data contained on the ArrayList
	 * "CineController.shows"
	 */
	public void saveShowsAsJavaByteCode() {
		try {
			ObservableList<MovieShow> showList = shows;
			File ref = new File(MainController.showsDataPath);
			FileOutputStream fos = new FileOutputStream(ref);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(new ArrayList<MovieShow>(showList));
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method generates a room's report
	 * 
	 * @param ms, MovieShow, this is the show which report is going to be generated
	 * @return report, String, this is the report of the room
	 */
	public void reportToString(MovieShow ms) {
		

		report = ms.getMovieName() + " - " + ms.getDate() + " - SALA " + ms.getType() + "\nEspectadores:\n";

		for (int i = 0; i < ms.getCustomers().length; i++) {
			for (int j = 0; j < 7; j++) {
				if (ms.getCustomers()[i][j] != null) {
					report += ms.getCustomers()[i][j].toString();
				}

			}
		}

	}

}
