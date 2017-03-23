package Dao;

import org.junit.Test;

/**
 * Created by David Stovlbaek
 * 17 March 2017.
 */
public class SQLCheckReservationTest {
    @Test
    public void getAllSeats() throws Exception {
        System.out.println(SQLCheckReservation.getAllSeats(1, "2017-03-16 18:22:12"));
    }
/*
    @Test
    public void checkSeatIsValid() throws Exception {
        Seat seat = new Seat(1, 1, false , 1);
        System.out.println(SQLCheckReservation.checkSeatIsValid(seat));
        assertEquals(SQLCheckReservation.checkSeatIsValid(seat), true);

        Seat seat2 = new Seat(2, 2,false,  1);
        System.out.println(SQLCheckReservation.checkSeatIsValid(seat2));
        assertEquals(SQLCheckReservation.checkSeatIsValid(seat2), false);
    }
*/
}