package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import control.RegisterUser;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.CineIcesiController;
import model.User;
import model.UserData;

public class Main extends Application{
	
	private CineIcesiController systemOF;
	
	public Main() {
		systemOF = new CineIcesiController();		
	}
	
	public static void main(String[] args) {
		Main ppal= new Main();
		
		if(fileExists()) {
			loadData();
		}
		
		launch(args);
		
	}
	
	/**
	 * This method confirms if the file named "data" exists
	 * @return out, true if the data file exists
	 */
	public static boolean fileExists(){
		boolean out = false;
		File aux = new File("data/data.txt");
		if(aux.exists()) {
			out = true;
		}	
		return out;
		
	}
	
	/**
	 * This Method is responsible for loading the serialized information in the static variable UserData.data for later use in execution
	 */
	public static void loadData() {
		
	    	try{
	    		File file = new File(RegisterUser.root);
	    		FileInputStream fis= new FileInputStream(file);
	    		ObjectInputStream ois = new ObjectInputStream(fis);
	    		ArrayList<User> userList = (ArrayList<User>) ois.readObject();
	    		UserData.data = userList;
	    	}catch(IOException e) {
	    		e.printStackTrace();
	    	} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	
	
	@Override
	public void start(Stage primaryStage){
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/MainWindow.fxml"));
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
