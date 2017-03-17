package BusinessLogic;

/**
 * Created by BorisGrunwald on 14/03/2017.
 */
public class Movie {

    private String name;
    private String ageRestriction;
    private double price;
    private String genre;

    public Movie(String name, String ageRestriction, double price, String genre) {
        this.name = name;
        this.ageRestriction = ageRestriction;
        this.price = price;
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
