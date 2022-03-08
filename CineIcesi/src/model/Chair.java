package model;

import java.util.HashMap;

import javafx.scene.control.Button;

public class Chair {
	
	private ChairStatus status;
	
	private Button chairButton;

	
	public Chair(ChairStatus status, Button chairButton) {
		this.status = status;
		this.chairButton = chairButton;
	}
	
	
	public ChairStatus getStatus() {
		return status;
	}

	public void setStatus(ChairStatus status) {
		this.status = status;
	}


	public Button getChairButton() {
		return chairButton;
	}


	public void setChairButton(Button chairButton) {
		this.chairButton = chairButton;
	}
	
}