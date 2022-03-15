package control;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import exceptions.UnregisteredUserException;
import exceptions.WrongPasswordException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import main.Main;
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

	
	/***************************************************************************
	 * * Methods * *
	 **************************************************************************/
	
	
	/**
	 * This method allows to a registered user go to index window
	 * 
	 * @param event, ActionEvent, it gets the event source of the button
	 * @throws UnregisteredUserException
	 * @throws IOException
	 */
	@FXML
	void login(ActionEvent event) throws UnregisteredUserException, IOException {
		if (Main.cine.checkUserExists(idTF.getText(), passwordTF.getText())) {
			launchIndex(event);
		}else if(Main.cine.wrongPassword(idTF.getText(), passwordTF.getText())) {
			new WrongPasswordException();
			clearTFs();
		}
		else {
			MainController.flag = "login";
			new UnregisteredUserException(event);
		}

	}
	

	/**
	 * This method launches the index window
	 * 
	 * @param event, ActionEvent, it gets the event source of the button
	 * @throws IOException
	 */
	public void launchIndex(ActionEvent event) {
		MainController.launchIndex(event);
	}


	/**
	 * This method launches register user window when a button is pressed
	 * 
	 * @param event, ActionEvent, it gets the event source of the button
	 * @throws IOException
	 */
	@FXML
	void register(ActionEvent event) throws IOException {
		MainController.flag = "login";
		launchRegisterWindow(event);
	}

	/**
	 * Clears the text of all the elements
	 */
	public void clearTFs() {
		passwordTF.setText(null);
		// after setting the fields as empty
		passwordTF.setText("");

	}
	
	/**
	 * This method launches register user window
	 * 
	 * @param event, ActionEvent, it gets the event source of the button
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