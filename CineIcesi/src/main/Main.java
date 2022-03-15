package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import control.MainController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.CineController;
import model.Movie;
import model.MovieShow;
import model.User;

/**
 * This is the main Controller of the project, this class executes the main window of the interface
 *
 */
public class Main extends Application {
	
	public static CineController cine = new CineController();

	public Main() {
	}

	public static void main(String[] args) {
		Main ppal = new Main();

		if (fileExists(MainController.userDataPath)) {
			loadUserData();
		}
		if (fileExists(MainController.movieDataPath)) {
			loadMovieData();
		}
		if (fileExists(MainController.showsDataPath)) {
			loadShowsData();
		}

		launch(args);
	}

	/**
	 * This method confirms if the file named "data" exists
	 * 
	 * @return out, true if the data file exists
	 */
	public static boolean fileExists(String path) {
		boolean out = false;
		File aux = new File(path);
		if (aux.exists()) {
			out = true;
		}
		return out;

	}

	/**
	 * This Method loads the serialized information in the
	 * static variable UserData.data for its later use in execution
	 */
	public static void loadUserData() {

		try {
			File file = new File(MainController.userDataPath);
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			ArrayList<User> userList = (ArrayList<User>) ois.readObject();
			cine.userData = userList;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * This Method loads the serialized information in the
	 * static variable UserData.catalogue for its later use in execution
	 */
	public static void loadMovieData() {

		try {
			File file = new File(MainController.movieDataPath);
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			ArrayList<Movie> movieList = (ArrayList<Movie>) ois.readObject();
			cine.catalogue = movieList;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * This Method loads the serialized information in the
	 * static variable UserData.shows for its later use in execution
	 */
	public static void loadShowsData() {

		try {
			File file = new File(MainController.showsDataPath);
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			ArrayList<MovieShow> showsList =(ArrayList<MovieShow>) ois.readObject();
			ObservableList<MovieShow> newList = FXCollections.observableArrayList(showsList);
			cine.shows = newList;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void start(Stage primaryStage) {
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
