package control;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import model.CineIcesiController;

public class RegisterShow implements Initializable {

   @FXML
    private ChoiceBox<?> availableRoomCB;

    @FXML
    private DatePicker datePickerDP;

    @FXML
    private TextField durationShowTF;

    @FXML
    private ChoiceBox<String> filmListCB;

    @FXML
    private TextField startTimeTF;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	public void fullFilmListCB() {
		filmListCB.getItems().addAll(CineIcesiController.catalogueFilm.toString());
	}

}
