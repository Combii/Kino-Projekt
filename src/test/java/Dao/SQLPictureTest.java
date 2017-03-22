package Dao;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;


/**
 * Created by David Stovlbaek
 * 21 March 2017.
 */
public class SQLPictureTest {
    @Test
    public void uploadPictureToDB() throws Exception {
        SQLPicture sqlPicture = new SQLPicture();

        sqlPicture.uploadPictureToDB(new File("/Users/Combii/Dropbox/Datamatiker/3. Semester/Agil Aflevering/Kino Aflevering/src/main/Resources/MoviePictures/terminator.jpeg"));
    }

    @Test
    public void getPicture(){
        SQLPicture sqlPicture = new SQLPicture();

        File file = sqlPicture.getPicture("");

        System.out.println(file);
    }

}