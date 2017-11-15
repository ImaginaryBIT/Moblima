package entity;

import java.util.Scanner;

import application.MovieController;
import application.SystemSettingController;

public class Staff {
	private String staffName;
	private int staffContact;
	private String staffMail;
	private String staffID;
	private String password;
	private String username;

	public Staff() {

	}
	
	public Staff (String name, String id, String pw, String mail, int contact){
		staffName = name;
		staffContact = contact;
		staffMail = mail;
		staffID = id;
		password = pw;
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
