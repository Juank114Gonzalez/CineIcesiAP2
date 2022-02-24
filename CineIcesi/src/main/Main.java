package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import control.RegisterUser;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.User;
import model.UserData;

public class Main extends Application{
	
	public static UserData pene;
	
	public static void main(String[] args) {
		//saveAsJavaByteCode();
		if(UserData.data.size() > 0) {
			loadData();
		}
		launch(args);
	}
	
	public static boolean saveAsJavaByteCode() {
    	boolean out = false;
    	try {
    		UserData.data.add(new User("default", "default", "default"));
    		ArrayList<User> defaultList = UserData.data;
    		File ref = new File(RegisterUser.root);
	    	FileOutputStream fos = new FileOutputStream(ref);
	    	ObjectOutputStream oos = new ObjectOutputStream(fos);
	    	oos.writeObject(defaultList);
	    	oos.close();
	    	out = true;
		}catch (IOException e) {
			e.printStackTrace();
			out = false;
		}
    	
    	return out;
    }
	
	
	/**
	 * Metodo encargado de cargar la información serializada en la variable estática UserData.data para su posterior uso en ejecucion
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
