package entity;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 
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
	/** Holidays */
	private List<Date> holidays;
	/** 3D movie type price increment */
	private float threeDTypeIncrement;
	/** BlockBuster movie type price increment */
	private float blockBusterTypeIncrement;
	/** 3igital movie type price increment */
	private float digitalTypeIncrement;
	
	/* ******************** Constructors *********************/
	
	
	/** Default Constructor to instantiate the SystemSetting obj */
	public SystemSetting() {
		//Do Nothing
	}

	/**
	 * Constructor to instantiate the SystemSetting Object with following inputs:
	 * @param standardTicketPrice
	 * @param premiumTicketPrice
	 * @param childDiscount
	 * @param seniorCitizenDiscount
	 * @param holidayIncrement
	 * @param holidays
	 * @param threeDTypeIncrement
	 * @param blockBusterTypeIncrement
	 * @param digitalTypeIncrement
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
	 * @return the standardTicketPrice
	 */
	public float getStandardTicketPrice() {
		return standardTicketPrice;
	}

	/**
	 * @return the premiumTicketPrice
	 */
	public float getPremiumTicketPrice() {
		return premiumTicketPrice;
	}

	/**
	 * @return the childDiscount
	 */
	public float getChildDiscount() {
		return childDiscount;
	}

	/**
	 * @return the seniorCitizenDiscount
	 */
	public float getSeniorCitizenDiscount() {
		return seniorCitizenDiscount;
	}

	/**
	 * @return the holidayIncrement
	 */
	public float getHolidayIncrement() {
		return holidayIncrement;
	}

	/**
	 * @return the holidays
	 */
	public List<Date> getHolidays() {
		return holidays;
	}

	/**
	 * @param standardTicketPrice the standardTicketPrice to set
	 */
	public void setStandardTicketPrice(float standardTicketPrice) {
		this.standardTicketPrice = standardTicketPrice;
	}

	/**
	 * @param premiumTicketPrice the premiumTicketPrice to set
	 */
	public void setPremiumTicketPrice(float premiumTicketPrice) {
		this.premiumTicketPrice = premiumTicketPrice;
	}

	/**
	 * @param childDiscount the childDiscount to set
	 */
	public void setChildDiscount(float childDiscount) {
		this.childDiscount = childDiscount;
	}

	/**
	 * @param seniorCitizenDiscount the seniorCitizenDiscount to set
	 */
	public void setSeniorCitizenDiscount(float seniorCitizenDiscount) {
		this.seniorCitizenDiscount = seniorCitizenDiscount;
	}

	/**
	 * @param holidayIncrement the holidayIncrement to set
	 */
	public void setHolidayIncrement(float holidayIncrement) {
		this.holidayIncrement = holidayIncrement;
	}

	/**
	 * @param holidays the holidays to set
	 */
	public void setHolidays(List<Date> holidays) {
		this.holidays = holidays;
	}
	
	
	/**
	 * @return the threeDTypeIncrement
	 */
	public float getThreeDTypeIncrement() {
		return threeDTypeIncrement;
	}

	/**
	 * @return the blockBusterTypeIncrement
	 */
	public float getBlockBusterTypeIncrement() {
		return blockBusterTypeIncrement;
	}

	/**
	 * @return the digitalTypeIncrement
	 */
	public float getDigitalTypeIncrement() {
		return digitalTypeIncrement;
	}

	/**
	 * @param threeDTypeIncrement the threeDTypeIncrement to set
	 */
	public void setThreeDTypeIncrement(float threeDTypeIncrement) {
		this.threeDTypeIncrement = threeDTypeIncrement;
	}

	/**
	 * @param blockBusterTypeIncrement the blockBusterTypeIncrement to set
	 */
	public void setBlockBusterTypeIncrement(float blockBusterTypeIncrement) {
		this.blockBusterTypeIncrement = blockBusterTypeIncrement;
	}

	/**
	 * @param digitalTypeIncrement the digitalTypeIncrement to set
	 */
	public void setDigitalTypeIncrement(float digitalTypeIncrement) {
		this.digitalTypeIncrement = digitalTypeIncrement;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		System.out.println("========Current System Config=========");
		System.out.println(" Standard Ticket Price      : "+this.standardTicketPrice);
		System.out.println(" Premium Ticket Price       : "+this.premiumTicketPrice);
		System.out.println(" Child Discount             : "+this.childDiscount);
		System.out.println(" Senior Citizen Discount    : "+this.seniorCitizenDiscount);
		System.out.println(" Holiday Increment          : "+this.holidayIncrement);
		System.out.println(" 3D Type Increment          : "+this.threeDTypeIncrement);
		System.out.println(" Blockbuster Type Increment : "+this.blockBusterTypeIncrement);
		System.out.println(" Digital Type Increment		: "+this.digitalTypeIncrement);
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
	
	public void printHoliday(){
		DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		int count = 0;
		for(Date holiday : this.getHolidays()){
			count = count + 1;
			System.out.println(count +". " + formatter.format(holiday));
		}
	}
	
	
}
