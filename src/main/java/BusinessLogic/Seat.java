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

    @Override
    public String toString() {
        return "Seat{" +
                "number=" + number +
                ", row=" + row +
                ", isReserved=" + isReserved +
                '}';
    }

    public int getNumber() {
        return number;
    }

    public int getRow() {
        return row;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Seat seat = (Seat) o;

        if (number != seat.number) return false;
        if (row != seat.row) return false;
        return isReserved == seat.isReserved;
    }

    @Override
    public int hashCode() {
        int result = number;
        result = 31 * result + row;
        result = 31 * result + (isReserved ? 1 : 0);
        return result;
    }
}
