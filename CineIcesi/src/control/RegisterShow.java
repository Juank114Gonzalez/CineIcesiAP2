package control;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import exceptions.EmptyFieldsException;
import exceptions.OverlappedShowsException;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import model.CineController;
import model.Movie;
import model.MovieShow;

public class RegisterShow implements Initializable {

	private ArrayList<String> hours = new ArrayList<>();
	private ArrayList<String> minutes = new ArrayList<>();

	// Choice boxes
	@FXML
	private ChoiceBox<String> availableRoomCB;
	@FXML
	private ChoiceBox<String> filmListCB;
	@FXML
	private ChoiceBox<String> hoursCB;
	@FXML
	private ChoiceBox<String> minutesCB;

	// Date pickers
	@FXML
	private DatePicker datePickerDP;

	// Text fields
	@FXML
	private TextField durationShowTF;
	@FXML
	private TextField startTimeTF;

	// Images
	@FXML
	private ImageView back_IMG;

	// Buttons
	@FXML
	private Button back_BTN;

	/**
	 * This method launches the previous window
	 */
	@FXML
	void goBack(ActionEvent event) {
		launchIndex(event);
	}
	
	/**
	 * This method sets the durationShowTF as the actual duration of the movie selected
	 * @param event
	 */
	@FXML
	void setDuration(ActionEvent event) {
		for (Movie mv : CineController.catalogue) {
			if (filmListCB.getValue().equals(mv.getName())) {
				int hours = mv.getDuration().getHours();
				int minutes = mv.getDuration().getMinutes();
				durationShowTF.setText(hours + "h " + minutes + "m");
				break;
			}
		}
	}

	/**
	 * This method launches the index window
	 * 
	 * @param event
	 */
	public void launchIndex(ActionEvent event) {
		MainController.flag = "login";
		MainController.launchIndex(event);
	}

	/**
	 * this method sets all the items of the films choice box
	 */
	public void fillFilmListCB() {
		ArrayList<String> moviesNameList = new ArrayList<>();
		for (Movie movie : CineController.catalogue) {
			moviesNameList.add(movie.getName());
		}
		filmListCB.getItems().addAll(moviesNameList);
	}

	/**
	 * This method sets all the items of the room Type
	 */
	public void fillRoomTypeCB() {
		ArrayList<String> roomTypes = new ArrayList<>();
		roomTypes.add("Mini");
		roomTypes.add("Normal");
		availableRoomCB.getItems().addAll(roomTypes);
	}

	/**
	 * This method fills the hours choice box with the values contained in the
	 * "hours" array list
	 */
	public void fillHoursCB() {
		hoursCB.getItems().addAll(hours);
	}

	/**
	 * This method fills the minutes choice box with the values contained in the
	 * "minutes" array list
	 */
	public void fillMinutesCB() {
		minutesCB.getItems().addAll(minutes);
	}

	/**
	 * This method adds a new show into the ArrayList CineController.shows
	 */
	@FXML
	void registerShow(ActionEvent event) throws EmptyFieldsException, OverlappedShowsException {
		boolean validReg = true;
		if(!filmListCB.getValue().equals("")) {
			setDuration(event);
		}
		if (filmListCB.getValue().equals("") || hoursCB.getValue().equals("")
				|| availableRoomCB.getValue().equals("") || minutesCB.getValue().equals("")
				|| durationShowTF.getText().equals("") || datePickerDP.getValue().equals(null)) {
			new EmptyFieldsException();
			validReg = false;
		} else {
			Movie movie = getMovie(filmListCB.getValue());
			String roomType = availableRoomCB.getValue().toUpperCase();
			String timeS = hoursCB.getValue() + ":" + minutesCB.getValue() + ":00";
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			Date time = null;
			try {
				time = sdf.parse(timeS);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (verifyOverlap(movie, datePickerDP.getValue(), time, roomType)) {
				new OverlappedShowsException();
				validReg = false;
			}

		}

		if (!validReg) {
			clearTFs();
		} else {
			Movie movie = getMovie(filmListCB.getValue());
			String roomType = availableRoomCB.getValue().toUpperCase();
			String timeS = hoursCB.getValue() + ":" + minutesCB.getValue() + ":00";
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			Date time = null;
			try {
				time = sdf.parse(timeS);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// Date date, Date time, Movie movie, String roomType
			CineController.shows.add(new MovieShow(datePickerDP.getValue(), time, movie, roomType));
			clearTFs();
			saveAsJavaByteCode();
			System.out.println(CineController.shows);
			
		}
	}
	
	/**
	 * This method saves all the data contained on the ArrayList "CineController.shows"
	 */
	public void saveAsJavaByteCode() {
		try {
			ObservableList<MovieShow> showList = CineController.shows;
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
		for (MovieShow mS : CineController.shows) {
			if (mS.getDate().equals(date) && mS.getTypeString().equals(roomType)) {
				int[] newMovieTime = startAndEndTime(startTime, duration);
				int[] movieToCompare = startAndEndTime(mS.getTime(), mS.getMovieShowDuration());
				if (newMovieTime[0] >= movieToCompare[0] && newMovieTime[0] < movieToCompare[1]
						|| newMovieTime[1] <= movieToCompare[1] && movieToCompare[1] >= movieToCompare[0]) {
					System.out.println("hora de inicio película nueva: " + newMovieTime[0]
							+ "| hora de fin película nueva: " + newMovieTime[1]
							+ "\n hora de inicio película con la que se superpone: " + movieToCompare[0]
							+ "| hora de fin de película con la que se superpone: " + movieToCompare[1]);
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
		for (Movie mv : CineController.catalogue) {
			if (mv.getName().equals(movieName)) {
				out = mv;
				break;
			}
		}

		return out;
	}

	/**
	 * Clears the text of all the elements
	 */
	public void clearTFs() {
		filmListCB.setValue(null);
		datePickerDP.setValue(null);
		availableRoomCB.setValue(null);
		hoursCB.setValue(null);
		minutesCB.setValue(null);
		durationShowTF.setText(null);
		// after setting the fields as empty
		filmListCB.setValue("");
		datePickerDP.setValue(null);
		availableRoomCB.setValue("");
		hoursCB.setValue("");
		minutesCB.setValue("");
		durationShowTF.setText("");

	}

	/**
	 * This method initializes the window
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		clearTFs();
		// TODO Auto-generated method stub
		for (int i = 0; i < 24; i++) {
			hours.add("" + (i));
		}
		for (int i = 0; i < 60; i = i + 5) {
			minutes.add("" + (i));
		}
		fillFilmListCB();
		fillRoomTypeCB();
		fillHoursCB();
		fillMinutesCB();

	}

}
