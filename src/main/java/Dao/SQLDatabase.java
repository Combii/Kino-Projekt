package Dao;

import java.sql.*;

public class SQLDatabase implements SQLDatabaseInterface {

    private static String url = "jdbc:mysql://sql7.freemysqlhosting.net:3306/";
    private static String dbName = "sql7163805";
    private static String userName = "sql7163805";
    private static String password = "wiX3QSmZ1A";

    private static SQLDatabase database = null;
    private static Connection connection = null;
    private static Statement statement;


    //private constructor to avoid client applications to use constructor
    private SQLDatabase() {
        try {
            connection = DriverManager.getConnection(url + dbName, userName, password);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static SQLDatabase getDatabase() throws SQLException {
        if(database == null){
            database = new SQLDatabase();
        }
        return database;
    }

    public void startConnection() throws SQLException {
        if(connection == null){
            connection = DriverManager.getConnection(url+dbName,userName,password);
        }
    }

    public void closeConnection() throws SQLException {
        connection.close();
        connection = null;
    }

    public Connection getConnection() throws SQLException {
        if(connection == null){
            connection = DriverManager.getConnection(url+dbName,userName,password);
        }
        return connection;
    }

    public ResultSet query(String query) throws SQLException {
        statement = SQLDatabase.connection.createStatement();
        ResultSet res = statement.executeQuery(query);
        return res;
    }

    // method for Data Manipulation (DML)
    public void queryUpdate(String query) throws SQLException {
        statement = SQLDatabase.connection.createStatement();
        statement.executeUpdate(query);
    }
}
