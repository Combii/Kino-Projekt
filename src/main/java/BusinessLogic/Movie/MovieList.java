package BusinessLogic.Movie;

import Dao.SQLMovie;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by David Stovlbaek
 * 18 March 2017.
 */
public class MovieList {

    private List<Movie> movieList;

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

    @Override
    public String toString() {
        return movieList.toString();
    }
}
