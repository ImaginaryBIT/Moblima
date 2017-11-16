package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import database.SerializeDB;
import entity.Movie;
import entity.MovieGoer;
import entity.Transaction;
/**
 * This class controller is used by staff. 
 * It offers them the option to
 * 1. View all movies in the database               
 * 2. Add a new movie to the database  
 * 3. Or update any particular movie  
 * 4. They can also generate sale reports            
 * 5. Or configure System Settings      
 * 6. And finally, logout    
 * @author Group5
 *
 */
public class StaffFunctionsController {

	private boolean errorFlag = false;

	private static Scanner sc = new Scanner(System.in);

	/**
	 * Displays all available options to the staff
	 */
	public static void printStaffMenu() {
		try {
			do {
				System.out.println("=========Available Functions==========");
				System.out.println("|1. View All Movie.                  |");
				System.out.println("|2. Add Movie.                       |");
				System.out.println("|3. Update Movie.                    |");
				System.out.println("|4. Generate Sale Report.            |");
				System.out.println("|5. Configure System Settings.       |");
				System.out.println("|6. Logout                           |");
				System.out.println("======================================");
				System.out.println("Enter your choice: ");
				int choice = sc.nextInt();
				sc.nextLine();
				switch (choice) {
				case 1:
					MovieController.viewAllMovie();
					break;
				case 2:
					MovieController.addMovie();
					break;
				case 3:
					MovieController.updateMovie();
					break;
				case 4:
					generateSaleReport();
					break;
				case 5:
					SystemSettingController.printMenu();
					break;
				case 6:
					System.out.println("You had Logout Successfully");
					return;
				default:
					System.out.println("Sorry, there is no " + choice);
				}
			} while (true);
		} catch (Exception e) {

			System.out.println("Exception >> " + e.getMessage());
			throw e;
		}
	}

	/**
	 * Generates sale report based on the tickets sold
	 */
	private static void generateSaleReport() {

		List<MovieGoer> goerList = (ArrayList<MovieGoer>) SerializeDB.readSerializedObject("MovieGoer.ser");
		List<Movie> movieList = (ArrayList<Movie>) SerializeDB.readSerializedObject("Movie.ser");

		List<Transaction> transList;
		int numberOfSoldTickets = 0;
		float amountOfSales = 0;

		System.out.println("=========Printing Sales for each movie.==========");
		for (int i = 0; i < movieList.size(); i++) {
			System.out.println((i + 1) + ". " + movieList.get(i).getTitle() + "=>");
			for (int j = 0; j < goerList.size(); j++) {
				transList = goerList.get(j).getTxnList();

				for (int k = 0; k < transList.size(); k++) {
					if (movieList.get(i).getTitle() == transList.get(k).getMovieName()) {
						numberOfSoldTickets += transList.get(k).getTickets().size();
						amountOfSales += transList.get(k).getTotalPayment();
					}
				}
			}
			System.out.println("The total number of Sold Tickets is : " + numberOfSoldTickets);
			System.out.println("The total amount of Sales is : " + amountOfSales);
		}
	}

}
