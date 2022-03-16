package control;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import main.Main;

public class ReportWindow implements Initializable {

	
	//Buttons
	@FXML
	private Button closeReportBTN;
	
	//Images
	@FXML
	private ImageView bgIMG;
	@FXML
	private ImageView icesiBGIMG;

	
	//Anchor pane
	@FXML
	private AnchorPane mainAP;

	
	//Text Areas
	@FXML
	private TextArea reportTA;

	
	//Labels
	@FXML
	private Label roomTypeLB;

	/**
	 * This method closes the report window
	 * @param event, ActionEvent, it gets the event source of the button
	 * @throws IOException
	 */
	@FXML
	void closeReport(ActionEvent event) throws IOException {
		try {
            Node source = (Node) event.getSource();
            Stage old = (Stage) source.getScene().getWindow();
            old.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	/**
	 * This method initializes the window
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		reportTA.setText(Main.cine.report);
	}

}
