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
	private String title;//1
	/** Movie Cast */
	private String movieType;//2
	/** Movie Restrict Level */
	private String[] cast;//3
	/** Director of the Movie */
	private String director;//4
	/** Movie Language */
	private String language;//5
	/** Brief Summary of the Movie */
	private String synopsis;//6
	/** Movie Running Time (minute) */
	private int runningTime;//7
	/** Overall User Rating  */
	private float overallUserRate;//8
	/** Movie Reviews */
	private List<Review> reviews;//9
	/** Movie Type ( ) */
	private String rating;//10
	/** Show Times */
	private List<ShowTime> showTimes;//11
	/** Status */
	private String status;//12
	
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
		
		int rchoice, choice;
		boolean flag = false;
		List list;
		
		try {
			//0 movieId
			list = (ArrayList) SerializeDB.readSerializedObject("Movie.ser");
			movieId = list.size() + 1;
			
			//1 title
			System.out.print("Enter the new Movie Name: ");
			title = sc.nextLine();
			
			//2 movieType
			System.out.println("Choose the Movie Type: ");
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
			
			//3 cast
			System.out.print("Enter the Movie Cast: ");
			cast[0] = sc.nextLine(); // update [] later
			
			//4 director
			System.out.print("Enter the Movie Director: ");
			director = sc.nextLine();
			
			//5 language
			System.out.print("Enter the Movie language: ");
			language = sc.nextLine();
			
			//6 synopsis
			System.out.print("Enter the Movie synopsis: ");
			synopsis = sc.nextLine();
			
			//7 runningTime
			System.out.print("Enter the Movie running time: ");
			runningTime = sc.nextInt();
			
			//8 overallUserRate
			System.out.print("Enter the Movie overall user rate: ");
			overallUserRate = sc.nextFloat();
			
			//9 reviews
			System.out.print("Enter the Movie reviews: ");
			// need to update arraylist!!!
			
			//10 rating
			System.out.print("Enter the Movie rating: ");
			rating = sc.nextLine();
			
			//11 showTimes
			System.out.print("Enter the Movie show times: ");
			// need to update arraylist!!!
			
			list = (ArrayList) SerializeDB.readSerializedObject("Movie.ser");
			
			//12 status
			System.out.print("Select the Movie show status: ");
			System.out.println("1. Coming Soon");
			System.out.println("2. Preview");
			System.out.println("3. Now Showing");
			System.out.println("4. End of Showing");
			System.out.print("Choice: ");
			do {
				choice = sc.nextInt(); sc.nextLine();
				switch(choice) {
				case 1: status = "Coming Soon"; break;
				case 2: status = "Preview"; break;
				case 3: status = "Now Showing"; break;
				case 4: status = "End of Showing"; break;
				default: System.out.println("No such choice");			
				}
			} while (rchoice < 1 || rchoice >4);	
			
			
			for(int i=0; i<list.size(); i++){
				Movie movie = (Movie)list.get(i);

				if(movie.getTitle().equals(title)) {
					flag = true;
					break;
				}
				else 
					flag = false;
			}
			
			if (!flag) { 
				Movie mov = new Movie(movieId, title, cast, director,
						language, synopsis,runningTime,
						overallUserRate, reviews, movieType,
						rating, showTimes, status);
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

	public boolean updateMovie() {
		int choice, rchoice;
		List list;
		
		try {			
			System.out.print("Enter the movie name: ");
			title = sc.nextLine();

			list = (ArrayList) SerializeDB.readSerializedObject("Movie.ser");
			
			for(int i=0; i<list.size(); i++){
				Movie movie = (Movie)list.get(i);

				if(movie.getTitle().equals(title)) {
					do {
						System.out.println("Which detail do you want to update?");
						System.out.println(movie.getTitle());
						System.out.println("1. Update the Movie Name");
						System.out.println("2. Update the Movie Type");
						System.out.println("3. Update the Movie Runtime");
						System.out.println("4. Update the Movie Rating");
						System.out.println("5. Update the Movie Status");
						System.out.println("6. Exit");
						
						System.out.print("Choice: ");		
						choice = sc.nextInt();
						sc.nextLine();
						
						switch (choice) {
						case 1: 	//1 title
							System.out.print("Enter the new Movie Name: ");
							title = sc.nextLine();
							break;
							
						case 2: //2 movieType
							System.out.println("Choose the Movie Type: ");
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
							break;
							
						case 3: //3 cast
							System.out.print("Enter the Movie Cast: ");
							cast[0] = sc.nextLine(); // update [] later
							break;
							
						case 4: //4 director
							System.out.print("Enter the Movie Director: ");
							director = sc.nextLine();
							break;
							
						case 5://5 language
							System.out.print("Enter the Movie language: ");
							language = sc.nextLine();
							break;
							
						case 6://6 synopsis
							System.out.print("Enter the Movie synopsis: ");
							synopsis = sc.nextLine();
							break;
							
						case 7://7 runningTime
							System.out.print("Enter the Movie running time: ");
							runningTime = sc.nextInt();
							break;
							
						case 8://8 overallUserRate
							System.out.print("Enter the Movie overall user rate: ");
							overallUserRate = sc.nextFloat();
							break;
							
						case 9://9 reviews
							System.out.print("Enter the Movie reviews: ");
							// need to update arraylist!!!
							break;
							
						case 10://10 rating
							System.out.print("Enter the Movie rating: ");
							rating = sc.nextLine();
							break;
							
						case 11://11 showTimes
							System.out.print("Enter the Movie show times: ");
							// need to update arraylist!!!
							break;
							
						case 12://12 status
							System.out.print("Select the Movie show status: ");
							System.out.println("1. Coming Soon");
							System.out.println("2. Preview");
							System.out.println("3. Now Showing");
							System.out.println("4. End of Showing");
							System.out.print("Choice: ");
							do {
								choice = sc.nextInt(); sc.nextLine();
								switch(choice) {
								case 1: status = "Coming Soon"; break;
								case 2: status = "Preview"; break;
								case 3: status = "Now Showing"; break;
								case 4: status = "End of Showing"; break;
								default: System.out.println("No such choice");			
								}
							} while (choice < 1 || choice >4);	
							
						list = (ArrayList) SerializeDB.readSerializedObject("Movie.ser");
								
						case 13: //write into DB
							Movie mov = new Movie(movie.getMovieId(), movie.getTitle(), movie.getCast(), 
									movie.getDirector(),movie.getLanguage(), movie.getSynopsis(), movie.getRunningTime(),
									movie.getOverallUserRate(), movie.getReviews() , movie.getMovieType(),
									movie.getRating(), movie.getShowTimes(),movie.getStatus());
							list.remove(mov);
							list.add(mov);
							SerializeDB.writeSerializedObject("Movie.ser", list);
							return true;

						default: System.out.println("No such choice");
						}
						
					} while (choice != 13);
				}	
			}	
		}
		catch (Exception e ) {
			System.out.println( "Exception >> " + e.getMessage() );
			return false;
		}
		System.out.println("Movie not found in Database.");
		return false;
	
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
