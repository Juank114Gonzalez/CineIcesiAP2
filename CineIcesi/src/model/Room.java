package model;

public class Room {

	private Chair[] chairs;
	private Show currentShow;
	
	
	
	public Room() {}
	
	public Room(Show currentShow) {
		this.currentShow = currentShow;
	}
	
	
	
	public Chair[] getChairs() {
		return chairs;
	}
	public void setChairs(Chair[] chairs) {
		this.chairs = chairs;
	}
	public Show getcurrentShow() {
		return currentShow;
	}
	public void setcurrentShow(Show currentShow) {
		this.currentShow = currentShow;
	}
	
	
}
