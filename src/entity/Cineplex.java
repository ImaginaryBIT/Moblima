package entity;

import java.io.Serializable;
import java.util.ArrayList;

public class Cineplex implements Serializable{
    private int cineplexId;
    private String name;

    public Cineplex(int cineplexId, String name) {
        this.cineplexId = cineplexId;
        this.name = name;
    }

    public int getCineplexId() {
        return cineplexId;
    }

    public String getName() {
        return name;
    }

    public void setCineplexId(int cineplexId) {
        this.cineplexId = cineplexId;
    }

    public void setName(String name) {
        this.name = name;
    }

	
	
}
