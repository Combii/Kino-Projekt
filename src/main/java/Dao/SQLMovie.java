package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by David Stovlbaek
 * 16 March 2017.
 */
public class SQLMovie {

    public void addMovie(String name, String ageRestriction, double price, String genre) {
        try {
            SQLDatabase database = SQLDatabase.getDatabase();
            Connection conn = database.getConnection();

            PreparedStatement ps = conn.prepareStatement("INSERT INTO Movie VALUES ('" + name + "','" + genre + "','" + ageRestriction + "','" + price + "');");

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

}
