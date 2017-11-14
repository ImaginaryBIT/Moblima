package entity;

import java.util.ArrayList;

public class MovieGoer {
	private String movieGoerId;
	private String name;
	private String email;
	private int contact;
	private ArrayList<Transaction> txnList;
	
	public MovieGoer(String name, String email, int contact)
	{
		setMovieGoerId(name, contact);
		this.name=name;
		this.email=email;
		this.contact=contact;
	}
	public String movieGoerId()
	{
		return movieGoerId;
	}
	public String getName()
	{
		return name;
	}
	public String email()
	{
		return email;
	}
	public int getContact()
	{
		return contact;
	}
	public ArrayList<Transaction> getMovieGoerTXN()
	{
		return txnList;
	}
	//set methods
	public void setMovieGoerId(String name, int contact)
	{
		movieGoerId = name + String.valueOf(contact);
	}
	
	public void setName(String name)
	{
		this.name=name;
	}
	public void setEmail(String email)
	{
		this.email=email;		
	}
	public void setContact(int contact)
	{
		this.contact=contact;
	}
public void setMovieGoerTXN(Transaction txn)
{
	this.txnList.add(txn);
}
}
