package control;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import com.google.gson.Gson;

import exceptions.EmptyFieldsException;
import exceptions.ExistingUserException;
import exceptions.SpaceCharactersException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import main.Main;
import model.User;
import model.UserData;

public class RegisterUser implements Initializable{

	//Attributes
	public static String root = "data/data.txt";
	
	//Text Fields
	@FXML
    private PasswordField confirmPasswordTF;
    @FXML
    private TextField idTF;
    
    @FXML
    private TextField nameRegisterTF;
    @FXML
    private PasswordField passwordTF;
    
    
    //Buttons
    @FXML
    private Button back_BTN;
    @FXML
    private Button registerBTN;

    
    //Labels
    @FXML
    private Label loginLB;
    
    
    //Images
    @FXML
    private ImageView logoIMG;
    @FXML
    private ImageView bgIMG;
    @FXML
    private ImageView bgIMG2;


    
    //Anchor pane
    @FXML
    private AnchorPane mainAP;

    

    /**
     * This method registers an user when the Button called "registerBTN" has been pressed
     * @param event, event getter
     */
    @FXML
    void registerUser(ActionEvent event) throws EmptyFieldsException, ExistingUserException, SpaceCharactersException {
    	boolean validReg = true;
    	User userTemp = new User(nameRegisterTF.getText(),idTF.getText(),passwordTF.getText());
    	if(nameRegisterTF.getText().equals("") || idTF.getText().equals("") || passwordTF.getText().equals("")) {
			new EmptyFieldsException();
			validReg = false;
		}else if (checkUserExists(idTF.getText())) {
			validReg = false;
			new ExistingUserException();
		}else if (detectSpaces( idTF.getText() ) || detectSpaces( passwordTF.getText() )){
			validReg = false;
			new SpaceCharactersException();
		}
    	
    	if(!validReg) {
    		clearTFs();
    	}else {
    			UserData.data.add(new User(nameRegisterTF.getText(), idTF.getText(), passwordTF.getText()));
    			saveAsJavaByteCode();
    			System.out.println(UserData.data);
    			Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        		alert.setTitle("Usuario añadido!");
                alert.setContentText("El usuario "+ nameRegisterTF.getText() + " ha sido añadido con éxito");
                Optional<ButtonType> result = alert.showAndWait();
                openLoginAgain(event);
    		}
	}

    /**
     * This method checks if any user has the id entered as parameter
     * @param id, String, id of the user
     * @return out, boolean, true if there is any user 
     */
    public boolean checkUserExists(String id) {
    	boolean out = false;
    	for(User user : UserData.data) {
    		if(user.getUserID().equals(id)) {
    			out= true;
    			break;
    			
    		}
    	}
    	return out;
    }
    
    public void saveJSON() throws IOException {
    	try {
    	Gson gson = new Gson();
    	String json = gson.toJson(UserData.data);
    	System.out.println(json);
    	File file = new File("data/data.json");
    	FileOutputStream fos = new FileOutputStream(file);
    	try {
			fos.write(json.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    /**
     * This method saves data contained on ArrayList "UserData.data"
     */
    public void saveAsJavaByteCode() {
    	try {
    		ArrayList<User> userList = UserData.data;
    		File ref = new File(root);
	    	FileOutputStream fos = new FileOutputStream(ref);
	    	ObjectOutputStream oos = new ObjectOutputStream(fos);
	    	oos.writeObject(userList);
	    	oos.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
    	
    	
    
    }
    /**
     * This method opens the login window after registering an User successfully
     * @param event, event getter
     */
    public void openLoginAgain(ActionEvent event) {
    	 try {
 			FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/MainWindow.fxml"));
 			Parent parent = (Parent) loader.load();
 			
 			Stage stage = new Stage();
 			
 			Scene scene = new Scene(parent);
 			
 			stage.setScene(scene);
 			
 			stage.show();
 			
 			try {
 	    		Node source = (Node)event.getSource();
 	    		Stage old = (Stage) source.getScene().getWindow();
 	    		old.close();
 	    	}catch(Exception e){
 	    		e.printStackTrace();
 	    	}
 		} catch (IOException e) {
 			// TODO: handle exception
 			e.printStackTrace();
 		}
    }
    
    /**
     * This method detects spaces in a string and returns a boolean
     * @param parameter, String, it is the string that may have a space
     * @return out, Boolean, it is true if there is any space into the string, false otherwise
     */
    public boolean detectSpaces (String parameter) {
    	boolean out = false;
    	for (int i = 0; i < parameter.length(); i++) {
    		if(parameter.charAt(i) == ' ') {
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
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		try {
			saveJSON();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}