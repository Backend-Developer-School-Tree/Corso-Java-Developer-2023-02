package esempi.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Properties;

public class ConnectionHandler  implements AutoCloseable {

    public static final String DB_URL_PREFIX = "jdbc:postgresql://";

    public static final Path propertiesPath = Paths.get("module_16", "src", "esempi", "dao","config.properties");

    private static ConnectionHandler instance;

    private Connection connection;

    private Properties dbProps;

    private ConnectionHandler() {
        try (BufferedReader br = Files.newBufferedReader(propertiesPath))
        {
            this.dbProps = new Properties();
            this.dbProps.load(br);

            System.out.println("Host name: "     + dbProps.getProperty("host") + ":" + dbProps.getProperty("port"));
            System.out.println("Database name: " + dbProps.getProperty("name"));
            System.out.println("DB username: "   + dbProps.getProperty("user"));
            System.out.println("DB password: "   + dbProps.getProperty("password"));
        }
        catch (IOException e) { e.printStackTrace(); }
    }

    public static ConnectionHandler getInstance() {
        if (instance == null)
            instance = new ConnectionHandler();

        return instance;
    }

    public String getDatabaseUrl() {
        return DB_URL_PREFIX +
                dbProps.getProperty("host") +
                ":" + dbProps.getProperty("port") +
                "/" + dbProps.getProperty("name");
    }

    public Connection getConnection() throws SQLException {
        if (this.connection == null || this.connection.isClosed())
            // se la connessione non esiste o è chiusa, ne viene creata una nuova
            this.connection = DriverManager.getConnection(getDatabaseUrl(), dbProps);

        return this.connection;
    }

    @Override
    public void close() throws SQLException { this.closeConnection(); }


    public void closeConnection() throws SQLException {
        if (this.connection != null && !this.connection.isClosed()) {
            this.connection.close();
            this.connection = null;
        }
    }


    public PreparedStatement getPreparedStatement(String query) throws SQLException {
        Connection conn = getConnection();

        return conn.prepareStatement(query);
    }
}
