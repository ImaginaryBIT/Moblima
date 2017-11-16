package entity;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 * @author Group5
 *
 */
public class MovieGoer extends Person{
	/**
	 * Used during deserialization to verify that the sender and receiver of a
	 * serialized object have loaded classes for that object that are compatible
	 * with respect to serialization
	 */
	private static final long serialVersionUID = 1L;
	private String movieGoerId;
	private ArrayList<Transaction> txnList;
	
	public MovieGoer(String name, String email, int contact)
	{
		super(name, email, contact);
		this.txnList = new ArrayList();
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
		if(this.txnList.isEmpty()) {
			this.txnList = new ArrayList();
			this.txnList.add(txn);
		}else {
			this.txnList.add(txn);
		}
		
	}

}
