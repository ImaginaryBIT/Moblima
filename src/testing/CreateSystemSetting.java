package testing;

import application.SystemSettingController;

public class CreateSystemSetting {

	public static void main(String[] args) {
		SystemSettingController systemController = new SystemSettingController();
		systemController.printMenu();
		/*List<Date> holidays = new ArrayList<Date>();
		holidays.add(systemController.convertDate("01-09-2017"));
		holidays.add(systemController.convertDate("18-10-2017"));
		holidays.add(systemController.convertDate("25-12-2017"));
		SystemSetting systemSetting = new SystemSetting((float)12.00, (float)15.00, (float)3.00, (float)5.00, (float)3.00, holidays);
		systemController.createSystemSetting(systemSetting);
		
		List<SystemSetting> systemSettings = SerializeDB.readSerializedObject("SystemSetting.ser");*/
		
	}

}
