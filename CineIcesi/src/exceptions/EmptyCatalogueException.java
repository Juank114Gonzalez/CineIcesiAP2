package exceptions;

import java.util.Optional;

import control.MainController;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class EmptyCatalogueException extends Exception{
	
	public EmptyCatalogueException(ActionEvent event ) {
		super();
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Catálogo vacío!");
        alert.setContentText("Debe registrar al menos una película en el catálogo para registrar una función");
        Optional<ButtonType> result = alert.showAndWait();
        
        MainController.launchRegisterFilm(event);
	}
}
