package entity;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * This class meant for settings which will be used to calculate the price of tickets
 * based on the date booked, the type of movie, type of cinema, and the age of moviegoer
 * @author Group5
 *
 */
public class SystemSetting implements Serializable {
	/**
	 * Used during deserialization to verify that the sender and receiver of a serialized object have loaded 
	 * classes for that object that are compatible with respect to serialization 
	 */
	private static final long serialVersionUID = 1L;
	
	/** Standard Ticket Price */
	private float standardTicketPrice;
	/** Premium Ticket Price */
	private float premiumTicketPrice;
	/** Child Discount Price */
	private float childDiscount;
	/** Senior Citizen Discount */
	private float seniorCitizenDiscount;
	/** Holiday Increment */
	private float holidayIncrement;
	/** List of Holidays */
	private List<Date> holidays;
	/** 3D movie type price increment */
	private float threeDTypeIncrement;
	/** BlockBuster movie type price increment */
	private float blockBusterTypeIncrement;
	/** Digital movie type price increment */
	private float digitalTypeIncrement;
	
	/* ******************** Constructors *********************/
	
	/** Default Constructor to instantiate the SystemSetting object */
	public SystemSetting() {
		//Do Nothing
	}

	/**
	 * Constructor to instantiate the SystemSetting Object with following inputs:
	 * @param standardTicketPrice Price for standard tickets
	 * @param premiumTicketPrice Price for premium tickets
	 * @param childDiscount Discount for child
	 * @param seniorCitizenDiscount Discount for senior citizen
	 * @param holidayIncrement The increment on holiday
	 * @param holidays The list of holidays
	 * @param threeDTypeIncrement The increment on 3D movies
	 * @param blockBusterTypeIncrement The increment on Block Buster movies
	 * @param digitalTypeIncrement The increment on Digital movies
	 */
	public SystemSetting(float standardTicketPrice, float premiumTicketPrice,
			float childDiscount, float seniorCitizenDiscount,
			float holidayIncrement, List<Date> holidays,
			float threeDTypeIncrement, float blockBusterTypeIncrement,
			float digitalTypeIncrement) {
		this.standardTicketPrice = standardTicketPrice;
		this.premiumTicketPrice = premiumTicketPrice;
		this.childDiscount = childDiscount;
		this.seniorCitizenDiscount = seniorCitizenDiscount;
		this.holidayIncrement = holidayIncrement;
		this.holidays = holidays;
		this.threeDTypeIncrement = threeDTypeIncrement;
		this.blockBusterTypeIncrement = blockBusterTypeIncrement;
		this.digitalTypeIncrement = digitalTypeIncrement;
	}

	/* ******************** Getter and Setter Methods *********/
	/**
	 * Gets the price for standard tickets
	 * @return the standardTicketPrice
	 */
	public float getStandardTicketPrice() {
		return standardTicketPrice;
	}

	/**
	 * Gets the price for premium tickets
	 * @return the premiumTicketPrice
	 */
	public float getPremiumTicketPrice() {
		return premiumTicketPrice;
	}

	/**
	 * Gets the discount for kids
	 * @return the childDiscount
	 */
	public float getChildDiscount() {
		return childDiscount;
	}

	/**
	 * Gets the discounts for senior citizens
	 * @return the seniorCitizenDiscount
	 */
	public float getSeniorCitizenDiscount() {
		return seniorCitizenDiscount;
	}

	/**
	 * Gets the increment for holidays
	 * @return the holidayIncrement
	 */
	public float getHolidayIncrement() {
		return holidayIncrement;
	}

	/**
	 * Gets the list of holidays
	 * @return the holidays
	 */
	public List<Date> getHolidays() {
		return holidays;
	}
	
	/**
	 * Gets the increment for 3D movies
	 * @return the threeDTypeIncrement
	 */
	public float getThreeDTypeIncrement() {
		return threeDTypeIncrement;
	}
	
