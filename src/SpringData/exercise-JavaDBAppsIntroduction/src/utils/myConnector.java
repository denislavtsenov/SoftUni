package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public enum myConnector {
    ;
    private static Connection connection;

    private static final String USERNAME = "root";
    private static final String PASSWORD = "@teslata777!@#";
    private static final String DATABASE_NAME = "minions_db";


    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/";
    private static final String USER_KEY = "user";
    private static final String PASSWORD_KEY = "password";

    private static void createConnection() throws SQLException {
        Properties properties = new Properties();
        properties.setProperty(USER_KEY, USERNAME);
        properties.setProperty(PASSWORD_KEY, PASSWORD);

        connection = DriverManager.getConnection(JDBC_URL + DATABASE_NAME, properties);
    }

    public static Connection getConnection() throws SQLException {
        createConnection();
        return connection;
    }
}
