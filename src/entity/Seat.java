package entity;

import java.io.Serializable;

/**
 * This class represents a seat with its ID, row and column details
 * @author Group5
 *
 */

public class Seat implements Serializable{
	/** The ID of this seat */
    private int seatId;
    /** The row number of this seat */
    private int row;
    /** The column number of this seat */
    private int column;
	/**
	 * This constructor instantiates a new seat object using its ID, row and column numbers
	 * @param seatId This seat's ID
	 * @param row This seat's row number
	 * @param column This seat's column number
	 */
    public Seat(int seatId, int row, int column) {
        this.seatId = seatId;
        this.row = row;
        this.column = column;
    }

    /**
     * Gets the ID of this seat
     * @return seatID 
     */
    public int getSeatId() {
        return seatId;
    }
    
	/**
	 * Gets the row number of this seat
	 * @return row
	 */
    public int getRow() {
        return row;
    }

    /**
     * Gets the column number of this seat
     * @return column
     */
    public int getColumn() {
        return column;
    }
    
    
}
