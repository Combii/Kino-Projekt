
package BusinessLogic;
import BusinessLogic.Movie.Movie;
import Dao.SQLreservation;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by BorisGrunwald on 14/03/2017.
 */
public abstract class Theater {

    private int theaterNumber;
    private int rows;
    private int seats;

    private List<ShowMovie> schedule;

    public Theater() {
    }

    public Theater(int rows, int seats, int theaterNumber) {
        this.rows = rows;
        this.seats = seats;
        this.theaterNumber = theaterNumber;
    }
    //Tilføjer et objekt til databasen / Tilføjer en movie til databasen med en liste af sæder
    public List<ShowMovie> addMovie(Movie m, Timestamp date) {
        List<ShowMovie> list = new ArrayList<ShowMovie>();
        List<Seat> seatList = new ArrayList<>();
        for(int i = 1; i < rows+1; i++){
            for(int j = 1; j < seats+1; j++) {
                seatList.add(new Seat(i , j , false));
            }
        }
        ShowMovie sh = new ShowMovie(m, date, this.theaterNumber, seatList);
        list.add(sh);

        return list;
    }

    public List<Seat> getSeatsList(String name, Timestamp date) throws SQLException {
        SQLreservation sql = new SQLreservation();
        return sql.getSeatsForMovie(name, date, this.theaterNumber);
    }



}
