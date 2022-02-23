package control;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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

public class RegisterUser extends Application implements Initializable{

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
    void pressBTN(ActionEvent event) {
    	if(event.getSource() == registerBTN) {
    		genericUser = new User(nameRegisterTF.getText(), idTF.getText(),passwordTF.getText());
    		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    		alert.setTitle("Alert!");
            alert.setContentText("This is an alert");
            Optional<ButtonType> result = alert.showAndWait();

    		launch();
    	}else {}
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("MainWindow.fxml"));
			Parent parent = (Parent) loader.load();
			
			Stage stage = new Stage();
			
			Scene scene = new Scene(parent);
			
			stage.setScene(scene);
			
			stage.show();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
