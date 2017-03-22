package Dao;

import BusinessLogic.Movie.Movie;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by David Stovlbaek
 * 16 March 2017.
 */
public class SQLMovie {

    private SQLDatabase database = SQLDatabase.getDatabase();
    private Connection conn = database.getConnection();
    private PreparedStatement ps;

    public SQLMovie() throws SQLException {
    }

    public void addMovie(Movie toAdd) {
        try {
            /**
             * The programmer reading this is welcome to refactor this to make it more reusable friendly ;)
             */
            ps = conn.prepareStatement("SELECT count(1) FROM Genre WHERE genreName = '"+ toAdd.getGenre() + "';");
            ResultSet genreName = ps.executeQuery();
            //If zero doesn't exist. If one it does exist
            genreName.next();
            int check = genreName.getInt(1);
            if(check == 0){
                PreparedStatement ps = conn.prepareStatement("INSERT INTO Genre VALUES ('" + toAdd.getGenre() + "');");
                ps.executeUpdate();
            }

            ps = conn.prepareStatement("SELECT count(1) FROM AgeRestriction WHERE restriction = '"+ toAdd.getAgeRestriction() + "';");
            ResultSet ageRestriction = ps.executeQuery();
            //If zero doesn't exist. If one it does exist
            ageRestriction.next();
            check = ageRestriction.getInt(1);
            if(check == 0){
                PreparedStatement ps = conn.prepareStatement("INSERT INTO AgeRestriction VALUES ('" + toAdd.getAgeRestriction() + "');");
                ps.executeUpdate();
            }

            ps = conn.prepareStatement("SELECT count(1) FROM Picture WHERE pictureName = '"+ toAdd.getPicturePath() + "';");
            ResultSet picturePath = ps.executeQuery();
            //If zero doesn't exist. If one it does exist
            picturePath.next();
            check = picturePath.getInt(1);
            if(check == 0){
            uploadPictureToDB(new File(toAdd.getPicturePath()));
            }

            PreparedStatement ps = conn.prepareStatement("INSERT INTO Movie VALUES ('" + toAdd.getMovieName() + "','" + toAdd.getGenre() + "','" + toAdd.getAgeRestriction() + "','" + toAdd.getPrice() + "','" + toAdd.getPictureFileName() + "');");
            ps.executeUpdate();

        } catch (SQLException | FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    static void uploadPictureToDB(File file) throws SQLException, FileNotFoundException {
        SQLDatabase database = SQLDatabase.getDatabase();
        Connection conn = database.getConnection();

        String sql = "INSERT INTO Picture (pictureName, picture) values (?, ?)";
        PreparedStatement statement = conn.prepareStatement(sql);

        statement.setString(1, file.getName());


        InputStream inputStream = new FileInputStream(file);
        statement.setBlob(2, inputStream);

        statement.executeUpdate();
    }

    public List<Movie> getAllMovies() throws SQLException {

            List<Movie> movies = new ArrayList<>();

            ps = conn.prepareStatement("SELECT * FROM Movie;");
            ResultSet movieRs = ps.executeQuery();

            while(movieRs.next()) {
                movies.add(getMovie(movieRs));
            }

            //Needed if missing picture locally
            for (Movie movie : movies){
                getPicture(movie.getPictureFileName());
            }

            return movies;
    }

    private Movie getMovie(ResultSet movie) throws SQLException {
        return new Movie(movie.getString(1),movie.getString(2),movie.getString(3),movie.getDouble(4), movie.getString(5));
    }

    File getPicture(String movieNameFile) {
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



    public void deleteMovie(String name) throws SQLException {

        PreparedStatement ps = conn.prepareStatement("DELETE FROM Movie WHERE movieName = '" + name + "';");
        ps.executeUpdate();

    }

    public Movie getMovie(String name) {

        try {
            ps = conn.prepareStatement("SELECT FROM Movie WHERE movieName = '" + name + "';");
            ResultSet movie = ps.executeQuery();
            return getMovie(movie);

        } catch (SQLException e) {
            return null;
        }

    }

}
