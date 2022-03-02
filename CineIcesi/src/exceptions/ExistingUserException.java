package exceptions;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class ExistingUserException extends Exception {
	public ExistingUserException() {
		super();
		Alert alert = new Alert(Alert.AlertType.WARNING);
		alert.setTitle("Usuario Existente!");
        alert.setContentText("Está intentando añadir un usuario existente");
        Optional<ButtonType> result = alert.showAndWait();
	}
}