	/**
	 * Changes the increment for Block Buster movies
	 * @return the blockBusterTypeIncrement
	 */
	public float getBlockBusterTypeIncrement() {
		return blockBusterTypeIncrement;
	}
	
	/**
	 * Gets the increment for Digital movies 
	 * @return the digitalTypeIncrement
	 */
	public float getDigitalTypeIncrement() {
		return digitalTypeIncrement;
	}

	/**
	 * Changes the standard ticket price
	 * @param standardTicketPrice The standardTicketPrice to set
	 */
	public void setStandardTicketPrice(float standardTicketPrice) {
		this.standardTicketPrice = standardTicketPrice;
	}

	/**
	 * Changes the premium ticket price
	 * @param premiumTicketPrice the premiumTicketPrice to set
	 */
	public void setPremiumTicketPrice(float premiumTicketPrice) {
		this.premiumTicketPrice = premiumTicketPrice;
	}

	/**
	 * Changes the discount for kids
	 * @param childDiscount the childDiscount to set
	 */
	public void setChildDiscount(float childDiscount) {
		this.childDiscount = childDiscount;
	}

	/**
	 * Changes the discount for senior citizen
	 * @param seniorCitizenDiscount the seniorCitizenDiscount to set
	 */
	public void setSeniorCitizenDiscount(float seniorCitizenDiscount) {
		this.seniorCitizenDiscount = seniorCitizenDiscount;
	}

	/**
	 * Changes the holiday increment
	 * @param holidayIncrement the holidayIncrement to set
	 */
	public void setHolidayIncrement(float holidayIncrement) {
		this.holidayIncrement = holidayIncrement;
	}

	/**
	 * Changes the list of holidays
	 * @param holidays the holidays to set
	 */
	public void setHolidays(List<Date> holidays) {
		this.holidays = holidays;
	}

	/**
	 * Changes the increment for 3D movies
	 * @param threeDTypeIncrement the threeDTypeIncrement to set
	 */
	public void setThreeDTypeIncrement(float threeDTypeIncrement) {
		this.threeDTypeIncrement = threeDTypeIncrement;
	}

	/**
	 * Changes the increment for Block Buster movies
	 * @param blockBusterTypeIncrement the blockBusterTypeIncrement to set
	 */
	public void setBlockBusterTypeIncrement(float blockBusterTypeIncrement) {
		this.blockBusterTypeIncrement = blockBusterTypeIncrement;
	}

	/**
	 * Changes the increment for Digital movies
	 * @param digitalTypeIncrement the digitalTypeIncrement to set
	 */
	public void setDigitalTypeIncrement(float digitalTypeIncrement) {
		this.digitalTypeIncrement = digitalTypeIncrement;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * This method is printing out the details of current settings for prices, discounts and increments
	 */
	@Override
	public String toString() {
		
		System.out.println("========Current System Config=========");
		System.out.println(" Standard Ticket Price      : $"+this.standardTicketPrice);
		System.out.println(" Premium Ticket Price       : $"+this.premiumTicketPrice);
		System.out.println(" Child Discount             : $"+this.childDiscount);
		System.out.println(" Senior Citizen Discount    : $"+this.seniorCitizenDiscount);
		System.out.println(" Holiday Increment          : $"+this.holidayIncrement);
		System.out.println(" 3D Type Increment          : $"+this.threeDTypeIncrement);
		System.out.println(" Blockbuster Type Increment : $"+this.blockBusterTypeIncrement);
		System.out.println(" Digital Type Increment     : $"+this.digitalTypeIncrement);
		System.out.println(" Holidays : ");
		int count= 0;
		DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		for(Date holiday : this.getHolidays()){
			count = count + 1;
			System.out.println(count +". " + formatter.format(holiday));
		}
		System.out.println("=====================================");	
		return super.toString();
	}
	
	/**
	 * This method prints all holidays in dd-MM-yyyy format
	 */
	public void printHoliday(){
		DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		int count = 0;
		for(Date holiday : this.getHolidays()){
			count = count + 1;
			System.out.println(count +". " + formatter.format(holiday));
		}
	}
	
	
}
