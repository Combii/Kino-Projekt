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
public class SQLCheckReservation {


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
