package exceptions;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class ExistingUserException extends Exception {
	public ExistingUserException(String id) {
		super();
		Alert alert = new Alert(Alert.AlertType.WARNING);
		alert.setTitle("Usuario Existente!");
        alert.setContentText("Ya hay un usuario registrado con este ID " + "\"" + id + "\"");
        Optional<ButtonType> result = alert.showAndWait();
	}
}
