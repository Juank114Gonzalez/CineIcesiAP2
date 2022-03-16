package control;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import model.CineController;
import model.MovieShow;
import model.RoomType;

public class RoomAdministrationWindow implements Initializable {

	
	@FXML
	private ImageView bgIMG;

	@FXML
	public Button bigRoomBTN;
	
	@FXML
	private Button back_BTN;

	@FXML
	private ImageView cineIMG;

	@FXML
	private ImageView cineIMG1;

	@FXML
	public static Button miniRoomBTN;

	/***************************************************************************
	 * * Methods * *
	 **************************************************************************/
	@FXML
	void openNormalRoomWindow(ActionEvent event) throws IOException {
		MainController.flag = "Normal";
		MainController.launchSelectFunctionWindow(event);
	}

	@FXML
	void openMiniRoomWindow(ActionEvent event) throws IOException {
		MainController.flag = "Mini";
		MainController.launchSelectFunctionWindow(event);
	}
	
	
	/**
	 * This method launches the previous window
	 */
	@FXML
	void goBack(ActionEvent event) {
		MainController.launchIndex(event);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
