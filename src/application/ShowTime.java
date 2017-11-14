package entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ShowTime implements Serializable {
	private int showTimeId;
	private Cinema cinema;
	//private Cineplex cineplex;
	private GregorianCalendar showDate;
	//private GregorianCalendar timeSlot;
	//private ArrayList<Ticket> tickets;

	public ShowTime(GregorianCalendar showDate, Cinema cinema) {
		this.showDate = showDate;
		//this.timeSlot = timeSlot;
		this.cinema = cinema;
		//this.cineplex = cineplex;
		setTickets(showDate);
	}

	// all get methods
	public int getShowTimeId() {
		return showTimeId;
	}

	public Cinema getCinema() {
		return cinema;
	}

	//public Cineplex getCineplex() {
		//return cineplex;
	//}

	public GregorianCalendar getShowDate() {
		return showDate;
	}

	//public GregorianCalendar getTimeSlot() {
	//return timeSlot;
	//}

	//public ArrayList<Ticket> getTickets() {
		//return tickets;
	//}

	// all set methods
	public void setShowTimeID(int showTimeId) {
		this.showTimeId = showTimeId;
	}

	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}

	//public void setCineplex(Cineplex cineplex) {
		//this.cineplex = cineplex;
	//}

	public void setShowDate(GregorianCalendar showDate) {
		this.showDate = showDate;
	}

	//public void setTimeSlot(GregorianCalendar timeSlot) {
	//	this.timeSlot = timeSlot;
	//}

	public void setTickets(GregorianCalendar showDate) {
		
	}

	/*public void printShowTime() {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("MMMM d, yyyy HH:mm");
		Date date = showDate.getTime();
		System.out.println(dateFormatter.format(date) + "\t\t\t" + cinema.getCinemaId());
	}*/

}