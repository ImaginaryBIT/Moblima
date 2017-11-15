package entity;

import java.io.Serializable;

public class Seat implements Serializable{
    private int seatId;
    private int row;
    private int column;

    public Seat(int seatId, int row, int column) {
        this.seatId = seatId;
        this.row = row;
        this.column = column;
    }

    public int getSeatId() {
        return seatId;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
    
    
}
