package control;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import exceptions.EmptyFieldsException;
import exceptions.UnselectedChairException;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import main.Main;
import model.CineController;
import model.Customer;
import model.MovieShow;

public class NormalRoomWindow implements Initializable{
	
	public static MovieShow movieShow;
	public static int[] position;

	
	@FXML
	private ImageView bgIMG;

	@FXML
	private TextField nameTF;

	@FXML
	private TextField idTF;

	@FXML
	private Pane roomP;

	@FXML
	private Button back_BTN;

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
    private Button btn40;

    @FXML
    private Button btn41;

    @FXML
    private Button btn42;

    @FXML
    private Button btn43;

    @FXML
    private Button btn44;

    @FXML
    private Button btn45;

    @FXML
    private Button btn46;

    @FXML
    private Button btn50;

    @FXML
    private Button btn51;

    @FXML
    private Button btn52;

    @FXML
    private Button btn53;

    @FXML
    private Button btn54;

    @FXML
    private Button btn55;

    @FXML
    private Button btn56;
    
    @FXML
	private Button assignChairBTN;
    
    
    /**
	 * This method gets the position of the show in the static ArrayList
	 * "CineController.shows"
	 * 
	 * @return movieId, int, this is the id of the show into the arraylist
	 */
	public int getMovieShowPosition() {
		int movieId = 0;
		for (int i = 0; i < Main.cine.shows.size(); i++) {
			if (Main.cine.shows.get(i).equals(movieShow)) {
				movieId = i;
				break;
			}
		}
		return movieId;
	}

	/**
	 * This method assigns the selected chair in the room to user who is registering
	 * @param event
	 */
	@FXML
	void assignChair(ActionEvent event) throws EmptyFieldsException, UnselectedChairException {
		boolean validReg = true;

		if (nameTF.getText().equals("") || idTF.getText().equals("")) {
			new EmptyFieldsException();
			validReg = false;
		} else if (position == null) {
			validReg = false;
			new UnselectedChairException();
		}

		if (!validReg) {
			clearTFs();
		} else {
			Main.cine.shows.get((getMovieShowPosition())).addCustomer(position,
					new Customer(nameTF.getText(), idTF.getText()));
			Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
			alert.setHeaderText("Cliente añadido");
			alert.setTitle("Asiento asignado!");
			alert.setContentText("El cliente ha sido asignado correctamente a la silla seleccionada");
			Optional<ButtonType> result = alert.showAndWait();
			clearTFs();
			saveAsJavaByteCode();
		}
		resetButtonConfig(Main.cine.shows.get((getMovieShowPosition())));
	}

