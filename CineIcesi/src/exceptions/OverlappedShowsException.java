package exceptions;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class OverlappedShowsException extends Exception{

	public OverlappedShowsException() {
		super();
		Alert alert = new Alert(Alert.AlertType.WARNING);
		alert.setTitle("Error al a�adir!");
        alert.setContentText("La funci�n se superpone con alguna otra registrada actualmente");
        Optional<ButtonType> result = alert.showAndWait();
	}

	
}