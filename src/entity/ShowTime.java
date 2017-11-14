package entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ShowTime implements Serializable {
	private int showTimeId;
	private Cinema cinema;
	private Date showDateTime;
	private Ticket[] tickets;

        public ShowTime(int showTimeId, Cinema cinema, Date showDateTime, Ticket[] tickets) {
                this.showTimeId = showTimeId;
                this.cinema = cinema;
                this.showDateTime = showDateTime;
                this.tickets = tickets;
        }

	

	// all get methods
	public int getShowTimeId() {
		return showTimeId;
	}

	public Cinema getCinema() {
		return cinema;
	}


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

	public void setTickets(Ticket[] tickets) {
		this.tickets = tickets;
	}

	public String getShowTime() {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("hh:mm");
		return dateFormatter.format(showDateTime.getTime());
	}

        public String getShowDate() {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-mm-yyyy");
		return dateFormatter.format(showDateTime.getTime());
        }

        public Date getShowDateTime() {
                return showDateTime;
        }

}