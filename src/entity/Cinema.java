package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Cinema implements Serializable {
    public static final String CINEMA_CLASS_REGULAR = "Regular Movie Suites";
    public static final String CINEMA_CLASS_PLATINIUM = "Platinium Movie Suites";

    private int cinemaId;
    private String cinemaCode;
    private Cineplex cineplex;
    private Seat[] seat;
    private String classType;
    private List<TimeSlot> timeSlot;
    private List<Integer> aisleColumns;
 
    public Cinema(int cinemaId, String cinemaCode, Cineplex cineplex, Seat[] seat, String classType, List<TimeSlot> timeSlot,List<Integer> aisleColumns) {
        this.cinemaId = cinemaId;
        this.cinemaCode = cinemaCode;
        this.cineplex = cineplex;
        this.seat = seat;
        this.classType = classType;
        this.timeSlot = timeSlot;
        this.aisleColumns = aisleColumns;
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

    public List<TimeSlot> getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(List<TimeSlot> timeSlot) {
        this.timeSlot = timeSlot;
    }

    public List<Integer> getAisleColumns() {
        return aisleColumns;
    }

    public void setAisleColumns(List<Integer> aisleColumns) {
        this.aisleColumns = aisleColumns;
    }
    
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