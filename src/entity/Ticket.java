package entity;

import java.io.Serializable;

/**
 * This represents a ticket with its availability, seat details, price and type
 * @author group5
 *
 */

public class Ticket implements Serializable  {
	/** The status of a ticket as available */
    public static final String AVAILABLE = "available";
    /** The status of a ticket as sold */
    public static final String SOLD = "sold";
    
    /** The type of this ticket as cenior_citizen */
    public static final String CENIOR_CITIZEN = "cenior_citizen";
    /** The type of this ticket as adult */
    public static final String ADULT = "adult";
    /** The type of this ticket as child */
    public static final String CHILD = "child";
    
    /** The ID of this ticket */
    private int ticketId;
    /** The seat that this ticket being sold for */
    private Seat seat;
    /** The price of this ticket */
    private float price;
    /** The type of this ticket */
    private String ticketType;
    /** The availability of this ticket */
    private String status;
    
    /* ******************** Constructor *************************/
    /**
     * This constructor creates a ticket based on its ID, associated seat, price and availability
     * @param ticketId The ID of this ticket
     * @param seat The seat that this ticket being sold for
     * @param price The price of this ticket
     * @param status The availability of this ticket
     */
    public Ticket(int ticketId, Seat seat, float price, String status) {
        this.ticketId = ticketId;
        this.seat = seat;
        this.price = price;
        this.status = status;
    }

    /* ******************** Getter and Setter Methods *********/
    
    /**
     * Gets the seat that this ticket being sold for
     * @return seat
     */
    public Seat getSeat() {
        return seat;
    }

    /**
     * Gets the ID of this ticket
     * @return ticketId
     */
    public int getTicketId() {
        return ticketId;
    }

    /**
     * Gets the price of this ticket    
     * @return price
     */
    public float getPrice() {
        return price;
    }

    /**
     * Gets the type of this ticket
     * @return
     */
    public String getTicketType() {
        return ticketType;
    }

    /**
     * Gets the availability of this ticket
     * @return
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the ticket's price
     * @param price
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**Sets the type
     * @param ticketType
     */
    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    /**
     * Sets the availability
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Changes the seat that this ticket being sold for
     * @param seat
     */
    public void setSeat(Seat seat) {
        this.seat = seat;
    }
    
    
}
