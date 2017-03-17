package Dao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by David Stovlbaek
 * 16 March 2017.
 */


public interface SQLDatabaseInterface {
    Connection getConnection() throws SQLException;
}
