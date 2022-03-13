package control;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import model.CineController;
import model.MovieShow;
import model.RoomType;
public class SelectFunctionWindow implements Initializable {

	@FXML
	private ImageView bgIMG;

	@FXML
	private Button nextBTN;

	@FXML
	private TableView<MovieShow> movieShow;

	@FXML
	private TableColumn<MovieShow, LocalDate> dateCol;

	@FXML
	private TableColumn<MovieShow, String> startHourCol;

	@FXML
	private TableColumn<MovieShow, String> movieNameCol;

	@FXML
	private TableColumn<MovieShow, String> durationCol;

	@FXML
	private TableColumn<MovieShow, RoomType> roomTypeCol;

	@FXML
	private TableColumn<MovieShow, String> statusCol;

	/**
	 * 
	 * @param event
	 */
	@FXML
	void goNext(ActionEvent event) {
		MovieShow m = (MovieShow) movieShow.getSelectionModel().getSelectedItem();
		MiniRoomWindow.movieShow = m;
		MainController.launchMiniRoomWindow(event);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		nextBTN.setDisable(true);
		//
		dateCol.setCellValueFactory(new PropertyValueFactory<>("date")); // dateCol
		startHourCol.setCellValueFactory(new PropertyValueFactory<>("timeString")); // startHourCol
		movieNameCol.setCellValueFactory(new PropertyValueFactory<>("movieName"));// movieNameCol
		durationCol.setCellValueFactory(new PropertyValueFactory<>("date"));// durationCol
		roomTypeCol.setCellValueFactory(new PropertyValueFactory<>("type"));// roomTypeCol
		statusCol.setCellValueFactory(new PropertyValueFactory<>("viewersCount"));// statusCool

		/*
		 * for(int i = 0; i < CineController.shows.size(); i++) {
		 * CineController.shows.get(i).setViewersCount("s"); }
		 */

		movieShow.setItems(CineController.shows);
	}

	/**
	 * This method disables the add button when an item of the table is selected
	 * 
	 * @param event
	 */
	@FXML
	void disableNextBTN(MouseEvent event) {
		if (movieShow != null) {
			List<MovieShow> table = movieShow.getSelectionModel().getSelectedItems();
			if (table.size() == 1) {
				nextBTN.setDisable(false);
			}
		}
	}

}
