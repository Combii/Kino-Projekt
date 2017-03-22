package BusinessLogic.Movie;

import org.junit.Test;

import java.io.File;

/**
 * Created by David Stovlbaek
 * 18 March 2017.
 */
public class MovieTest {
    @Test
    public void testFilePath() throws Exception {
        System.out.println(new File("src/main/Resources/MoviePictures").getAbsolutePath());
    }

}