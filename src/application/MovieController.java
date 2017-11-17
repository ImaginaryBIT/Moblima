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

/**
 * This controller class is meant for staff to change update add or remove movies and their associated details
 * Any changes will be written to the database Movie.ser
 * @author group5
 *
 */

public class MovieController {
	/** List of movies */
	private static List<Movie> list;
	/** Movie Id */
	private static int movieId;
	/** Movie Title */
	private static String title;// 1
	/** Movie Type 2D/3D */
	private static String movieType;// 2
	/** Movie Cast */
	private static List<String> cast;// 3
	private static String actor1;
	private static String actor2;
	/** Director of the Movie */
	private static String director;// 4
	/** Movie Language */
	private static String language;// 5
	/** Brief Summary of the Movie */
	private static String synopsis;// 6
	/** Movie Running Time (minute) */
	private static int runningTime;// 7
	/** Movie Reviews */
	private static List<Review> reviews;// 8
	/** Movie Restrict Level */
	private static String rating;// 9
	/** Show Times */
	private static List<ShowTime> showTimes;// 10
	/** Status of the movie*/
	private static String status;// 11

	/** The show time ID */
	private static int showTimeId;
	/** The cinema showing movies */
	private static Cinema cinema;
	/** The tickets generated for a particular movie */
	private static Ticket[] tickets;

	private static Scanner sc = new Scanner(System.in);
	/** The list of movie grabbed from the database Movie.ser */
	private static List<Movie> movieList = (ArrayList<Movie>) SerializeDB.readSerializedObject("Movie.ser");
	/** The list of cinema grabbed from the database Cinema.ser */
	private static List<Cinema> cinemaList = (ArrayList<Cinema>) SerializeDB.readSerializedObject("Cinema.ser");

	/** The size of movie list */
	private static int size = movieList.size();
	/** The list of available show time */
	private static List<ShowTime> showTimeList = new ArrayList();

