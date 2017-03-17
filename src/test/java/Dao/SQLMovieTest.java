package Dao;

import BusinessLogic.Movie;
import org.junit.Test;

/**
 * Created by BorisGrunwald on 16/03/2017.
 */
public class SQLMovieTest {


    @Test
    public void testAddMovie() {

        SQLMovie movieAdder = new SQLMovie();
        movieAdder.addMovie(new Movie("adaee","+12",23.3,"action"));

    }



}
