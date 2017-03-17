package Dao;

import BusinessLogic.Movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

            PreparedStatement ps = conn.prepareStatement("INSERT INTO Movie VALUES ('" + toAdd.getName() + "','" + toAdd.getGenre() + "','" + toAdd.getAgeRestriction() + "','" + toAdd.getPrice() + "');");
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deleteMovie(String name) throws SQLException {

        PreparedStatement ps = conn.prepareStatement("DELETE FROM Movie WHERE movieName = '" + name + "';");
        ps.executeUpdate();

    }

    public void updateMovie()

    public Movie getMovie(String name) {

        try {

            ps = conn.prepareStatement("SELECT FROM Movie WHERE movieName = '" + name + "';");
            ResultSet movie = ps.executeQuery();
            return getMovie(movie);

        } catch (SQLException e) {
            return null;
        }

    }

    public List<Movie> getAllMovies(String genre) throws SQLException {

            List<Movie> movies = new LinkedList<>();

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
        return new Movie(movie.getString(0),movie.getString(2),movie.getDouble(4),movie.getString(1));
    }

}
