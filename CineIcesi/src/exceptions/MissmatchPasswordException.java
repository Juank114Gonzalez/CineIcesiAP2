package exceptions;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class MissmatchPasswordException extends Exception {
	public MissmatchPasswordException() {
		super();
		Alert alert = new Alert(Alert.AlertType.WARNING);
		alert.setHeaderText("Contraseña errónea");
		alert.setTitle("Error de confirmación de contraseña");
        alert.setContentText("las contraseñas no coinciden");
        Optional<ButtonType> result = alert.showAndWait();
	}
}
