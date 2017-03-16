package BusinessLogic;

/**
 * Created by KO3AK on 16-03-2017.
 */
public interface Reservation {

    void setReservation(Seat seat);
    boolean isReserved(Seat seat);
    void removeReservation(Seat seat);

}
