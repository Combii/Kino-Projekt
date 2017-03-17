package Dao;

import BusinessLogic.Movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by David Stovlbaek
 * 16 March 2017.
 */
public class SQLMovie {

    public void addMovie(Movie toAdd) {
        try {
            SQLDatabase database = SQLDatabase.getDatabase();
            Connection conn = database.getConnection();

            PreparedStatement ps = conn.prepareStatement("INSERT INTO Movie VALUES ('" + toAdd.getName() + "','" + toAdd.getGenre() + "','" + toAdd.getAgeRestriction() + "','" + toAdd.getPrice() + "');");

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deleteMovie(String name) throws SQLException {

        SQLDatabase database = SQLDatabase.getDatabase();
        Connection conn = database.getConnection();

        PreparedStatement ps = conn.prepareStatement("DELETE FROM Movie WHERE movieName = '" + name + "';");

    }

    public void getMovie(Movie m) {



    }

}
