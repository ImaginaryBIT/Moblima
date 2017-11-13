package entity;

import java.util.Scanner;

public class Staff {
	private int staffId;
	private String password;
	private String username;

	public Staff(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public boolean login() {
		return false;
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
				System.out.print("Movie title: ");
				String movieName = sc.nextLine();
				System.out.print("\nMovie type: ");
				String movieType= sc.nextLine();
				break;
				
			case 3://Update movies
				break;
			}		
		} while (choice < 4 && choice > 0);

	}
}
