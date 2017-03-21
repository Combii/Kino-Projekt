package BusinessLogic;

import BusinessLogic.Movie.Movie;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Julius on 20-03-2017.
 */
class ShowMovie {

    Movie m;
    Timestamp date;
    List<Seat> seats;
    int theaterNumber;

    public ShowMovie() {

    }

    public ShowMovie(Movie m, Timestamp date, int theaterNumber, List<Seat> seats) {
        this.m = m;
        this.date = date;
        this.theaterNumber = theaterNumber;
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "ShowMovie{" +
                "m=" + m +
                ", date='" + date + '\'' +
                ", seats=" + seats +
                ", theaterNumber=" + theaterNumber +
                '}';
    }
}
