package entity;

import java.io.Serializable;

public class Cinema implements Serializable {
    public static final String CINEMA_CLASS_REGULAR = "Regular Movie Suites";
    public static final String CINEMA_CLASS_PLATINIUM = "Platinium Movie Suites";

    private int cinemaId;
    private String cinemaCode;
    private Cineplex cineplex;
    private Seat[] seat;
    private String classType;

    public Cinema(int cinemaId, String cinemaCode, Cineplex cineplex, Seat[] seat, String classType) {
        this.cinemaId = cinemaId;
        this.cinemaCode = cinemaCode;
        this.cineplex = cineplex;
        this.seat = seat;
        this.classType = classType;
    }

    public static String getCINEMA_CLASS_REGULAR() {
        return CINEMA_CLASS_REGULAR;
    }

    public static String getCINEMA_CLASS_PLATINIUM() {
        return CINEMA_CLASS_PLATINIUM;
    }

    public int getCinemaId() {
        return cinemaId;
    }

    public String getCinemaCode() {
        return cinemaCode;
    }

    public Cineplex getCineplex() {
        return cineplex;
    }

    public Seat[] getSeat() {
        return seat;
    }

    public String getClassType() {
        return classType;
    }

    public void setCinemaId(int cinemaId) {
        this.cinemaId = cinemaId;
    }

    public void setCinemaCode(String cinemaCode) {
        this.cinemaCode = cinemaCode;
    }

    public void setCineplex(Cineplex cineplex) {
        this.cineplex = cineplex;
    }

    public void setSeat(Seat[] seat) {
        this.seat = seat;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    
}