package control;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.EventObject;
import java.util.Optional;
import java.util.ResourceBundle;
import model.UserData;
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

public class MainWindow implements Initializable{
	
	//Attributes
	private User genericUser;
	
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
    void login(ActionEvent event) throws IOException {
    	if(checkUserExists(idTF.getText(),passwordTF.getText())) {
    		launchIndex(event);
    	}else {
    		Alert alert = new Alert(Alert.AlertType.ERROR);
    		alert.setTitle("Error al ingresar!");
            alert.setContentText("El usuario no existe en la base de datos.\n\n"
            					+"Para registrar haga click en registrar");
            Optional<ButtonType> result = alert.showAndWait();
    	}
    	
	}
    
    public void launchIndex(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/IndexWindow.fxml"));
		loader.setController(new IndexWindow());
		
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
    }
    
    public boolean checkUserExists(String id, String pass) {
    	boolean out = false;
    	for(User user : UserData.data) {
    		if(user.getUserID().equals(id) && user.getPassword().equals(pass)) {
    			out= true;
    			break;
    			
    		}
    	}
    	return out;
    }
    
    @FXML
    void register(ActionEvent event) throws IOException {
    	if(event.getSource() == registerBTN) {
    		FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/RegisterUser.fxml"));
    		loader.setController(new RegisterUser());
    		
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
    	}
    }
    
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

	
}