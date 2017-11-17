package application;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import database.SerializeDB;
import entity.Cinema;
import entity.Movie;
import entity.MovieGoer;
import entity.ShowTime;
import entity.Staff;
import entity.Ticket;
import entity.Transaction;

/**
 * This is the main interface that both staff and movieoger will work with
 * Moblima gives user the option to:
 * 1. List down all movies being shown (including "Preview" movies),
 * 2. Query the top 5 ranking based on either sale or review rate
 * 3. Search and book any Preview or Now Showing movies
 * 4. Also view their booking history
 * 5. This option is dedicated to staff only. 
 * Once the staff logins successfully, they can modify movies, show time, holidays, etc in the database. 
 * Changing the settings of the system will also be available to staff
 * @author group5
 *
 */

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
			System.out.println("|3. Search and Book                 |");
			System.out.println("|4. View past booking               |");
			System.out.println("|5. Staff Login                     |");
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
				menuAfterList(movieList);
				break;

			case 2: // top 5 ranking
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
				if (choice == 1)
					rankBy = "sales";
				else if (choice == 2)
					rankBy = "review";
				List<Movie> top5movies = showTopRank(rankBy);
				System.out.println("\nTop 5 Ranking");
				for (int i = 0; i < top5movies.size(); i++) {
                    if (choice == 1)
                        System.out.printf("%d\t%s : %s tickets sold", i + 1, top5movies.get(i).getTitle(),top5movies.get(i).getTicketSold());
                    else
                        if (top5movies.get(i).getOverallUserRating() == 0)
                            System.out.printf("%d\t%s : %s", i + 1, top5movies.get(i).getTitle(),"NA");
                        else
                            System.out.printf("%d\t%s : %s/5", i + 1, top5movies.get(i).getTitle(),top5movies.get(i).getOverallUserRating());
					System.out.println("");
				}
				menuAfterList(top5movies);
				break;
			case 3:
				System.out.print("Enter movie name to search: ");
				String movieTitle = sc.nextLine();
				List<Movie> searchMovieList = MovieController.searchMovies(movieTitle);
				if(searchMovieList.isEmpty()){
					System.out.println("No movie found");
				}
				else{
					int sn = 1;
					for(Movie movie : searchMovieList){
						System.out.println(sn +". "+ movie.getTitle()+",( "+movie.getStatus()+")");
						sn++;
					}
				}
				menuAfterList(searchMovieList);
				break;
			case 4:
				pastBooking();
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
		} while (choice <= 4 && choice > 0); // end of do-while loop
	}
	
	/**
	 * This methods will be called after a successful search of a movie.
	 * It offers users the options to start new booking, view the movie in full details or just simply go back to main menu 
	 * @param movieLst The list of movies being queried before hand
	 */
	private static void menuAfterList(List<Movie> movieLst){
		try{
			do{
				System.out.println("=======Options =========");
				System.out.println("|1. Start a new booking ");
				System.out.println("|2. View Movie Detail   ");
				System.out.println("|3. Go Back to Main Menu");
				System.out.print("  Your Choice : ");
				int no = sc.nextInt();
				switch(no){
				case 1:
					System.out.print("Enter Movie No to book: ");
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
					return;
				default:
					System.out.println("Sorry, there is choice no. " + no);
				}
			}
			while(true);
		}
		catch(Exception e){
			//System.out.println("Invalid Input"+e.getMessage());
		}		
	}
	
	/**
	 * The method generates a form for users to write a review for any particular movie.
	 * The user will needs to enter their email before starting writing review. This is for the purpose of showing and maintaining reviews
	 * Once the process of writing review is successful, the system will store the reviewer personal details, their review and the rate they have given in Movie.ser database
	 * @param movie The movie object that the user would like to give a review
	 * @return movie with a new review added
	 */
	private static Movie writeReview(Movie movie) {

		// ask for user's email
		List<MovieGoer> mgList = (ArrayList<MovieGoer>) SerializeDB.readSerializedObject("MovieGoer.ser");
		MovieGoer mg = null;
		boolean foundEmail = false;
                sc.nextLine();
		System.out.print("Enter your email: ");
		String email = sc.nextLine();
		for (int i = 0; i < mgList.size(); i++) {
			mg = mgList.get(i);
			if (mg.getEmail().toLowerCase().equals(email.toLowerCase())) {
				foundEmail = true;
				break;
			}
		}
		if (!foundEmail) {
			System.out.println("\nThis is the first time you are here. Kindly provide us your info");
			System.out.print("Enter your name: ");
			String name = sc.nextLine();
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
		System.out.print("Enter your rating: ");
		float rate;
		while (true) {
			try {
				rate = sc.nextFloat();
				break;
			} catch (InputMismatchException e) {

				System.out.println("Your rate is in incorrect format. Please re-enter");
			
			}
		}
		System.out.println();
                
                movie.addReview(mg.getName(), mg.getEmail(), rate, content);
		
                
                //find the movie id index
                int index = 0;
                for(Movie mv: movieList){
                    if(mv.getMovieId() == movie.getMovieId()){
                        break;
                    }
                    index++;
                }
                movieList.set(index, movie);
                SerializeDB.writeSerializedObject("Movie.ser", movieList);
		return movie;
	}

	/**
	 * This method is used by staff to login to the system. It asks for the staff's ID and password.
	 * It brings up staff menu if the login is success
	 */
	private static void staffLogin() {
		Staff staff = new Staff();
		if (!staff.login())
			System.out.println("Incorrect ID or Password");
		else
			StaffFunctionsController.printStaffMenu();
	}

	/**
	 * Gets top 5 movies sort by review or number of tickets sold for this particular movie
	 * @param rankBy The sorting that users would like to make
	 * @return List of top 5 movies based on selected sorting method
	 */
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

	/**
	 * Print the seat layout of a particular movie at a particular show time and cinema.
	 * The seat layout will show users the arrangement of seats, the screen, the exit as well as aisle between seat rows
	 * @param st Show time of selected movie
	 */
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

	/**
	 * Shows user their booking history based on their email address
	 * "No transaction found" message will be return if the user has never made any booking 
	 */
	private static void pastBooking() {
		SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd HH:MM");

		boolean foundMG = false;
		MovieGoer movieGoer;
		Transaction txn;

		List<MovieGoer> mgList = (ArrayList<MovieGoer>) SerializeDB.readSerializedObject("MovieGoer.ser");

		
			System.out.print("Enter your email: ");
			String email = sc.nextLine();
			if(!mgList.isEmpty()) {
				for (int i = 0; i < mgList.size(); i++) {
					movieGoer = mgList.get(i);
					if (movieGoer.getEmail().equalsIgnoreCase(email)) {
						if (!movieGoer.getTxnList().isEmpty()){
							System.out.println("\nYour booking history:");
							System.out.printf("%10s %30s %30s %20s %15s%n", "Bought at", "Movie Name", "Show Time",
                                                                            "No. of Tickets", "Total Payment");
							
							for(Transaction trans : movieGoer.getTxnList()) {
								System.out.printf("%10s %30s %30s %10d %20f%n", dft.format(trans.getTransactionDate()),
										trans.getMovieName(), dft.format(trans.getShowTime()), trans.getTickets().size(),
										trans.getTotalPayment());
							}
							
						} 
						
						foundMG = true;
						break;
					}
				}
			}
			if (!foundMG)
				System.out.println("No transaction found");
		
	}

	/**
	 * Print the transaction of a booked ticket based on movie title, selected seat and total payment
	 * @param movieTitle The selected movie title
	 * @param seatNum The selected seat number
	 * @param totalPayment The total payment calculated by the system
	 */
	private static void printTXN(String movieTitle, int seatNum, float totalPayment) {
		System.out.println("Your ticket(s) is/are booked");
		System.out.println("------ Transaction details -----");
		System.out.println("Movie title: " + movieTitle);
		System.out.println("Number of seats: " + seatNum);
		System.out.println("Total price: " + totalPayment);
	}

	/**
	 * Offers the moviegoer the mean to make payment. By which, their personal details and the new transaction will be written into the database MovieGoer.ser
	 * The limitation of this method is that no real payment is actually processed. The system acts as if the payment is real and updates the databases accordingly to the change
	 * @param bookedTickets The list of tickets being booked by the user
	 * @return true if the payment is successful, and false otherwise
	 * Note: The payment is always successful in this project
	 */
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

	/**
	 * Gives the users options to pick a ticket type
	 * @return ticket type in String
	 */
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

	/**
	 * Displays to user the full details of selected movie
	 * Afterwards, offers them the options to book the movie or write a review for it
	 * @param movie The selected movie
	 * @throws Exception 
	 */
	private static void viewMovieDetail(Movie movie) throws Exception{
		try {
			movie.showMovieDetailWithReview();
			
			do {
				System.out.println("===What would you like to do?========");
				System.out.println("|1. Book this Movie                  |");
				System.out.println("|2. Write Review                     |");
				System.out.println("|3. Exit                             |");
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
			
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * Guides the user through the whole process of booking tickets
	 * @param movie The selected movie
	 * @throws Exception
	 */
	private static void bookTicket(Movie movie) throws Exception {
		// ask user to choose a movie
		do {
		
			List<ShowTime> showTimes = movie.getShowTimes();
                        System.out.printf("Showtime for %s in %s\n", movie.getTitle(), movie.getMovieType());
                        System.out.printf("ShowTime ID \tDateTime \t\t\tCinema \t\t\tAvailable Seats");
			int index = 0;
                        for (ShowTime showTime : showTimes){
                            System.out.println("");
                            System.out.printf("%s \t\t%s \t%s %s %s \t%s",
                                                (index+1),
                                                showTime.getShowTime(),
                                                showTime.getShowDate(),
                                                showTime.getCinema().getClassType(),
                                                showTime.getCinema().getCineplex().getName(),
                                                showTime.getNoOfTicketsAvailable());
                            index++;
			}
                        System.out.println("");
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
				System.out.println("-----------SCREEN-----------");
				printingSeatLayout(selectedShowTime);
                                System.out.println("");
				System.out.println("----------ENTRANCE----------");
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
				
				startBooking(selectedShowTime, movie);
				return;
			} // end of booking
			
			
		}while(true);
		
	}
	
	/**
	 * Complements to bookTicket() methods, this method allows user to choose a seat, and get a ticket for that seat
	 * Multiple seats can be selected before the user proceeds to confirm booking
	 * Once booking is confirmed, the user can make a payment or just cancel the booking
	 * @param selectedST The selected show time
	 * @param selectedMv The selected movie
	 */
	@SuppressWarnings("unchecked")
	private static void startBooking(ShowTime selectedST, Movie selectedMv) {
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

				int seatNum;

				while (true) {
					try {
						System.out.print("\nEnter the seat number: ");
						seatNum = sc.nextInt();
						sc.nextLine();
						row = seatNum / 10;
						col = (seatNum - (row * 10));
						boolean foundSeat = false;

						for (x = 0; x < tmpTickets.length; x++) {
							if (tmpTickets[x].getSeat().getRow() == row && tmpTickets[x].getSeat().getColumn() == col
									&& tmpTickets[x].getStatus().equals(Ticket.AVAILABLE)) {
								foundSeat = true;
								tmpTickets[x].setStatus(Ticket.SOLD);
								break;
							}
						}
						if (foundSeat) {
							break;
						} else {
							System.out.println("Seat not available. Re-enter seat number");

						}

					} catch (InputMismatchException e) {
						System.out.println("Your seat number is in incorrect format");
						sc.nextLine();
					}
				}

				String ticketType = ticketTypePicker();
				tmpTickets[x].setTicketType(ticketType);
				System.out.println("-----------SCREEN-----------");
				printingSeatLayout(selectedST);
				System.out.println("");
				System.out.println("----------ENTRANCE----------");
				System.out.println();
				// get the price base on cinema type,movietype,tickettype and showtime date
				float price = 0;
				// base on cinema set the price
				if (selectedST.getCinema().getClassType().equals(Cinema.CINEMA_CLASS_PLATINIUM)) {
					price = SystemSettingController.getSystemSetting().getPremiumTicketPrice();
				} else {
					price = SystemSettingController.getSystemSetting().getStandardTicketPrice();
				}
				// base on movie type increse the price
				if (selectedMv.getMovieType().equals(Movie.BLOCKBUSTER)) {
					price += SystemSettingController.getSystemSetting().getBlockBusterTypeIncrement();
				} else if (selectedMv.getMovieType().equals(Movie.THREED)) {
					price += SystemSettingController.getSystemSetting().getThreeDTypeIncrement();
				}

				// base on ticket increase the price
				if (tmpTickets[x].getTicketType().equals(Ticket.CENIOR_CITIZEN)) {
					price -= SystemSettingController.getSystemSetting().getSeniorCitizenDiscount();
				} else if (tmpTickets[x].getTicketType().equals(Ticket.CHILD)) {
					price -= SystemSettingController.getSystemSetting().getChildDiscount();
				}
				// increaste if holiday
				Calendar c1 = Calendar.getInstance();
				c1.setTime(selectedST.getShowDateTime());
				if (c1.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || c1.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY
						|| SystemSettingController.getSystemSetting().getHolidays()
								.contains(selectedST.getShowDateTime())) {

					price += SystemSettingController.getSystemSetting().getHolidayIncrement();
				}
				tmpTickets[x].setPrice(price);

				bookedTickets.add(tmpTickets[x]);
				break;
			case 2: // confirm booking
				if (bookedTickets.size() == 0) {
					System.out.println("You haven't selected any seat! ");
					break;
				}
				// ask for user's email
				List<MovieGoer> mgList = (ArrayList<MovieGoer>) SerializeDB.readSerializedObject("MovieGoer.ser");
				MovieGoer movieGoer = null;
				boolean foundEmail = false;
				System.out.print("Enter your email: ");
				String email = sc.nextLine();
				for (int i = 0; i < mgList.size(); i++) {
					movieGoer = mgList.get(i);
					if (movieGoer.getEmail().toLowerCase().equals(email.toLowerCase())) {
						foundEmail = true;
						break;
					}
				}
				if (!foundEmail) {
					System.out.println("\nThis is the first time you are here. Kindly provide us your info");
					System.out.print("Enter your name: ");
					String name = sc.nextLine();
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
					movieGoer = new MovieGoer(name, email, contact);
					mgList.add(movieGoer);
				}
				float total_payment = 0;
				for (Ticket tk : bookedTickets) {
					total_payment += tk.getPrice();
				}
				Transaction txn = new Transaction(selectedST.getShowDateTime(), selectedST.getCinema().getCinemaCode(),
						selectedMv.getTitle(), bookedTickets, total_payment);

				printTXN(selectedMv.getTitle(), bookedTickets.size(), txn.getTotalPayment());
				// proceed to purchase
				if (purchaseTicket(bookedTickets)) {
					System.out.println("Payment was successful!!!");

					movieGoer.setMovieGoerTXN(txn);

					SerializeDB.writeSerializedObject("MovieGoer.ser", mgList);
					// find the movie id index
					int index = 0;
					for (Movie mv : movieList) {
						if (mv.getMovieId() == selectedMv.getMovieId()) {
							break;
						}
						index++;
					}
					movieList.set(index, selectedMv);
					SerializeDB.writeSerializedObject("Movie.ser", movieList);
					return;
				}
				break;
			case 3: // back to main menu
				for (Ticket tk : bookedTickets) {
					tk.setStatus(Ticket.AVAILABLE);
				}
				return;
			default:
				System.out.println("Option not found");
			}

		} while (choice != 3);
	}
	
}
