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
    private int theater; //Which theater seat is in. 1 Big 2 small

    private List<Seat> list = new ArrayList<Seat>();
    //List<Seat> bigTheater = new ArrayList<Seat>();

    //konstructor
    public Seat(int row, int number, int theater) {
        this.number = number;
        this.row = row;
        this.theater = theater;
    }


    public void setReserved(Seat seat) {

    }

    //returnere seat...
    public Seat getSeat() {
        return this;
    }

    public List getList() {
        return list;
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
                "list=" + list +
                '}';
    }
}
