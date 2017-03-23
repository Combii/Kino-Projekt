package BusinessLogic.Schedule;

/**
 * Created by David Stovlbaek
 * 21 March 2017.
 */
public class Schedule {

    private String movie;
    private int theaterType;
    private String date;


    public Schedule(String movie, int theaterType, String date) {
        this.movie = movie;
        this.theaterType = theaterType;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "movie='" + movie + '\'' +
                ", theaterType=" + theaterType +
                ", date='" + date + '\'' +
                '}';
    }
}
