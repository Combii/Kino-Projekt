package Dao;

import BusinessLogic.Seat;
import junit.framework.TestCase;

/**
 * Created by David Stovlbaek
 * 16 March 2017.
 */
public class SQLCheckReservationTest extends TestCase {
    public void testCheckSeatIsValid() throws Exception {
        Seat seat = new Seat(1, 1, 1);
        System.out.println(SQLCheckReservation.checkSeatIsValid(seat));
        assertEquals(SQLCheckReservation.checkSeatIsValid(seat), true);

        Seat seat2 = new Seat(2, 2, 1);
        System.out.println(SQLCheckReservation.checkSeatIsValid(seat2));
        assertEquals(SQLCheckReservation.checkSeatIsValid(seat2), false);
    }

}