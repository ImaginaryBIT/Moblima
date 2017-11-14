package entity;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import database.SerializeDB;

public class PublicHoliday {
	private ArrayList<GregorianCalendar> publicHoliday;

	public PublicHoliday() {
	}

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

	public ArrayList<GregorianCalendar> getPublicHoliday() {
		publicHoliday = (ArrayList<GregorianCalendar>) SerializeDB.readSerializedObject("PublicHoliday.ser");
		return publicHoliday;
	}
}
