
package BusinessLogic;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by BorisGrunwald on 14/03/2017.
 */
public abstract class Theater {

    private List<Movie> movies;
    private int theaterNumber;

    // liste af liste af sæder (række, nummer) giver ikke mening... v.1 => List<List<Seat>> rowsList;
    private List<Seat> seatList;

    public Theater() {
    }

    public Theater(int rows, int seats, int theaterNumber) {
        seatList = new ArrayList<Seat>(); // ændret
        this.theaterNumber = theaterNumber;
        //addSeats(rows, seats);
    }

    public void addMovie(Movie m) {
        movies.add(m);
    }

    /*private void addSeats(int rows, int seats) {

        for (int a = 0; a <= rows; a++) {
            List<Seat> seatList = new ArrayList<Seat>();
            for (int j = 0; j <= seats; j++) {
                seatList.add(new Seat(a, j, theaterNumber));
            }
            seatList.add(seatList);

        }
    }*/

    @Override
    public String toString() {
        return "Theater{" +
                "movies=" + movies +
                ", seatList=" + seatList +
                '}';
    }
}
