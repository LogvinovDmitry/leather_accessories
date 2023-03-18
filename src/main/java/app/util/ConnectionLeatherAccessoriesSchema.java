package app.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionLeatherAccessoriesSchema {

    public static final String NAME_USER;
    public static final String PASSWORD;
    public static final String URL;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Can't load mysql driver: " + e.getMessage());
        }

        final String envDbUrl = System.getenv("DATABASE_URL");
        if (envDbUrl == null) {
            URL = "jdbc:mysql://localhost:3306/leather_accessories_schema"; // Default database url
        } else {
            URL = envDbUrl;
        }

        final String envDbUsr = System.getenv("DATABASE_USER");
        if (envDbUsr == null) {
            NAME_USER = "root"; // Default database user name
        } else {
            NAME_USER = envDbUsr;
        }

        final String envDbPsw = System.getenv("DATABASE_PASSWORD");
        if (envDbPsw == null) {
            PASSWORD = "345680qwer"; // Default database user password
        } else {
            PASSWORD = envDbPsw;
        }
    }

    private Connection connection;

    public ConnectionLeatherAccessoriesSchema() {
        try {
            connection = DriverManager.getConnection(URL, NAME_USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Не удалось подключиться к серверу: " + e.getMessage());
        }
    }

    public Connection getConnection() {
        if (connection == null) {
            System.err.println("Can't connect to database using url: " + URL);
            throw new IllegalStateException("Database is not available!");
        }
        return connection;
    }

}
