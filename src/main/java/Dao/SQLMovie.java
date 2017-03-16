package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by David Stovlbaek
 * 16 March 2017.
 */
public class SQLMovie {

    public void addMovie(String name, int ageRestriction, double price, String genre) {
        try {
            SQLDatabase database = SQLDatabase.getDatabase();
            Connection conn = database.getConnection();

            int seatNumber = seat.getNumber();
            int seatRow = seat.getRow();

            //PreparedStatement ps = conn.prepareStatement("INSERT INTO Movie (" FROM Seat WHERE seatRow = '"+seatRow+"' AND seatNumber ='"+ seatNumber +"';");
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
