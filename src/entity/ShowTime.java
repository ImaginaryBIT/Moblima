package entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ShowTime implements Serializable {
	private static final long serialVersionUID = 1L;
	private int showTimeId;
	private Cinema cinema;
	private Cineplex cineplex;
	private GregorianCalendar showDate;
	//private GregorianCalendar timeSlot;
	private Ticket[] tickets;

	public ShowTime(GregorianCalendar showDate, Cinema cinema, Ticket[] tickets) {
		this.showDate = showDate;
		this.cinema = cinema;
		this.tickets = tickets;
	}

	// all get methods
	public int getShowTimeId() {
		return showTimeId;
	}

	public Cinema getCinema() {
		return cinema;
	}

	public Cineplex getCineplex() {
		return cineplex;
	}

	public GregorianCalendar getShowDate() {
		return showDate;
	}

	//public GregorianCalendar getTimeSlot() {
		//return timeSlot;
	//}

	public Ticket[] getTickets() {
		return tickets;
	}

	// all set methods
	public void setShowTimeID(int showTimeId) {
		this.showTimeId = showTimeId;
	}

	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}

	public void setCineplex(Cineplex cineplex) {
		this.cineplex = cineplex;
	}

	public void setShowDate(GregorianCalendar showDate) {
		this.showDate = showDate;
	}

	//public void setTimeSlot(GregorianCalendar timeSlot) {
	//	this.timeSlot = timeSlot;
	//}

	public void setTickets(Ticket[] tickets) {
		this.tickets = tickets;
	}

	public void printShowTime() {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("MMMM d, yyyy HH:mm");
		Date date = showDate.getTime();
		System.out.println("Date Time\t\t\tCinema");
		System.out.println(dateFormatter.format(date) +"\t\t\t" + cinema.getId());
	}

}