	/**
	 * This method saves all the data contained on the ArrayList
	 * "CineController.shows"
	 */
	public void saveAsJavaByteCode() {
		try {
			ObservableList<MovieShow> showList = Main.cine.shows;
			File ref = new File(MainController.showsDataPath);
			FileOutputStream fos = new FileOutputStream(ref);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(new ArrayList<MovieShow>(showList));
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method gets the position of the chair selected in the interface, to its
	 * respective position on the Customers matrix
	 * 
	 * @param event, ActionEvent, this is the event of clicking some button
	 */
	@FXML
	public int[] getChairPosition(ActionEvent event) {
		int[] output = new int[2];
		resetButtonConfig(Main.cine.shows.get((getMovieShowPosition())));
		Button chair = (Button) event.getSource();
		chair.setStyle("-fx-background-color: #FF8300; -fx-background-radius: 50;");
		String chairId = chair.getId();
		String[] chairSplit = chairId.split("btn");
		String[] chairSplitTwice = chairSplit[1].split(";");
		int row = Character.getNumericValue(chairSplitTwice[0].charAt(0));
		int column = Character.getNumericValue(chairSplitTwice[0].charAt(1));
		output = new int[] { row, column };
		position = output;
		
		return output;
	}

	/**
	 * This method resets the configuration of the unselected buttons
	 */
	public void resetButtonConfig(MovieShow show) {
		if (show.getCustomers()[0][0] != null) {
			btn00.setStyle("-fx-background-color: #2424ff; -fx-background-radius: 50;");
			btn00.setDisable(true);
		} else {
			btn00.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 50;");
		}
		if (show.getCustomers()[0][1] != null) {
			btn01.setStyle("-fx-background-color: #2424ff; -fx-background-radius: 50;");
			btn01.setDisable(true);
		} else {
			btn01.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 50;");
		}
		if (show.getCustomers()[0][2] != null) {
			btn02.setStyle("-fx-background-color: #2424ff; -fx-background-radius: 50;");
			btn02.setDisable(true);
		} else {
			btn02.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 50;");
		}
		if (show.getCustomers()[0][3] != null) {
			btn03.setStyle("-fx-background-color: #2424ff; -fx-background-radius: 50;");
			btn03.setDisable(true);
		} else {
			btn03.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 50;");
		}
		if (show.getCustomers()[0][4] != null) {
			btn04.setStyle("-fx-background-color: #2424ff; -fx-background-radius: 50;");
			btn04.setDisable(true);
		} else {
			btn04.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 50;");
		}
		if (show.getCustomers()[0][5] != null) {
			btn05.setStyle("-fx-background-color: #2424ff; -fx-background-radius: 50;");
			btn05.setDisable(true);
		} else {
			btn05.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 50;");
		}
		if (show.getCustomers()[0][6] != null) {
			btn06.setStyle("-fx-background-color: #2424ff; -fx-background-radius: 50;");
			btn06.setDisable(true);
		} else {
			btn06.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 50;");
		}
		if (show.getCustomers()[1][0] != null) {
			btn10.setStyle("-fx-background-color: #2424ff; -fx-background-radius: 50;");
			btn10.setDisable(true);
		} else {
			btn10.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 50;");
		}
		if (show.getCustomers()[1][1] != null) {
			btn11.setStyle("-fx-background-color: #2424ff; -fx-background-radius: 50;");
			btn11.setDisable(true);
		} else {
			btn11.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 50;");
		}
		if (show.getCustomers()[1][2] != null) {
			btn12.setStyle("-fx-background-color: #2424ff; -fx-background-radius: 50;");
			btn12.setDisable(true);
		} else {
			btn12.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 50;");
		}
		if (show.getCustomers()[1][3] != null) {
			btn13.setStyle("-fx-background-color: #2424ff; -fx-background-radius: 50;");
			btn13.setDisable(true);
		} else {
			btn13.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 50;");
		}
		if (show.getCustomers()[1][4] != null) {
			btn14.setStyle("-fx-background-color: #2424ff; -fx-background-radius: 50;");
			btn14.setDisable(true);
		} else {
			btn14.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 50;");
		}
		if (show.getCustomers()[1][5] != null) {
			btn15.setStyle("-fx-background-color: #2424ff; -fx-background-radius: 50;");
			btn15.setDisable(true);
		} else {
			btn15.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 50;");
		}
		if (show.getCustomers()[1][6] != null) {
			btn16.setStyle("-fx-background-color: #2424ff; -fx-background-radius: 50;");
			btn16.setDisable(true);
		} else {
			btn16.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 50;");
		}
		if (show.getCustomers()[2][0] != null) {
			btn20.setStyle("-fx-background-color: #2424ff; -fx-background-radius: 50;");
			btn20.setDisable(true);
		} else {
			btn20.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 50;");
		}
		if (show.getCustomers()[2][1] != null) {
			btn21.setStyle("-fx-background-color: #2424ff; -fx-background-radius: 50;");
			btn21.setDisable(true);
		} else {
			btn21.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 50;");
		}
		if (show.getCustomers()[2][2] != null) {
			btn22.setStyle("-fx-background-color: #2424ff; -fx-background-radius: 50;");
			btn22.setDisable(true);
		} else {
			btn22.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 50;");
		}
		if (show.getCustomers()[2][3] != null) {
			btn23.setStyle("-fx-background-color: #2424ff; -fx-background-radius: 50;");
			btn23.setDisable(true);
		} else {
			btn23.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 50;");
		}
		if (show.getCustomers()[2][4] != null) {
			btn24.setStyle("-fx-background-color: #2424ff; -fx-background-radius: 50;");
			btn24.setDisable(true);
		} else {
			btn24.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 50;");
		}
		if (show.getCustomers()[2][5] != null) {
			btn25.setStyle("-fx-background-color: #2424ff; -fx-background-radius: 50;");
			btn25.setDisable(true);
		} else {
			btn25.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 50;");
		}
		if (show.getCustomers()[2][6] != null) {
			btn26.setStyle("-fx-background-color: #2424ff; -fx-background-radius: 50;");
			btn26.setDisable(true);
		} else {
			btn26.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 50;");
		}
		if (show.getCustomers()[3][0] != null) {
			btn30.setStyle("-fx-background-color: #2424ff; -fx-background-radius: 50;");
			btn30.setDisable(true);
		} else {
			btn30.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 50;");
		}
		if (show.getCustomers()[3][1] != null) {
			btn31.setStyle("-fx-background-color: #2424ff; -fx-background-radius: 50;");
			btn31.setDisable(true);
		} else {
			btn31.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 50;");
		}
		if (show.getCustomers()[3][2] != null) {
			btn32.setStyle("-fx3background-color: #2424ff; -fx-background-radius: 50;");
			btn32.setDisable(true);
		} else {
			btn32.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 50;");
		}
		if (show.getCustomers()[3][3] != null) {
			btn33.setStyle("-fx-background-color: #2424ff; -fx-background-radius: 50;");
			btn33.setDisable(true);
		} else {
			btn33.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 50;");
		}
		if (show.getCustomers()[3][4] != null) {
			btn34.setStyle("-fx-background-color: #2424ff; -fx-background-radius: 50;");
			btn34.setDisable(true);
		} else {
			btn34.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 50;");
		}
		if (show.getCustomers()[3][5] != null) {
			btn35.setStyle("-fx-background-color: #2424ff; -fx-background-radius: 50;");
			btn35.setDisable(true);
		} else {
			btn35.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 50;");
		}
		if (show.getCustomers()[3][6] != null) {
			btn36.setStyle("-fx-background-color: #2424ff; -fx-background-radius: 50;");
			btn36.setDisable(true);
		} else {
			btn36.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 50;");
		}
		if (show.getCustomers()[4][0] != null) {
			btn40.setStyle("-fx-background-color: #2424ff; -fx-background-radius: 50;");
			btn40.setDisable(true);
		} else {
			btn40.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 50;");
		}
		if (show.getCustomers()[4][1] != null) {
			btn41.setStyle("-fx-background-color: #2424ff; -fx-background-radius: 50;");
			btn41.setDisable(true);
		} else {
			btn41.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 50;");
		}
		if (show.getCustomers()[4][2] != null) {
			btn42.setStyle("-fx-background-color: #2424ff; -fx-background-radius: 50;");
			btn42.setDisable(true);
		} else {
			btn42.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 50;");
		}
		if (show.getCustomers()[4][3] != null) {
			btn43.setStyle("-fx-background-color: #2424ff; -fx-background-radius: 50;");
			btn43.setDisable(true);
		} else {
			btn43.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 50;");
		}
		if (show.getCustomers()[4][4] != null) {
			btn44.setStyle("-fx-background-color: #2424ff; -fx-background-radius: 50;");
			btn44.setDisable(true);
		} else {
			btn44.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 50;");
		}
		if (show.getCustomers()[4][5] != null) {
			btn45.setStyle("-fx-background-color: #2424ff; -fx-background-radius: 50;");
			btn45.setDisable(true);
		} else {
			btn45.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 50;");
		}
		if (show.getCustomers()[4][6] != null) {
			btn46.setStyle("-fx-background-color: #2424ff; -fx-background-radius: 50;");
			btn46.setDisable(true);
		} else {
			btn46.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 50;");
		}
		if (show.getCustomers()[5][0] != null) {
			btn50.setStyle("-fx-background-color: #2424ff; -fx-background-radius: 50;");
			btn50.setDisable(true);
		} else {
			btn50.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 50;");
		}
		if (show.getCustomers()[5][1] != null) {
			btn51.setStyle("-fx-background-color: #2424ff; -fx-background-radius: 50;");
			btn51.setDisable(true);
		} else {
			btn51.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 50;");
		}
		if (show.getCustomers()[5][2] != null) {
			btn52.setStyle("-fx-background-color: #2424ff; -fx-background-radius: 50;");
			btn52.setDisable(true);
		} else {
			btn52.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 50;");
		}
		if (show.getCustomers()[5][3] != null) {
			btn53.setStyle("-fx-background-color: #2424ff; -fx-background-radius: 50;");
			btn53.setDisable(true);
		} else {
			btn53.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 50;");
		}
		if (show.getCustomers()[5][4] != null) {
			btn54.setStyle("-fx-background-color: #2424ff; -fx-background-radius: 50;");
			btn54.setDisable(true);
		} else {
			btn54.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 50;");
		}
		if (show.getCustomers()[5][5] != null) {
			btn55.setStyle("-fx-background-color: #2424ff; -fx-background-radius: 50;");
			btn55.setDisable(true);
		} else {
			btn55.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 50;");
		}
		if (show.getCustomers()[5][6] != null) {
			btn56.setStyle("-fx-background-color: #2424ff; -fx-background-radius: 50;");
			btn56.setDisable(true);
		} else {
			btn56.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 50;");
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		resetButtonConfig(Main.cine.shows.get((getMovieShowPosition())));
	}
	
	/**
	 * This method launches the previous window
	 * @throws IOException 
	 */
	@FXML
	void goBack(ActionEvent event) throws IOException {
		MainController.launchSelectFunctionWindow(event);
	}

	public void clearTFs() {
		nameTF.setText("");
		idTF.setText("");
	}
	
}
