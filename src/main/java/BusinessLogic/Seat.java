package BusinessLogic;

import com.sun.javafx.scene.control.skin.VirtualFlow;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BorisGrunwald on 14/03/2017.
 */
public class Seat {

    private int number;
    private int row;
    private boolean isReserved;
    private int theater; //Which theater seat is in. 1 Big 2 small

    //private List<Seat> list = new ArrayList<Seat>();
    //List<Seat> bigTheater = new ArrayList<Seat>();

    public Seat(int row, int number, boolean isReserved, int theater) {
        this.number = number;
        this.row = row;
        this.theater = theater;
        this.isReserved = isReserved;
    }

    public int getNumber() {
        return number;
    }

    public int getRow() {
        return row;
    }

    public int getTheater() {
        return theater;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "number=" + number +
                ", row=" + row +
                ", isReserved=" + isReserved +
                ", theater=" + theater +
                '}';
    }
}
