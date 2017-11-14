package entity;

import java.io.Serializable;

public class Seat implements Serializable{
	//private int seatId;
	private int row;
	private int column;
	private boolean isAvailable = true;
	
	public Seat()
	{}

    public Seat(int row, int column, boolean isAvailable) {
      //  this.seatId = seatId;
        this.row = row;
        this.column = column;
        this.isAvailable = isAvailable;
    }

  //  public int getSeatId() {
    //    return seatId;
    //}

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
	
    public boolean checkStatus()
    {
    	return isAvailable;
    }
    
    public void setStatus(boolean isAvailable)
    {
    	this.isAvailable = isAvailable;
    }
}
