package Dao;

import BusinessLogic.Seat;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by David Stovlbaek
 * 16 March 2017.
 */
public class SQLCheckReservation {


    public static List<Seat> getAllSeats(int theaterNumber, String date) throws SQLException {

        SQLDatabase database = SQLDatabase.getDatabase();
        Connection conn = database.getConnection();

        PreparedStatement ps = conn.prepareStatement("SELECT seatRow, seatNumber, isReserved FROM Seat JOIN Theater ON Seat.TheaterID=Theater.TheaterID JOIN TheaterType ON TheaterType.theaterType=Theater.theaterType\n" +
                "WHERE Theater.theaterType = '"+ theaterNumber +"' AND Theater.movieDate = '"+ date +"';");
        ResultSet rs = ps.executeQuery();

        List<Seat> rList = new ArrayList<>();

        boolean isReservedBoolean = false;

        while(rs.next()) {
            int seatRow = rs.getInt(1);
            int seatNumber = rs.getInt(2);
            int isReserved = rs.getInt(3);
            if(isReserved == 1)
                isReservedBoolean = true;
            else
                isReservedBoolean = false;

            rList.add(new Seat(seatRow, seatNumber, isReservedBoolean, theaterNumber));
        }
        return rList;
    }


    public static boolean checkSeatIsValid(Seat seat){
        try {
            SQLDatabase database = SQLDatabase.getDatabase();
            Connection conn = database.getConnection();

            int seatNumber = seat.getNumber();
            int seatRow = seat.getRow();
            int theater = seat.getTheater();


            PreparedStatement ps = conn.prepareStatement("SELECT isReserved FROM Seat WHERE seatRow = '"+seatRow+"' AND seatNumber ='"+ seatNumber +"' AND TheaterID ='"+ theater +"';");
            ResultSet rs = ps.executeQuery();
            rs.next();
            int check = rs.getInt(1);


            //Return true if reserved
            if(check == 1) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
