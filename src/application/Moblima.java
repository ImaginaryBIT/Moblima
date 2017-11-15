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
	private static final long serialVersionUID = 1L;
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
				System.out.println("=====================================");
				System.out.println("|1. Rank by Sales                   |");
				System.out.println("|2. Rank by Review Rate             |");
				System.out.println("|3. Back to main menu               |");
				System.out.println("=====================================");
				System.out.print("Enter your choice: ");
				choice = sc.nextInt();

				sc.nextLine();
				if (choice == 1)
					rankBy = "sales";
				else if (choice == 2)
					rankBy = "review";
				ArrayList<Movie> top5movies = showTopRank(rankBy);
				System.out.println("\nTop 5 Ranking");
				for (int i = 0; i < top5movies.size(); i++) {
					System.out.printf("%d\t%s", i + 1, top5movies.get(i).getTitle());
				}
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
		int movieId;
		// ask user for movie title
		ArrayList<Movie> movieList;
		String movieTitle;
		String movieType = "";
		Movie movie = null;

		// ask user to choose a movie
		do {
			System.out.print("Enter the movie name: ");
			movieTitle = sc.nextLine().toLowerCase();
			sc.nextLine();
			movieList = searchMovies(movieTitle);
			if (movieList.size() == 0)
				System.out.println("No movie found. Re-enter the movie title");
			else {
				System.out.println("Your movie is available in:");
				for (int a = 0; a > movieList.size(); a++) {
					movie = movieList.get(a);
					System.out.printf("%d   %s", a, movie.getMovieType());
				}
				// ask user to choose the type
				boolean foundType = false;
				do {
					System.out.print("\nEnter the movie type: ");
					movieType = sc.nextLine();
					sc.nextLine().toLowerCase();
					for (int b = 0; b < movieList.size(); b++) {
						movie = movieList.get(b);
						if (movie.getMovieType().toLowerCase() == movieType) {
							foundType = true;
							break;
						}
					}
					if (!foundType)
						System.out.println("Type not found. Please re-enter the type");
				} while (!foundType);
			}
		} while (movieList.size() == 0);

		// print out showtime for selected movie
		if (movie.getStatus() == "Coming Soon") {
			System.out.println("The movie is coming soon. Please come back later");
		} else if (movie.getStatus() == "End of Showing") {
			System.out.println("Sorry, the showing period for this movie has ended");
		} else {// printing showtime for "Now showing" and "Preview" movies
			for (int i = 0; i < movie.getShowTimes().size(); i++) {
				System.out.printf("Showtime for %s in %s\n", i, movie.getTitle(), movie.getMovieType());
				System.out.printf("ShowTime ID \tDateTime \t\t\tCinema \t\t\tAvailable Seats");
				List<ShowTime> stList = movie.getShowTimes();
				for (int j = 0; j < stList.size(); j++) {
					ShowTime st = stList.get(j);
					int availSeatNum = st.getNoOfTicketsAvailable();
					System.out.printf("%d \t", st.getShowTimeId());
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

		// ask user to start booking
		int bchoice;
		System.out.println("======================================");
		System.out.println("|Enter 1. To start booking 2. To exit|");
		System.out.println("======================================");
		bchoice = sc.nextInt();
		sc.nextLine();
		if (bchoice == 1) {

			ShowTime selectedST = showtimePicker(movie.getShowTimes());
			startBooking(selectedST, movieTitle);
		} // end of booking
	}

	private static void pastBooking() {
		SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd HH:MM");

		boolean foundMG = false;
		MovieGoer movieGoer;
		Transaction txn;

		ArrayList<MovieGoer> mgList = (ArrayList<MovieGoer>) SerializeDB.readSerializedObject("MovieGoer.ser");

		while (!foundMG) {
			System.out.print("Enter your email: ");
			String email = sc.nextLine();
			sc.nextLine();
			System.out.print("Enter your contact number: ");
			int contact = sc.nextInt();
			sc.nextLine();

			for (int i = 0; i < mgList.size(); i++) {
				movieGoer = mgList.get(i);
				if (movieGoer.getEmail() == email && movieGoer.getContact() == contact) {
					if (movieGoer.getMovieGoerTXN().size() != 0) {
						System.out.println("\nYour booking history:");
						System.out.printf("%30s %30s %30s %10s %10s%n", "Bought at", "Movie Name", "Show Time",
								"No. of Tickets", "Total Payment");
						for (int j = 0; j < movieGoer.getMovieGoerTXN().size(); j++) {
							txn = movieGoer.getMovieGoerTXN().get(i);
							System.out.printf("%30s %30s %30s %10d %10f%n", dft.format(txn.getTransactionDate()),
									txn.getMovieName(), dft.format(txn.getShowTime()), txn.getTickets().size(),
									txn.getTotalPayment());
						}
					} else
						System.out.println("No transaction found");
					foundMG = true;
					break;
				}
			}
			if (!foundMG)
				System.out.println("Your input information is not found. Please re-enter");
		}
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
			for (int i = 0; i < bookedTickets.size(); i++) {
				Ticket ticket = bookedTickets.get(i);
				ticket.setStatus(Ticket.SOLD);
			}
			return true;
		}
		return false;
	}

	private static ShowTime showtimePicker(List<ShowTime> stList) {
		// List<ShowTime> stList;
		ShowTime st = null;
		while (true) {
			System.out.print("Enter the ShowTime ID you want to book: ");
			int stID = sc.nextInt();
			sc.nextLine();

			for (int j = 0; j < stList.size(); j++) {
				st = stList.get(j);
				if (st.getShowTimeId() == stID) {
					return st;
				}

			}

			System.out.println("ShowTime ID not found. Re-enter the ShowTime ID");
		} // end while
	}

	private static String ticketTypePicker() {
		int typeChoice;
		do {
			System.out.println("===================================================");
			System.out.println("| Ticket type 1. Child 2. Adult 3. Senior Citizen |");
			System.out.println("===================================================");
			System.out.print("Enter your choice: ");
			typeChoice = sc.nextInt();

			if (typeChoice == 1)
				return Ticket.CHILD;
			else if (typeChoice == 3)
				return Ticket.CENIOR_CITIZEN;
			else
				return Ticket.ADULT;
		} while (typeChoice > 0 && typeChoice < 4);
	}

	@SuppressWarnings("null")
	private static void startBooking(ShowTime selectedST, String movieTitle) {
		ArrayList<Ticket> bookedTickets = null;
		int choice;
		do {
			System.out.println("=====================================");
			System.out.println("|1. Pick a seat                     |");
			System.out.println("|2. Confirm booking                 |");
			System.out.println("|3. Go back to main menu            |");
			System.out.println("=====================================");
			System.out.print("Enter your choice: ");
			choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1:// pick a seat
				int col = 0;
				int row = 0;
				int x = 0;
				Ticket[] tmpTickets = selectedST.getTickets();
				// Seat selectedSeat = new Seat();
				System.out.print("\nEnter the seat number: ");
				int seatNum = sc.nextInt();
				sc.nextLine();

				col = seatNum / 10;
				row = (seatNum - col) / 10;

				boolean foundSeat = false;
				do {
					for (x = 0; x < tmpTickets.length; x++) {
						if (tmpTickets[x].getSeat().getRow() == row && tmpTickets[x].getSeat().getColumn() == col
								&& tmpTickets[x].getStatus() == Ticket.AVAILABLE) {
							foundSeat = true;
							break;
						}
					}
					System.out.println("Seat not available. Re-enter seat number");
				} while (!foundSeat);

				String ticketType = ticketTypePicker();
				tmpTickets[x].setTicketType(ticketType);
				bookedTickets.add(tmpTickets[x]);
				break;
			case 2: // confirm booking
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
				Transaction txn = new Transaction(selectedST.getShowDateTime(), selectedST.getCinema().getCinemaCode(),
						movieTitle, bookedTickets, movieGoer);
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

		} while (choice != 3);
	}
}
