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
    private String pictureFileName;


    public Movie(String movieName, String genre, String ageRestriction, double price, String pictureName) {
        this.movieName = movieName;
        this.ageRestriction = ageRestriction;
        this.price = price;
        this.genre = genre;
        this.picturePath += "/" + pictureName;
        removeAbsolutePath();
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

    public String getPictureFileName() {
        return pictureFileName;
    }

    //Used for when uploading to DB
    private void removeAbsolutePath(){
        pictureFileName = picturePath.substring(picturePath.lastIndexOf('/')+1, picturePath.length());
    }

    @Override
    public String toString() {
        return  "{Movie Name: " + movieName +
                ", AgeRestriction: " + ageRestriction +
                ", Price: " + price +
                ", Genre: " + genre +
                ", PicturePath: " + pictureFileName + "}";
    }
}
