package BusinessLogic.Movie;

import org.junit.Test;

/**
 * Created by David Stovlbaek
 * 18 March 2017.
 */
public class MovieListTest {
    @Test
    public void getMovieListInDatabase() throws Exception {
        MovieList movieList = new MovieList();

        movieList.getMovieListInDatabase();

        System.out.println(movieList);
    }

}