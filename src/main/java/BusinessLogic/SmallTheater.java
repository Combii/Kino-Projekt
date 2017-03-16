package BusinessLogic;

import java.util.List;

/**
 * Created by BorisGrunwald on 14/03/2017.
 */
public class SmallTheater extends Theater implements Reservation {

    private List<Seat> reservationList;

    public SmallTheater() {
        super(20, 12, 2);
    }

    public void setReservation(Seat seat) {
        reservationList.add(seat);
    }

    public boolean isReserved(Seat seat) {
        if(reservationList.contains(seat)) {
            return true;
        } else return false;
    }

    public void removeReservation(Seat seat) {
        reservationList.remove(seat);
    }
}
