package entity;

import java.io.Serializable;

public class Ticket implements Serializable  {
    public static final String AVAILABLE = "available";
    public static final String SOLD = "sold";
    
    public static final String CENIOR_CITIZEN = "cenior_citizen";
    public static final String ADULT = "adult";
    public static final String CHILD = "child";
    
    private int ticketId;
    private Seat seat;
    private float price;
    private String ticketType;
    private String status;
    
    
    public Ticket(int ticketId, Seat seat, float price, String status) {
        this.ticketId = ticketId;
        this.seat = seat;
        this.price = price;
        this.status = status;
    }

    public Seat getSeat() {
        return seat;
    }

    public int getTicketId() {
        return ticketId;
    }

    public float getPrice() {
        return price;
    }

    public String getTicketType() {
        return ticketType;
    }

    public String getStatus() {
        return status;
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

    public void setSeat(Seat seat) {
        this.seat = seat;
    }
    
    
}
