package control;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import exceptions.UnregisteredUserException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import model.CineController;
import model.User;

public class MainWindow implements Initializable {

	// Anchor pane
	@FXML
	private AnchorPane mainAP;

	// Text fields
	@FXML
	private TextField idTF;
	@FXML
	private PasswordField passwordTF;

	// Buttons
	@FXML
	private Button loginBTN;

	@FXML
	private Button registerBTN;

	// Labels
	@FXML
	private Label loginLB;

	// Images
	@FXML
	private ImageView logoIMG;
	@FXML
	private ImageView bgIMG;
	@FXML
	private ImageView bgIMG2;

	/*
	 * -----------------------------------------------Methods-----------------------
	 * ------------------------
	 */
	/**
	 * This method allows to a registered user go to index window
	 * 
	 * @param event
	 * @throws UnregisteredUserException
	 * @throws IOException
	 */
	@FXML
	void login(ActionEvent event) throws UnregisteredUserException, IOException {
		if (checkUserExists(idTF.getText(), passwordTF.getText())) {
			launchIndex(event);
		} else {
			MainController.flag = "login";
			new UnregisteredUserException(event);
		}

	}

	/**
	 * This method launches the index window
	 * 
	 * @param event
	 * @throws IOException
	 */
	public void launchIndex(ActionEvent event) {
		MainController.launchIndex(event);
	}

	/**
	 * This method checks if an user exists
	 * 
	 * @param id
	 * @param pass
	 * @return
	 */
	public boolean checkUserExists(String id, String pass) {
		boolean out = false;
		for (User user : CineController.userData) {
			if (user.getUserID().equals(id) && user.getPassword().equals(pass)) {
				MainController.loggedUser = user;
				out = true;
				break;
			}
		}
		return out;
	}

	/**
	 * This method launches register user window when a button is pressed
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void register(ActionEvent event) throws IOException {
		MainController.flag = "login";
		launchRegisterWindow(event);
	}

	/**
	 * This method launches register user window
	 * 
	 * @param event
	 * @throws IOException
	 */
	void launchRegisterWindow(ActionEvent event) {
		MainController.launchRegisterWindow(event);

	}

	/**
	 * This method initializes the windows
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}