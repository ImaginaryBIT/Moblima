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
		SimpleDateFormat dateFormatter = new SimpleDateFormat("HH:mm");
		return dateFormatter.format(showDateTime.getTime());
	}

        public String getShowDate() {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
		return dateFormatter.format(showDateTime.getTime());
        }

        public Date getShowDateTime() {
                return showDateTime;
        }
        public int getNoOfTicketsSold() {
                int total = 0;
                for (int t = 0; t < tickets.length; t++) {
                    if(tickets[t].getStatus().equals(Ticket.SOLD)){
                        //if ticket is sold add to total count
                        total++;
                    }
                }
                return total;
        }
        public int getNoOfTicketsAvailable() {
                int total = 0;
                for (int t = 0; t < tickets.length; t++) {
                    if(tickets[t].getStatus().equals(Ticket.AVAILABLE)){
                        //if ticket is sold add to total count
                        total++;
                    }
                }
                return total;
        }

}