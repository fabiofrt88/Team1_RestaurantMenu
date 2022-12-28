package it.team1Restaurant.jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.sql.*;

public abstract class DriverJDBC {

    private static final String url;
    private static final String user;
    private static final String password;

    static {
        Properties pros = getProperties("db.properties");
        // assign db parameters
        url = pros.getProperty("DB_URL");
        user = pros.getProperty("USER");
        password = pros.getProperty("PASSWORD");
    }

    public static Properties getProperties(String filename) {

        Properties pros = new Properties();
        try (FileInputStream f = new FileInputStream(filename)) {
            // load the properties file
            pros.load(f);

        } catch (IOException e) {
            System.out.println(e.getMessage() + "\n");
        }
        return pros;

    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

}
