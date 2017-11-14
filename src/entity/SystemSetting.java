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
	
	/* ******************** Constructors *********************/
	/**
	 * @param standardTicketPrice
	 * @param premiumTicketPrice
	 * @param childDiscount
	 * @param seniorCitizenDiscount
	 * @param holidayIncrement
	 * @param holidays
	 */
	public SystemSetting(float standardTicketPrice, float premiumTicketPrice,
			float childDiscount, float seniorCitizenDiscount,
			float holidayIncrement, List<Date> holidays) {
		this.standardTicketPrice = standardTicketPrice;
		this.premiumTicketPrice = premiumTicketPrice;
		this.childDiscount = childDiscount;
		this.seniorCitizenDiscount = seniorCitizenDiscount;
		this.holidayIncrement = holidayIncrement;
		this.holidays = holidays;
	}
	
	/** Default Constructor to instantiate the SystemSetting obj */
	public SystemSetting() {
		//Do Nothing
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		System.out.println("=====================================");
		System.out.println(" Standard Ticket Price   : "+this.getStandardTicketPrice());
		System.out.println(" Premium Ticket Price    : "+this.getPremiumTicketPrice());
		System.out.println(" Child Discount          : "+this.getChildDiscount());
		System.out.println(" Senior Citizen Discount : "+this.getSeniorCitizenDiscount());
		System.out.println(" Holiday Increment       : "+this.getHolidayIncrement());
		System.out.println("");
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