	/**
	 * Allows staff to add new movie to the database
	 * The method will guide the staff through the whole process of entering movie details and assigning its show time and location
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static boolean addMovie() {

		int rchoice, choice;
		boolean flag = false;
		boolean codeCheck = false;
		boolean showTimeCheck;
		Date chosen_timeSlot = new Date();
		try {
			while (true) {
				// 0 movieId
				movieId = size + 1;

				// 1 title
				System.out.print("Enter the new Movie Name: ");
				title = sc.nextLine();

				// 2 movieType
				System.out.print("Enter the Movie type: ");
                                System.out.println("Choose the Movie type: ");
                                System.out.println("1. Digital");
                                System.out.println("2. 3D");
                                System.out.println("3. Blockbuster ");
                                do {
                                    rchoice = sc.nextInt();
                                    sc.nextLine();
                                    switch (rchoice) {
                                    case 1:
                                            movieType = Movie.DIGITAL;
                                            break;
                                    case 2:
                                            movieType = Movie.THREED;
                                            break;
                                    case 3:
                                            movieType = Movie.BLOCKBUSTER;
                                            break;
                                    default:
                                            System.out.println("No such choice");
                                    }
                                } while (rchoice < 1 || rchoice > 3);

				// 4 director
				System.out.print("Enter the Movie Director: ");
				director = sc.nextLine();

				boolean errorflag = checkDuplicateMovie(title, director, movieType);

				if (!errorflag) {

					// 3 cast
					System.out.print("Enter the Movie Cast(First actor)");
					actor1 = sc.nextLine();

					System.out.print("Enter the Movie Cast(second actor)");
					actor2 = sc.nextLine();

					cast = new ArrayList<String>();
					cast.add(actor1);
					cast.add(actor2);

					// 5 language
					System.out.print("Enter the Movie language: ");
					language = sc.nextLine();

					// 6 synopsis
					System.out.print("Enter the Movie synopsis: ");
					synopsis = sc.nextLine();

					// 7 runningTime
					System.out.print("Enter the Movie running time: ");
					runningTime = sc.nextInt();
					sc.nextLine();
                                        
					// 8 reviews
					reviews = new ArrayList();

					// 9 rating
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
						rchoice = sc.nextInt();
						sc.nextLine();
						switch (rchoice) {
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
					} while (rchoice < 1 || rchoice > 7);

					// 10 showTimes
					System.out.println("=============Available Show Times to add================");
					int showTimeId = showTimeList.size() + 1;

					for (Cinema cinema : cinemaList) {
						System.out.println(cinema.getCinemaId() + ": " + cinema.getClassType() + " "
								+ cinema.getCinemaCode() + " from " + cinema.getCineplex().getName());
					}
					while (!codeCheck) {
						System.out.print("Enter the cinema id: ");
						int cinemaId = sc.nextInt();
						sc.nextLine();

						for (Cinema cnma : cinemaList) {
							if (cnma.getCinemaId() == cinemaId) {

								cinema = cnma;
								tickets = new Ticket[cinema.getSeat().length];
								for (int s = 0; s < cinema.getSeat().length; s++) {

									float price = 0.0f;

									tickets[s] = new Ticket(s, cinema.getSeat()[s], price, Ticket.AVAILABLE);

								}
								codeCheck = true;
							}
						}
					}

					System.out.println("You have chosen:");
					System.out.println(cinema.getClassType() + " " + cinema.getCinemaCode() + " from "
							+ cinema.getCineplex().getName());

					List<String> temp = new ArrayList();
					int count = 0;
					System.out.println("=====Movie Show Time Slot=====");
					System.out.println("Total number of slots is: " + cinema.getTimeSlot().size());

					if (cinema.getTimeSlot().size() == 1) {
						System.out.println(count + ". " + cinema.getTimeSlot().get(0).getDate());
						temp.add(cinema.getTimeSlot().get(0).getDate());
					} 
					else 
					{
						System.out.println(count + ". " + cinema.getTimeSlot().get(0).getDate());
						temp.add(cinema.getTimeSlot().get(0).getDate());
						count++;

						for (int i = 1; i < cinema.getTimeSlot().size(); i++) 
						{
							if (cinema.getTimeSlot().get(i).getDate()
									.compareTo(cinema.getTimeSlot().get(i-1).getDate()) != 0) 
							{
								System.out.println(count + ". " + cinema.getTimeSlot().get(i).getDate());
								temp.add(cinema.getTimeSlot().get(i).getDate());
								count++;
							}
						}
					}
					showTimeCheck = false;
					while (!showTimeCheck) {

						System.out.println("Please choose the date: ");
						int choseDay = sc.nextInt();
						sc.nextLine();
						if (choseDay >= count || choseDay < 0) {
							System.out.println("out of range! Please re-choose date");
							showTimeCheck = false;
						} else {
							String day_string = temp.get(choseDay);

							boolean date_check = false;
							int slot_count = 0;
							// list to store the menu
							List<TimeSlot> timeSlotArray = new ArrayList();

							for (int i = 0; i < cinema.getTimeSlot().size(); i++) {
								if (cinema.getTimeSlot().get(i).getDate().equals(day_string)
										&& cinema.getTimeSlot().get(i).getStatus().equals(TimeSlot.AVAILABLE)) {
									slot_count++;
									System.out.println(slot_count + ": " + cinema.getTimeSlot().get(i).getTime() + " ");
									timeSlotArray.add(cinema.getTimeSlot().get(i));
									date_check = true;
								}
							}
							if (date_check == false) {
								// no time slot found ask to enther again
								System.out.println("No time slot found for input " + day_string + ".");

							} else {
								int time_slot_no = 0;
								do {
									System.out.println("Please select a time slot (1 to " + slot_count + "): ");
									time_slot_no = sc.nextInt();
									sc.nextLine();
								} while (time_slot_no < 0 || time_slot_no > slot_count);

								chosen_timeSlot = timeSlotArray.get(time_slot_no - 1).getDateTime();
								showTimeCheck = true;
							}
						}

					}
					cinema.setTimeSlotStatus(chosen_timeSlot, TimeSlot.UNAVAILABLE);
					ShowTime st = new ShowTime(showTimeId, cinema, chosen_timeSlot, tickets);
					showTimeList.add(st);

					// 11 status
					System.out.println("Select the Movie show status: ");
					System.out.println("1. Coming Soon");
					System.out.println("2. Preview");
					System.out.println("3. Now Showing");
					System.out.println("4. End of Showing");
					System.out.print("Choice: ");
					do {
						choice = sc.nextInt();
						sc.nextLine();
						switch (choice) {
						case 1:
							status = "Coming Soon";
							break;
						case 2:
							status = "Preview";
							break;
						case 3:
							status = "Now Showing";
							break;
						case 4:
							status = "End of Showing";
							break;
						default:
							System.out.println("No such choice");
						}
					} while (choice < 1 || choice > 4);

					Movie mov = new Movie(movieId, title, cast, director, language, synopsis, runningTime,
							 reviews, movieType, rating, showTimeList, status);
					movieList.add(mov);
					SerializeDB.writeSerializedObject("Movie.ser", movieList);

					// int current_index = cinemaList.indexOf(cinema);
					// cinemaList.remove(current_index);
					// cinemaList.set(current_index,cinema);
					SerializeDB.writeSerializedObject("Cinema.ser", cinemaList);
					return true;
				} else {
					System.out.println("Choose 1 to Add another movie.");
					System.out.println("Choose 2 to Back to menu.");
					choice = sc.nextInt();
					sc.nextLine();
					if (choice == 2)
						return false;
					;
				}
			}
		} catch (Exception e) {
			System.out.println("Exception >> " + e.getMessage());
			return false;
		}
	}

	/**
	 * This method allows staff to update details of a movie
	 * @return true if the update is successful, false otherwise
	 */
	public static boolean updateMovie() {
		int choice, rchoice;
		boolean choiceCheck = false;
		boolean codeCheck = false;
		boolean dateCheck = false;
		boolean showTimeCheck;
		Date chosen_timeSlot = new Date();
		try {
			System.out.println("Enter the updating movie name: ");
			title = sc.nextLine();
			// sc.nextLine();
			System.out.println("Choose the Movie type: ");
			System.out.println("1. Digital");
			System.out.println("2. 3D");
			System.out.println("3. Blockbuster ");
			do {
				rchoice = sc.nextInt();
				sc.nextLine();
				switch (rchoice) {
				case 1:
					movieType = Movie.DIGITAL;
					break;
				case 2:
					movieType = Movie.THREED;
					break;
				case 3:
					movieType = Movie.BLOCKBUSTER;
					break;
				default:
					System.out.println("No such choice");
				}
			} while (rchoice < 1 || rchoice > 3);

			for (int i = 0; i < movieList.size(); i++) {
				Movie movie = (Movie) movieList.get(i);

				if (movie.getTitle().equals(title) && movie.getMovieType().equals(movieType)) {
					while (!choiceCheck) {
						System.out.println("");
						System.out.println("===============================================");
						System.out.println("Which detail do you want to update?");
						System.out.println("Current movie title <" + movie.getTitle() + ">");
						System.out.println("1. Update the Movie Name");
						System.out.println("2. Update the Movie Type");
						System.out.println("3. Update the Movie Cast");
						System.out.println("4. Update the Movie Director");
						System.out.println("5. Update the Movie language");
						System.out.println("6. Update the Movie synopsis");
						System.out.println("7. Update the Movie running time");
						System.out.println("8. Update the Movie rating");
						System.out.println("9. Remove the Movie showtimes");
						System.out.println("10. Add the Movie showtimes");
						System.out.println("11. Update the Movie status");
						System.out.println("12. Exit");
						System.out.print("Choice: ");
						choice = sc.nextInt();
						sc.nextLine();

						switch (choice) {
						case 1: // 1 title
							System.out.print("Enter the new Movie Name: ");
							title = sc.nextLine();
							movie.setTitle(title);
							break;

						case 2: // 2 movieType
							System.out.print("Enter the Movie type: ");
							System.out.println("Choose the Movie type: ");
							System.out.println("1. Digital");
							System.out.println("2. 3D");
							System.out.println("3. Blockbuster ");
							do {
								rchoice = sc.nextInt();
								sc.nextLine();
								switch (rchoice) {
								case 1:
									movieType = Movie.DIGITAL;
									break;
								case 2:
									movieType = Movie.THREED;
									break;
								case 3:
									movieType = Movie.BLOCKBUSTER;
									break;
								default:
									System.out.println("No such choice");
								}
							} while (rchoice < 1 || rchoice > 3);
							movie.setMovieType(movieType);
							break;

						case 3: // 3 cast
							System.out.print("Enter the new Movie Cast(First actor)");
							actor1 = sc.nextLine();

							System.out.print("Enter the new Movie Cast(second actor)");
							actor2 = sc.nextLine();

							cast = new ArrayList<String>();
							cast.add(actor1);
							cast.add(actor2);
							movie.setCast(cast);
							break;

						case 4: // 4 director
							System.out.print("Enter the new Movie Director: ");
							director = sc.nextLine();
							movie.setDirector(director);
							;
							break;

						case 5:// 5 language
							System.out.print("Enter the new Movie language: ");
							language = sc.nextLine();
							movie.setLanguage(language);
							break;

						case 6:// 6 synopsis
							System.out.print("Enter the Movie synopsis: ");
							synopsis = sc.nextLine();
							movie.setSynopsis(synopsis);
							break;

						case 7:// 7 runningTime
							System.out.print("Enter the Movie running time: ");
							runningTime = sc.nextInt();
							sc.nextLine();
							movie.setRunningTime(runningTime);
							break;

						case 8:// 9 rating
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
								rchoice = sc.nextInt();
								sc.nextLine();
								switch (rchoice) {
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
							} while (rchoice < 1 || rchoice > 7);

							movie.setRating(rating);
							break;

						case 9:// 10 remove showTimes
							List<ShowTime> temp = movie.getShowTimes();
							ShowTime st = null;
							boolean idCheck = false;
							if (temp.size() == 0) {
								System.out.println("No showtime to remove: ");
								break;
							}
							System.out.println("==========Current Show Times============");
							for (int l = 0; l < temp.size(); l++) {
								System.out.println((l + 1) + ": " + temp.get(l).getShowTime() + " "
										+ temp.get(l).getShowDate() + " " + temp.get(l).getCinema().getCinemaCode()
										+ " " + temp.get(l).getCinema().getCineplex().getName());
							}
							do {
								System.out.println("Enter a number to remove: ");
								rchoice = sc.nextInt();
								sc.nextLine();
								if (rchoice > temp.size() || rchoice < 1)
									System.out.println("Out of range! Please Enter again!");
							} while (rchoice > temp.size() || rchoice < 1);
							int index = rchoice - 1;
							// update the time slot in cinema
							for (Cinema cnma : cinemaList) {
								if (cnma.getCinemaId() == temp.get(index).getCinema().getCinemaId()) {
									cnma.setTimeSlotStatus(temp.get(index).getShowDateTime(), TimeSlot.AVAILABLE);
								}
							}
							temp.remove(index);
							movie.setShowTimes(temp);
							System.out.println("Showtime removed");

							break;
						case 10:// 11 add showTimes
							System.out.println("=============Available Show Times to add================");
							int showTimeId = showTimeList.size() + 1;

							for (Cinema cinema : cinemaList) {
								System.out.println(cinema.getCinemaId() + ": " + cinema.getClassType() + " "
										+ cinema.getCinemaCode() + " from " + cinema.getCineplex().getName());
							}
							while (!codeCheck) {
								System.out.print("Enter the cinema id: ");
								int cinemaId = sc.nextInt();
								sc.nextLine();

								for (Cinema cnma : cinemaList) {
									if (cnma.getCinemaId() == cinemaId) {

										cinema = cnma;
										tickets = new Ticket[cinema.getSeat().length];
										for (int s = 0; s < cinema.getSeat().length; s++) {

											float price = 0.0f;

											tickets[s] = new Ticket(s, cinema.getSeat()[s], price, Ticket.AVAILABLE);

										}
										codeCheck = true;
									}
								}
							}

							System.out.println("You have chosen:");
							System.out.println(cinema.getClassType() + " " + cinema.getCinemaCode() + " from "
									+ cinema.getCineplex().getName());

							List<String> temp2 = new ArrayList();
							int count = 0;
							System.out.println("=====Movie Show Time Slot=====");
							System.out.println("total number of slot is: " + cinema.getTimeSlot().size());

							if (cinema.getTimeSlot().size() == 1) {
								System.out.println(count + ". " + cinema.getTimeSlot().get(0).getDate());
								temp2.add(cinema.getTimeSlot().get(0).getDate());
							} else {
								System.out.println(count + ". " + cinema.getTimeSlot().get(0).getDate());
								temp2.add(cinema.getTimeSlot().get(0).getDate());
								count++;

								for (int j = 1; j < cinema.getTimeSlot().size(); j++) {
									if (cinema.getTimeSlot().get(j).getDate()
											.compareTo(cinema.getTimeSlot().get(j - 1).getDate()) != 0) {
										System.out.println(count + ". " + cinema.getTimeSlot().get(j).getDate());
										temp2.add(cinema.getTimeSlot().get(j).getDate());
										count++;
									}
								}
							}
							showTimeCheck = false;

							while (!showTimeCheck) {

								System.out.println("Please choose the date: ");
								int choseDay = sc.nextInt();
								sc.nextLine();
								if (choseDay >= count || choseDay < 0) {
									System.out.println("out of range! Please re-choose date");
									showTimeCheck = false;
								} else {
									String day_string = temp2.get(choseDay);

									boolean date_check = false;
									int slot_count = 0;
									// list to store the menu
									List<TimeSlot> timeSlotArray = new ArrayList();

									for (int k = 0; k < cinema.getTimeSlot().size(); k++) {
										if (cinema.getTimeSlot().get(k).getDate().equals(day_string)
												&& cinema.getTimeSlot().get(k).getStatus().equals(TimeSlot.AVAILABLE)) {
											slot_count++;
											System.out.println(
													slot_count + ": " + cinema.getTimeSlot().get(k).getTime() + " ");
											timeSlotArray.add(cinema.getTimeSlot().get(k));
											date_check = true;
										}
									}
									if (date_check == false) {
										// no time slot found ask to enter again
										System.out.println("No time slot found for input " + day_string + ".");

									} else {
										int time_slot_no = 0;
										do {
											System.out.println("Please select a time slot (1 to " + slot_count + "): ");
											time_slot_no = sc.nextInt();
											sc.nextLine();
										} while (time_slot_no < 0 || time_slot_no > slot_count);

										chosen_timeSlot = timeSlotArray.get(time_slot_no - 1).getDateTime();
										showTimeCheck = true;
									}
								}

							}

							cinema.setTimeSlotStatus(chosen_timeSlot, TimeSlot.UNAVAILABLE);
							ShowTime showtime = new ShowTime(showTimeId, cinema, chosen_timeSlot, tickets);
							movie.getShowTimes().add(showtime);
							System.out.println("Show time added!");
							// sc.nextLine();
							break;
						case 11:// 12 status
							System.out.println("Select the new Movie show status: ");
							System.out.println("1. Coming Soon");
							System.out.println("2. Preview");
							System.out.println("3. Now Showing");
							System.out.println("4. End of Showing");
							System.out.print("Choice: ");
							do {
								rchoice = sc.nextInt();
								sc.nextLine();
								switch (choice) {
								case 1:
									status = "Coming Soon";
									break;
								case 2:
									status = "Preview";
									break;
								case 3:
									status = "Now Showing";
									break;
								case 4:
									status = "End of Showing";
									break;
								default:
									System.out.println("No such choice");
								}
							} while (rchoice < 1 || rchoice > 4);
							movie.setStatus(status);
							break;
						case 12: // write into DB
							SerializeDB.writeSerializedObject("Cinema.ser", cinemaList);
							SerializeDB.writeSerializedObject("Movie.ser", movieList);
							choiceCheck = true;
							return true;

						default:
							System.out.println("No such choice");
						}

					}
				}
			}
		} catch (Exception e) {
			throw e;
			// System.out.println( "Exception >> " + e.getMessage() );
			// return false;
		}
		System.out.println("Movie not found in Database.");
		return false;
	}

