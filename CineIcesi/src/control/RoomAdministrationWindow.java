package control;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class RoomAdministrationWindow implements Initializable {

	@FXML
	private ImageView bgIMG;

	@FXML
	private Button bigRoomBTN;

	@FXML
	private ImageView cineIMG;

	@FXML
	private ImageView cineIMG1;

	@FXML
	private Button miniRoomBTN;

	@FXML
	void openBigRoomWindow(ActionEvent event) {
		MainController.launchCroquisWindoBig(event);
	}

	@FXML
	void openMiniRoomWindow(ActionEvent event) {
		MainController.launchCroquisWindoMiniRoom(event);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
