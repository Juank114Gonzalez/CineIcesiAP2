package control;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import exceptions.EmptyCatalogueException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import main.Main;
import model.CineController;

public class IndexWindow implements Initializable {
	
	//Buttons
  	@FXML
    private Button administrateRoomsBTN;
    @FXML
    private Button registerShowBTN;
    @FXML
    private Button registerUserBTN;	 
    @FXML
    private Button logOutBTN;
  
  	//Images
  	@FXML
    private ImageView back_IMG;
    @FXML
    private ImageView bgIMG; 
    @FXML
    private ImageView cineIMG;
    @FXML
    private ImageView roomIMG;
    @FXML
    private ImageView userIMG;
    
    
    //Anchor panes
    @FXML
    private AnchorPane mainAP;
    
    //
    @FXML
    private Label nameIndexLB;
	    
    /**
     * This method launches the register user window
     * @param event
     * @throws IOException
     */
    @FXML
    void openRegisterUserWindow(ActionEvent event) throws IOException {
    	MainController.flag = "Index";
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
	 * This method set label as logged user name
	 */
    void setLabel() {
    	nameIndexLB.setText(MainController.loggedUser.getName());
    }
    
    
    /**
	 * This method initializes the window
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		setLabel();
	}
	/**
	 * This method launches the previous window
	 * @param event
	 */
	 @FXML
	    void goBack(ActionEvent event) {
	    	MainController.launchLogin(event);
	    }
	
	 /**
	  * This method launches the register show window
	  * @param event
	  */
	@FXML
    void openRegisterShowWindow(ActionEvent event) throws EmptyCatalogueException{
		if (CineController.catalogue.size() == 0) {
			new EmptyCatalogueException(event);
		}else {
			MainController.launchRegisterShowWindow(event);
		}
	
		
    }
	/**
	 * This method launch Administrator rooms window
	 * @param event
	 */
	@FXML
    void openRoomAdministrationWindow(ActionEvent event) {
		MainController.launchRoomAdministration(event);
    }
	
	
}
