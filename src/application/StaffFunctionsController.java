package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import database.SerializeDB;
import entity.Cinema;
import entity.Movie;
import entity.Review;
import entity.ShowTime;
/**
 * 
 * @author Group5
 *
 */
public class StaffFunctionsController {
	private boolean errorFlag = false;
	
	@SuppressWarnings("unchecked")
	private List<Movie> movieLst = (ArrayList<Movie>) SerializeDB.readSerializedObject("Movie.ser");
	private List<Cinema> cinemaLst = (ArrayList<Cinema>) SerializeDB.readSerializedObject("Cinema.ser");
	int size = movieLst.size();
	Scanner sc = new Scanner(System.in);
	
	
	public void printStaffMenu(){
		System.out.println("Available Functions");
		System.out.println("  1. Add Movie.");
		System.out.println("  2. Update Movie.");
		System.out.println("  3. Generate Sale Report.");
		System.out.println("  4. Configure System Settings.");
		System.out.print(" Enter your choice:");
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			addMovie();
			break;
		case 2:
			updateMovie();
			break;
		case 3:
			generateSaleReport();
			break;
		case 4:
			configureSystemSetting();
			break;
		default:
			System.out.println("Sorry, there is no " + choice);
		}
	}
	
	public void addMovie(){
		try{
			while(!errorFlag){
				System.out.print("Enter the new Movie title: ");
				String name = sc.nextLine();
				System.out.print("Enter the director name: ");
				String director = sc.nextLine();
				System.out.print("Enter the movie type: ");
				String type = sc.nextLine();
				
				errorFlag = checkDuplicateMovie(name, director, type);
				if (!errorFlag){
					System.out.print("Enter the main actor 1: ");
					String actor1 = sc.nextLine();
					System.out.print("Enter the main actor 2: ");
					String actor2 = sc.nextLine();
					System.out.print("Enter the main language: ");
					String language = sc.nextLine();
					System.out.print("Enter the movie brief summary: ");
					String synopsis = sc.nextLine();
					System.out.print("Enter the movie running time in minute: ");
					String runningTime = sc.nextLine();
					int choice;
					System.out.println("Choose the Movie Rating: ");
					System.out.println("1. G");
					System.out.println("2. PG");
					System.out.println("3. PG13 ");
					System.out.println("4. NC16");
					System.out.println("5. M18");
					System.out.println("6. R21");
					System.out.println("7. TBA");
					String rating = "";
					do {
						System.out.print("Choice: ");
						choice = sc.nextInt();
						sc.nextLine();
						System.out.println();
		
						switch (choice) {
						case 1:
							rating = "G";
							break;
						case 2:
							rating = "PG";
							break;
						case 3:
							rating = "PG13";
							break;
						case 4:
							rating = "NC16";
							break;
						case 5:
							rating = "M18";
							break;
						case 6:
							rating = "R21";
							break;
						case 7:
							rating = "TBA";
							break;
						default:
							System.out.println("No such choice");
						}
					} while (choice < 1 || choice > 7);
				
					
					
					System.out.println("Choose the movie status");
					System.out.println("  1. Now Showing.");
					System.out.println("  2. Comming Soon.");
					System.out.println("  3. Preview.");
					
					
					String status = "";
					do{
						System.out.print("Choice: ");
						choice = sc.nextInt();
						sc.nextLine();
						System.out.println();
						switch(choice){
						case 1:
							status = "Now Showing";
							break;
						case 2:
							status = "Coming Soon";
							break;
						case 3:
							status = "Preview";
							break;
						default:
							System.out.println("No such choice");
						}
					} while (choice < 1 || choice > 3);
					
					//add Show Time
					List<ShowTime> showTimes = new ArrayList<>();
					if(status.equalsIgnoreCase("Now Showing")){
						System.out.println("Please add Show Times for this Movie");
						System.out.print("  Enter Date Time in DD-MM-YYYY HH:MM");
					}
					
					// set default data 
					float overallUserRate = 0;
					List<Review> reviews = new ArrayList<>();
					List<String> cast = new ArrayList<String>();
					cast.add(actor1);
					cast.add(actor2);
					
					Movie movie = new Movie(size, name, cast, director, language, synopsis, runningTime, overallUserRate, reviews, type, rating, showTimes, status);
						
				}
				
				
			}
			
		} catch (Exception e) {
			System.out.println("Exception >> " + e.getMessage());
			
		}
		System.out.println(" Enter Movie Name");
	}
	
	public void updateMovie(){
		
	}
	
	public void generateSaleReport(){
		
	}
	
	public void configureSystemSetting(){
		
	}
	
	private boolean checkDuplicateMovie(String name, String director, String type){
		
		for(Movie movie : movieLst){
			if ((movie.getTitle().equalsIgnoreCase(name)) && (movie.getMovieType().equalsIgnoreCase(type))
					&& (movie.getDirector().equals(director))) {
				System.out.println("Movie already in database.Please add another movie");
				return true;
			} 
		}
		return false;
	}
}
