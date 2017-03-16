package Dao;

import BusinessLogic.Seat;

import java.sql.SQLException;

/**
 * Created by David Stovlbaek
 * 16 March 2017.
 */
public class CheckReservation {



    public static boolean checkSeatIsValid(Seat seat){
        try {
            SQLDatabase database = SQLDatabase.getDatabase();


            int seatNumber = seat.getNumber();
            int seatRow = seat.getRow();





        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
