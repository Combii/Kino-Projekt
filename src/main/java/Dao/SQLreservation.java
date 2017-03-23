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

    public SQLreservation() throws SQLException {
    }


    //-------------------------GET RESERVATIONS--------------------------------//

    public List<Schedule> getMovieSchedulesForMovie(String movieName) {
        ResultSet rs = getMovieSchedules(movieName);

        List<Schedule> list = new ArrayList<>();
        try {
            while (rs.next()) {
                list.add(new Schedule(rs.getString(2), rs.getInt(1), rs.getString(3)));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public List<Seat> getSeatsForMovie(String movieName, Timestamp dateAndTime, int theaterType) throws SQLException {

        int movieScheduleId = getMovieScheduleId(movieName,dateAndTime,theaterType);
        return getSeatList(movieScheduleId);

    }

    //-------------------------ADD RESERVATIONS--------------------------------//

    void reserveSeats(String movieName, Timestamp dateAndTime, int theaterType, List<Seat> seatsToReserve) throws SQLException {

        setIsReserved(true,seatsToReserve,movieName,dateAndTime,theaterType);
    }

    void removeReservations(String movieName, Timestamp dateAndTime, int theaterType, List<Seat> seatsToReserve) throws SQLException {

        setIsReserved(false,seatsToReserve,movieName,dateAndTime,theaterType);

    }

    //----------------------------PRIVATE METHODS-------------------------------//

    private void setIsReserved(boolean reserve, List<Seat> seats, String movieName, Timestamp dateAndTime, int theaterType) throws SQLException {

        int movieScheduleId = getMovieScheduleId(movieName,dateAndTime,theaterType);

        for(Seat toReserve: seats) {
            database.queryUpdate("UPDATE Seat SET isReserved = "+reserve+" WHERE movieScheduleID = "+movieScheduleId+" AND seatNumber = "+toReserve.getNumber()+" AND seatRow = "+toReserve.getRow()+";");
        }

    }

    private List<Seat> getSeatList(int movieScheduleId) throws SQLException {

        ResultSet seat = database.query("SELECT seatRow,seatNumber,isReserved FROM Seat WHERE movieScheduleID = '"+movieScheduleId+"';");

        List<Seat> seats = new LinkedList<>();

        while(seat.next()) {

            int seatRow = seat.getInt("seatRow");
            int seatNumber = seat.getInt("seatNumber");
            boolean isReserved = seat.getBoolean("isReserved");
            seats.add(new Seat(seatRow,seatNumber,isReserved));

        }

        return seats;
    }

    private ResultSet getMovieSchedules(String movieName){
        try {
             return database.query("SELECT theaterType, movieName, movieDate FROM MovieSchedule WHERE movieName ='"+ movieName +"';");
        } catch (SQLException e) {
            return null;
        }
    }

    private int getMovieScheduleId(String movieName, Timestamp dateAndTime, int theaterType) {


        try {
            ResultSet movieScheduleID = database.query("SELECT movieScheduleID FROM MovieSchedule WHERE movieName = '"+movieName+"' AND movieDate = '"+dateAndTime+"' AND theaterType = '" + theaterType +"';");
            movieScheduleID.next();
            return movieScheduleID.getInt("movieScheduleID");
        } catch (SQLException e) {
            return -1;
        }

    }




}
