package control;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MiniRoomChairSelectorWindow extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * This method gets the position of the chair selected in the interface, to its respective position on the Customers matrix
	 * @param event, ActionEvent, this is the event of clicking some button
	 */
	@FXML
	public int [] getChairPosition(ActionEvent event) {
		Button chair = (Button) event.getSource();
		String chairId = chair.getId();
		String [] chairSplit = chairId.split("btn");
		String [] chairSplitTwice = chairSplit[1].split(";");
		
		int row = Character.getNumericValue(chairSplitTwice[0].charAt(0));
		int column = Character.getNumericValue(chairSplitTwice[0].charAt(1));
		System.out.println(row+" "+column);
		return new int[] {row,column};
	}
}
