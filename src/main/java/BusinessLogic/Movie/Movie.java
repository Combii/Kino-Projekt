package BusinessLogic.Movie;

/**
 * Created by BorisGrunwald on 14/03/2017.
 */
public class Movie {

    private String movieName;
    private String ageRestriction;
    private double price;
    private String genre;

    public Movie(String movieName, String genre, String ageRestriction, double price) {
        this.movieName = movieName;
        this.ageRestriction = ageRestriction;
        this.price = price;
        this.genre = genre;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getAgeRestriction() {
        return ageRestriction;
    }

    public void setAgeRestriction(String ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
