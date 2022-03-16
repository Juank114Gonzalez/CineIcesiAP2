package control;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import main.Main;
import model.MovieShow;
import model.RoomType;

public class SelectFunctionWindow implements Initializable {

	// Images
	@FXML
	private ImageView bgIMG;
	@FXML
	private ImageView printIMG;

	
	//Panes
	@FXML
	private Pane paneReportPN;
	
	//Buttons
	@FXML
	private Button nextBTN;
	@FXML
	private Button back_BTN;
	@FXML
	private Button printReportBTN;

	
	//Table view elements
	@FXML
	public TableView<MovieShow> movieShow = new TableView<>();
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
	 * This method sets the room to going to be administered on next window
	 * 
	 * @param event, ActionEvent, it gets the event source of the button
	 */
	@FXML
	void goNext(ActionEvent event) {

		if (MainController.flag.equals("Normal")) {
			MovieShow m = (MovieShow) movieShow.getSelectionModel().getSelectedItem();
			NormalRoomWindow.movieShow = m;

			MainController.launchNormalRoomWindow(event);
		} else {
			MovieShow m = (MovieShow) movieShow.getSelectionModel().getSelectedItem();
			MiniRoomWindow.movieShow = m;

			MainController.launchMiniRoomWindow(event);
		}

	}

	/**
	 * This method prints the report of all room or a selected show
	 * 
	 * @param event, ActionEvent, it gets the event source of the button
	 */
	@FXML
	void printReport(MouseEvent event) {

		Main.cine.reportToString((MovieShow) movieShow.getSelectionModel().getSelectedItem());
		
		
		MainController.launchReportWindow(new ActionEvent());
	}

	/**
	 * This method initializes the window
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		nextBTN.setDisable(true);
		printReportBTN.setDisable(true);
		paneReportPN.setOpacity(0.5);
		printIMG.setOpacity(0.5);
		//
		dateCol.setCellValueFactory(new PropertyValueFactory<>("date")); // dateCol
		startHourCol.setCellValueFactory(new PropertyValueFactory<>("timeString")); // startHourCol
		movieNameCol.setCellValueFactory(new PropertyValueFactory<>("movieName"));// movieNameCol
		durationCol.setCellValueFactory(new PropertyValueFactory<>("date"));// durationCol
		roomTypeCol.setCellValueFactory(new PropertyValueFactory<>("type"));// roomTypeCol
		statusCol.setCellValueFactory(new PropertyValueFactory<>("viewersCount"));// statusCool

		applyFilter();
		
	}

	/**
	 * This method applies a filter in reference to the type of room
	 */
	public void applyFilter() {
		ObservableList<MovieShow> filteredListPerTypeOfRoom = FXCollections.observableArrayList();

		if (MainController.flag.equals("Normal")) {

			for (MovieShow ms : Main.cine.shows) {
				if (ms.getType().equals(RoomType.NORMAL)) {

					filteredListPerTypeOfRoom.add(ms);

				}
			}
		} else if (MainController.flag.equals("Mini")) {
			for (MovieShow ms : Main.cine.shows) {
				if (ms.getType().equals(RoomType.MINI)) {

					filteredListPerTypeOfRoom.add(ms);

				}
			}
		}

		movieShow.setItems(filteredListPerTypeOfRoom);

	}

	/**
	 * This method launches the previous window
	 */
	@FXML
	void goBack(ActionEvent event) {
		MainController.launchRoomAdministration(event);
	}

	/**
	 * This method disables the add button when an item of the table is selected
	 * 
	 * @param event, ActionEvent, it gets the event source of the button
	 */
	@FXML
	void disableNextBTN(MouseEvent event) {
		if (movieShow != null) {
			List<MovieShow> table = movieShow.getSelectionModel().getSelectedItems();
			if (table.size() == 1) {
				nextBTN.setDisable(false);
				printReportBTN.setDisable(false);
				paneReportPN.setOpacity(1);
				printIMG.setOpacity(1);
			}else {
				nextBTN.setDisable(true);
				printReportBTN.setDisable(true);
				paneReportPN.setOpacity(0.5);
				printIMG.setOpacity(0.5);
			}

		}
	}

}
