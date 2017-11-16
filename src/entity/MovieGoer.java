package entity;

import java.util.ArrayList;

/**
 * 
 * @author Group5
 *
 */
public class MovieGoer {
	private String movieGoerId;
	private String name;
	private String email;
	private int contact;
	private ArrayList<Transaction> txnList;
	
	public MovieGoer(String name, String email, int contact)
	{
		this.name=name;
		this.email=email;
		this.contact=contact;
	}

	/**
	 * @return the movieGoerId
	 */
	public String getMovieGoerId() {
		return movieGoerId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return the contact
	 */
	public int getContact() {
		return contact;
	}

	/**
	 * @return the txnList
	 */
	public ArrayList<Transaction> getTxnList() {
		return txnList;
	}
	
	
	/**
	 * @param movieGoerId the movieGoerId to set
	 */
	public void setMovieGoerId(String movieGoerId) {
		this.movieGoerId = movieGoerId;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @param contact the contact to set
	 */
	public void setContact(int contact) {
		this.contact = contact;
	}

	/**
	 * @param txnList the txnList to set
	 */
	public void setTxnList(ArrayList<Transaction> txnList) {
		this.txnList = txnList;
	}
	
	public void setMovieGoerTXN(Transaction txn)
	{
		this.txnList.add(txn);
	}

}
