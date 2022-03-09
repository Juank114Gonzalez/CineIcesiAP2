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
import exceptions.ExistingFilmException;
import exceptions.SpaceCharactersException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import model.CineController;
import model.Movie;
import model.User;


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
		
		
		// TODO Auto-generated method stub
		
		//This loop fills the hours ArrayList with the numbers from 0:00 to 23:00
		for(int i = 0; i<24; i++) {
			hours.add((i) + ":00");
		}
		for(int i = 0; i<60; i= i+5) {
			minutes.add(""+(i));
		}
		fillHoursCB();
		fillMinutesCB();
		
	}
	
	@FXML
    void registerFilm(ActionEvent event) throws EmptyFieldsException, ExistingFilmException{
		boolean validReg = true;
		if (filmNameTF.getText().equals("") || hoursCB.getValue().equals(null) || minutesCB.getValue().equals(null)) {
			new EmptyFieldsException();
			validReg = false;
		} else if (checkMovieExists(filmNameTF.getText())) {
			validReg = false;
			new ExistingFilmException(filmNameTF.getText());
		}

		if (!validReg) {
			clearTFs();
		} else {
			String time = hoursCB.getValue() + ":" + minutesCB.getValue();
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
			Date duration = null;
			try {
				duration = sdf.parse(time);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			CineController.catalogue.add(new Movie(filmNameTF.getText(),duration));
			saveAsJavaByteCode();
			System.out.println(CineController.catalogue);
			Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
			alert.setHeaderText("Película añadida");
			alert.setTitle("Película añadida!");
			alert.setContentText("La película " + filmNameTF.getText() + " ha sido añadida con éxito");
			Optional<ButtonType> result = alert.showAndWait();
			clearTFs();
			
			
		}
    }
	
	/**
	 * This method saves all the data contained on the ArrayList "CineController.catalogue"
	 */
	public void saveAsJavaByteCode() {
		try {
			ArrayList<Movie> movieList = CineController.catalogue;
			File ref = new File(MainController.movieDataPath);
			FileOutputStream fos = new FileOutputStream(ref);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(movieList);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method checks if a movie is currently registered
	 * @param a
	 * @return
	 */
	public boolean checkMovieExists(String movieName) {
		boolean out = false;
		for(Movie film:  CineController.catalogue) {
			if(film.getName().equals(movieName)) {
				out = true;
				break;
			}
		}
		return out;
		
	}
	
	/**
	 * This method clears the elements that contain text in the interface
	 */
	public void clearTFs() {
		filmNameTF.setText(null);
		hoursCB.setValue(null);
		minutesCB.setValue(null);
	}
}