	/**
	 * This method is used by both moviegoer and staff to add a review to a particular movie
	 * @param MovieId The ID of selected movie
	 * @param name The name of reviewer
	 * @param email Their email
	 * @param rating Their rating
	 * @param review Their review's content
	 * @return true if adding is successful, false otherwise
	 */
	public static boolean addReview(int MovieId, String name, String email, float rating, String review) {
		for (Movie mv : movieList) {
			if (mv.getMovieId() == MovieId) {
				mv.addReview(name, email, rating, review);
				SerializeDB.writeSerializedObject("Movie.ser", movieList);
				return true;
			}
		}
		return false;
	}

	/**
	 * This method supplements addMovie() method. Which checks for duplicate of the movie, input by the user, and the database 
	 * @param name Name of the movie
	 * @param director The director of the movie
	 * @param type The movie's type
	 * @return true if there is duplicate, false otherwise
	 */
	private static boolean checkDuplicateMovie(String name, String director, String type) {

		for (Movie movie : movieList) {
			if ((movie.getTitle().equalsIgnoreCase(name)) && (movie.getMovieType().equalsIgnoreCase(type))
					&& (movie.getDirector().equals(director))) {
				System.out.println("Movie already in database. Please add another movie");
				return true;
			}
		}
		return false;
	}

	/**
	 * This method simply shows all movies in the database
	 * @return
	 */
	public static List<Movie> viewAllMovie() {
		System.out.println("============All Movies================");
		int sn = 0;
		for (Movie movie : movieList) {
			sn++;
			System.out.println(sn + ". " + movie.getTitle() + ", (" + movie.getStatus() + ")");

		}
		System.out.println("======================================");
		return movieList;
	}
	
	/**
	 * This method simply shows all movies with detail view.
	 * @return
	 */
	public static List<Movie> viewAllMovieWithDetail() {
		System.out.println("============All Movies================");
		for (Movie movie : movieList) {
			movie.showMovieDetailWithReview();
		}
		System.out.println("======================================");
		return movieList;
	}
	/**
	 * Search Movies by name and return all the movies that contain the searched name
	 * @param movieName
	 * @return List<Movie> List of Movie search by name
	 */
	public static List<Movie> searchMovies(String movieName) {
		// empty array list for the result
		List<Movie> returnMovieList = new ArrayList<>();
		for(Movie movie : movieList){
			if(movie.getTitle().toLowerCase().contains(movieName.toLowerCase())){
			 // if search name is in movie title add to list
				returnMovieList.add(movie);
			}
		}
		return returnMovieList;
	}
}
