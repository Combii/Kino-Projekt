package Dao;

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


    public void uploadPictureToDB(File file) throws SQLException, FileNotFoundException {
        SQLDatabase database = SQLDatabase.getDatabase();
        Connection conn = database.getConnection();

        String sql = "INSERT INTO Picture (picture) values (?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        InputStream inputStream = new FileInputStream(file);
        statement.setBlob(1, inputStream);

        statement.executeUpdate();

    }


    public File getPicture(String movieName) throws SQLException, FileNotFoundException {

        SQLDatabase database = SQLDatabase.getDatabase();

        ResultSet resultSet = database.query("SELECT picture from Picture where pictureID = 1");

        InputStream binaryStream = resultSet.getBinaryStream(1);

        OutputStream outputStream = new FileOutputStream(new File(""));

        int read = 0;
        byte[] bytes = new byte[1024];

        while ((read = inputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, read);
        }

        return null;

    }

    private boolean checkIfFileExist(String path){
    return false;
    }
}
