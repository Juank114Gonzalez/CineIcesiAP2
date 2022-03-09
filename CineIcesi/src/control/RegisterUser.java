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
	void registerUser(ActionEvent event) throws EmptyFieldsException, ExistingUserException, SpaceCharactersException {
		boolean validReg = true;
		if (nameRegisterTF.getText().equals("") || idTF.getText().equals("") || passwordTF.getText().equals("")) {
			new EmptyFieldsException();
			validReg = false;
		} else if (checkUserExists(idTF.getText())) {
			validReg = false;
			new ExistingUserException(idTF.getText());
		} else if (detectSpaces(idTF.getText()) || detectSpaces(passwordTF.getText())) {
			validReg = false;
			new SpaceCharactersException();
		}

		if (!validReg) {
			clearTFs();
		} else {
			CineController.userData.add(new User(nameRegisterTF.getText(), idTF.getText(), passwordTF.getText()));
			saveAsJavaByteCode();
			System.out.println(CineController.userData);
			Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
			alert.setTitle("Usuario añadido!");
			alert.setContentText("El usuario " + nameRegisterTF.getText() + " ha sido añadido con éxito");
			Optional<ButtonType> result = alert.showAndWait();
			if (MainController.flag.equals("login") ) {
				openLoginAgain(event);
				clearTFs();
			}
			
		}
	}

	/**
	 * This method checks if any user has the id entered as parameter
	 * 
	 * @param id, String, id of the user
	 * @return out, boolean, true if there is any user
	 */
	public boolean checkUserExists(String id) {
		boolean out = false;
		for (User user : CineController.userData) {
			if (user.getUserID().equals(id)) {
				out = true;
				break;

			}
		}
		return out;
	}

	/**
	 * This method saves all the data contained on the ArrayList "CineController.userData"
	 */
	public void saveAsJavaByteCode() {
		try {
			ArrayList<User> userList = CineController.userData;
			File ref = new File(MainController.userDataPath);
			FileOutputStream fos = new FileOutputStream(ref);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(userList);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
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
	 * This method detects spaces in a string and returns a boolean
	 * 
	 * @param parameter, String, it is the string that may have a space
	 * @return out, Boolean, it is true if there is any space into the string, false
	 *         otherwise
	 */
	public boolean detectSpaces(String parameter) {
		boolean out = false;
		for (int i = 0; i < parameter.length(); i++) {
			if (parameter.charAt(i) == ' ') {
				out = true;
				break;
			}
		}
		return out;
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