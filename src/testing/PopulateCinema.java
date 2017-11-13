package testing;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

import database.SerializeDB;
import entity.*;

public class PopulateCinema {

	
	public static void main(String[] args) {

		List list;
		try {
			/////////////////////////////// Cinema //////////////////////////////////////////
                        
                        ArrayList<Cinema> cinemaList = new ArrayList<>();

                        
                        Cinema newCinema;
                        //4 cineplex
                        Cineplex newCineplex1 = new Cineplex(1,"Woodlands Cineplex");
                        Cineplex newCineplex2 = new Cineplex(2,"AMK Cineplex");
                        Cineplex newCineplex3 = new Cineplex(3,"Bugis Cineplex");
                        Cineplex newCineplex4 = new Cineplex(4,"Yishun Cineplex");
                        
                        //4 different kind of seat list
                        int[][] layout1 = new int[5][10]; // 50 seats
                        int[][] layout2 = new int[5][2]; //premium 10 seats
                        int[][] layout3 = new int[10][10]; //100 seat s
                        int[][] layout4 = new int[4][3]; // 12 seats premium
                        
                        
                        //50 seats
                        Seat[] seatList1 = new Seat[50];
                        int id = 0;
                        for(int i=0; i<layout1.length; i++) {
                            for(int j=0; j<layout1[i].length; j++) {
                                seatList1[id] = new Seat(id,i,j);
                                id++;
                            }
                        }
                        //premium 10 seats
                        Seat[] seatList2 = new Seat[10];
                        id = 0;
                        for(int i=0; i<layout2.length; i++) {
                            for(int j=0; j<layout2[i].length; j++) {
                                seatList2[id] = new Seat(id,i,j);
                                id++;
                            }
                        }
                        //100 seats
                        Seat[] seatList3 = new Seat[100];
                        id = 0;
                        for(int i=0; i<layout3.length; i++) {
                            for(int j=0; j<layout3[i].length; j++) {
                                seatList3[id] = new Seat(id,i,j);
                                id++;
                            }
                        }
                        //premium 12 seats
                        Seat[] seatList4 = new Seat[12];
                        id = 0;
                        for(int i=0; i<layout4.length; i++) {
                            for(int j=0; j<layout4[i].length; j++) {
                                seatList4[id] = new Seat(id,i,j);
                                id++;
                            }
                        }
                        //cineplex1
                        newCinema = new Cinema(0, "C1", newCineplex1, seatList1, Cinema.CINEMA_CLASS_REGULAR);
                        cinemaList.add(newCinema);
                        newCinema = new Cinema(1, "C2", newCineplex1, seatList2, Cinema.CINEMA_CLASS_PLATINIUM);
                        cinemaList.add(newCinema);
                        newCinema = new Cinema(2, "C3", newCineplex1, seatList3, Cinema.CINEMA_CLASS_REGULAR);
                        cinemaList.add(newCinema);
                        newCinema = new Cinema(3, "C4", newCineplex1, seatList4, Cinema.CINEMA_CLASS_PLATINIUM);
                        cinemaList.add(newCinema);
                        
                        //cineplex2
                        newCinema = new Cinema(4, "C1", newCineplex2, seatList1, Cinema.CINEMA_CLASS_REGULAR);
                        cinemaList.add(newCinema);
                        newCinema = new Cinema(5, "C2", newCineplex2, seatList2, Cinema.CINEMA_CLASS_PLATINIUM);
                        cinemaList.add(newCinema);
                        newCinema = new Cinema(6, "C3", newCineplex2, seatList3, Cinema.CINEMA_CLASS_REGULAR);
                        cinemaList.add(newCinema);
                        newCinema = new Cinema(7, "C4", newCineplex2, seatList4, Cinema.CINEMA_CLASS_PLATINIUM);
                        cinemaList.add(newCinema);
                        
                        //cineplex3
                        newCinema = new Cinema(8, "C1", newCineplex3, seatList1, Cinema.CINEMA_CLASS_REGULAR);
                        cinemaList.add(newCinema);
                        newCinema = new Cinema(9, "C2", newCineplex3, seatList2, Cinema.CINEMA_CLASS_PLATINIUM);
                        cinemaList.add(newCinema);
                        newCinema = new Cinema(10, "C3", newCineplex3, seatList3, Cinema.CINEMA_CLASS_REGULAR);
                        cinemaList.add(newCinema);
                        newCinema = new Cinema(11, "C4", newCineplex3, seatList4, Cinema.CINEMA_CLASS_PLATINIUM);
                        cinemaList.add(newCinema);
                        
                        //cineplex4
                        newCinema = new Cinema(12, "C1", newCineplex4, seatList1, Cinema.CINEMA_CLASS_REGULAR);
                        cinemaList.add(newCinema);
                        newCinema = new Cinema(13, "C2", newCineplex4, seatList2, Cinema.CINEMA_CLASS_PLATINIUM);
                        cinemaList.add(newCinema);
                        newCinema = new Cinema(14, "C3", newCineplex4, seatList3, Cinema.CINEMA_CLASS_REGULAR);
                        cinemaList.add(newCinema);
                        newCinema = new Cinema(15, "C4", newCineplex4, seatList4, Cinema.CINEMA_CLASS_PLATINIUM);
                        cinemaList.add(newCinema);
                        
                        SerializeDB.writeSerializedObject("Cinema.ser", cinemaList);
                        
                        list = (ArrayList<Cinema>) SerializeDB.readSerializedObject("Cinema.ser");
			for (int i = 0; i < list.size(); i++) {
				Cinema cnma = (Cinema) list.get(i);
				System.out.println( cnma.getCinemaId()+": "+cnma.getCinemaCode() + " from " +cnma.getCineplex().getName());
				System.out.println("-------------------");
			}
			/////////////////////////////// Movie //////////////////////////////////////////
			// Create new data
			// String name, String type, String rate, String length, String status
			/*ArrayList<Movie> mlist = new ArrayList<>();
			Movie addMovie;
			addMovie = new Movie("Geostorm", "Gerard Butler, Abbie Cornish, Andy Garcia", "Dean Devlin",
					"After an unprecedented series of natural disasters threatened the planet, the world�s leaders came together to create an...",
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
                        */
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
                        throw e;
		}
	}
}
