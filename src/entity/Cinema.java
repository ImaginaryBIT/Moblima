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

	public Cinema (int cinemaId, String classType) {
		this.setId(cinemaId);
		this.setCinemaClass(classType);
	}
	
	public Cinema (int cinemaId, String classType, Cineplex cineplex)
	{
		this.setId(cinemaId);
		this.setCinemaClass(classType);
		this.cineplex = cineplex;
	}

	public int getId() {
		return cinemaId;
	}

	public void setId(int id) {
		this.cinemaId = id;
	}

	public String getCinemaClass() {
		return classType;
	}

	public void setCinemaClass(String classType) {
		this.classType = classType;
	}
}