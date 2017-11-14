package application;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

import database.SerializeDB;
import entity.*;

import java.io.*;
import java.text.SimpleDateFormat;

public class Moblima {

	private static Scanner sc = new Scanner(System.in);
	private static List list;
	// private static Person person;

	public static void main(String[] args) {

		int choice;
		do {

			System.out.println("=====================================");
			System.out.println("|1. List Movies                     |");
			System.out.println("|2. Search Movie                    |");
			System.out.println("|3. Top 5 Ranking                   |");
			System.out.println("|4. Booking and Purchasing Tickets  |");
			System.out.println("|5. Staff Login                     |");
			System.out.println("=====================================");

			System.out.print("Enter your choice: ");
			choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1: // list all movies
				showAllMovies();
				break;

			case 2: // search for movies
				ArrayList<Movie> movieList = new ArrayList<>();

				System.out.print("Enter movie name to book: ");
				String movieTitle = sc.nextLine();
				sc.nextLine();
				movieList = searchMovies(movieTitle);
				if (movieList.size() == 0)
					System.out.println("No movie found");
				break;

			case 3: // top 5 ranking
				String rankBy = "";
				ArrayList<Movie> top5movies = showTopRank(rankBy);
				break;

			case 4: // booking and purchasing tickets
				do {
					System.out.println("=====================================");
					System.out.println("|1. Start a new booking             |");
					System.out.println("|2. View past booking               |");
					System.out.println("|3. Back to main menu               |");
					System.out.println("=====================================");
					System.out.print("Enter your choice: ");
					choice = sc.nextInt();
					sc.nextLine();

					switch (choice) {
					case 1:
						bookTicket();
						break;
					case 2:
						pastBooking();
						break;
					case 3:
						break;
					default:
						System.out.print("No such choice. Re-enter your choice");
						break;
					}
				} while (choice != 3);
				break;

			case 5: // staff login
				staffLogin();
				break;

			default: // need to improve here
				System.out.println("Re-enter your choice!");
				System.out.print("Enter your choice: ");
				choice = sc.nextInt();
			}
		} while (choice <= 5 && choice > 0); // end of do-while loop
	}

	private static void staffLogin() {
		Staff staff = new Staff();
		if (!staff.login())
			System.out.println("Incorrect ID or Password");
		else
			staff.showStaffMenu();
	}

	public static ArrayList<Movie> searchMovies(String movieName) {
		// empty array list for movie
		ArrayList<Movie> movieList = new ArrayList<>();

		// pull from database and add to movieList
		list = (ArrayList<Movie>) SerializeDB.readSerializedObject("Movie.ser");
		for (int i = 0; i < list.size(); i++) {
			Movie mv = (Movie) list.get(i);
			if (mv.getTitle().toLowerCase().contains(movieName.toLowerCase())) {
				// if search name is in movile title add to list
				movieList.add(mv);
			}
		}
		return movieList;
	}

	// get all the Movies as Arraylist
	public static ArrayList<Movie> showAllMovies() {
		return (ArrayList<Movie>) SerializeDB.readSerializedObject("Movie.ser");
	}

	// get top 5 sort by review or no_of_ticket_sold
	public static ArrayList<Movie> showTopRank(String rankBy) {
		// temp movie to hold during sort
		Movie temp_movie;
		list = (ArrayList<Movie>) SerializeDB.readSerializedObject("Movie.ser");
		// change to normal list to do the sort
		Movie[] MovieList = new Movie[list.size()];
		MovieList = (Movie[]) list.toArray(MovieList);
		if (rankBy == "review") {
			// do insertion sort
			for (int i = 0; i < MovieList.length - 1; i++) {
				for (int d = i; d >= 0; d--) {
					if (MovieList[i].getOverallUserRating() > MovieList[i + 1].getOverallUserRating()) {
						temp_movie = MovieList[i];
						MovieList[i] = MovieList[i + 1];
						MovieList[i + 1] = temp_movie;
					} else {
						break;
					}
				}
			}
		} else {
			// do insertion sort
			for (int i = 0; i < MovieList.length - 1; i++) {
				for (int d = i; d >= 0; d--) {
					if (MovieList[i].getTicketSold() > MovieList[i + 1].getTicketSold()) {
						temp_movie = MovieList[i];
						MovieList[i] = MovieList[i + 1];
						MovieList[i + 1] = temp_movie;
					} else {
						break;
					}
				}
			}
		}
		// return only top 5
		ArrayList<Movie> top5List = new ArrayList<>();
		for (int i = 0; i < MovieList.length; i++) {
			if (i < 5) {
				top5List.add(MovieList[i]);
			} else {
				break;
			}
		}
		return top5List;
	}
	/*
	 * list = (ArrayList<Cinema>) SerializeDB.readSerializedObject("Cinema.ser");
	 * for (int i = 0; i < list.size(); i++) { Cinema cnma = (Cinema) list.get(i);
	 * Ticket[] tckt = new Ticket[cnma.getSeat().length]; for (int s = 0; s <
	 * cnma.getSeat().length; s++) {
	 * 
	 * // movie type and getting system setting here // if newMovie.getType() ==
	 * "something" price = something float price = 0.0f; // if holiday add price +=
	 * 2.0; if (s == 10 || s == 11 || s == 12) { tckt[s] = new Ticket(s,
	 * cnma.getSeat()[s], price, Ticket.SOLD); } else { tckt[s] = new Ticket(s,
	 * cnma.getSeat()[s], price, Ticket.AVAILABLE); }
	 * 
	 * } ShowTime st = new ShowTime(0, cnma, new Date(), tckt);
	 * showtimeList.add(st); break; }
	 */

	private static void printingSeatLayout(ShowTime st) {
		int prevRow = 0;
		for (int z = 0; z < st.getTickets().length; z++) {

			if (st.getTickets()[z].getSeat().getRow() != prevRow) {
				System.out.println("");
			}
			// print layout [00] ,[XX]

			if (st.getTickets()[z].getStatus().equals(Ticket.AVAILABLE)) {
				System.out.print(
						"[" + st.getTickets()[z].getSeat().getRow() + st.getTickets()[z].getSeat().getColumn() + "]");
			} else {
				System.out.print("[--]");
			}
			// update the previous row
			prevRow = st.getTickets()[z].getSeat().getRow();
		}
	}

	@SuppressWarnings("unchecked")
	private static void bookTicket() {
		// display all now showing movies
		System.out.println("Now showing movies:");
		showAllMovies();
		// ask user for movie title
		ArrayList<Movie> movieList = new ArrayList<>();
		String movieTitle;
		do {
			System.out.print("Enter movie name to book: ");
			movieTitle = sc.nextLine();
			sc.nextLine();
			movieList = searchMovies(movieTitle);
			if (movieList.size() == 0)
				System.out.println("No movie found. Re-enter the movie title");
		} while (movieList.size() == 0);

		// print out showtime for each movie
		for (int i = 0; i < movieList.size(); i++) {
			Movie movie = (Movie) movieList.get(i);
			if (movie.getStatus() == "Now showing") {
				System.out.printf("Showtime for %s %s\n", i, movie.getTitle(), movie.getMovieType());
				System.out.printf("ShowTime ID \tDateTime \t\t\tCinema \t\t\tAvailable Seats");
				List<ShowTime> stList = movie.getShowTimes();
				for (int j = 0; j < stList.size(); j++) {
					ShowTime st = stList.get(j);
					int availSeatNum = st.getNoOfTicketsAvailable();
					System.out.print(st.getShowTimeId() + "\t");
					System.out.print(st.getShowDateTime());
					System.out.printf("\t\t\t%s \t\t\t%d%n", st.getCinema().getCinemaId(), availSeatNum);
					if (availSeatNum > 0) {
						System.out.println("--------Seat layout--------");
						printingSeatLayout(st);
						System.out.println("---------------------------");
						System.out.println();
					}
				}
			}
		} // end of printing all showtime

		// ask for userinput
		int bchoice;
		System.out.println("======================================");
		System.out.println("|Enter 1. To start booking 2. To exit|");
		System.out.println("======================================");
		bchoice = sc.nextInt();
		sc.nextLine();
		if (bchoice == 1) {
			Movie movie;
			List<ShowTime> stList;
			boolean foundST = false;
			int i = 0;
			int j = 0;
			while (true) {
				System.out.print("Enter the ShowTime ID you want to book: ");
				int stID = sc.nextInt();
				sc.nextLine();
				for (i = 0; i < movieList.size(); i++) {
					movie = (Movie) movieList.get(i);
					if (movie.getTitle() == movieTitle) {
						stList = movie.getShowTimes();
						for (j = 0; j < stList.size(); j++) {
							ShowTime st = stList.get(j);
							if (st.getShowTimeId() == stID) {
								foundST = true;
								break;
							}
						}
					}
				}

				if (foundST)
					break;
				else
					System.out.println("Re-enter the ShowTime ID");
			} // end while

			ShowTime selectedST = (movieList.get(i)).getShowTimes().get(j);
			int b2choice;
			ArrayList<Ticket> bookedTickets = new ArrayList<>();
			
			
			
			do {
				System.out.println("=====================================");
				System.out.println("|1. Pick a seat                     |");
				System.out.println("|2. Confirm booking                 |");
				System.out.println("|3. Go back to main menu            |");
				System.out.println("=====================================");
				System.out.print("Enter your choice: ");
				b2choice = sc.nextInt();
				sc.nextLine();
				
				switch (b2choice) {
				case 1:// pick a seat
					int col = 0;
					int row = 0;
					int x = 0;
					Ticket[] tmpTickets = selectedST.getTickets();
					Seat selectedSeat = new Seat();
					System.out.print("\nEnter the seat number: ");
					int seatNum = sc.nextInt();
					sc.nextLine();

					col = seatNum / 10;
					row = (seatNum - col) / 10;
					
					try
					{
						for (x = 0; x < tmpTickets.length; x++) {
							Seat tmpSeat = tmpTickets[x].getSeat();
							if (tmpSeat.getRow() == row && tmpSeat.getColumn() == col) {
								selectedSeat = tmpSeat;
								break;
							}
						}
					}
					catch (ArrayIndexOutOfBoundsException exception)
					{
						System.out.println("Selected seat not found");
					}
					catch (Exception ex)
					{
						System.out.println(ex);
					}

					System.out.println("===================================================");
					System.out.println("| Ticket type 1. Child 2. Adult 3. Senior Citizen |");
					System.out.println("===================================================");
					System.out.print("Enter your choice: ");
					int typeChoice = sc.nextInt();
					String ticketType;
					if (typeChoice == 1)
						ticketType = Ticket.CHILD;
					else if (typeChoice == 3)
						ticketType = Ticket.CENIOR_CITIZEN;
					else
						ticketType = Ticket.ADULT;

					tmpTickets[x].setTicketType(ticketType);
					tmpTickets[x].setSeat(selectedSeat);
					bookedTickets.add(tmpTickets[x]);
					break;
				case 2: // confirm booking
					// update seats's availability to false and ticket to SOLD

					System.out.print("Enter your name: ");
					String mgName = sc.nextLine();
					sc.nextLine();
					System.out.print("Email: ");
					String mgEmail = sc.nextLine();
					sc.nextLine();
					System.out.print("Contact: ");
					int mgContact = sc.nextInt();
					sc.nextLine();

					MovieGoer movieGoer = new MovieGoer(mgName, mgEmail, mgContact);
					Transaction txn = new Transaction(selectedST.getShowDateTime(),
							selectedST.getCinema().getCinemaCode(), movieTitle, bookedTickets, movieGoer);
					movieGoer.setMovieGoerTXN(txn);

					printTXN(movieTitle, bookedTickets.size(), txn.getTotalPayment());
					// proceed to purchase
					if (purchaseTicket(bookedTickets)) {
						System.out.println("Payment was successful!!!");
						// add movieGoer to database
						ArrayList<MovieGoer> mgList = (ArrayList<MovieGoer>) SerializeDB
								.readSerializedObject("MovieGoer.ser");
						mgList.add(movieGoer);
						SerializeDB.writeSerializedObject("Staff.ser", mgList);
					}
					break;
				case 3: // back to main menu
					break;
				default:
					System.out.println("Option not found");
				}

			} while (bchoice > 0 && bchoice < 3);

		} // end of booking
	}

	private static void pastBooking() {

	}

	private static void printTXN(String movieTitle, int seatNum, float totalPayment) {
		System.out.println("Your ticket(s) is/are booked");
		System.out.println("------ Transaction details -----");
		System.out.println("Movie title: " + movieTitle);
		System.out.println("Number of seats: " + seatNum);
		System.out.println("Total price: " + totalPayment);
	}

	private static boolean purchaseTicket(ArrayList<Ticket> bookedTickets) {
		System.out.println("=====================================");
		System.out.println("|1. Make payment                    |");
		System.out.println("|2. Cancel booking                  |");
		System.out.println("=====================================");
		System.out.print("Enter your choice: ");
		int choice = sc.nextInt();
		if (choice == 1) {
			for(int i = 0;i<bookedTickets.size();i++)
			{
				Ticket ticket = bookedTickets.get(i);
				ticket.setStatus(Ticket.SOLD);
				ticket.getSeat().setStatus(false);
			}
			return true;
		}
		return false;
	}
}
