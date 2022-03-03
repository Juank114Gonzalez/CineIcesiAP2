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

   @FXML
    private ChoiceBox<?> availableRoomCB;

    @FXML
    private DatePicker datePickerDP;

    @FXML
    private TextField durationShowTF;

    @FXML
    private ChoiceBox<String> filmListCB;
    
    @FXML
    private Button back_BTN;

    @FXML
    private TextField startTimeTF;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	@FXML
    void goBack(ActionEvent event) {
		launchIndex(event);
    }
	
	public void launchIndex(ActionEvent event) {
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
	
	public void fullFilmListCB() {
		filmListCB.getItems().addAll(CineIcesiController.catalogueFilm.toString());
	}

}
