package Dao;

import BusinessLogic.Schedule.Schedule;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by David Stovlbaek
 * 21 March 2017.
 */
public class SQLreservationTest {
    @Test
    public void getMovieSchedules() throws Exception {
        SQLreservation sqLreservation = new SQLreservation();

        List<Schedule> scheduleList = sqLreservation.getMovieSchedulesForMovie("Shrek");

        System.out.println(scheduleList);
    }

}