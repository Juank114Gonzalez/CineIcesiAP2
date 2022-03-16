package control;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;

import exceptions.EmptyFieldsException;
import exceptions.ExistingFilmException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import main.Main;
import model.CineController;
import model.Movie;


public class RegisterFilm implements Initializable{
	
	private ArrayList<String> hours = new ArrayList<>();
	private ArrayList<String> minutes = new ArrayList<>();
	
	//Images
	@FXML
    private ImageView back_IMG;
	
	@FXML
    private ImageView bgIMG;
	
	//Buttons
    @FXML
    private Button back_BTN;
    
    //Choice boxes
    @FXML
    private ChoiceBox<String> hoursCB;

    @FXML
    private ChoiceBox<String> minutesCB;
    
    //Text fields
    @FXML
    private TextField filmNameTF;

    @FXML
    void goBack(ActionEvent event) {
    	MainController.launchIndex(event);
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
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		clearTFs();
		// TODO Auto-generated method stub
		
		//This loop fills the hours ArrayList with the numbers from 0:00 to 23:00
		for(int i = 0; i<24; i++) {
			hours.add((i) + "");
		}
		for(int i = 0; i<60; i= i+5) {
			minutes.add(""+(i));
		}
		fillHoursCB();
		fillMinutesCB();
		
	}
	
	/**
	 * This method registers a film with the information in the fields
	 * @param event
	 * @throws EmptyFieldsException
	 * @throws ExistingFilmException
	 */
	@FXML
    void registerFilm(ActionEvent event) throws EmptyFieldsException, ExistingFilmException{
		String movieName = filmNameTF.getText();
		String hours = hoursCB.getValue();
		String minutes = minutesCB.getValue();
		if (!Main.cine.validateFilm(movieName, hours, minutes)) {
			clearTFs();
		} else {
			Main.cine.registerFilm(movieName, hours, minutes);
			Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
			alert.setHeaderText("Película añadida");
			alert.setTitle("Película añadida!");
			alert.setContentText("La película " + filmNameTF.getText() + " ha sido añadida con éxito");
			Optional<ButtonType> result = alert.showAndWait();
			clearTFs();
			
			
		}
    }

	
	/**
	 * This method clears the elements that contain text in the interface
	 */
	public void clearTFs() {
		filmNameTF.setText("");
		hoursCB.setValue(null);
		minutesCB.setValue(null);
		//after setting fields as empty
		hoursCB.setValue("");
		minutesCB.setValue("");
	}
}
