package Dao;

import org.apache.commons.io.IOUtils;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by David Stovlbaek
 * 21 March 2017.
 */
public class SQLPicture {

    /**
     * This Class is saving a picture for a movie to the online Database
     */


    protected static void uploadPictureToDB(File file) throws SQLException, FileNotFoundException {
        SQLDatabase database = SQLDatabase.getDatabase();
        Connection conn = database.getConnection();

        String sql = "INSERT INTO Picture (pictureName, picture) values (?, ?)";
        PreparedStatement statement = conn.prepareStatement(sql);

        statement.setString(1, file.getName());


        InputStream inputStream = new FileInputStream(file);
        statement.setBlob(2, inputStream);

        statement.executeUpdate();
    }


     protected static File getPicture(String movieNameFile) {
        try {
            SQLDatabase database = SQLDatabase.getDatabase();
            ResultSet resultSet = database.query("SELECT * from Picture where pictureName = '"+ movieNameFile +"'");
            resultSet.next();
            String fileName = new File("src/main/Resources/MoviePictures").getAbsolutePath() + "/" + resultSet.getString(1);

            File file = new File(fileName);


            if(!file.exists()) {
                InputStream inputStream = resultSet.getBinaryStream(2);
                OutputStream outputStream = new FileOutputStream(file);

                //Using library to extract from input to output
                IOUtils.copy(inputStream, outputStream);
            }

            return file;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
