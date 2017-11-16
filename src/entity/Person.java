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
	/** Person contact number */
	private int contact;
	
	/**
	 * Default Constructor to instantiate the Person Object
	 */
	public Person(){
		//do nothing
	}
	/**
	 * This create a new person object with his/her personal information
	 * @param name This person's name
	 * @param email This person's email
	 * @param contact This person's contact number
	 */
	public Person(String name, String email, int contact) {
		super();
		this.name = name;
		this.email = email;
		this.contact = contact;
	}
	/**
	 * Gets the name of this person
	 * @return name The person's name
	 */
	public String getName() {
		return name;
	}
	/**
	 * Gets this person's email
	 * @return email This person's email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * Gets this person's contact number
	 * @return the contact
	 */
	public int getContact() {
		return contact;
	}
	/**
	 * Changes the name to a new one
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Changes his/her email
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * Changes his/her contact number
	 * @param contact the contact to set
	 */
	public void setContact(int contact) {
		this.contact = contact;
	}
	
	
}
