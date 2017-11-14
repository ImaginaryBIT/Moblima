package entity;

import java.io.Serializable;

/**
 * 
 * @author Group5
 *
 */

public class Seat implements Serializable{
	//private int seatId;
	
	/** Seat Layout row */
	private int row;
	/** Seat Layout column */
	private int column;
	/** Status of Seat */
	private boolean isAvailable = true;
	
	public Seat()
	{}

	/* ******************** Constructors *********************/
	
	/**
	 * This constructs the Seat with row-column layout and status
	 * @param row
	 * @param column
	 * @param isAvailable
	 */
    public Seat(int row, int column, boolean isAvailable) {
      //  this.seatId = seatId;
        this.row = row;
        this.column = column;
        this.isAvailable = isAvailable;
    }
    
    /* ******************** Getter and Setter Methods *********/

  //  public int getSeatId() {
    //    return seatId;
    //}

    /**
     * @return the row
     */
    public int getRow() {
        return row;
    }

    /**
     * @return the column
     */
    public int getColumn() {
        return column;
    }
	
    /**
     * @return the isAvailable
     */
    public boolean checkStatus()
    {
    	return isAvailable;
    }
    
    /**
     * @param isAvailable the isAvailable to set
     */
    public void setStatus(boolean isAvailable)
    {
    	this.isAvailable = isAvailable;
    }
}
