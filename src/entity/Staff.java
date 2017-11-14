package entity;

import java.util.Scanner;

import application.MovieController;
import application.SystemSettingController;

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
			System.out.println("|4. Generate Sale Report.");
			System.out.println("|5. Logout                          |");
			System.out.println("=====================================");
			System.out.print("Enter your choice: ");
			choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1://Configure System Settings 
				SystemSettingController config = new SystemSettingController();
				config.printMenu();
			break;
			
			case 2://Add Movies
				addMovie();
				break;
				
			case 3://Update movies
				updateMovie();
				break;
				
			case 4://Generate Sale Report
				generateSaleReport();
				break;
				
			case 5://return to menu
				return;
			}		
		} while (choice < 5 && choice > 0);

	}
	
	private void generateSaleReport() {
		
		
	}

	public void addMovie() {
		MovieController ms = new MovieController();
		if(!(ms.addMovie()))
			System.out.println("Error adding it into database");
		else
			System.out.println("Successfully adding it to database");
	}
	
	public void updateMovie() {
		MovieController ms = new MovieController();
		if(!ms.updateMovie())
			System.out.println("Error updating it into database");
		else
			System.out.println("Successfully updating it to database");
	}
}
