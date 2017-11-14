package entity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Transaction {
	private String transactionId;
	private ArrayList<Ticket> tickets;
	private float totalPayment;
	private String movieName;
	private Date transactionDate;
	private Date showTime;
	private MovieGoer movieGoer;

	public Transaction(Date showTime, String cinemaCode, String movieName, ArrayList<Ticket> tickets, MovieGoer movieGoer) {
		setTxnId(showTime, cinemaCode);
		this.tickets = tickets;
		this.showTime = showTime;
		this.movieName = movieName;
		transactionDate = new Date();
		this.movieGoer= movieGoer;
	}

	public String getTxnId() {
		return transactionId;
	}

	public ArrayList<Ticket> getTickets() {
		return tickets;
	}

	public float getTotalPayment() {
		return totalPayment;
	}

	public String getMovieName() {
		return movieName;
	}

	public Date getTxnDate() {
		return transactionDate;
	}

	public Date getShowTime() {
		return showTime;
	}
	public MovieGoer getMovieGoer()
	{
		return movieGoer;
	}

	private void setTxnId(Date dateTime, String cinemaCode) {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("YYYYMMDDHHMM");
		this.transactionId = cinemaCode + dateFormatter.format(dateTime);
	}

}
