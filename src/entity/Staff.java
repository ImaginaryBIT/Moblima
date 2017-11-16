package entity;

/**
 * This represents a staff who inherits a person's behaviors and signatures
 * Instantiates a Staff object and grant the admin the access to functions and classes dedicated to Staff
 * @author group5
 *
 */

public class Staff extends Person {
	/**
	 * Used during deserialization to verify that the sender and receiver of a
	 * serialized object have loaded classes for that object that are compatible
	 * with respect to serialization
	 */
	private static final long serialVersionUID = 1L;
	/** The ID of this staff */
	private String staffID;
	/** The password of this staff */
	private String password;
	
	/* ******************** Constructors *************************/
	
	/**
	 * The creates a new Staff with his/her personal details
	 * @param name The name of this staff
	 * @param id The username of this staff
	 * @param pw His/her password
	 * @param mail His/her email
	 * @param contact The contact number
	 */
	public Staff (String name, String id, String pw, String mail, int contact){
		super(name, mail, contact);
		staffID = id;
		password = pw;
	}
	
	/**
	 * The default constructor
	 */
	public Staff() {
		super();
	}

	/* ******************** Getter Methods *********/
	
	/** 
	 * Gets the ID of this staff 
	 * @return staffID
	 */
	public String getStaffID() {
		return staffID;
	}

	/**
	 * Gets this staff password
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * This methods creates a Login object and make an authentication query
	 * @return true if the authentication for this staff is successful, false otherwise 
	 */
	public boolean login() {
		Login log= new Login();
		return log.authenticate();
	}

}
