package model;

import java.util.ArrayList;

public class CineIcesiController {

	public static ArrayList<Film> catalogueFilm;
	
	public CineIcesiController() {
		catalogueFilm = new ArrayList<Film>();
	}

	public static ArrayList<Film> getCatalogueFilm() {
		return catalogueFilm;
	}

	public static void setCatalogueFilm(ArrayList<Film> catalogFilm) {
		CineIcesiController.catalogueFilm = catalogFilm;
	}
	
	
	
	
}
