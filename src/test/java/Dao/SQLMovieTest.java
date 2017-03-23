package Dao;

import org.junit.Test;

import java.io.File;
import java.sql.SQLException;

/**
 * Created by BorisGrunwald on 16/03/2017.
 */
public class SQLMovieTest {


    @Test
    public void uploadPictureToDB() throws Exception {
        SQLMovie sqlPicture = new SQLMovie();

        SQLMovie.uploadPictureToDB(new File("/Users/Combii/Dropbox/Datamatiker/3. Semester/Agil Aflevering/Kino Aflevering/src/main/Resources/MoviePictures/terminator.jpeg"));
    }

    @Test
    public void getPicture() throws SQLException {
        SQLMovie sqlPicture = new SQLMovie();

        File file = sqlPicture.getPicture("shrek.jpg");

        System.out.println(file);
    }

    public void testEditMovie() throws SQLException {



    }


}
