package entity;

import java.io.Serializable;
import java.util.ArrayList;

public class Cineplex implements Serializable{
	private String cineplexId;
	private ArrayList<Cinema> cinemaList;

	public Cineplex(String cineplexId) {
		this.cineplexId = cineplexId;
		this.cinemaList = new ArrayList<Cinema>();
		for (int i = 0; i < 2; i++) {
			cinemaList.add(new Cinema((i+1), Cinema.CINEMA_CLASS_REGULAR));
		}
		cinemaList.add(new Cinema(2, Cinema.CINEMA_CLASS_PLATINIUM));
	}

	public ArrayList<Cinema> getCinemaList() {
		return cinemaList;
	}
	
	public void setCinema(ArrayList<Cinema> cinemaArray) {
		this.cinemaList = cinemaArray;
	}

	public String getCineplexId() {
		return cineplexId;
	}

	public void setCineplexId(String cineplexId) {
		this.cineplexId = cineplexId;
	}
	
}
