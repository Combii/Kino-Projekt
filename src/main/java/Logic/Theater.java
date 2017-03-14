package Logic;

import java.util.List;

/**
 * Created by BorisGrunwald on 14/03/2017.
 */
public class Theater {

    private List<Movie> movies;
    private List<Seat> seats;
    private int seatSize;

    public Theater(List<Movie> movies, int seatSize) {
        this.movies = movies;
        addSeats(seatSize);
        this.seatSize = seatSize;
    }

    public void addMovie(Movie m) {
        movies.add(m);
    }

    private void addSeats(int size){
        for(int i = 0; i < size; i++){
            Seat s = new Seat();
            s.setNumber(i);
            seats.add(s);

        }
    }

}
