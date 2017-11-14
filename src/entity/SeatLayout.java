package entity;

/**
 * This class layout the seat arrangement
 * @author Group5
 *
 */

public class SeatLayout {
	/** Seat Layout row */
	private int row;
	/** Seat Layout column */
	private int col;
	/** Seat Layout Two column array */
	private Seat[][] seats;

	/**
	 * Initializing of seat arrangement
	 */
	public SeatLayout() {
		row = 10;
		col = 10;
		seats = new Seat[row][col];
		initializeSeat();
	}

	/**
	 * Initialize based on row and column assigned
	 * @param row
	 * @param col
	 */
	public SeatLayout(int row, int col) {
		this.row = row;
		this.col = col;
		initializeSeat();
	}

	/**
	 * @param row
	 * @param col
	 * @return seats based on row and column assigned
	 */
	public Seat getSeat(int row, int col) {
		return seats[row][col];
	}

	/**
	 * 
	 * @return the seats
	 */
	public Seat[][] getSeats() {
		return seats;
	}

	/**
	 * Set seat is available
	 * @param row
	 * @param col
	 * @param available
	 */
	public void setSeats(int row, int col, boolean available) {
		seats[row][col].setStatus(available);
	}

	/**
	 * Create the seats
	 */
	private void initializeSeat() {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				seats[i][j] = new Seat(i, j, false);
			}
		}
	}

	/**
	 * @return the row
	 */
	public int getRow() {
		return row;
	}

	/**
	 * @return the column
	 */
	public int getCol() {
		return col;
	}

	/**
	 * get the avaliable seats
	 * @return the count
	 */
	public int getAvailSeatNum() {
		int count = 0;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (seats[i][j].checkStatus() == true) {// check if a seat is available
					count++;
				}
			}
		}
		return count;
	}

	/**
	 * Printing Seat Layout
	 */
	public void printSeatLayout() {
		System.out.print("  ");
		   for (int index = 0; index < seats[0].length; index++) {
				System.out.printf("%d ", index);
			}
		   System.out.println();

		for (int i = 0; i < seats.length; i++) {
			System.out.printf("%d ", i);
			for (int j = 0; j < seats[i].length; j++) {
				if (seats[i][j].checkStatus() == true)// if the seat is available
					System.out.print("O");
				else
					System.out.print("X");
			}
			System.out.println();
		}
	}
}
