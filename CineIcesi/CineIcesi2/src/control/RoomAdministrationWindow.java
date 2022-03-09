package control;

import java.io.IOException;
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

	/***************************************************************************
	 * * Methods * *
	 **************************************************************************/
	@FXML
	void openBigRoomWindow(ActionEvent event) throws IOException {
		//MainController.launchCroquisWindowBig(event);
	}

	@FXML
	void openMiniRoomWindow(ActionEvent event) throws IOException {
		MainController.launchMiniRoomChairSelectorWindow(event);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
