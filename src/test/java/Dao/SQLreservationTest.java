package Dao;

import BusinessLogic.Schedule.Schedule;
import BusinessLogic.Seat;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by BorisGrunwald on 21/03/2017.
 */
public class SQLreservationTest {

    SQLreservation res;

    @Before
    public void setUp() throws SQLException {
        res = new SQLreservation();
    }


    @Test
    public void testReserveSeats() throws SQLException {

        List<Seat> toReserve = new ArrayList<>();

        Seat s1 = new Seat(1,5, false);
        Seat s2 = new Seat(1,6, false);

        toReserve.add(s1);
        toReserve.add(s2);

        String moviename = "Shrek";
        int theaterType = 2;
        Timestamp timeAndDate = Timestamp.valueOf("2017-03-17 19:00:00");

        res.reserveSeats(moviename,timeAndDate,theaterType,toReserve);





    }

    @Test
    public void testRemoveReservation() throws SQLException {

        List<Seat> toRemove = new ArrayList<>();

        Seat s1 = new Seat(1,5, false);
        Seat s2 = new Seat(1,6, false);

        toRemove.add(s1);
        toRemove.add(s2);

        String moviename = "Shrek";
        int theaterType = 2;
        Timestamp timeAndDate = Timestamp.valueOf("2017-03-17 19:00:00");

        res.removeReservations(moviename,timeAndDate,theaterType,toRemove);





    }

    @Test
    public void getMovieSchedules() throws Exception {
        SQLreservation sqLreservation = new SQLreservation();

        List<Schedule> scheduleList = sqLreservation.getMovieSchedulesForMovie("Shrek");

        System.out.println(scheduleList);
    }

}


