package entity;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import database.SerializeDB;

/**
 * This class implement the login function
 * @author Group5
 *
 */

public class Login {
	
	/** User Id */
	private String id;
	
	/** Password */
	private String pw;
	
	
	int choice;
	Scanner sc = new Scanner(System.in);
	
	/**
	 * This method return the message if login is successful or not
	 * @return boolean
	 */
	public boolean authenticate(){
		
		try{
			System.out.print("Enter Login ID: ");
			String id = sc.nextLine();
			System.out.print("Enter Password: ");
			String pw = sc.nextLine();
			
			ArrayList list = new ArrayList();		
			
			list = (ArrayList) SerializeDB.readSerializedObject("Staff.ser");
			
			for(int i=0;i<list.size();i++){
				Staff s = (Staff)list.get(i);

				if(s.getStaffID().equals(id)){
					if(s.getPassword().equals(pw)){
						return true;
					}
				}
			}
		}
		catch (Exception e ) {
			System.out.println( "Exception >> " + e.getMessage() );
		}
		
		return false;
	}
	

}
