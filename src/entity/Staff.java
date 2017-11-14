package entity;

import java.util.Scanner;

import application.MovieController;
import system.MovieSystem;

public class Staff {
	private String staffName;
	private int staffContact;
	private String staffMail;
	private String staffID;
	private String password;
	private String username;

	public Staff() {

	}
	
	public Staff (String name, String id, String pw, String mail, int contact){
		staffName = name;
		staffContact = contact;
		staffMail = mail;
		staffID = id;
		password = pw;
	}
	
	public String getStaffID() {
		return staffID;
	}

	public String getPassword() {
		return password;
	}

	public boolean login() {
		Login log= new Login();
		return log.authenticate();
	}

	public void showStaffMenu() {
		int choice;
		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("=====================================");
			System.out.println("|1. Configure System Settings       |");
			System.out.println("|2. Add Movies                      |");
			System.out.println("|3. Update Movies                   |");
			System.out.println("|4. Logout                          |");
			System.out.println("=====================================");
			System.out.print("Enter your choice: ");
			choice = sc.nextInt();
			sc.nextLine();

			int configChoice;
			switch (choice) {
			case 1://Configure System Settings 
				System.out.println("=====================================");
				System.out.println("|1. Standard Ticket Price           |");
				System.out.println("|2. Premium Ticket Price            |");
				System.out.println("|3. Child Discount                  |");
				System.out.println("|4. Senior Citizen Discount         |");
				System.out.println("|5. Holiday Increment               |");
				System.out.println("|6. Add Holiday                     |");
				System.out.println("|7. Remove Holiday                  |");
				System.out.println("=====================================");				
				System.out.print("Enter your choice: ");
				configChoice = sc.nextInt();
				sc.nextLine();
			break;
			
			case 2://Add Movies
				addMovie();
				break;
				
			case 3://Update movies
				break;
			}		
		} while (choice < 4 && choice > 0);

	}

	private void addMovie() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Movie title: ");
		String movieName = sc.nextLine();
		System.out.print("\nMovie type: ");
		String movieType= sc.nextLine();
		
	}
	
	public void addMovie() {
		MovieController ms = new MovieSystem();
		if(!(ms.addMovieToDB()))
			System.out.println("Error adding it into database");
		else
			System.out.println("Successfully adding it to database");
	}
	
	public void editMovieDB() {
		MovieSystem ms = new MovieSystem();
		ms.editMovieDB();
	}
}
