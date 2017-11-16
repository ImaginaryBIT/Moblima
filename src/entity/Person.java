package entity;

public class Person {
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
