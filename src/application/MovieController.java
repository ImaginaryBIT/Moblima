package application;

import java.io.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import database.SerializeDB;
import entity.Cinema;
import entity.Movie;
import entity.Review;
import entity.ShowTime;
import entity.Ticket;

public class MovieController {

	private List<Movie> list;
	/** Movie Id */
	private int movieId;
	/** Movie Title */
	private String title;//1
	/** Movie Type 2D/3D */
	private String movieType;//2
	/** Movie Cast */
	private List<String> cast;//3
	private String actor1;
	private String actor2;
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
	/** Movie Restrict Level */
	private String rating;//10
	/** Show Times */
	private List<ShowTime> showTimes;//11
	/** Status */
	private String status;//12
	
	Scanner sc = new Scanner(System.in);
	private List<Movie> movieList = (ArrayList<Movie>) SerializeDB.readSerializedObject("Movie.ser");
	private List<Cinema> cinemaList = (ArrayList<Cinema>) SerializeDB.readSerializedObject("Cinema.ser");
	private List<ShowTime> showTimeList = (ArrayList<ShowTime>) SerializeDB.readSerializedObject("ShowTime.ser");
	int size = movieList.size();
	
	@SuppressWarnings("unchecked")
	public boolean addMovie() {
		
		int rchoice, choice;
		boolean flag = false;
		
		try {
			while(true){
				//0 movieId
				movieId = size + 1;
				
				//1 title
				System.out.print("Enter the new Movie Name: ");
				title = sc.nextLine();
				
				//2 movieType
				System.out.print("Enter the Movie type: ");
				movieType = sc.nextLine();
				
				//4 director
				System.out.print("Enter the Movie Director: ");
				director = sc.nextLine();
				
				boolean errorflag = checkDuplicateMovie(title, director, movieType);
				
				if(!errorflag) {
				
					//3 cast
					System.out.print("Enter the Movie Cast(First actor)");
					actor1 = sc.nextLine();
					
					System.out.print("Enter the Movie Cast(second actor)");
					actor2 = sc.nextLine();
					
					cast = new ArrayList<String>();
					cast.add(actor1);
					cast.add(actor2);
					
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
					reviews = null;
					
					//10 rating
					System.out.println("Choose the Movie rating: ");
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
					
					//11 showTimes need to continue
					int showTimeId = showTimeList.size() + 1;
					System.out.print("Enter the cinema name: ");
					Cinema cinema;
					System.out.print("Enter the show date and time in DD-MM-YYYY HH:MM: ");
					Date showDateTime;
					System.out.print("Enter the how many ticket: ");
					Ticket[] tickets;
					
					//12 status
					System.out.print("Select the Movie show status: ");
					System.out.println("1. Coming Soon");
					System.out.println("2. Preview");
					System.out.println("3. Now Showing");
					System.out.println("4. End of Showing");
					System.out.print("Choice: ");
					do {
						choice = sc.nextInt();
						switch(choice) {
						case 1: status = "Coming Soon"; break;
						case 2: status = "Preview"; break;
						case 3: status = "Now Showing"; break;
						case 4: status = "End of Showing"; break;
						default: System.out.println("No such choice");			
						}
					} while (rchoice < 1 || rchoice >4);	
					
					Movie mov = new Movie(movieId, title, cast, director,
							language, synopsis,runningTime,
							overallUserRate, reviews, movieType,
							rating, showTimes, status);
					list.add(mov);
					SerializeDB.writeSerializedObject("Movie.ser", list);
					return true;
					}
					else {
						System.out.println("Movie already in database.");
						System.out.println("Choose 1 to Add another movie.");
						System.out.println("Choose 2 to Back to menu.");
						choice = sc.nextInt();
						if(choice == 2)
							return false;;
						}
				}
		}
		catch (Exception e ) {
			System.out.println( "Exception >> " + e.getMessage() );
			return false;
		}
	}

	public boolean updateMovie() {
		int choice, rchoice;
		List list;
		
		try {			
			System.out.print("Enter the movie name: ");
			title = sc.nextLine();
			
			for(int i=0; i<movieList.size(); i++){
				Movie movie = (Movie)movieList.get(i);

				if(movie.getTitle().equals(title)) {
					do {
						System.out.println("Which detail do you want to update?");
						System.out.println(movie.getTitle());
						System.out.println("1. Update the Movie Name");
						System.out.println("2. Update the Movie Type");
						System.out.println("3. Update the Movie Cast");
						System.out.println("4. Update the Movie Director");
						System.out.println("5. Update the Movie language");
						System.out.println("6. Update the Movie synopsis");
						System.out.println("7. Update the Movie running time");
						System.out.println("8. Update the Movie overall User Rate");
						System.out.println("9. Update the Movie rating");
						System.out.println("10. Update the Movie showtimes");
						System.out.println("11. Update the Movie status");
						System.out.println("12. Exit");
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
							System.out.print("Enter the Movie Cast(First actor)");
							actor1 = sc.nextLine();
							
							System.out.print("Enter the Movie Cast(second actor)");
							actor2 = sc.nextLine();
							
							cast = new ArrayList<String>();
							cast.add(actor1);
							cast.add(actor2);
							
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
							
						case 9://9 rating
							System.out.print("Enter the Movie rating: ");
							rating = sc.nextLine();
							break;
							
						case 10://10 showTimes
							//need continue
							break;
							
						case 11://11 status
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
								
						case 12: //write into DB
							Movie mov = new Movie(movie.getMovieId(), movie.getTitle(), movie.getCast(), 
									movie.getDirector(),movie.getLanguage(), movie.getSynopsis(), movie.getRunningTime(),
									movie.getOverallUserRate(), movie.getReviews() , movie.getMovieType(),
									movie.getRating(), movie.getShowTimes(),movie.getStatus());
							movieList.remove(mov);
							movieList.add(mov);
							SerializeDB.writeSerializedObject("Movie.ser", movieList);
							return true;

						default: System.out.println("No such choice");
						}
						
					} while (choice < 13 && choice > 0);
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
	
	private boolean checkDuplicateMovie(String name, String director, String type){
		
		for(Movie movie : movieList){
			if ((movie.getTitle().equalsIgnoreCase(name)) && (movie.getMovieType().equalsIgnoreCase(type))
					&& (movie.getDirector().equals(director))) {
				System.out.println("Movie already in database.Please add another movie");
				return true;
			} 
		}
		return false;
	}

	public ArrayList<Movie> showAllMovie() {
		return null;
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
