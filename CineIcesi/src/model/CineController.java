package model;

import java.io.Serializable;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * This is the controller class of the cinema, this class have a static ArrayList of the class MovieShow
 *
 */
public class CineController implements Serializable	{
	
	/**
	 * Default version of the serialization of this class
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * This static ArrayList contains all the movie shows registered by the user
	 */
	public static ObservableList<MovieShow> shows = FXCollections.observableArrayList();
	
	/*
	 * This static ArrayList contains all the movies registered by the user
	 */
	public static ArrayList<Movie> catalogue = new ArrayList<>();
	
	/**
	 * This static ArrayList contains all the registered users
	 */
	public static ArrayList<User> userData = new ArrayList<>();
}
