package control;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import model.User;

public class MainWindow implements Initializable{
	
	//Attributes
	private User genericUser = new User("Pepe","A00342422");
	
	//Anchor pane
	@FXML
    private AnchorPane mainAP;
	
	
	//Text fields
	@FXML
    private TextField idTF;
	@FXML
    private PasswordField passwordTF;

    
	//Buttons
	@FXML
    private Button loginBTN;
   
    @FXML
    private Button registerBTN;
    
    
    //Labels
    @FXML
    private Label loginLB;
    
    
    //Images
    @FXML
    private ImageView logoIMG;


    /*
   -----------------------------------------------Methods-----------------------------------------------
   */
    @FXML
    void pressBTN(ActionEvent event) {
    	if(event.getSource()== loginBTN) {
    		if(passwordTF.getText().equals(genericUser.getPassword()) && idTF.getText().equals(genericUser.getUserID()) ) {
    			
    		}
    	}
    	if(event.getSource() == registerBTN) {
    		RegisterUser window = new RegisterUser();
    		window.setVisible(true);
    	}
    }
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

	
}