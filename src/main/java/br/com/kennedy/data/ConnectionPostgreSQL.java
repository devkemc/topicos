package br.com.kennedy.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPostgreSQL {
    private static volatile Connection instance;

    private ConnectionPostgreSQL() {
    }

    public static Connection getConnection() {
        if (instance == null) {
            synchronized (ConnectionPostgreSQL.class) {
                if (instance == null) {
                    try {
                        Class.forName("org.postgresql.Driver");
                        String url = System.getProperty("DATABASE_URL");
                        String user = System.getProperty("DATABASE_USER");
                        String password = System.getProperty("DATABASE_PASSWORD");
                        Connection connection = DriverManager.getConnection(url, user, password);
                        connection.setAutoCommit(false);
                        return connection;
                    } catch (SQLException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return instance;
    }
}
