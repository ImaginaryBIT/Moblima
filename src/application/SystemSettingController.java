package application;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import database.SerializeDB;
import entity.SystemSetting;

public class SystemSettingController  {
	private static int configChoice = 0;
	private static boolean errorFlag = false;
	private static SystemSetting systemSetting = new SystemSetting();
	private static List<Date> holidays = new ArrayList<Date>();
	@SuppressWarnings("unchecked")
	private static List<SystemSetting> systemSettingDb = (ArrayList<SystemSetting>) SerializeDB.readSerializedObject("SystemSetting.ser");
	
	public static void printMenu(){
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		systemSetting = systemSettingDb.get(0);
		holidays = systemSetting.getHolidays();
		try{
				do {
					System.out.println("=======System Config Menu============");
					System.out.println("|1. Standard Ticket Price           |");
					System.out.println("|2. Premium Ticket Price            |");
					System.out.println("|3. Child Discount                  |");
					System.out.println("|4. Senior Citizen Discount         |");
					System.out.println("|5. Holiday Increment               |");
					System.out.println("|6. Add Holiday                     |");
					System.out.println("|7. Remove Holiday                  |");
					System.out.println("|8. View Current System Setting     |");
					System.out.println("|9. Exit System Configuration       |");
					System.out.println("=====================================");				
					System.out.print("Enter your choice: ");
					configChoice = sc.nextInt();
					sc.nextLine();
					float newValue;
					switch (configChoice) {
					case 1:
						System.out.print(" Enter New Value to Update: ");
						newValue = sc.nextFloat();
						systemSetting.setStandardTicketPrice(newValue);
						break;
					case 2:
						System.out.print(" Enter New Value to Update: ");
						newValue = sc.nextFloat();
						systemSetting.setPremiumTicketPrice(newValue);
						break;
					case 3:
						System.out.print(" Enter New Value to Update: ");
						newValue = sc.nextFloat();
						systemSetting.setChildDiscount(newValue);
						break;
					case 4:
						System.out.print(" Enter New Value to Update: ");
						newValue = sc.nextFloat();
						systemSetting.setSeniorCitizenDiscount(newValue);
						break;
					case 5:
						System.out.print(" Enter New Value to Update: ");
						newValue = sc.nextFloat();
						systemSetting.setHolidayIncrement(newValue);
						break;
					case 6:
						System.out.println("Enter New Date to add in (dd-mm-yyyy) format");
						String newDate = sc.nextLine();
						checkDuplicateHoliday(newDate);
						if(!errorFlag){
							holidays.add(convertDate(newDate));
						}
						else{
							System.out.println("This holiday is already added!");
						}
						systemSetting.setHolidays(holidays);
						break;
					case 7:
						System.out.println("Following are the current holidays : ");
						systemSetting.printHoliday();
						System.out.print(" Enter the no to remove: ");
						int index = sc.nextInt();
						holidays.remove(index - 1);
						break;
					case 8:
						System.out.println();
						systemSetting.toString();
						break;
					case 9:
						//Update the SystemSetting before exit
						createSystemSetting(systemSetting);
						return;
					default:
						System.out.println("Sorry, there is no " + configChoice);
					}
				} while (true);
			
			} catch (Exception e) {
				System.out.println("Exception >> " + e.getMessage());
				
			}
	
	}
	
	private static Date checkDuplicateHoliday(String datestr){
		Date date = convertDate(datestr);
		for(Date holiday : holidays){
			if(holiday.equals(date)){
				errorFlag = true;
			}
		}
		return date;
		
	}
	
	/**
	 * Create SystemSetting to SerialDatabase
	 * @param systemSeting
	 */
	private static void createSystemSetting(SystemSetting systemSeting){
		List<SystemSetting> systems = new ArrayList<SystemSetting>();
		systems.add(systemSeting);
		SerializeDB.writeSerializedObject("SystemSetting.ser", systems);
	}
	
	/**
	 * Get date information based on the date string format
	 * @param dateString	Date information in string format
	 * @return				Date object that contains date information
	 */
	public static Date convertDate(String dateString) {
		DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy"); 
		Date date = null;
		try {
			date = (Date)formatter.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * Get SystemSetting from SerialDatabase
	 * @param 
	 */
	public static SystemSetting getSystemSetting(){
            return systemSettingDb.get(0);
	}
}
