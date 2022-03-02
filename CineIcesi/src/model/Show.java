package model;

import java.util.Date;

public class Show {
	
	private Date date;
	private Date duration;
	private String filmName;
	private Room assignedRoom;
	
	
	public Show() {}
	
	public Show(Date date, Date duration, String filmName, Room assignedRoom) {
		this.date = date;
		this.duration = duration;
		this.filmName = filmName;
		this.assignedRoom = assignedRoom;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Date getDuration() {
		return duration;
	}
	public void setDuration(Date duration) {
		this.duration = duration;
	}
	public String getFilmName() {
		return filmName;
	}
	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}
	public Room getAssignedRoom() {
		return assignedRoom;
	}
	public void setAssignedRoom(Room assignedRoom) {
		this.assignedRoom = assignedRoom;
	}
}
