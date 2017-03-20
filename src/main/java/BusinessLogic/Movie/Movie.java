package BusinessLogic.Movie;

import java.io.File;

/**
 * Created by BorisGrunwald on 14/03/2017.
 */
public class Movie {

    private String movieName;
    private String ageRestriction;
    private double price;
    private String genre;

    private String picturePath = new File("src/main/Resources/MoviePictures").getAbsolutePath();


    public Movie(String movieName, String genre, String ageRestriction, double price, String picturePath) {
        this.movieName = movieName;
        this.ageRestriction = ageRestriction;
        this.price = price;
        this.genre = genre;
        this.picturePath += "/" + picturePath;
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

    public String getPicturePath() {
        return picturePath;
    }

    //Used for when uploading to DB
    protected void removeAbsolutePath(){
        picturePath = picturePath.substring(picturePath.lastIndexOf('/')+1, picturePath.length());
    }

    @Override
    public String toString() {
        return  "{Movie Name: " + movieName +
                ", AgeRestriction: " + ageRestriction +
                ", Price: " + price +
                ", Genre: " + genre +
                ", PicturePath: " + picturePath + "}";
    }
}
