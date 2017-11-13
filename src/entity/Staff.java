package entity;

import java.util.Scanner;
import java.util.GregorianCalendar;

public class Staff 
{
	private int staffId;
	private String username;	
	private String password;

	public Staff() 
	{
		this.username = "username";
		this.password = "password";
	}

	public boolean login(String username, String password) 
	{
		if(this.username == username && this.password == password) return true;
		else return false;
	}

	public void showStaffMenu() {
		int choice;
		Scanner sc = new Scanner(System.in);

		while(true)
		{
			System.out.println("=====================================");
			System.out.println("|1. Configure System Settings       |");
			System.out.println("|2. Add Movies                      |");
			System.out.println("|3. Update Movies                   |");
			System.out.println("|4. Logout                          |");
			System.out.println("=====================================");
			System.out.print("Enter your choice: ");
			choice = sc.nextInt();

			switch (choice) 
			{
			case 1://Configure System Settings 
				systemSettings();
				break;
			
			case 2://Add Movies
				System.out.print("Movie title: ");
				String movieName = sc.nextLine();
				System.out.print("\nMovie type: ");
				String movieType= sc.nextLine();
				break;
				
			case 3://Update movies
				break;
				
			case 4://Logout
				return;
				
			default:
				System.out.print("Wrong input!");
				break;
			}		
		}
	}
		
	
	public void systemSettings()
	{
		int choiceSetting;
		Scanner sc = new Scanner(System.in);
		
		while(true) 
		{
			System.out.println("=====================================");
			System.out.println("|1. Set Standard Ticket Price       |");
			System.out.println("|2. Set Premium Ticket Price        |");
			System.out.println("|3. Set Child Discount              |");
			System.out.println("|4. Set Senior Citizen Discount     |");
			System.out.println("|5. Holiday Increment               |");
			System.out.println("|6. Add Holiday                     |");
			System.out.println("|7. Remove Holiday                  |");
			System.out.println("|8. Back to Main                    |");
			System.out.println("=====================================");				
			System.out.print("Enter your choice: ");
			choiceSetting = sc.nextInt();
			
			switch (choiceSetting) 
			{
			case 1://Set Standard Ticket Price
				break;
			
			case 2://Set Premium Ticket Price
				break;
				
			case 3://Set Child Discount
				break;
				
			case 4://Set Senior Citizen Discount
				break;
			
			case 5://Holiday Increment
				break;
			
			case 6://Add Holiday
				break;
				
			case 7://Remove Holiday
				break;
				
			case 8://Back to Main
				return;	
				
			default:
				System.out.print("Wrong input!");
				break;			
			}	
		}	
	}
}