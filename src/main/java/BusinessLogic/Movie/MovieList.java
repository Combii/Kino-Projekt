package BusinessLogic.Movie;

import Dao.SQLMovie;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by David Stovlbaek
 * 18 March 2017.
 */
public class MovieList {

    List<Movie> movieList;


    public void getMovieListInDatabase(){
        try {
            SQLMovie sqlMovie = new SQLMovie();

            //sqlMovie


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
