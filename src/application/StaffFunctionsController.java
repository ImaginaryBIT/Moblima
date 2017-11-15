package application;

import java.util.Scanner;
/**
 * 
 * @author Group5
 *
 */
public class StaffFunctionsController {

	
	private boolean errorFlag = false;

	private static Scanner sc = new Scanner(System.in);
	
	
	public static void printStaffMenu(){
		try {
			do {
				System.out.println("=========Available Functions==========");
				System.out.println("|1. Search Movie.                    |");
				System.out.println("|2. Add Movie.                       |");
				System.out.println("|3. Update Movie.                    |");
				System.out.println("|4. Generate Sale Report.            |");
				System.out.println("|5. Configure System Settings.       |");
				System.out.println("|6. Logout                           |");
				System.out.println("======================================");				
				System.out.print("Enter your choice: ");
				int choice = sc.nextInt();
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
			}while(true);
		} catch (Exception e) {
			System.out.println("Exception >> " + e.getMessage());
		}
		
	}
	
	private static void generateSaleReport(){
		
	}
	
}
