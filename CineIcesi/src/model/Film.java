package model;

import java.util.Date;

public class Film {
	
	private String filmName;
	private Date duration;
	
	public Film() {}
	
	public Film(String filmName, Date duration) {
		this.filmName = filmName;
		this.duration = duration;
	}
	
	public String getFilmName() {
		return filmName;
	}
	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}
	public Date getDuration() {
		return duration;
	}
	public void setDuration(Date duration) {
		this.duration = duration;
	}
	
	@Override
	public String toString() {
		return this.filmName.toUpperCase();
	}
}
