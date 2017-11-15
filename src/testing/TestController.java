package testing;

import application.StaffFunctionsController;

public class TestController {

	public static void main(String[] args) {
		StaffFunctionsController.printStaffMenu();
		//SystemSettingController.printMenu();
	}
	
	public void testStaffFunctionsController(){
		StaffFunctionsController.printStaffMenu();
	}
	
}
