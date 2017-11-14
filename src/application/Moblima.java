package application;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

import database.SerializeDB;
import entity.*;

import java.io.*;
import java.text.SimpleDateFormat;

public class Moblima {

	static Scanner sc = new Scanner(System.in);
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
				break;

			case 2: // search for movies
				break;

			case 3: // top 5 ranking
				break;

			case 4: // booking and purchasing tickets
				do {
					System.out.println("1. Start a new booking");
					System.out.println("2. View past booking");
					System.out.println("3. Back to main menu");
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
		System.out.print("Staff username: ");
		String username = sc.nextLine();
		System.out.print("Password: ");
		String pw = sc.nextLine();
		Staff staff = new Staff(username, pw);
	}

	private void showAllMovie() {

	}

	private static void bookTicket() {
		// display all now showing movies
		System.out.println("Now showing movies:");
		ArrayList<Movie> movieList = new ArrayList<>();
		movieList = (ArrayList<Movie>) SerializeDB.readSerializedObject("Movie.ser");
		System.out.println("ID\tMovie title");
		for (int i = 0; i < movieList.size(); i++) {
			Movie movie = (Movie) movieList.get(i);
			if (movie.getStatus() == "Now showing") {
				System.out.printf("%d. %s\n", movie.getMovieId(), movie.getTitle());
			}
		}

		System.out.print("Enter movie ID to book: ");
		int movieID = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < movieList.size(); i++) {
			Movie movie = (Movie) movieList.get(i);
			if (movie.getMovieId() == movieID) {
				System.out.printf("Showtime for %s\n", movie.getTitle());
				System.out.printf("DateTime\t\t\tCinema\t\t\tAvailable Seats");
				ArrayList<ShowTime> stList = movie.getShowTimes();
				for (int j = 0; j < stList.size(); j++) {
					ShowTime st = stList.get(j);
					System.out.print(st.getShowDate());
					System.out.printf("%15s %d%n", st.getCinema().getCinemaId(),
							(st.getCinema()).getAvailSeatNum());
					if ((st.getCinema()).getAvailSeatNum() > 0) {
						System.out.println("--------Seat layout--------");
						(st.getCinema()).getSeatLayout().printSeatLayout();
						System.out.println("---------------------------");
					}
				}
				System.out.print("Enter the cineplex name: ");
				String cineplexName = sc.nextLine();
				sc.nextLine();
				System.out.print("Enter the cinema code: ");
				String cinemaCode = sc.nextLine();
				sc.nextLine();
				System.out.print("Enter row number of seat you want to book: ");
				int row = sc.nextInt();
				sc.nextLine();
				if (row != -1) {
					System.out.print("Column number: ");
					int col = sc.nextInt();
					sc.nextLine();
					Seat tmpSeat = new Seat(row, col, true);
					System.out.println("Choose your ticket type (1. Child | 2. Adult | 3. Senior Citizen");
					int tchoice = sc.nextInt();
					String type;
					switch (tchoice) {
					case 1:
						type = "Child";
						break;
					case 2:
						type = "Adult";
						break;
					case 3:
						type = "Senior Citizen";
						break;
					default:
						type = "Adult";
					}

					// get the ticket and seat with selected details
					for (int index = 0; index < stList.size(); index++) {
						ShowTime st = stList.get(index);
						if (st.getCinema().getCinemaCode() == cinemaCode
								&& (st.getCinema().getSeatLayout().getSeat(row, col)).equals(tmpSeat)) {
							// set the status of selected seat to unavailable
							stList.get(index).getCinema().getSeatLayout().getSeat(row, col).setStatus(false);
							
							//get ticket's details
							ArrayList<Ticket> ticketList = (ArrayList<Ticket>) SerializeDB.readSerializedObject("Ticket.ser");
							
							for (int j=0; j<ticketList.size();j++)
							{
								if((ticketList.get(j).getSeat()).equals(tmpSeat) && ticketList.get(j).getTicketType() == type)
									{
										//check if the selected date is holiday/weekend/discount day
									
									}
							}
							break;
						}//end if
					}
				}
				break;
			} // end if (movie.getMovieId() == movieID)
		} // end for loop checking for movie

	}

	private static void pastBooking() {

	}
	
	private void createTXN()
	{
		
	}
}
