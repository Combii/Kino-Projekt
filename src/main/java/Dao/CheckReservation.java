package Dao;

import BusinessLogic.Seat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by David Stovlbaek
 * 16 March 2017.
 */
public class CheckReservation {



    public static boolean checkSeatIsValid(Seat seat){
        try {
            SQLDatabase database = SQLDatabase.getDatabase();

            Connection conn = database.getConnection();

            int seatNumber = seat.getNumber();
            int seatRow = seat.getRow();

            PreparedStatement ps = conn.prepareStatement("SELECT isReserved FROM Seat WHERE seatRow = '"+seatRow+"' AND seatNumber ='"+ seatNumber +"';");
            ResultSet rs = ps.executeQuery();
            rs.next();
            int check = rs.getInt(1);
            if(check == 1) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
