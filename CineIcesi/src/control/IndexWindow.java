package control;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import main.Main;

public class IndexWindow implements Initializable {
	

	  @FXML
	    private Button administrateRoomsBTN;

	    @FXML
	    private ImageView bgIMG;

	    @FXML
	    private ImageView cineIMG;

	    @FXML
	    private AnchorPane mainAP;

	    @FXML
	    private Button registerShowBTN;

	    @FXML
	    private Button registerUserBTN;

	    @FXML
	    private ImageView roomIMG;

	    @FXML
	    private ImageView userIMG;

	    @FXML
	    void openRegisterUserWindow(ActionEvent event) throws IOException {
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


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	@FXML
    void openRegisterShowWindow(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/RegisterShow.fxml"));
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
	
	@FXML
    void openRoomAdministrationWindow(ActionEvent event) {

    }


	
	
	public void openLoginAgain(ActionEvent event) {
   	 
   }
}
