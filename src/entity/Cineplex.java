package entity;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Represents a Cineplex
 * 
 * @author Group5
 * @since 16/11/2017
 */

public class Cineplex implements Serializable {

	/** Cineplex Id */
	private int cineplexId;
	/** Cineplex Name */
	private String name;

	/*
	 * ******************** Constructors ********************* 
	 * This instantiates a cineplex with the cineplex name and ID
	 * @param cineplexId This cineplex's ID	 * 
	 * @param name This cineplex's name
	 *
	 */
	public Cineplex(int cineplexId, String name) {
		this.cineplexId = cineplexId;
		this.name = name;
	}

	/* ******************** Getter and Setter Methods *********/
	/**
	 * Gets the ID of the cineplex
	 * @return the cineplexId
	 */
	public int getCineplexId() {
		return cineplexId;
	}

	/**
	 * Gets the cineplex's name
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Changes this cineplex's ID
	 * @param cineplexId The cineplexId to change to
	 */
	public void setCineplexId(int cineplexId) {
		this.cineplexId = cineplexId;
	}

	/**
	 * Changes the name of this cineplex
	 * @param name The name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
