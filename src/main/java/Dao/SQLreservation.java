package Dao;

import BusinessLogic.Schedule.Schedule;
import BusinessLogic.Seat;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by BorisGrunwald on 20/03/2017.
 */
public class SQLreservation {

    SQLDatabase database = SQLDatabase.getDatabase();
    Connection conn = database.getConnection();
    PreparedStatement ps;

    public SQLreservation() throws SQLException {
    }

    public List<Schedule> getMovieSchedules(String movieName, Timestamp dateAndTime, int theaterType) throws SQLException {
        ResultSet rs = getMovieScheduleId(movieName, dateAndTime, theaterType);

        List<Schedule> list = new ArrayList<>();

        while(rs.next()){
            list.add(new Schedule(rs.getString(3), rs.getInt(2), rs.getString(4)));
        }
        return list;
    }

    public List<Seat> getSeatsForMovie(String movieName, Timestamp dateAndTime, int theaterType) throws SQLException {

        ResultSet movieScheduleIdAndTheaterType = getMovieScheduleId(movieName,dateAndTime, theaterType);
        movieScheduleIdAndTheaterType.next();
        int movieScheduleId = movieScheduleIdAndTheaterType.getInt("movieScheduleID");
        return getSeatList(movieScheduleId);

    }

    private List<Seat> getSeatList(int movieScheduleId) throws SQLException {

        ps = conn.prepareStatement("SELECT seatRow,seatNumber,isReserved FROM Seat WHERE movieScheduleID = '"+movieScheduleId+"';");
        ResultSet seat = ps.executeQuery();

        List<Seat> seats = new LinkedList<>();

        while(seat.next()) {

            int seatRow = seat.getInt("seatRow");
            int seatNumber = seat.getInt("seatNumber");
            boolean isReserved = seat.getBoolean("isReserved");
            seats.add(new Seat(seatRow,seatNumber,isReserved));

        }

        return seats;
    }

    private ResultSet getMovieScheduleId(String movieName, Timestamp dateAndTime, int theaterType) {

        try {
            ps = conn.prepareStatement("SELECT movieScheduleID FROM MovieSchedule WHERE movieName = '"+movieName+"' AND movieDate = '"+dateAndTime+"' AND theaterType = '" + theaterType +"';");
            return ps.executeQuery();

        } catch (SQLException e) {
            return null;
        }

    }


}
