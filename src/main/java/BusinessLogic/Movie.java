package BusinessLogic;

/**
 * Created by BorisGrunwald on 14/03/2017.
 */
public class Movie {

    private String name;
    private int ageRestriction;
    private double price;
    private String genre;

    public Movie(String name, int ageRestriction, double price, String genre) {
        this.name = name;
        this.ageRestriction = ageRestriction;
        this.price = price;
        this.genre = genre;
    }
}
