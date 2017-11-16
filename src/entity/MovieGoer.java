package entity;

import java.util.ArrayList;
import java.util.List;

/**
 * This represents a moviegoer which inherits person's behaviors and signatures
 * Contains Transaction list, uUsed to store all transactions purchased by the MovieGoer
 * @author Group5
 *
 */
public class MovieGoer extends Person {
	/**
	 * Used during deserialization to verify that the sender and receiver of a
	 * serialized object have loaded classes for that object that are compatible
	 * with respect to serialization
	 */
	private static final long serialVersionUID = 1L;
	/** The ID of this moviegoer */
	private String movieGoerId;
	/** The list of transctions that this moviegoer has made */
	private List<Transaction> txnList;
	
	/* ******************** Constructor ************************/
	
	/**
	 * This constructs the MovieGoer with his/her personal information
	 * @param name This is moviegoer's name
	 * @param email This is his/her email
	 * @param contact This is his/her contact number
	 */
	public MovieGoer(String name, String email, int contact)
	{
		super(name, email, contact);
		this.txnList = new ArrayList<>();
	}

	/* ******************** Getter and Setter Methods *********/
	
	/**
	 * Gets the ID of this moviegoer
	 * @return the movieGoerId
	 */
	public String getMovieGoerId() {
		return movieGoerId;
	}

	/**
	 * Gets all the transactions this moviegoer has made
	 * @return the txnList
	 */
	public List<Transaction> getTxnList() {
		return txnList;
	}
	
	/**
	 * Changes the ID of this moviegoer
	 * @param movieGoerId The movieGoerId to set
	 */
	public void setMovieGoerId(String movieGoerId) {
		this.movieGoerId = movieGoerId;
	}

	/**
	 * Changes the transactions list that the moviegoer has made
	 * @param txnList The transaction list to set
	 */
	public void setTxnList(List<Transaction> txnList) {
		this.txnList = txnList;
	}
	
	/**
	 * Adds one more transaction into transaction list
	 * @param txn New transaction that has just been made
	 */
	public void setMovieGoerTXN(Transaction txn)
	{
		if(this.txnList.isEmpty()) {
			this.txnList = new ArrayList<>();
			this.txnList.add(txn);
		}else {
			this.txnList.add(txn);
		}
		
	}

}
