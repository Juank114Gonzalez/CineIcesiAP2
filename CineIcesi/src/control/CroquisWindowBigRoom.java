package control;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class CroquisWindowBigRoom implements Initializable {

	@FXML
	private Button btn00;

	@FXML
	private Button btn01;

	@FXML
	private Button btn02;

	@FXML
	private Button btn03;

	@FXML
	private Button btn04;

	@FXML
	private Button btn05;

	@FXML
	private Button btn06;

	@FXML
	private Button btn10;

	@FXML
	private Button btn11;

	@FXML
	private Button btn12;

	@FXML
	private Button btn13;

	@FXML
	private Button btn14;

	@FXML
	private Button btn15;

	@FXML
	private Button btn16;

	@FXML
	private Button btn20;

	@FXML
	private Button btn21;

	@FXML
	private Button btn22;

	@FXML
	private Button btn23;

	@FXML
	private Button btn24;

	@FXML
	private Button btn25;

	@FXML
	private Button btn26;

	@FXML
	private Button btn30;

	@FXML
	private Button btn31;

	@FXML
	private Button btn32;

	@FXML
	private Button btn33;

	@FXML
	private Button btn34;

	@FXML
	private Button btn35;

	@FXML
	private Button btn36;

	@FXML
	private GridPane mainGP;

	@FXML
	void chairsPressBTN(ActionEvent event) {
		if(event.getSource().equals(btn00)) {
			btn00.setStyle("-fx-background-color: #ff0000; ");
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}
	@FXML
    void changeColor(MouseEvent event) {
		Button myButton = (Button)event.getSource();
		myButton.setStyle("-fx-background-color: #ff0000; ");
    }

}