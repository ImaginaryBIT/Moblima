package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Represents a Cinema. Contains arrays of Seat and TimeSlot and Cineplex object
 * @author Group5
 * @since 16/11/2017
 */

public class Cinema implements Serializable {
	/** Regular Movie Suite */
    public static final String CINEMA_CLASS_REGULAR = "Regular Movie Suites";
    /** Platinium Movie Suites */
    public static final String CINEMA_CLASS_PLATINIUM = "Platinium Movie Suites";

    /** Cinema Id */
    private int cinemaId;
    /** Cinema Code */
    private String cinemaCode;
    /** Cineplex */
    private Cineplex cineplex;
    /** Seat list*/
    private Seat[] seat;
    /** Class Type of the Cinema*/
    private String classType;
    /** List of Time Slot */
    private List<TimeSlot> timeSlot;
    /** The aisle in this cinema */
    private List<Integer> aisleColumns;
 
    /* ******************** Constructors *********************/
  	/**
  	 * This construct the Cinema with cinema's Id, cinema code, its cineplex, list of seats, class type, list of movie time slot and list of aisle columns
  	 * @param cinemaId This cinema's ID
  	 * @param cinemaCode This cinema's code
  	 * @param cineplex The cineplex where this cinema is located at
  	 * @param seat List of seats in this cinema
  	 * @param classType This cinema's class type
  	 * @param aisleColumns The aisle in this cinema
  	 * @param timeSlot This cinema's time slot
  	 */
    public Cinema(int cinemaId, String cinemaCode, Cineplex cineplex, Seat[] seat, String classType, List<TimeSlot> timeSlot,List<Integer> aisleColumns) {
        this.cinemaId = cinemaId;
        this.cinemaCode = cinemaCode;
        this.cineplex = cineplex;
        this.seat = seat;
        this.classType = classType;
        this.timeSlot = timeSlot;
        this.aisleColumns = aisleColumns;
    }
    
    /* ******************** Getter and Setter Methods *********/

    /**
     * Gets the regular type of this cinema
     * @return the CINEMA_CLASS_REGULAR
     */
    public static String getCINEMA_CLASS_REGULAR() {
        return CINEMA_CLASS_REGULAR;
    }

    /**
     * Gets the the platinum type of this cinema
     * @return the CINEMA_CLASS_PLATINIUM
     */
    public static String getCINEMA_CLASS_PLATINIUM() {
        return CINEMA_CLASS_PLATINIUM;
    }

    /**
     * Gets this cinema's ID
     * @return the cinemaId
     */
    public int getCinemaId() {
        return cinemaId;
    }

    /**
     * Gets this cinema's code
     * @return the cinemaCode
     */
    public String getCinemaCode() {
        return cinemaCode;
    }

    /**
     * Gets the cineplex where the cinema is in
     * @return the cineplex
     */
    public Cineplex getCineplex() {
        return cineplex;
    }

    /**
     * Gets the list of seats in this cinema
     * @return the seat array
     */
    public Seat[] getSeat() {
        return seat;
    }

    /**
     * Gets the type of cinema's class
     * @return the classType
     */
    public String getClassType() {
        return classType;
    }

    /**
     * Gets the cinema's time slot
     * @return the timeSlot
     */
    public List<TimeSlot> getTimeSlot() {
        return timeSlot;
    }
    
    /**
     * Gets this cinema's aisle columns 
     * @return aisleColumns
     */
    public List<Integer> getAisleColumns() {
        return aisleColumns;
    }
    
    /**
     * Changes the ID of this cinema
     * @param cinemaId the cinemaId to set
     */
    public void setCinemaId(int cinemaId) {
        this.cinemaId = cinemaId;
    }

    /**
     * Changes the code of this cinema
     * @param cinemaCode the cinemaCode to set
     */
    public void setCinemaCode(String cinemaCode) {
        this.cinemaCode = cinemaCode;
    }

    /**
     * Changes the cineplex of this cinema
     * @param cineplex the cineplex to set
     */
    public void setCineplex(Cineplex cineplex) {
        this.cineplex = cineplex;
    }

    /**
     * Changes the list of seats in this cinema
     * @param seat the seat to set
     */
    public void setSeat(Seat[] seat) {
        this.seat = seat;
    }

    /**
     * Changes the class type of this cinema
     * @param classType the classType to set
     */
    public void setClassType(String classType) {
        this.classType = classType;
    }

    /**
     * Changes this cinema's time slot 
     * @param timeSlot the timeSlot to set
     */
    public void setTimeSlot(List<TimeSlot> timeSlot) {
        this.timeSlot = timeSlot;
    }

    /**
     * Changes the list of this cinema's aisle columns 
     * @param aisleColumns The aisle column lists to change to
     */
    public void setAisleColumns(List<Integer> aisleColumns) {
        this.aisleColumns = aisleColumns;
    }
    
    /**
     * Changes the status of certain time slot when this movie is shown
     * @param date The time slot when this movie is shown
     * @param status The status to set to
     * @return true if success, false if fail to 
     */
    public boolean setTimeSlotStatus(Date date,String status){
        for(TimeSlot ts :this.timeSlot){
            if(date.equals(ts.getDateTime())){
                ts.setStatus(status);
                return true;
            }
        }
        return false;
    }
    
}
