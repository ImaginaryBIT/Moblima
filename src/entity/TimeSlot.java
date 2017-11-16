/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class is implemented for storing information of a particular time slot
 * It will then be used by the staff during creation of show time
 * 
 * @author group5
 */
public class TimeSlot implements Serializable {
	/** Status of this time slot as "available" */
	public static final String AVAILABLE = "available";
	/* Status of this time slot as "unavailable" */
	public static final String UNAVAILABLE = "unavailable";

	/** The date time of this time slot */
	private Date dateTime;
	/** The status of this time slot */
	private String status;

	/* ******************** Constructor *************************/
	/**
	 * This initializes a new time slot with given date time and availability
	 * @param dateTime The date time of this time slot
	 * @param status The status of this time slot
	 */
	public TimeSlot(Date dateTime, String status) {
		this.dateTime = dateTime;
		this.status = status;
	}

	/* ******************** Getter and Setter Methods *********/

	/**
	 * Gets the availability
	 * @return status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Gets the time as in HH:mm format
	 * @return string of time in HH:mm format
	 */
	public String getTime() {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("HH:mm");
		return dateFormatter.format(dateTime.getTime());
	}

	/**
	 * Gets the date as in dd-MM-yyyy format
	 * @return string of date in dd-MM-yyyy format
	 */
	public String getDate() {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
		return dateFormatter.format(dateTime.getTime());
	}

	/**
	 * Gets both date and time of this time slot	
	 * @return dateTime
	 */
	public Date getDateTime() {
		return dateTime;
	}

	/**
	 * Set the availability of this time slot
	 * @param status The availability of this time slot
	 */
	public void setStatus(String status) {
		this.status = status;
	}

}
