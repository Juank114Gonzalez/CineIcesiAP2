package control;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

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
	public static String root = "data/data.temp";
	
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
    private Button registerBTN;

    
    //Labels
    @FXML
    private Label loginLB;
    
    
    //Images
    @FXML
    private ImageView logoIMG;

    
    //Anchor pane
    @FXML
    private AnchorPane mainAP;

    

    /**
     * This method registers an user when the Button called "registerBTN" has been pressed
     * @param event, event getter
     */
    @FXML
    void registerUser(ActionEvent event) {
    	boolean validReg = true;
    	User userTemp = new User(nameRegisterTF.getText(),idTF.getText(),passwordTF.getText());
    	if(nameRegisterTF.getText().equals("") || idTF.getText().equals("") || passwordTF.getText().equals("")) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			validReg = false;
    		alert.setTitle("Error al añadir!");
            alert.setContentText("Ha ocurido un error al momento de añadir al usuario");
            Optional<ButtonType> result = alert.showAndWait();
		}else if (UserData.data.contains(userTemp)) {
			validReg = false;
			Alert alert = new Alert(Alert.AlertType.WARNING);
    		alert.setTitle("Usuario Existente!");
            alert.setContentText("Está intentando añadir un usuario existente");
            Optional<ButtonType> result = alert.showAndWait();
		}else if (detectSpaces( idTF.getText() ) || detectSpaces( passwordTF.getText() )){
			validReg = false;
			Alert alert = new Alert(Alert.AlertType.WARNING);
    		alert.setTitle("Campos inválidos!");
            alert.setContentText("Ingresó un espacio en alguno de los campos (ID, PASSWORD)");
            Optional<ButtonType> result = alert.showAndWait();
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
		
	}
}