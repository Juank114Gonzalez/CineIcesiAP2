package main;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

	public static void main(String[] args) {
		launch(args);
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
