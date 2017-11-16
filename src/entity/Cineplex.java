package entity;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 * @author Group5
 *
 */

public class Cineplex implements Serializable{
	
	/** Cineplex Id */
    private int cineplexId;
    /** Cineplex Name */
    private String name;

    /* ******************** Constructors *********************/
    public Cineplex(int cineplexId, String name) {
        this.cineplexId = cineplexId;
        this.name = name;
    }

    /* ******************** Getter and Setter Methods *********/
    /**
	 * @return the cineplexId
	 */
    public int getCineplexId() {
        return cineplexId;
    }

    /**
	 * @return the name
	 */
    public String getName() {
        return name;
    }

    /**
	 * @param cineplexId the cineplexId to set
	 */
    public void setCineplexId(int cineplexId) {
        this.cineplexId = cineplexId;
    }

    /**
   	 * @param name the name to set
   	 */
    public void setName(String name) {
        this.name = name;
    }

	
	
}
