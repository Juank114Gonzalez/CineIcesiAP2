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
import java.util.Optional;
import java.util.ResourceBundle;

import exceptions.EmptyFieldsException;
import exceptions.OverlappedShowsException;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import main.Main;
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
		MainController.flag = "login";
		MainController.launchIndex(event);
	}

	/**
	 * This method sets the durationShowTF as the actual duration of the movie
	 * selected
	 * 
	 * @param event
	 */
	@FXML
	void setDuration(ActionEvent event) {
		for (Movie mv : Main.cine.catalogue) {
			if (filmListCB.getValue().equals(mv.getName())) {
				int hours = mv.getDuration().getHours();
				int minutes = mv.getDuration().getMinutes();
				durationShowTF.setText(hours + "h " + minutes + "m");
				break;
			}
		}
	}

	/**
	 * this method sets all the items of the films choice box
	 */
	public void fillFilmListCB() {
		ArrayList<String> moviesNameList = new ArrayList<>();
		for (Movie movie : Main.cine.catalogue) {
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

		if (!filmListCB.getValue().equals("")) {
			setDuration(event);
		}

		String film = filmListCB.getValue();
		String hours = hoursCB.getValue();
		String minutes = minutesCB.getValue();
		String room = availableRoomCB.getValue();
		String duration = durationShowTF.getText();
		LocalDate date = datePickerDP.getValue();

		if (!Main.cine.validateShow(film, hours, minutes, room, duration, date)) {
			clearTFs();
		} else {
			Main.cine.registerShow(film, hours, minutes, room, date);
			Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
			alert.setTitle("Función registrada!");
			alert.setContentText("La función ha shido registrada para la siguiente fecha:\n" + datePickerDP.getValue());
			Optional<ButtonType> result = alert.showAndWait();
			clearTFs();
		}
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
