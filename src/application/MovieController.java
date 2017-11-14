package application;

import java.io.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import database.SerializeDB;
import entity.Cinema;
import entity.Cineplex;
import entity.Movie;
import entity.Review;
import entity.Seat;
import entity.ShowTime;
import entity.Ticket;
import entity.TimeSlot;

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
	
	int showTimeId;
	Cinema cinema;
	Ticket[] tickets;
	
	Scanner sc = new Scanner(System.in);
	private List<Movie> movieList = (ArrayList<Movie>) SerializeDB.readSerializedObject("Movie.ser");
	private List<Cinema> cinemaList = (ArrayList<Cinema>) SerializeDB.readSerializedObject("Cinema.ser");
	private List<ShowTime> showTimeList = (ArrayList<ShowTime>) SerializeDB.readSerializedObject("ShowTime.ser");
	int size = movieList.size();
	
	@SuppressWarnings("unchecked")
	public boolean addMovie() {
		
		int rchoice, choice;
		boolean flag = false;
		boolean codeCheck = false;
		
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
					reviews = new ArrayList();
					
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
					
					//11 showTimes
					showTimeId = showTimeList.size() + 1;
					for(int i = 0; i < cinemaList.size(); i++)
					{
						System.out.println(cinemaList.get(i).getCinemaCode());
					}
					while(!codeCheck) {
						System.out.print("Enter the cinema code: ");
						String cinemaCode = sc.nextLine();
						
						for(int j = 0; j < cinemaList.size(); j++)
						{
							if(cinemaList.get(j).getCinemaCode().equals(cinemaCode)) 
							{
								
								cinema = cinemaList.get(j);
								tickets = new Ticket[cinema.getSeat().length];
								for(int s = 0; s < cinema.getSeat().length; s++){
	                                
	                                //movie type and getting system setting here
	                                // if newMovie.getType() == "something" price = something
	                                float price = 0.0f;
	                                //if holiday add 
	                                price += 2.0;
	                                if(s == 10 || s == 11 || s == 12)
	                                	tickets[s] = new Ticket(s,cinema.getSeat()[s],price,Ticket.SOLD);
	                                else
	                                	tickets[s] = new Ticket(s,cinema.getSeat()[s],price,Ticket.AVAILABLE);
	                                
	                                
								}
								codeCheck = true;
							}
						}
					}
					ShowTime st = new ShowTime(showTimeId, cinema, new Date(),tickets);
					showTimeList.add(st);
					SerializeDB.writeSerializedObject("Movie.ser", showTimeList);
					
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
					} while (choice < 1 || choice >4);	
					
					Movie mov = new Movie(movieId, title, cast, director,
							language, synopsis,runningTime,
							overallUserRate, reviews, movieType,
							rating, showTimes, status);
					movieList.add(mov);
					SerializeDB.writeSerializedObject("Movie.ser", movieList);
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
		
		try {			
			System.out.print("Enter the updating movie name: ");
			title = sc.nextLine();
			System.out.println("Enter the updating Movie Type");
			movieType = sc.nextLine();
			
			for(int i=0; i<movieList.size(); i++){
				Movie movie = (Movie)movieList.get(i);

				if(movie.getTitle().equals(title) && movie.getMovieType().equals(movieType)) {
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
							movie.setTitle(title);
							break;
							
						case 2: //2 movieType
							System.out.print("Enter the new Movie movieType: ");
							movieType = sc.nextLine();
							movie.setMovieType(movieType);
							break;
							
						case 3: //3 cast
							System.out.print("Enter the new Movie Cast(First actor)");
							actor1 = sc.nextLine();
							
							System.out.print("Enter the new Movie Cast(second actor)");
							actor2 = sc.nextLine();
							
							cast = new ArrayList<String>();
							cast.add(actor1);
							cast.add(actor2);
							movie.setCast(cast);
							break;
							
						case 4: //4 director
							System.out.print("Enter the new Movie Director: ");
							director = sc.nextLine();
							movie.setDirector(director);;
							break;
							
						case 5://5 language
							System.out.print("Enter the new Movie language: ");
							language = sc.nextLine();
							movie.setLanguage(language);
							break;
							
						case 6://6 synopsis
							System.out.print("Enter the Movie synopsis: ");
							synopsis = sc.nextLine();
							movie.setSynopsis(synopsis);
							break;
							
						case 7://7 runningTime
							System.out.print("Enter the Movie running time: ");
							runningTime = sc.nextInt();
							movie.setRunningTime(runningTime);
							break;
							
						case 8://8 overallUserRate
							System.out.print("Enter the Movie overall user rate: ");
							overallUserRate = sc.nextFloat();
							movie.setOverallUserRate(overallUserRate);
							break;
							
						case 9://9 rating
							System.out.println("Choose the new Movie rating: ");
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
							
							movie.setRating(rating);
							break;

						case 10://10 showTimes
							List<ShowTime> temp = movie.getShowTimes();
							ShowTime st = null;
							boolean idCheck = false;
							boolean codeCheck = false;
							
							for(int l = 0; l < temp.size(); l++) {
								System.out.println(temp.get(l).getShowTime());
							}
							while(!idCheck) {
								System.out.println("Please enter the showTimeId to update");
								showTimeId = sc.nextInt();
								
								for(int l = 0; l < temp.size(); l++) 
								{
									if(temp.get(l).getShowTimeId() == showTimeId)
									{
										temp.remove(l);
										
										while(!codeCheck) {
											System.out.print("Enter the new cinema code: ");
											String cinemaCode = sc.nextLine();
										
											for(int k = 0; k < cinemaList.size(); k++)
											{
												if(cinemaList.get(k).getCinemaCode().equals(cinemaCode)) 
												{
													cinema = cinemaList.get(k);
													tickets = new Ticket[cinema.getSeat().length];
													
													for(int s = 0; s < cinema.getSeat().length; s++){
	
						                                float price = 0.0f;
						                                price += 2.0;
						                                
						                                if(s == 10 || s == 11 || s == 12)
						                                	tickets[s] = new Ticket(s,cinema.getSeat()[s],price,Ticket.SOLD);
						                                else
						                                	tickets[s] = new Ticket(s,cinema.getSeat()[s],price,Ticket.AVAILABLE);
						                                
						                                st = new ShowTime(showTimeId, cinema, new Date(),tickets);
						                                
						                                codeCheck = true;
						                                idCheck = true;
						                                break;
													}     
												}
											}
											System.out.println("The cinema code entered wrongly!");
										}
									}									
								}
								System.out.println("The showTimeId entered wrongly!");
							}
							temp.add(st);
							movie.setShowTimes(temp);
							break;
							
						case 11://11 status
							System.out.print("Select the new Movie show status: ");
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
							movie.setStatus(status);
								
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
}
