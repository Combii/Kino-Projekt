package Dao;

import BusinessLogic.Movie.Movie;

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

            PreparedStatement ps = conn.prepareStatement("INSERT INTO Movie VALUES ('" + toAdd.getMovieName() + "','" + toAdd.getGenre() + "','" + toAdd.getAgeRestriction() + "','" + toAdd.getPrice() + "','" + toAdd.getPicturePath() + "');");
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deleteMovie(String name) throws SQLException {

        PreparedStatement ps = conn.prepareStatement("DELETE FROM Movie WHERE movieName = '" + name + "';");
        ps.executeUpdate();

    }


    // Medmindre at de parametiserede værdier er blevet ændret, så bare sæt de samme værdier ind i tabellen igen
    // Dette ordner vi i logic/GUI
    public void editMovie (String name, String ageRestriction, double price, String genre) throws SQLException {

        ps = conn.prepareStatement("UPDATE Movie\n" +
                "        SET ageRestriction =" + ageRestriction +
                ", price =" + price +
                ", genreName =" + genre +
                "WHERE movieName = name;");
        ResultSet genreName = ps.executeQuery();

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
            ResultSet movie = ps.executeQuery();

            while(movie.next()) {
                movies.add(getMovie(movie));
            }

            return movies;
    }

    public void closeConn() throws SQLException {
        conn.close();
    }

    private Movie getMovie(ResultSet movie) throws SQLException {
        return new Movie(movie.getString(1),movie.getString(2),movie.getString(3),movie.getDouble(4), movie.getString(5));
    }



}
