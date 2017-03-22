package BusinessLogic;

import java.util.List;

/**
 * Created by BorisGrunwald on 14/03/2017.
 */
public class BigTheater extends Theater implements Reservation {

    private List<Seat> reservationList;

    public BigTheater() {
        super(25, 16, 1);
    }

    public void setReservation(Seat seat) {
        reservationList.add(seat);
    }

    public boolean isReserved(Seat seat) {
        return reservationList.contains(seat);
    }
    public void removeReservation(Seat seat) {
        reservationList.remove(seat);
    }
}
