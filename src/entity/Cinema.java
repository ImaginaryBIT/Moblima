package entity;

import java.io.Serializable;

/**
 * 
 * @author Group5
 *
 */

public class Cinema implements Serializable {
    public static final String CINEMA_CLASS_REGULAR = "Regular Movie Suites";
    public static final String CINEMA_CLASS_PLATINIUM = "Platinium Movie Suites";

    /** Cinema Id */
    private int cinemaId;
    /** Cinema Code */
    private String cinemaCode;
    /** Cineplex */
    private Cineplex cineplex;
    /** Seat */
    private Seat[] seat;
    /** Seat Class type */
    private String classType;

    /* ******************** Constructors *********************/
    public Cinema(int cinemaId, String cinemaCode, Cineplex cineplex, Seat[] seat, String classType) {
        this.cinemaId = cinemaId;
        this.cinemaCode = cinemaCode;
        this.cineplex = cineplex;
        this.seat = seat;
        this.classType = classType;
    }

    /* ******************** Getter and Setter Methods *********/
    /**
	 * @return the CINEMA_CLASS_REGULAR
	 */
    public static String getCINEMA_CLASS_REGULAR() {
        return CINEMA_CLASS_REGULAR;
    }

    /**
	 * @return the CINEMA_CLASS_PLATNIUM
	 */
    public static String getCINEMA_CLASS_PLATINIUM() {
        return CINEMA_CLASS_PLATINIUM;
    }

    /**
	 * @return the cinemaId
	 */
    public int getCinemaId() {
        return cinemaId;
    }

    /**
	 * @return the cinemaCode
	 */
    public String getCinemaCode() {
        return cinemaCode;
    }

    /**
	 * @return the cineplex
	 */
    public Cineplex getCineplex() {
        return cineplex;
    }

    /**
	 * @return the Seat
	 */
    public Seat[] getSeat() {
        return seat;
    }

    /**
	 * @return the classType
	 */
    public String getClassType() {
        return classType;
    }

    /**
	 * @param cinemaId the cinemaId to set
	 */
    public void setCinemaId(int cinemaId) {
        this.cinemaId = cinemaId;
    }

    /**
	 * @param cinemaCode the cinemaCode to set
	 */
    public void setCinemaCode(String cinemaCode) {
        this.cinemaCode = cinemaCode;
    }

    /**
	 * @param cineplex the cineplex to set
	 */
    public void setCineplex(Cineplex cineplex) {
        this.cineplex = cineplex;
    }

    /**
	 * @param seat the seat to set
	 */
    public void setSeat(Seat[] seat) {
        this.seat = seat;
    }

    /**
	 * @param classType the classType to set
	 */
    public void setClassType(String classType) {
        this.classType = classType;
    }

    
}
