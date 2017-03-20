package BusinessLogic;

/**
 * Created by BorisGrunwald on 14/03/2017.
 */
public class Seat {

    private int number;
    private int row;
    private boolean isReserved;

    public Seat(int row, int number, boolean isReserved) {
        this.number = number;
        this.row = row;
        this.isReserved = isReserved;
    }

    public int getNumber() {
        return number;
    }

    public int getRow() {
        return row;
    }
}
