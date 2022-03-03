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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.Main;
import model.CineIcesiController;

public class RegisterShow implements Initializable {

	//Choice boxes
	@FXML
    private ChoiceBox<?> availableRoomCB;
	@FXML
    private ChoiceBox<String> filmListCB;
	
	//Date pickers 
   @FXML
   private DatePicker datePickerDP;

   //Text fields 
   @FXML
   private TextField durationShowTF;
   @FXML
   private TextField startTimeTF;
    
   //Buttons
   @FXML
   private Button back_BTN;

    
   /**
    * This method launches the previous window
    */
	@FXML
    void goBack(ActionEvent event) {
		launchIndex(event);
    }
	
	/**
	 * This method launches the index window
	 * @param event
	 */
	public void launchIndex(ActionEvent event) {//Pa la controladora
    	MainWindow.flag = "login";
    	try {
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
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	/**
	 * this method sets all the items of the films choice box
	 */
	
	public void fullFilmListCB() {
		filmListCB.getItems().addAll(CineIcesiController.catalogueFilm.toString());
	}

	/**
	 * This method initializes the window
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
