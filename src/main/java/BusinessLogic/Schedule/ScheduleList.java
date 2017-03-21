package BusinessLogic.Schedule;


import Dao.SQLreservation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by David Stovlbaek
 * 21 March 2017.
 */
public class ScheduleList {
    List<Schedule> scheduleList = new ArrayList<>();


    public void addScheduleList(String movie, String date, int theaterType){
        scheduleList.add(new Schedule(movie, theaterType, date));
    }


    public void getSchedulesForMovie(String movieName) throws SQLException {
        SQLreservation sqLreservation = new SQLreservation();

        scheduleList = sqLreservation.getMovieSchedulesForMovie(movieName);
    }
}
