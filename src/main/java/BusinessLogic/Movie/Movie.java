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

    public String getAgeRestriction() {
        return ageRestriction;
    }

    public double getPrice() {
        return price;
    }

    public String getGenre() {
        return genre;
    }


    @Override
    public String toString() {
        return  "{Movie Name: " + movieName +
                ", AgeRestriction: " + ageRestriction +
                ", Price: " + price +
                ", Genre: " + genre + "}";
    }
}
