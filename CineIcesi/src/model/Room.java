package model;

public class Room {

	private Chair[] chairs;
	private Show currentlyShow;
	
	
	
	public Room() {}
	
	public Room(Show currentlyShow) {
		this.currentlyShow = currentlyShow;
	}
	
	
	
	public Chair[] getChairs() {
		return chairs;
	}
	public void setChairs(Chair[] chairs) {
		this.chairs = chairs;
	}
	public Show getCurrentlyShow() {
		return currentlyShow;
	}
	public void setCurrentlyShow(Show currentlyShow) {
		this.currentlyShow = currentlyShow;
	}
	
	
}
