package control;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import model.Chair;
import model.ChairStatus;

public class CroquisWindowBigRoom implements Initializable {

	public Chair[][] chairs = new Chair[7][4];

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
		if (event.getSource().equals(btn00)) {
			btn00.setStyle("-fx-background-color: #ff0000; ");
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		setChairBTNs();
	}

	void setChairBTNs() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 7; j++) {
				String name = "btn" + i + j;
				Button btn = new Button("-fx-id: " + name + "; ");
				if (chairs[i][j] != null) {
					chairs[i][j].setChairButton(btn);
					mainGP.add(chairs[i][j].getChairButton(), i, j);
				} else if (chairs[i][j] == null) {
					System.out.println("a");
				}
			}
		}
	}

	/*
	 * void setChairBTNs(){ chairs[0][0].setChairButton(btn00);
	 * chairs[0][1].setChairButton(btn01); chairs[0][2].setChairButton(btn02);
	 * chairs[0][3].setChairButton(btn03); chairs[0][4].setChairButton(btn04);
	 * chairs[0][5].setChairButton(btn05); chairs[0][6].setChairButton(btn06);
	 * chairs[1][0].setChairButton(btn10); chairs[1][1].setChairButton(btn11);
	 * chairs[1][2].setChairButton(btn12); chairs[1][3].setChairButton(btn13);
	 * chairs[1][4].setChairButton(btn14); chairs[1][5].setChairButton(btn15);
	 * chairs[1][6].setChairButton(btn16); chairs[2][0].setChairButton(btn20);
	 * chairs[2][1].setChairButton(btn21); chairs[2][2].setChairButton(btn22);
	 * chairs[2][3].setChairButton(btn23); chairs[2][4].setChairButton(btn24);
	 * chairs[2][5].setChairButton(btn25); chairs[2][6].setChairButton(btn26);
	 * chairs[3][0].setChairButton(btn30); chairs[3][1].setChairButton(btn31);
	 * chairs[3][2].setChairButton(btn32); chairs[3][3].setChairButton(btn33);
	 * chairs[3][4].setChairButton(btn34); chairs[3][5].setChairButton(btn35);
	 * chairs[3][6].setChairButton(btn36); }
	 */

	/**
	 * This method changes button color
	 * 
	 * @param event
	 */
	@FXML
	void changeColor(MouseEvent event) {
		Button myButton = (Button) event.getSource();
		myButton.setStyle("-fx-background-color: #ff0000; " + "-fx-background-radius: 100");
		int i = 0;
		int j = 0;
		for (i = 0; i < 4; i++) {
			for (j = 0; j < 7; j++) {
				if (chairs[i][j].getChairButton().equals(myButton)) {
					chairs[i][j].setStatus(ChairStatus.UNAVAILABLE);
					break;
				}
			}
		}

		if (chairs[i][j].getStatus().equals(ChairStatus.UNAVAILABLE)) {
			System.out.println("Si sirve... Pene?");
		}
	}

}