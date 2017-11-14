package entity;

public class SeatLayout {
	private int row;
	private int col;

	private Seat[][] seats;

	public SeatLayout() {
		row = 10;
		col = 10;
		seats = new Seat[row][col];
		initializeSeat();
	}

	public SeatLayout(int row, int col) {
		this.row = row;
		this.col = col;
		initializeSeat();
	}

	public Seat getSeat(int row, int col) {
		return seats[row][col];
	}

	public Seat[][] getSeats() {
		return seats;
	}

	public void setSeats(int row, int col, boolean available) {
		seats[row][col].setStatus(available);
	}

	private void initializeSeat() {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				seats[i][j] = new Seat(i, j, false);
			}
		}
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

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
