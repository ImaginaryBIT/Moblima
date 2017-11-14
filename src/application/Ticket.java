package entity;

import java.util.GregorianCalendar;

public class Ticket {

	private int ticketId;
	private Seat seat;
	private String ticketType;
	private String status;
	private float price;
	private float childDiscount;
	private float seniorDiscount;
	private float increment;
	private float threeDInc;
	private float premiumInc;

	public Ticket(Seat seat, float price, String ticketType, String status) {
		this.status = status;
		this.price = price;
		this.seat = seat;
		this.ticketType = ticketType;
	}
	// get methods

	public int getTicketId() {
		return ticketId;
	}

	public Seat getSeat() {
		return seat;
	}

	public String getTicketType() {
		return ticketType;
	}

	public float getPrice(String citizen, GregorianCalendar dateTime, Cinema cinema, String movieType) {
		price = price + price * getIncrementRate(dateTime, cinema, movieType);
		price = price * getDiscountRate(citizen);
		return price;
	}

	public String getStatus() {
		return status;
	}

	private float getDiscountRate(String citizen) {
		float discount = 1;

		// get discount rate for child and senior citizen
		if (citizen == "Child")
			discount = discount + getChildDiscountRate();
		else if (citizen == "Senior Citizen")
			discount = discount + getSeniorDiscountRate();

		return (float) discount;
	}

	public float getSeniorDiscountRate() {
		return seniorDiscount;
	}

	public float getIncRate() {
		return increment;
	}

	public float getChildDiscountRate() {
		return childDiscount;
	}
	public float get3DInc()
	{
		return threeDInc;
	}
	public float getPremiumInc()
	{
		return premiumInc;
	}

	// apply for both holiday and weekend
	private float getIncrementRate(GregorianCalendar dateTime, Cinema cinema, String movieType) {
		float incRate = 0;
		PublicHoliday holiday = new PublicHoliday();
		// get increament rate for holiday
		if (holiday.isHoliday((GregorianCalendar) dateTime.clone())) // public holiday
			incRate += getIncRate();
		else if (dateTime.get(GregorianCalendar.DAY_OF_WEEK) == GregorianCalendar.SATURDAY
				|| dateTime.get(GregorianCalendar.DAY_OF_WEEK) == GregorianCalendar.SUNDAY) {
			if (movieType == "3D") {
				incRate += get3DInc();
			} else {
				incRate += getIncRate();
			}
		}

		// no matter who you are
		if (cinema.getClassType().equals(Cinema.CINEMA_CLASS_PLATINIUM)) {
			incRate += getPremiumInc();
		}
		return incRate;
	}

	// set methods
	public void setSeat(Seat seat) {
		this.seat = seat;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setChildDiscountRate(float childDR) {
		this.childDiscount = childDR;
	}

	public void setSeniorDiscountRate(float seniorCitizenDR) {
		this.seniorDiscount = seniorCitizenDR;
	}

	public void setIncRate(float increment) {
		this.increment = increment;
	}
	public void set3DInc(float threeDInc)
	{
		this.threeDInc = threeDInc;
	}
	public void setPremiumInc(float premiumInc)
	{
		this.premiumInc = premiumInc;
	}
}
