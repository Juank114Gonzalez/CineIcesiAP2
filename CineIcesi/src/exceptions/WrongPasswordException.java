package exceptions;

import java.util.Optional;

import control.MainController;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class WrongPasswordException extends Exception{

	public WrongPasswordException() {
		super();
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Contrase�a incorrecta!");
	    alert.setContentText("La contrase�a no coincide con el ID digitado.");
	    Optional<ButtonType> result = alert.showAndWait();
	  
	}

	
}