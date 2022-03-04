package control;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.Main;

/**
 * This class contains many methods which will be used into other classes
 * @author gabri
 *
 */
public class MainController {
	 /**
     * This method launches register user window
     * @param event
     * @throws IOException
     */
    public static void launchRegisterWindow(ActionEvent event) {
    	FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/RegisterUser.fxml"));
		loader.setController(new RegisterUser());
		
		Parent parent = null;
		try {
			parent = (Parent) loader.load();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
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
     * This method launches the index window
     * @param event
     * @throws IOException
     */
    public static void launchIndex(ActionEvent event) {
    	FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/IndexWindow.fxml"));
		loader.setController(new IndexWindow());
		
		Parent parent = null;
		try {
			parent = (Parent) loader.load();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
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
     * This method opens the login window 
     * @param event, event getter
     */
    public static void launchLogin(ActionEvent event){
		FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/MainWindow.fxml"));
		
		Parent parent = null;
		try {
			parent = (Parent) loader.load();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
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
