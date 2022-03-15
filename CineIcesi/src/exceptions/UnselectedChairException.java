package exceptions;

import java.util.Optional;

import control.MainController;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class UnselectedChairException extends Exception{

	public UnselectedChairException() {
		super();
		Alert alert = new Alert(Alert.AlertType.WARNING);
		alert.setTitle("Selecciona una silla!");
	    alert.setContentText("Debe seleccionar una silla para continuar");
	    Optional<ButtonType> result = alert.showAndWait();
	  
	}

	
}