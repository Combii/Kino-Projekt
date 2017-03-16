
package BusinessLogic;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by BorisGrunwald on 14/03/2017.
 */
public abstract class Theater {

    private List<Movie> movies;
    private List<List<Seat>> rowsList;

    public Theater() {
    }

    public Theater(int rows, int seats) {
        rowsList = new ArrayList<List<Seat>>();
        addSeats(rows, seats);
    }

    public void addMovie(Movie m) {
        movies.add(m);
    }

    private void addSeats(int rows, int seats) {

        for (int a = 0; a <= rows; a++) {
            List<Seat> seatList = new ArrayList<Seat>();
            for (int j = 0; j <= seats; j++) {
                seatList.add(new Seat(j));
            }
            rowsList.add(seatList);

        }
    }

    @Override
    public String toString() {
        return "Theater{" +
                "movies=" + movies +
                ", rowsList=" + rowsList +
                '}';
    }
}
