package entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Transaction implements Serializable{
	private String transactionId;
	private List<Ticket> tickets;
	private float totalPayment;
	private String movieName;
	private Date transactionDate;
	private Date showTime;

	public Transaction(Date showTime, String cinemaCode, String movieName, List<Ticket> tickets,float totalPayment) {
		setTxnId(showTime, cinemaCode);
		this.tickets = tickets;
		this.showTime = showTime;
		this.movieName = movieName;
                this.totalPayment = totalPayment;
		transactionDate = new Date();
	}

	
	/**
	 * @return the transactionId
	 */
	public String getTransactionId() {
		return transactionId;
	}



	/**
	 * @return the tickets
	 */
	public List<Ticket> getTickets() {
		return tickets;
	}



	/**
	 * @return the totalPayment
	 */
	public float getTotalPayment() {
		return totalPayment;
	}



	/**
	 * @return the movieName
	 */
	public String getMovieName() {
		return movieName;
	}



	/**
	 * @return the transactionDate
	 */
	public Date getTransactionDate() {
		return transactionDate;
	}



	/**
	 * @return the showTime
	 */
	public Date getShowTime() {
		return showTime;
	}

	/**
	 * @param transactionId the transactionId to set
	 */
	public void setTransactionId(Date dateTime, String cinemaCode) {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("YYYYMMDDHHMM");
		this.transactionId = cinemaCode + dateFormatter.format(dateTime);
	}



	/**
	 * @param tickets the tickets to set
	 */
	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}



	/**
	 * @param totalPayment the totalPayment to set
	 */
	public void setTotalPayment(float totalPayment) {
		this.totalPayment = totalPayment;
	}



	/**
	 * @param movieName the movieName to set
	 */
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}



	/**
	 * @param transactionDate the transactionDate to set
	 */
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}



	/**
	 * @param showTime the showTime to set
	 */
	public void setShowTime(Date showTime) {
		this.showTime = showTime;
	}


	// use setTransactionId method. will remove this method
	private void setTxnId(Date dateTime, String cinemaCode) {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("YYYYMMDDHHMM");
		this.transactionId = cinemaCode + dateFormatter.format(dateTime);
	}

}
