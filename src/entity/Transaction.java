package entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * This represents a transaction which stores information of tickets being sold
 * along with its show time, location, movie name, and total payment
 * @author group5
 *
 */

public class Transaction implements Serializable{
	/** The ID of this transaction */
	private String transactionId;
	/** The list of tickets for this transaction */
	private List<Ticket> tickets;
	/** This transaction's total payment */
	private float totalPayment;
	/** The movie that the tickets are sold for */
	private String movieName;
	/** The date of transaction creation */
	private Date transactionDate;
	/** The show time of this transaction */
	private Date showTime;

	/* ******************** Constructor *************************/
	/**
	 * This generates a transaction which stores information of tickets being sold
	 * along with its show time, location, movie name, and total payment
	 * Records down the date time this transaction is made
	 * Also creates the transaction ID based on the show time and cinema code
	 * @param showTime The show time of this transaction
	 * @param cinemaCode The cinema code
	 * @param movieName The movie that the tickets are sold for
	 * @param tickets The list of tickets for this transaction
	 * @param totalPayment The total payment
	 */
	public Transaction(Date showTime, String cinemaCode, String movieName, List<Ticket> tickets,float totalPayment) {
		setTransactionId(showTime, cinemaCode);
		this.tickets = tickets;
		this.showTime = showTime;
		this.movieName = movieName;
                this.totalPayment = totalPayment;
		transactionDate = new Date();
	} 
	
	/* ******************** Getter and Setter Methods *********/
	/**
	 * Gets transaction ID
	 * @return the transactionId
	 */
	public String getTransactionId() {
		return transactionId;
	}

	/**
	 * Gets the list of tickets for this transaction
	 * @return the tickets
	 */
	public List<Ticket> getTickets() {
		return tickets;
	}

	/**
	 * Gets the total payment 
	 * @return the totalPayment
	 */
	public float getTotalPayment() {
		return totalPayment;
	}

	/**
	 * Gets the movie name
	 * @return the movieName
	 */
	public String getMovieName() {
		return movieName;
	}

	/**
	 * Gets the date time this transaction is generated
	 * @return the transactionDate
	 */
	public Date getTransactionDate() {
		return transactionDate;
	}

	/**
	 * Gets the show time date
	 * @return the showTime
	 */
	public Date getShowTime() {
		return showTime;
	}

	/**
	 * Creates transaction ID based on given show time and cinema code
	 * @param dateTime The show time 
	 * @param cinemaCode The cinema code
	 */
	public void setTransactionId(Date dateTime, String cinemaCode) {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("YYYYMMDDHHMM");
		this.transactionId = cinemaCode + dateFormatter.format(dateTime);
	}

	/**
	 * Changes the list of tickets
	 * @param tickets the tickets to set
	 */
	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	/**
	 * Changes the total payment
	 * @param totalPayment the totalPayment to set
	 */
	public void setTotalPayment(float totalPayment) {
		this.totalPayment = totalPayment;
	}

	/**
	 * Changes the movie name
	 * @param movieName the movieName to set
	 */
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	/**
	 * Changes the date this transaction is made
	 * @param transactionDate the transactionDate to set
	 */
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	/**
	 * Changes the show time of this transaction
	 * @param showTime the showTime to set
	 */
	public void setShowTime(Date showTime) {
		this.showTime = showTime;
	}
}
