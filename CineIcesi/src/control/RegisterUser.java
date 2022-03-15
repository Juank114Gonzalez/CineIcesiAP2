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
import exceptions.ExistingUserException;
import exceptions.MissmatchPasswordException;
import exceptions.SpaceCharactersException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import main.Main;
import model.CineController;
import model.User;
public class RegisterUser implements Initializable {

	// Text Fields
	@FXML
	private PasswordField confirmPasswordTF;
	@FXML
	private TextField idTF;
	@FXML
	private TextField nameRegisterTF;
	@FXML
	private PasswordField passwordTF;

	// Buttons
	@FXML
	private Button back_BTN;
	@FXML
	private Button registerBTN;

	// Labels
	@FXML
	private Label loginLB;

	// Images
	@FXML
    private ImageView back_IMG;
	@FXML
	private ImageView logoIMG;
	@FXML
	private ImageView bgIMG;
	@FXML
	private ImageView bgIMG2;

	// Anchor pane
	@FXML
	private AnchorPane mainAP;
	
	
	
	/**
	 * This method registers an user when the Button called "registerBTN" has been
	 * pressed
	 * 
	 * @param event, event getter
	 */
	@FXML
	void registerUser(ActionEvent event) throws EmptyFieldsException, ExistingUserException, SpaceCharactersException, MissmatchPasswordException{
		String name = nameRegisterTF.getText();
		String id = idTF.getText();
		String password = passwordTF.getText();
		String confirmPassword = confirmPasswordTF.getText();
		if (!Main.cine.validateUser(name, id, password, confirmPassword)) {
			clearTFs();
		} else {
			Main.cine.registerUser(name, id, password);
			Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
			alert.setTitle("Usuario añadido!");
			alert.setContentText("El usuario " + nameRegisterTF.getText() + " ha sido añadido con éxito");
			Optional<ButtonType> result = alert.showAndWait();
			if (MainController.flag.equals("login") ) {
				openLoginAgain(event);
			}
			clearTFs();
			
		}
	}
	/**
	 * This method opens the login window after registering an User successfully
	 * 
	 * @param event, event getter
	 * @throws IOException
	 */
	public void openLoginAgain(ActionEvent event) {
		MainController.launchLogin(event);

	}

	/**
	 * This method launches index window
	 * 
	 * @param event
	 */
	public void launchIndex(ActionEvent event) {
		MainController.launchIndex(event);

	}

	/**
	 * This method launches the previous window
	 * 
	 * @param event
	 */
	@FXML
	void goBack(ActionEvent event) {
		if (MainController.flag.equals("login")) {
			openLoginAgain(event);
		} else if (MainController.flag.equals("Index")) {
			launchIndex(event);
		}
	}

	/**
	 * This method clears all the text fields
	 */
	public void clearTFs() {
		confirmPasswordTF.setText("");
		idTF.setText("");
		nameRegisterTF.setText("");
		passwordTF.setText("");
	}

	/**
	 * This method initializes the window
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	}
}