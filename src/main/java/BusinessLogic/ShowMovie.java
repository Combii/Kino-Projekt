package BusinessLogic;

import BusinessLogic.Movie.Movie;

import java.util.List;

/**
 * Created by Julius on 20-03-2017.
 */
class ShowMovie {

    Movie m;
    String date;
    List<Seat> seats;
    int theaterNumber;

    public ShowMovie() {

    }

    public ShowMovie(Movie m, String date, int theaterNumber, List<Seat> seats) {
        this.m = m;
        this.date = date;
        this.theaterNumber = theaterNumber;
        this.seats = seats;
    }
}
