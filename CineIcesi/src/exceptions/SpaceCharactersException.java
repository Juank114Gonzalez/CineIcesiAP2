package exceptions;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class SpaceCharactersException extends Exception{
	public SpaceCharactersException() {
		Alert alert = new Alert(Alert.AlertType.WARNING);
		alert.setTitle("Campos inválidos!");
        alert.setContentText("Ingresó un espacio en alguno de los campos (ID, PASSWORD)");
        Optional<ButtonType> result = alert.showAndWait();
	}
}
