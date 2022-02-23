package control;

import java.io.IOException;
import java.net.URL;
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
	private User genericUser;
	
	
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

    

    @FXML
    void registerUser(ActionEvent event) {
    	boolean flag = false;
    	if(nameRegisterTF.getText().equals("") || idTF.getText().equals("") || passwordTF.getText().equals("") || nameRegisterTF.getText().equals(" ") || idTF.getText().equals(" ") || passwordTF.getText().equals(" ")) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
    		alert.setTitle("Error al añadir!");
            alert.setContentText("Ha ocurido un error al momento de añadir al usuario");
            Optional<ButtonType> result = alert.showAndWait();
		}else {
			genericUser = new User(nameRegisterTF.getText(), idTF.getText(),passwordTF.getText());
			if(!UserData.data.contains(genericUser)) {
				UserData.data.add(genericUser);
				flag = true;
			}
			//Usar serialización para validar en la dataBase
    		if(flag) {
    			Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        		alert.setTitle("Usuario añadido!");
                alert.setContentText("El usuario "+ nameRegisterTF.getText() + " ha sido añadido con éxito");
                Optional<ButtonType> result = alert.showAndWait();
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
        		
    		}else {
    			Alert alert = new Alert(Alert.AlertType.WARNING);
        		alert.setTitle("Usuario Existente!");
                alert.setContentText("Está intentando añadir un usuario existente");
                Optional<ButtonType> result = alert.showAndWait();
    		}
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
}
