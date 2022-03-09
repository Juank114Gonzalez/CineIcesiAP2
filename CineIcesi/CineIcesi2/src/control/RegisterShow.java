package control;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import model.CineController;
import model.Movie;

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

	//Images
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
		for(Movie movie : CineController.catalogue) {
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
	 * This method fills the hours choice box with the values contained in the "hours" array list
	 */
	public void fillHoursCB() {
		hoursCB.getItems().addAll(hours);
	}
	
	/**
	 * This method fills the minutes choice box with the values contained in the "minutes" array list
	 */
	public void fillMinutesCB() {
		minutesCB.getItems().addAll(minutes);
	}
	
	

	/**
	 * This method initializes the window
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		for(int i = 0; i<24; i++) {
			hours.add(""+(i));
		}
		for(int i = 0; i<60; i= i+5) {
			minutes.add(""+(i));
		}
		fillFilmListCB();
		fillRoomTypeCB();
		fillHoursCB();
		fillMinutesCB();
		
	}
	
	

}
