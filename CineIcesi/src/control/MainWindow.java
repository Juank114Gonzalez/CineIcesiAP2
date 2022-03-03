package control;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import exceptions.UnregisteredUserException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import main.Main;
import model.User;
import model.UserData;

public class MainWindow implements Initializable{
	
	//Attributes
	private User genericUser;
	public static String flag = "";
	
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
    @FXML
    private ImageView bgIMG;
    @FXML
    private ImageView bgIMG2;



    /*
   -----------------------------------------------Methods-----------------------------------------------
   */
    /**
     * This method allows to a registered user go to index window
     * @param event
     * @throws UnregisteredUserException
     * @throws IOException
     */
    @FXML
    void login(ActionEvent event) throws UnregisteredUserException, IOException {
    	if(checkUserExists(idTF.getText(),passwordTF.getText())) {
    		launchIndex(event);
    	}else {
    		new UnregisteredUserException();
    	}
    	
	}
    
    /**
     * This method launches the index window
     * @param event
     * @throws IOException
     */
    public void launchIndex(ActionEvent event) throws IOException {//Para la controladora
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
    /**
     * This method checks if an user exists
     * @param id
     * @param pass
     * @return
     */
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
    /**
     * This method launches register user window when a button is pressed
     * @param event
     * @throws IOException
     */
    @FXML
    void register(ActionEvent event) throws IOException {
    		flag = "login";
    		launchRegisterWindow(event);
    }
    /**
     * This method launches register user window
     * @param event
     * @throws IOException
     */
    void launchRegisterWindow(ActionEvent event) throws IOException {//Para la controladora
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
    /**
     * This method initializes the windows
     */
    @Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

	
}