package Dao;

import BusinessLogic.Seat;
import junit.framework.TestCase;

/**
 * Created by David Stovlbaek
 * 16 March 2017.
 */
public class CheckReservationTest extends TestCase {
    public void testCheckSeatIsValid() throws Exception {
        Seat seat = new Seat(1, 1);
        System.out.println(CheckReservation.checkSeatIsValid(seat));
        assertEquals(CheckReservation.checkSeatIsValid(seat), true);

        Seat seat2 = new Seat(2, 2);
        System.out.println(CheckReservation.checkSeatIsValid(seat2));
        assertEquals(CheckReservation.checkSeatIsValid(seat2), false);
    }

}