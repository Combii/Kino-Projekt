package BusinessLogic.Movie;

import Dao.SQLreservation;
import java.sql.SQLException;

/**
 * Created by Lenovo on 21-03-2017.
 */
public class Statistic {

    String movie = "";
    int count = 0;


    public String mostSoldMovie() {
        try {
            SQLreservation checkSeat = new SQLreservation();
            while(true) {
                //if seat reserved count
                if(checkSeat.checkAllSeats()){
                    count++;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movie;
    }
}
