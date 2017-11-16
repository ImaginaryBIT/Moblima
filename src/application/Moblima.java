package application;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import database.SerializeDB;
import entity.Movie;
import entity.MovieGoer;
import entity.Review;
import entity.ShowTime;
import entity.Staff;
import entity.Ticket;
import entity.Transaction;

public class Moblima {
	private static final long serialVersionUID = 1L;
	private static Scanner sc = new Scanner(System.in);
	private static List<Movie> movieList = new ArrayList<>();
	// private static Person person;

	public static void main(String[] args) throws Exception {
		
		int choice;
		movieList = (ArrayList<Movie>) SerializeDB.readSerializedObject("Movie.ser");
		do {

			System.out.println("=====================================");
			System.out.println("|1. List Movies                     |");
			System.out.println("|2. Top 5 Ranking                   |");
			System.out.println("|3. Search and Book					|");
			System.out.println("|4. Staff Login                     |");
			System.out.println("=====================================");

			System.out.print("Enter your choice: ");
			while (true) {
				try {
					choice = sc.nextInt();
					sc.nextLine();
					break;
				} catch (InputMismatchException e) {
					System.out.println("Your choice is in incorrect format");
					sc.nextLine();
				}
			}
			
			switch (choice) {
			case 1: // list all movies
				movieList = MovieController.viewAllMovie();
				break;

			case 2: // search for movies
			case 4:
				System.out.print("Enter movie name to search: ");
				String movieTitle = sc.nextLine();
				sc.nextLine();
				List<Movie> searchMovieList = MovieController.searchMovies(movieTitle);
				if(searchMovieList.isEmpty()){
					System.out.println("No movie found");
				}
				else{
					int sn = 0;
					for(Movie movie : searchMovieList){
						sn = sn+1;
						System.out.println(sn +". "+ movie.getTitle()+",( "+movie.getStatus()+")");
					}
				}
				menuAfterList(searchMovieList);
				break;

			case 3: // top 5 ranking
				String rankBy = "";
				System.out.println("=====================================");
				System.out.println("|1. Rank by Sales                   |");
				System.out.println("|2. Rank by Review Rate             |");
				System.out.println("|3. Back to main menu               |");
				System.out.println("=====================================");
				System.out.print("Enter your choice: ");

				while (true) {
					try {
						choice = sc.nextInt();
						sc.nextLine();
						break;
					} catch (InputMismatchException e) {
						System.out.println("Your choice is in incorrect format");
						sc.nextLine();
					}
				}
				sc.nextLine();
				if (choice == 1)
					rankBy = "sales";
				else if (choice == 2)
					rankBy = "review";
				List<Movie> top5movies = showTopRank(rankBy);
				System.out.println("\nTop 5 Ranking");
				for (int i = 0; i < top5movies.size(); i++) {
					System.out.printf("%d\t%s", i + 1, top5movies.get(i).getTitle());
				}
				break;

			case 5: // staff login
				staffLogin();
				break;

			default: // need to improve here
				System.out.println("Re-enter your choice!");
				System.out.print("Enter your choice: ");
				while (true) {
					try {
						choice = sc.nextInt();
						sc.nextLine();
						break;
					} catch (InputMismatchException e) {
						System.out.println("Your choice is in incorrect format");
						sc.nextLine();
					}
				}
			}
		} while (choice <= 5 && choice > 0); // end of do-while loop
	}
	
