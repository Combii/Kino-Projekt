package BusinessLogic.Movie;

import Dao.SQLMovie;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by David Stovlbaek
 * 18 March 2017.
 */
public class MovieList {

    private List<Movie> movieList = new ArrayList<>();

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void getMovieListInDatabase(){
        try {

            SQLMovie sqlMovie = new SQLMovie();
            movieList = sqlMovie.getAllMovies();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Movie> getListAfterMovieName(String movieName){
        if(movieName.trim().isEmpty())
            return movieList;

        List<Movie> rMovieList = new ArrayList<>();

        for(Movie movie : movieList){
            try {
                if (movieName.toLowerCase().equals(movie.getMovieName().toLowerCase().substring(0, movieName.length()))) {
                    rMovieList.add(movie);
                }
            }
            catch (Exception ignored){
            }
        }
        return rMovieList;
    }

    public void addMovieToList(String movieName, String genre, String ageRestriction, double price, String picturePath){
        movieList.add(new Movie(movieName, genre, ageRestriction, price, picturePath));
    }

    public void uploadMovieListToDatebase(){
        try {
            SQLMovie sqlMovie = new SQLMovie();

            for (Movie movie : movieList) {
                sqlMovie.addMovie(movie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return movieList.toString();
    }
}
