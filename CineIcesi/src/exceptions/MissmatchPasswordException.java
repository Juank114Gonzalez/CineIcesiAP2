package exceptions;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class MissmatchPasswordException extends Exception {
	public MissmatchPasswordException() {
		super();
		Alert alert = new Alert(Alert.AlertType.WARNING);
		alert.setHeaderText("Contrase�a err�nea");
		alert.setTitle("Error de confirmaci�n de contrase�a");
        alert.setContentText("las contrase�as no coinciden");
        Optional<ButtonType> result = alert.showAndWait();
	}
}