	private static void menuAfterList(List<Movie> movieLst){
		try{
			do{
				System.out.println("=======Options =========");
				System.out.println("|1. Start a new booking ");
				System.out.println("|2. View Movie Detail   ");
				System.out.println("|3. View past booking   ");
				System.out.println("|4. Go Back to Main Menu");
				System.out.print("  Your Choice : ");
				int no = sc.nextInt();
				switch(no){
				case 1:
					System.out.print("Enter Movie No to View Detail: ");
					try{
						int selectedIndex = sc.nextInt();
						Movie movie = movieLst.get(selectedIndex-1);
						bookTicket(movie);
						
					} catch (InputMismatchException e) {
						System.out.println("Your choice is in incorrect format");
						sc.nextLine();
					}
					
					break;
				case 2:
					System.out.print("Enter Movie No to View Detail: ");
					try{
						int selectedIndex = sc.nextInt();
						Movie movie = movieLst.get(selectedIndex-1);
						viewMovieDetail(movie);
						
					} catch (InputMismatchException e) {
						System.out.println("Your choice is in incorrect format");
						sc.nextLine();
					}
					break;
				case 3:
					pastBooking();
					break;
				case 4:
					return;
				default:
					System.out.println("Sorry, there is choice no. " + no);
				}
			}
			while(true);
		}
		catch(Exception e){
			System.out.println("Invalid Input");
		}
		
	}
	private static Movie writeReview(Movie movie) {

		// ask for user's email
		List<MovieGoer> mgList = (ArrayList<MovieGoer>) SerializeDB.readSerializedObject("MovieGoer.ser");
		MovieGoer mg = null;
		boolean foundEmail = false;
		System.out.print("\nEnter your email: ");
		String email = sc.nextLine();
		sc.nextLine();
		for (int i = 0; i < mgList.size(); i++) {
			mg = mgList.get(i);
			if (mg.getEmail().toLowerCase() == email.toLowerCase()) {
				foundEmail = true;
				break;
			}
		}
		if (!foundEmail) {
			System.out.println("\nThis is the first time you are here. Kindly provide us your info");
			System.out.print("Enter your name: ");
			String name = sc.nextLine();
			sc.nextLine();
			int contact;
			while (true) {
				try {
					System.out.print("Contact number: ");
					contact = sc.nextInt();
					sc.nextLine();
					break;
				} catch (InputMismatchException e) {

					System.out.println("Your contact is in incorrect format. Please re-enter");
					sc.nextLine();
				}
			}
			mg = new MovieGoer(name, email, contact);
		}
		System.out.println("Enter your review:");
		String content = sc.nextLine();
		sc.nextLine();
		System.out.print("Enter your rate: ");
		int rate;
		while (true) {
			try {
				rate = sc.nextInt();
				sc.nextLine();
				break;
			} catch (InputMismatchException e) {

				System.out.println("Your rate is in incorrect format. Please re-enter");
				sc.nextLine();
			}
		}
		System.out.println();
		List<Review> rvList = (ArrayList<Review>) movie.getReviews();
		movie.setReviews(rvList);
		return movie;
	}

	private static void staffLogin() {
		Staff staff = new Staff();
		if (!staff.login())
			System.out.println("Incorrect ID or Password");
		else
			StaffFunctionsController.printStaffMenu();
	}


