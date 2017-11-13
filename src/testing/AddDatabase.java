package testing;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

import database.SerializeDB;
import entity.*;

public class AddDatabase {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		List list;
		try {
			/////////////////////////////// STAFF //////////////////////////////////////////
			// Create new data
			ArrayList staffList = new ArrayList();
			Staff staff = new Staff("admin", "password");
			// add to list
			staffList.add(staff);

			SerializeDB.writeSerializedObject("Staff.ser", staffList);
								
			/////////////////////////////// Movie //////////////////////////////////////////
			// Create new data
			// String name, String type, String rate, String length, String status
			ArrayList<Movie> mlist = new ArrayList<>();
			Movie addMovie;
			addMovie = new Movie("Geostorm", "Gerard Butler, Abbie Cornish, Andy Garcia", "Dean Devlin",
					"After an unprecedented series of natural disasters threatened the planet, the world’s leaders came together to create an...",
					"PG13", "Coming Soon");
			addMovie.setUserRating((float) 8.3);
			// add to list
			mlist.add(addMovie);
			addMovie = new Movie("Mersal (Tamil)", "Kajal Aggarwal , Nithya Menon, Samantha Ruth Prabhu", "Atlee Kumar",
					"Directed by Atlee and music composed by A.R.Rahman, Mersal is an upcoming action drama movie...",
					"PG13", "Coming Soon");
			addMovie.setUserRating((float) 8.9);
			mlist.add(addMovie);
			addMovie = new Movie("Happy Death Day", "Ruby Modine, Charles Aitken", "Christopher Landon", "A college student (Jessica Rothe) is horrified to find herself...", "PG13","Now Showing");
			addMovie.setUserRating((float) 5.9);
			mlist.add(addMovie);
			SerializeDB.writeSerializedObject("Movie.ser", mlist);

			// read from serialized file the list of movie
			list = (ArrayList<Movie>) SerializeDB.readSerializedObject("Movie.ser");
			for (int i = 0; i < list.size(); i++) {
				Movie mov = (Movie) list.get(i);
				System.out.println("Movie title	: " + mov.getMovieName());
				System.out.println("Cast : " + mov.getCast());
				System.out.println("Director : " + mov.getDirector());
				System.out.println("SYNOPSIS : " + mov.getPlot());
				System.out.println("Movie type	: " + mov.getMovieRating());
				System.out.println("Overall rating	: " + mov.getUserRate());
				System.out.println("Showing status	: " + mov.getStatus());
				System.out.println("-------------------");
			}

			// // write to serialized file - update/insert/delete
			// example - add one staff
			// Movie adds = new Movie("Marvels Thor The Dark World", "BlockBuster", "TBA",
			// "TBA", "Coming Soon");
			// // add to list
			// list.add(adds);
			// // list.remove(adds); // remove if p equals object in the list
			//
			// SerializeDB.writeSerializedObject("Movie.ser", list);

		} catch (Exception e) {
			System.out.println("Exception >> " + e.getMessage());
		}
	}
}
