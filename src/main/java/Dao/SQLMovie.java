package Dao;

import BusinessLogic.Movie.Movie;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by David Stovlbaek
 * 16 March 2017.
 */
public class SQLMovie {

    SQLDatabase database = SQLDatabase.getDatabase();
    Connection conn = database.getConnection();
    PreparedStatement ps;

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
            SQLPicture.uploadPictureToDB(new File(toAdd.getPicturePath()));
            }

            PreparedStatement ps = conn.prepareStatement("INSERT INTO Movie VALUES ('" + toAdd.getMovieName() + "','" + toAdd.getGenre() + "','" + toAdd.getAgeRestriction() + "','" + toAdd.getPrice() + "','" + toAdd.getPictureFileName() + "');");
            ps.executeUpdate();

        } catch (SQLException | FileNotFoundException e) {
            e.printStackTrace();
        }

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

    public List<Movie> getAllMovies() throws SQLException {

            List<Movie> movies = new ArrayList<>();

            ps = conn.prepareStatement("SELECT * FROM Movie;");
            ResultSet movieRs = ps.executeQuery();

            while(movieRs.next()) {
                movies.add(getMovie(movieRs));
            }
            
            //Needed if missing picture locally
            for (Movie movie : movies){
                SQLPicture.getPicture(movie.getPictureFileName());
            }

            return movies;
    }

    private Movie getMovie(ResultSet movie) throws SQLException {
        return new Movie(movie.getString(1),movie.getString(2),movie.getString(3),movie.getDouble(4), movie.getString(5));
    }

}
