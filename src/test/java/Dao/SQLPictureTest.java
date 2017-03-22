package Dao;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;

import static org.junit.Assert.*;

/**
 * Created by David Stovlbaek
 * 21 March 2017.
 */
public class SQLPictureTest {
    @Test
    public void uploadPictureToDB() throws Exception {
        SQLPicture sqlPicture = new SQLPicture();

        sqlPicture.uploadPictureToDB(new File("/Users/Combii/Dropbox/Datamatiker/3. Semester/Agil Aflevering/Kino Aflevering/src/main/Resources/MoviePictures/theGrey.jpg"));
    }

    @Test
    public void getPicture() throws SQLException, FileNotFoundException {
        SQLPicture sqlPicture = new SQLPicture();

        File file = sqlPicture.getPicture("");

        System.out.println(file);
    }

}