package Dao;

import BusinessLogic.Movie.Movie;
import org.junit.Test;

import java.sql.SQLException;

/**
 * Created by BorisGrunwald on 16/03/2017.
 */
public class SQLMovieTest {


    @Test
    public void testAddMovie() throws SQLException {

        SQLMovie movieAdder = new SQLMovie();
        movieAdder.addMovie(new Movie("adaee","action", "12+", 50));

    }



}
