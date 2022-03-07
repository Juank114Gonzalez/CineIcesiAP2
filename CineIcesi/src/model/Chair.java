package model;

import java.util.HashMap;

public class Chair {
	
	private ChairStatus status;
	
	private HashMap<String,Integer> position;

	
	public Chair(ChairStatus status) {
		this.status = status;
		position = new HashMap<>();
	}
	
	
	public ChairStatus getStatus() {
		return status;
	}

	public void setStatus(ChairStatus status) {
		this.status = status;
	}

	public HashMap<String, Integer> getPosition() {
		return position;
	}

	public void setPosition(HashMap<String, Integer> position) {
		this.position = position;
	}
	
}
