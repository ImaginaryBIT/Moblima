package entity;


public class Staff extends Person {
	/**
	 * Used during deserialization to verify that the sender and receiver of a
	 * serialized object have loaded classes for that object that are compatible
	 * with respect to serialization
	 */
	private static final long serialVersionUID = 1L;
	private String staffID;
	private String password;

	
	public Staff (String name, String id, String pw, String mail, int contact){
		super(name, mail, contact);
		staffID = id;
		password = pw;
	}
	
	public Staff() {
		super();
	}

	public String getStaffID() {
		return staffID;
	}

	public String getPassword() {
		return password;
	}

	public boolean login() {
		Login log= new Login();
		return log.authenticate();
	}

}