	// get top 5 sort by review or no_of_ticket_sold
	public static List<Movie> showTopRank(String rankBy) {
		// temp movie to hold during sort
		Movie temp_movie;
		// change to normal list to do the sort
		Movie[] newMovieList = new Movie[movieList.size()];
		newMovieList = (Movie[]) movieList.toArray(newMovieList);
		if (rankBy == "review") {
			// do insertion sort
			for (int i = 0; i < newMovieList.length - 1; i++) {
				for (int d = i; d >= 0; d--) {
					if (newMovieList[i].getOverallUserRating() > newMovieList[i + 1].getOverallUserRating()) {
						temp_movie = newMovieList[i];
						newMovieList[i] = newMovieList[i + 1];
						newMovieList[i + 1] = temp_movie;
					} else {
						break;
					}
				}
			}
		} else {
			// do insertion sort
			for (int i = 0; i < newMovieList.length - 1; i++) {
				for (int d = i; d >= 0; d--) {
					if (newMovieList[i].getTicketSold() > newMovieList[i + 1].getTicketSold()) {
						temp_movie = newMovieList[i];
						newMovieList[i] = newMovieList[i + 1];
						newMovieList[i + 1] = temp_movie;
					} else {
						break;
					}
				}
			}
		}
		// return only top 5
		List<Movie> top5List = new ArrayList<>();
		for (int i = 0; i < newMovieList.length; i++) {
			if (i < 5) {
				top5List.add(newMovieList[i]);
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
		    if(st.getCinema().getAisleColumns().contains(st.getCinema().getSeat()[z].getColumn())){
                System.out.print("  ");
            }
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
			int contact = 0;
			while (true) {
				try {
					contact = sc.nextInt();
					sc.nextLine();
					break;
				} catch (InputMismatchException e) {
					System.out.println("Your contact is in incorrect format");
					sc.nextLine();
				}
			}

			for (int i = 0; i < mgList.size(); i++) {
				movieGoer = mgList.get(i);
				if (movieGoer.getEmail() == email && movieGoer.getContact() == contact) {
					if (movieGoer.getTxnList().size() != 0) {
						System.out.println("\nYour booking history:");
						System.out.printf("%30s %30s %30s %10s %10s%n", "Bought at", "Movie Name", "Show Time",
								"No. of Tickets", "Total Payment");
						for (int j = 0; j < movieGoer.getTxnList().size(); j++) {
							txn = movieGoer.getTxnList().get(i);
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

	private static boolean purchaseTicket(List<Ticket> bookedTickets) {
		System.out.println("=====================================");
		System.out.println("|1. Make payment                    |");
		System.out.println("|2. Cancel booking                  |");
		System.out.println("=====================================");
		System.out.print("Enter your choice: ");
		int choice = 0;
		while (true) {
			try {
				choice = sc.nextInt();
				sc.nextLine();
				break;
			} catch (InputMismatchException e) {
				System.out.println("Your choice is in incorrect format");
				sc.nextLine();
			}
		}
		if (choice == 1) {
			for (int i = 0; i < bookedTickets.size(); i++) {
				Ticket ticket = bookedTickets.get(i);
				ticket.setStatus(Ticket.SOLD);
			}
			return true;
		}
		return false;
	}



	private static String ticketTypePicker() {
		int typeChoice;
		do {
			System.out.println("===================================================");
			System.out.println("| Ticket type 1. Child 2. Adult 3. Senior Citizen |");
			System.out.println("===================================================");
			System.out.print("Enter your choice: ");

			while (true) {
				try {
					typeChoice = sc.nextInt();
					sc.nextLine();
					break;
				} catch (InputMismatchException e) {
					System.out.println("Your choice is in incorrect format");
					sc.nextLine();
				}

			}

			if (typeChoice == 1)
				return Ticket.CHILD;
			else if (typeChoice == 3)
				return Ticket.CENIOR_CITIZEN;
			else
				return Ticket.ADULT;
		} while (typeChoice > 0 && typeChoice < 4);
	}


	private static void viewMovieDetail(Movie movie) throws Exception{
		try {
			movie.showMovieDetailWithReview();
			
			do {
				System.out.println("===What would you like to do?========");
				System.out.println("|1. Book this Movie                  |");
				System.out.println("|2. Write Review                     |");
				System.out.println("|3. Exit				             |");
				System.out.println("======================================");				
				System.out.print("Enter your choice: ");
				int choice = sc.nextInt();
				switch (choice) {
				case 1:
					if (movie.getStatus().equalsIgnoreCase("Coming Soon")) {
						System.out.println("The movie is coming soon. Please come back later");
					} else if (movie.getStatus().equalsIgnoreCase("End of Showing")) {
						System.out.println("Sorry, the showing period for this movie has ended");
					}else{
						//book
						bookTicket(movie);
					}
					
					break;
				case 2:
					writeReview(movie);
					break;
				case 3:
					return;
				default:
					System.out.println("Sorry, there is no " + choice);
				}
			}while(true);
		} catch (Exception e) {
			
			System.out.println("Exception >> " + e.getMessage());
			throw e;
		}
	}

	private static void bookTicket(Movie movie) throws Exception {
		// ask user to choose a movie
		do {
			int sn = 0;
			List<ShowTime> showTimes = movie.getShowTimes();
			for (ShowTime showTime : showTimes){
				sn = sn +1;
				System.out.printf("Showtime for %s in %s\n", sn, movie.getTitle(), movie.getMovieType());
				System.out.printf("ShowTime ID \tDateTime \t\t\tCinema \t\t\tAvailable Seats");
			}
			System.out.print("Please enter showtime no: ");
			int selectedNo = sc.nextInt();
			ShowTime selectedShowTime = null;
			try{
				selectedShowTime = showTimes.get(selectedNo-1);
			} catch (Exception e) {
				System.out.println("ShowTime ID not found. Re-enter the ShowTime ID");
				return;
			}
		
			int availSeatNum = selectedShowTime.getNoOfTicketsAvailable();
			System.out.printf("%d \t", selectedShowTime.getShowTimeId());
			System.out.print(selectedShowTime.getShowDateTime());
			System.out.printf("\t\t\t%s \t\t\t%d%n", selectedShowTime.getCinema().getCinemaId(), availSeatNum);
			if (availSeatNum > 0) {
				System.out.println("--------Seat layout--------");
				printingSeatLayout(selectedShowTime);
				System.out.println("---------------------------");
				System.out.println();
			}
			
			// ask user to start booking
			int bchoice;
			System.out.println("======================================");
			System.out.println("|Enter 1. To start booking 2. To exit|");
			System.out.println("======================================");
			while (true) {
				try {
					bchoice = sc.nextInt();
					sc.nextLine();
					break;
				} catch (InputMismatchException e) {
					System.out.println("Your choice is in incorrect format");
					sc.nextLine();
				}
			}

			if (bchoice == 1) {
	
				
				startBooking(selectedShowTime, movie.getTitle());
			} // end of booking
			
		}while(true);
		
	}
	
	@SuppressWarnings("unchecked")
	private static void startBooking(ShowTime selectedST, String movieTitle) {
		List<Ticket> bookedTickets = new ArrayList<>();
		int choice;
		do {
			System.out.println("=====================================");
			System.out.println("|1. Pick a seat                     |");
			System.out.println("|2. Confirm booking                 |");
			System.out.println("|3. Go back to main menu            |");
			System.out.println("=====================================");
			System.out.print("Enter your choice: ");

			while (true) {
				try {
					choice = sc.nextInt();
					sc.nextLine();
					break;
				} catch (InputMismatchException e) {
					System.out.println("Your choice is in incorrect format");
					sc.nextLine();
				}

			}
			switch (choice) {
			case 1:// pick a seat
				int col = 0;
				int row = 0;
				int x = 0;
				Ticket[] tmpTickets = selectedST.getTickets();
				// Seat selectedSeat = new Seat();
				System.out.print("\nEnter the seat number: ");
				int seatNum;

				while (true) {
					try {
						seatNum = sc.nextInt();
						sc.nextLine();
						break;
					} catch (InputMismatchException e) {
						System.out.println("Your seat number is in incorrect format");
						sc.nextLine();
					}
				}

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
				int mgContact;

				while (true) {
					try {
						mgContact = sc.nextInt();
						sc.nextLine();
						break;
					} catch (InputMismatchException e) {
						System.out.println("Your contact is in incorrect format");
						sc.nextLine();
					}
				}

				MovieGoer movieGoer = new MovieGoer(mgName, mgEmail, mgContact);
				Transaction txn = new Transaction(selectedST.getShowDateTime(), selectedST.getCinema().getCinemaCode(),
						movieTitle, bookedTickets);
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
