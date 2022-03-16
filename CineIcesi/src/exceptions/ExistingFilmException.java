package exceptions;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class ExistingFilmException extends Exception {
	public ExistingFilmException(String filmName) {
		super();
		Alert alert = new Alert(Alert.AlertType.WARNING);
		alert.setHeaderText("Pel�cula Existente");
		alert.setTitle("Pel�cula Existente");
        alert.setContentText("Ya hay una pelicula registrada con este nombre " + "\"" + filmName + "\"");
        Optional<ButtonType> result = alert.showAndWait();
	}
}
