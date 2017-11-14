package entity;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import database.SerializeDB;

/**
 * This class implement to do action, add or delete public holidays from PublicHoliday.ser
 * @author Group5
 *
 */

public class PublicHoliday {
	private ArrayList<GregorianCalendar> publicHoliday;

	public PublicHoliday() {
	}

	/**
	 * This method add date as public holiday to PublicHoliday.ser
	 * @param date the date to add as holiday lists
	 * @return boolean
	 */
	public boolean addHoliday(GregorianCalendar date) {
		long dateMS = date.getTimeInMillis();
		long calendarMS;
		publicHoliday = (ArrayList<GregorianCalendar>) SerializeDB.readSerializedObject("PublicHoliday.ser");		
		for (GregorianCalendar calendar : publicHoliday) {
			calendarMS = calendar.getTimeInMillis();
			if (calendarMS == dateMS) {
				return false;
			}
		}
		publicHoliday.add(date);
		SerializeDB.writeSerializedObject("PublicHoliday.ser", publicHoliday);
		return true;
	}

	/**
	 * The method remove date from PublicHoliday.ser
	 * @param date the date to remove from holiday lists
	 * @return boolean 
	 */
	public boolean deleteHoliday(GregorianCalendar date) {
		long dateMS = date.getTimeInMillis();
		long calendarMS;
		publicHoliday = (ArrayList<GregorianCalendar>) SerializeDB.readSerializedObject("PublicHoliday.ser");

		for (GregorianCalendar calendar : publicHoliday) {
			calendarMS = calendar.getTimeInMillis();
			if (calendarMS == dateMS) {
				publicHoliday.remove(calendar);
				SerializeDB.writeSerializedObject("PublicHoliday.ser", publicHoliday);
				return true;
			}
		}
		return false;
	}

	/**
	 * The method check the date is whether holiday or not
	 * @param date the date to check whether holiday
	 * @return boolean
	 */
	public boolean isHoliday(GregorianCalendar date) {
		date.set(GregorianCalendar.HOUR_OF_DAY, 0);
		date.set(GregorianCalendar.MINUTE, 0);
		long dateMS = date.getTimeInMillis();
		long calendarMS;

		publicHoliday = (ArrayList<GregorianCalendar>) SerializeDB.readSerializedObject("PublicHoliday.ser");

		for (GregorianCalendar calendar : publicHoliday) {
			calendarMS = calendar.getTimeInMillis();
			if (calendarMS == dateMS) {
				return true;
			}
		}		
		return false;
	}

	/**
	 * the method to get the public holiday
	 * @return publicHoliday
	 */
	public ArrayList<GregorianCalendar> getPublicHoliday() {
		publicHoliday = (ArrayList<GregorianCalendar>) SerializeDB.readSerializedObject("PublicHoliday.ser");
		return publicHoliday;
	}
}
