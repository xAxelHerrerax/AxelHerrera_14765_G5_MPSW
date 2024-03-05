package ec.edu.espe.deinglogin.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteDataConnect {

    private static Connection connection;
    
    public SQLiteDataConnect() {
        try {
            // Establece la conexión con la base de datos SQLite
            connection = DriverManager.getConnection("jdbc:sqlite:database/database.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public SQLiteDataConnect(String dbName) {
        connect();
    }

    public void connect() {
        try {
            String url = "jdbc:sqlite:database/database.db";
            connection = DriverManager.getConnection(url);
            System.out.println("Connected to SQLite database");
        } catch (SQLException e) {
            System.err.println("Error connecting to SQLite database: " + e.getMessage());
        }
    }
    
    public Connection connectr() {
    Connection connection = null;
    try {
        String url = "jdbc:sqlite:database/database.db";
        connection = DriverManager.getConnection(url);
        System.out.println("Connected to SQLite database");
    } catch (SQLException e) {
        System.err.println("Error connecting to SQLite database: " + e.getMessage());
    }
    return connection;
}
    
    public static Connection getConnection() throws SQLException {
        // Implementación del método getConnection()
        return connection;
    }

    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Closed SQLite database connection");
            }
        } catch (SQLException e) {
            System.err.println("Error closing SQLite database connection: " + e.getMessage());
        }
    }
    
    public void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Closed SQLite database connection");
            }
        } catch (SQLException e) {
            System.err.println("Error closing SQLite database connection: " + e.getMessage());
        }
    }
}
