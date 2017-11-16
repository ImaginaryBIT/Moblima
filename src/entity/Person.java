package entity;

import java.io.Serializable;

public class Person implements Serializable {
	/**
	 * Used during deserialization to verify that the sender and receiver of a
	 * serialized object have loaded classes for that object that are compatible
	 * with respect to serialization
	 */
	private static final long serialVersionUID = 1L;
	/** Person Name */
	private String name;
	/** Person Email */
	private String email;
	/** Person contact nubmer */
	private int contact;
	
	/**
	 * Default Constructor to instantiate the Person Object
	 */
	public Person(){
		//do nothing
	}
	/**
	 * @param name
	 * @param email
	 * @param contact
	 */
	public Person(String name, String email, int contact) {
		super();
		this.name = name;
		this.email = email;
		this.contact = contact;
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
	
	
}
