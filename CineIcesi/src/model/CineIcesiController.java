package model;

import java.util.ArrayList;

public class CineIcesiController {

	private static ArrayList<Film> catalogFilm;
	
	public CineIcesiController() {
		catalogFilm = new ArrayList<Film>();
	}

	public static ArrayList<Film> getCatalogFilm() {
		return catalogFilm;
	}

	public static void setCatalogFilm(ArrayList<Film> catalogFilm) {
		CineIcesiController.catalogFilm = catalogFilm;
	}
	
	
	
}
