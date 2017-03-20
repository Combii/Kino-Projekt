


package BusinessLogic;

<<<<<<< HEAD

=======
import BusinessLogic.Movie.Movie;
>>>>>>> master

import java.util.Date;

/**
 * Created by BorisGrunwald on 14/03/2017.
 */
public class Ticket {

    private Seat seat;
    private Theater t;
    private Movie movie;
    private Date d;

    public Ticket(Seat seat, Theater t, Movie movie) {
        this.seat = seat;
        this.t = t;
        this.movie = movie;
        this.d = new Date();
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public Theater getT() {
        return t;
    }

    public void setT(Theater t) {
        this.t = t;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
