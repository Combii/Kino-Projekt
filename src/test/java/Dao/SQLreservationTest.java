package Dao;

import BusinessLogic.Schedule.Schedule;
import BusinessLogic.Seat;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.*;

/**
 * Created by BorisGrunwald on 21/03/2017.
 */
public class SQLreservationTest {

    SQLreservation res;
    SQLDatabase db;
    Random rand;

    //Test movie
    String moviename = "Shrek";
    int theaterType = 2;
    Timestamp timeAndDate = Timestamp.valueOf("2017-03-17 19:00:00");

    @Before
    public void setUp() throws SQLException {
        res = new SQLreservation();
        db = SQLDatabase.getDatabase();
        rand = new Random();
    }


    @Test
    public void testReserveAndRemoveSeats() throws SQLException {

        List<Seat> toReserveThenRemove = getTenUniqueSeats(20,12);

        testReserve(toReserveThenRemove);
        testRemove(toReserveThenRemove);

    }

    private void testRemove(List<Seat> toRemove) throws SQLException {

        res.removeReservations(moviename,timeAndDate,2,toRemove);

        ResultSet shouldBeZero = db.query("SELECT COUNT(*) FROM Seat WHERE movieScheduleID = 1 AND isReserved = TRUE;");
        shouldBeZero.next();

        assertEquals(0,shouldBeZero.getInt("COUNT(*)"));

    }

    private void testReserve(List<Seat> toReserve) throws SQLException {

        res.reserveSeats(moviename,timeAndDate,theaterType,toReserve);

        ResultSet reservedSeats = db.query("SELECT seatNumber,seatRow FROM Seat WHERE movieScheduleID = 1 AND isReserved = TRUE;");

        //Check the seats in DB match the seats in toReserveThenRemove
        while (reservedSeats.next()) {
            Seat seatInDb = new Seat(reservedSeats.getInt("seatRow"),reservedSeats.getInt("SeatNumber"),false);
            assertEquals(true,toReserve.contains(seatInDb));
        }
    }

    @Test
    public void getMovieSchedules() throws Exception {
        SQLreservation sqLreservation = new SQLreservation();

        List<Schedule> scheduleList = sqLreservation.getMovieSchedulesForMovie("Shrek");

        System.out.println(scheduleList);
    }

    private List<Seat> getTenUniqueSeats(int maxRows, int maxNumbers) {

        Set<Seat> seats = new HashSet<>();

        while(seats.size() < 10) {
            seats.add(randomSeat(maxRows,maxNumbers));
        }

        return new ArrayList<>(seats);

    }

    private Seat randomSeat(int maxRows, int maxNumber) {
        return new Seat(rand.nextInt(maxRows)+1,rand.nextInt(maxNumber)+1, false);
    }

}


