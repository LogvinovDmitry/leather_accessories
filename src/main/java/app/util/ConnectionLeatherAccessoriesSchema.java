package app.util;

import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.util.Map;
import java.util.TreeMap;

public class ConnectionLeatherAccessoriesSchema {

    public static final String NAME_USER;
    public static final String PASSWORD;
    public static final String URL;
    private static final Map<String, String> table2sqlfile = new TreeMap<>();

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

        table2sqlfile.put("bag_category", "sql/leather_accessories_schema_bag_category.sql");
        table2sqlfile.put("bag_information", "sql/leather_accessories_schema_bag_information.sql");
        table2sqlfile.put("bag_photo", "sql/leather_accessories_schema_bag_photo.sql");
        table2sqlfile.put("client", "sql/leather_accessories_schema_client.sql");
        table2sqlfile.put("order", "sql/leather_accessories_schema_order.sql");
    }

    private static Connection connection = null;

    public ConnectionLeatherAccessoriesSchema() {
        try {
            if (connection == null) {
                connection = DriverManager.getConnection(URL, NAME_USER, PASSWORD);

                DatabaseMetaData dbm = connection.getMetaData();
                for (Map.Entry<String, String> entry : table2sqlfile.entrySet()) {
                    final String tableName = entry.getKey();

                    try (ResultSet tables = dbm.getTables(null, null, tableName, null)) {

                        if (tables.next()) {
                            System.out.println("Table '" + tableName + "' already exist in database.");
                        } else {
                            // Таблица не существует
                            final String sqlFilePath = entry.getValue();
                            try (final InputStream resource = getClass().getClassLoader().getResourceAsStream(sqlFilePath)) {
                                if (resource == null) {
                                    System.err.println("Can't file sql file ('" + sqlFilePath + "') to create table '" + tableName + "'");
                                    // Не удалось найти sql файл чтоб создать таблицу!
                                } else {
                                    System.out.println("Creating table '" + tableName + "'...");
                                    final String sqlFileContent = IOUtils.toString(resource, StandardCharsets.UTF_8);
                                    final String[] allSql = sqlFileContent.split(";");
                                    for (String oneSql : allSql) {
                                        if (!oneSql.trim().isEmpty()) {
                                            try (final Statement preparedStatement = connection.createStatement()) {
                                                preparedStatement.execute(oneSql + ";");
                                            }
                                        }
                                    }
                                    System.out.println("Table '" + tableName + "' was created.");
                                }
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.err.println("Can't create table '" + tableName + "'!");
                        // Не удалось создать таблицу
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Can't connect to database or get data about tables!");
            // Не удалось подключиться к базе или получить данные о таблицах
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
