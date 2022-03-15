package control;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.Main;
import model.CineController;
import model.MovieShow;
import model.RoomType;
import model.User;

/**
 * This class contains some methods which will be used into more than one class
 */
public class MainController {
	// Attributes
	public static String flag = "";// This flag will be used to know if the user opens another window from
	public static String userDataPath = "data/userData.txt";// This is the path where the user data will be saved in
	public static String movieDataPath = "data/movieData.txt";// This is the path where the movie data will be saved in
	public static String showsDataPath = "data/showsData.txt"; // This is the path where the shows data will be saved in
	public static User loggedUser = new User();//This is the logged user on the session

	
	/***************************************************************************
	 * * Methods * *
	 **************************************************************************/
	
	/**
	 * This method launches register user window
	 * 
	 * @param event, ActionEvent, it gets the event source of the button
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
			Node source = (Node) event.getSource();
			Stage old = (Stage) source.getScene().getWindow();
			old.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method launches the register show window
	 * 
	 * @param event, ActionEvent, it gets the event source of the button
	 */
	@FXML
	public static void launchRegisterShowWindow(ActionEvent event) {

		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/RegisterShow.fxml"));
			loader.setController(new RegisterShow());
			Parent parent = (Parent) loader.load();

			Stage stage = new Stage();

			Scene scene = new Scene(parent);

			stage.setScene(scene);

			stage.show();

			try {
				Node source = (Node) event.getSource();
				Stage old = (Stage) source.getScene().getWindow();
				old.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/**
	 * This method launches the index window
	 * 
	 * @param event, ActionEvent, it gets the event source of the button
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
			Node source = (Node) event.getSource();
			Stage old = (Stage) source.getScene().getWindow();
			old.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method launches the register film window
	 * 
	 * @param event, ActionEvent, it gets the event source of the button
	 * @throws IOException
	 */
	public static void launchRegisterFilm(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/RegisterFilm.fxml"));
		loader.setController(new RegisterFilm());

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
			Node source = (Node) event.getSource();
			Stage old = (Stage) source.getScene().getWindow();
			old.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method launches the register function window
	 * 
	 * @param event, ActionEvent, it gets the event source of the button
	 * @throws IOException
	 */
	public static void launchSelectFunctionWindow(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/SelectFunctionWindow.fxml"));

		Parent parent = (Parent) loader.load();;
		

		Stage stage = new Stage();

		Scene scene = new Scene(parent);
		stage.setScene(scene);
		stage.show();

		try {
			Node source = (Node) event.getSource();
			Stage old = (Stage) source.getScene().getWindow();
			old.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method opens the report window
	 * @param event, ActionEvent, it gets the event source of the button
	 */
	public static void launchReportWindow(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/ReportWindow.fxml"));
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

	/**
	 * This method opens the login window
	 * 
	 * @param event, , ActionEvent, it gets the event source of the button
	 */
	public static void launchLogin(ActionEvent event) {
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
			Node source = (Node) event.getSource();
			Stage old = (Stage) source.getScene().getWindow();
			old.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method opens the Room Administration Window
	 * 
	 * @param event, ActionEvent, it gets the event source of the button
	 */
	public static void launchRoomAdministration(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/RoomAdministrationWindow.fxml"));

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
			Node source = (Node) event.getSource();
			Stage old = (Stage) source.getScene().getWindow();
			old.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method launches the MINI-room window
	 * 
	 * @param event, ActionEvent, it gets the event source of the button
	 */
	@FXML
	public static void launchMiniRoomWindow(ActionEvent event) {

		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/MiniRoomWindow.fxml"));
			loader.setController(new MiniRoomWindow());
			Parent parent = (Parent) loader.load();

			Stage stage = new Stage();

			Scene scene = new Scene(parent);

			stage.setScene(scene);

			

			stage.show();

			try {
				Node source = (Node) event.getSource();
				Stage old = (Stage) source.getScene().getWindow();
				old.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
	
	
	/**
	 * This method launches the NORMAL-Room window
	 * 
	 * @param event, ActionEvent, it gets the event source of the button
	 */
	@FXML
	public static void launchNormalRoomWindow(ActionEvent event) {

		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("../ui/NormalRoomWindow.fxml"));
			Parent parent = (Parent) loader.load();

			Stage stage = new Stage();

			Scene scene = new Scene(parent);

			stage.setScene(scene);

			

			stage.show();

			try {
				Node source = (Node) event.getSource();
				Stage old = (Stage) source.getScene().getWindow();
				old.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
