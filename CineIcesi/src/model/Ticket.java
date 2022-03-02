package model;

import java.util.ArrayList;

public class Ticket {
	
	private Film assigedFilm;
	private ArrayList<Viewer> viewerList;
	
	
	public Ticket(Film assigedFilm, ArrayList<Viewer> viewerList) {
		this.assigedFilm = assigedFilm;
		this.viewerList = viewerList;
	}


	public Film getAssigedFilm() {
		return assigedFilm;
	}


	public void setAssigedFilm(Film assigedFilm) {
		this.assigedFilm = assigedFilm;
	}


	public ArrayList<Viewer> getViewerList() {
		return viewerList;
	}


	public void setViewerList(ArrayList<Viewer> viewerList) {
		this.viewerList = viewerList;
	}
	
	
	
}
