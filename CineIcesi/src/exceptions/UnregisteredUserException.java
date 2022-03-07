package exceptions;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class UnregisteredUserException extends Exception{

	public UnregisteredUserException() {
		super();
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Error al ingresar!");
	    alert.setContentText("El usuario no existe en la base de datos.\n\n"
	    					+"Para registrar haga click en registrar");
	    Optional<ButtonType> result = alert.showAndWait();
	}

	
}