package repository;

import Exceptions.ConnectionException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSingelton {

    private static Connection connection;

    private ConnectionSingelton() {
    }

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test", "postgres", "Slon1939net");
            }
        } catch (SQLException e) {
            throw new ConnectionException(e.getMessage());
        }
        return connection;
    }
}
