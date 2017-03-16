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
    private List<Seat> list = new ArrayList<Seat>();
    //List<Seat> bigTheater = new ArrayList<Seat>();

    //konstructor
    public Seat(int row, int number) {
        this.number = number;
        this.row = row;
    }

    public boolean isReserved(Seat seat) {
        if(list.contains(seat)) {
            return true;
        } else return false;
    }

    public void setReserved(Seat seat) {

    }

    //returnere seat...
    public Seat getSeat() {
        return this;
    }
}
