package entity;

import java.util.ArrayList;

/**
 * 
 * @author Group5
 *
 */
public class MovieGoer extends Person {
	private String movieGoerId;
	private ArrayList<Transaction> txnList;
	
	public MovieGoer(String name, String email, int contact)
	{
		super(name, email, contact);
	}

	/**
	 * @return the movieGoerId
	 */
	public String getMovieGoerId() {
		return movieGoerId;
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
