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
				bookTicket();
				
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
	
	private static void staffLogin()
	{
		System.out.print("Staff username: ");
		String username = sc.nextLine();
		System.out.print("Password: ");
		String pw = sc.nextLine();
		Staff staff = new Staff(username, pw);
	}
	
	private void showAllMovie()
	{
		
	}
	
	private static void bookTicket()
	{
		//display all now showing movies
		System.out.println("Now showing movies:");
		ArrayList<Movie> movieList = new ArrayList<>();
		movieList = (ArrayList<Movie>) SerializeDB.readSerializedObject("Movie.ser");
		System.out.println("ID\tMovie title");
		for (int i = 0; i < movieList.size(); i++) {
			Movie movie = (Movie) movieList.get(i);					
			if(movie.getStatus() == "Now showing")
			{
				System.out.printf("%d. %s\n", movie.getMovieID(), movie.getMovieTitle());
			}
		}
		
		System.out.print("Enter movie ID to book: ");
		int movieID = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < movieList.size(); i++) {
			Movie movie = (Movie) movieList.get(i);					
			if(movie.getMovieID() == movieID)
			{
				System.out.printf("Showtime for %s\n", movie.getMovieTitle());
				ArrayList<ShowTime> stList = new ArrayList<>();
				for (int j =0; j< stList.size(); j++)
				{
					ShowTime st = stList.get(j);
					//datetime + cineplex/cinema + available seat
				}
				break;
			}
		}
		
	}
}
