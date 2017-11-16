package entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * This class represents a particular show time of a movie
 * Contains Cinema and Ticket lists. 
 * Accessed by MovieGoer upon booking process.
 * Accessed by Staff upon setting up a movie's show time, location and tickets
 * @author group5
 */
public class ShowTime implements Serializable {
	/** The ID of this show time */
	private int showTimeId;
	/** The cinema having this show time */
	private Cinema cinema;
	/** The date time of this show time */
	private Date showDateTime;
	/** The list of tickets for sale on this show time */
	private Ticket[] tickets;

	/* ******************** Constructor *************************/
	/**
	 * This creates a new instance of Show Time, specified by its ID, location, date time and list of tickets associated with
	 * @param showTimeId The ID of this show time
	 * @param cinema The cinema having this show time 
	 * @param showDateTime The date time 
	 * @param tickets The list of tickets for sale
	 */
	public ShowTime(int showTimeId, Cinema cinema, Date showDateTime, Ticket[] tickets) {
		this.showTimeId = showTimeId;
		this.cinema = cinema;
		this.showDateTime = showDateTime;
		this.tickets = tickets;
	}

	/* ******************** Getter and Setter Methods *********/

	/**
	 * Gets the ID of this show time
	 * @return showTimeId
	 */
	public int getShowTimeId() {
		return showTimeId;
	}

	/**
	 * Gets the cinema having this showtime
	 * @return cinema
	 */
	public Cinema getCinema() {
		return cinema;
	}

	/**
	 * Gets the list of tickets for sale
	 * @return tickets
	 */
	public Ticket[] getTickets() {
		return tickets;
	}
	
	/**
	 * Gets the time slot of in this show time
	 * @return time in string which shows the time in HH:mm format
	 */
	public String getShowTime() {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("HH:mm");
		return dateFormatter.format(showDateTime.getTime());
	}
	
	/**
	 * Gets the date in this show time
	 * @return date in string which shows the date in dd-MM-yyyy format
	 */
	public String getShowDate() {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
		return dateFormatter.format(showDateTime.getTime());
	}
	
	/**
	 * Gets both date and time
	 * @return showDateTime as in Date
	 */
	public Date getShowDateTime() {
		return showDateTime;
	}

	/**
	 * Changes the ID of this show time
	 * @param showTimeId
	 */
	public void setShowTimeID(int showTimeId) {
		this.showTimeId = showTimeId;
	}

	/**
	 * Changes the cinema having this show time
	 * @param cinema
	 */
	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}

	/**
	 * Changes the list of tickets on sale
	 * @param tickets
	 */
	public void setTickets(Ticket[] tickets) {
		this.tickets = tickets;
	}	

	/**
	 * Gets total number of tickets sold
	 * @return total The amount of tickets being sold
	 */
	public int getNoOfTicketsSold() {
		int total = 0;
		for (int t = 0; t < tickets.length; t++) {
			if (tickets[t].getStatus().equals(Ticket.SOLD)) {
				// if ticket is sold add to total count
				total++;
			}
		}
		return total;
	}
	
	/**
	 * Gets the number of tickets still available
	 * @return total The number of available tickets
	 */
	public int getNoOfTicketsAvailable() {
		int total = 0;
		for (int t = 0; t < tickets.length; t++) {
			if (tickets[t].getStatus().equals(Ticket.AVAILABLE)) {
				// if ticket is sold add to total count
				total++;
			}
		}
		return total;
	}
}