package application;

import java.io.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import database.SerializeDB;
import entity.Movie;
import entity.Review;
import entity.ShowTime;

public class MovieController {

	private List<Movie> list;
	/** Movie Id */
	private int movieId;
	/** Movie Title */
	private String title;
	/** Movie Cast */
	private String[] cast;
	/** Director of the Movie */
	private String director;
	/** Movie Language */
	private String language;
	/** Brief Summary of the Movie */
	private String synopsis;
	/** Movie Running Time (minute) */
	private int runningTime;
	/** Overall User Rating  */
	private float overallUserRate;
	/** Movie Reviews */
	private ArrayList<Review> reviews;
	/** Movie Type ( ) */
	private String movieType;
	/** Movie Restrict Level */
	private String rating;
	/** Show Times */
	private ArrayList<ShowTime> showTimes;
	/** Status */
	private String status;
	
	// private float userRate;
	Scanner sc = new Scanner(System.in);

	// private long movieRevenue
	public Movie findMovie(String movieName) {
		return null;
	}

	public ArrayList<Movie> showAllMovie() {
		return null;
	}

	public boolean addMovie() {
		
		int rchoice;
		boolean flag = false;
		List list;
		
		try {
			//need to update the options later
			System.out.print("Enter the new Movie Name: ");
			title = sc.nextLine();
			
			System.out.print("Enter the Movie Cast: ");
			cast[0] = sc.nextLine(); // update [] later
			
			System.out.print("Enter the Movie Director: ");
			director = sc.nextLine();
			
			System.out.println("Choose the Movie Rating: ");
			
			System.out.println("1. G");
			System.out.println("2. PG");
			System.out.println("3. PG13 ");
			System.out.println("4. NC16");
			System.out.println("5. M18");
			System.out.println("6. R21");
			System.out.println("7. TBA");
			System.out.print("Choice: ");
			
			do {
				rchoice = sc.nextInt(); sc.nextLine();
				switch(rchoice) {
				case 1: rating = "G"; break;
				case 2: rating = "PG"; break;
				case 3: rating = "PG13"; break;
				case 4: rating = "NC16"; break;
				case 5: rating = "M18"; break;
				case 6: rating = "R21"; break;
				case 7: rating = "TBA"; break;
				default: System.out.println("No such choice");			
				}
			} while (rchoice < 1 || rchoice >7);			
			
			list = (ArrayList) SerializeDB.readSerializedObject("Movie.ser");
			
			for(int i=0; i<list.size(); i++){
				Movie movie = (Movie)list.get(i);

				if(movie.getTitle().equals(title)) {
					flag = true;
					break;
				}
				else 
					flag = false;
			}
			
			if (!flag) { // movie constructor is so complicate..
				Movie mov = new Movie(int movieId, String title, String[] cast, String director,
						String[] language, String synopsis, int runningTime,
						float overallUserRate, ArrayList<Review> reviews, String movieType,
						String rating, ArrayList<ShowTime> showTimes, String status);
				list.add(mov);
				SerializeDB.writeSerializedObject("Movie.ser", list);
				return true;
			}
			else
				System.out.println("Movie already in database. Update the details instead");
		}
		catch (Exception e ) {
			System.out.println( "Exception >> " + e.getMessage() );
			return false;
		}
		return false;
	}

	public void updateMovie() {
	}
	
	public ArrayList<ShowTime> getShowTime(int movieId)
	{
		return null;
	}
	
	public ArrayList<Movie> getTopFive(String rankBy)
	{
		return null;
	}
}
