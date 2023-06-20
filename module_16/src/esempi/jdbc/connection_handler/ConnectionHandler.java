package esempi.jdbc.connection_handler;


import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionHandler implements AutoCloseable {

    public static final String DB_URL_PREFIX = "jdbc:postgresql://";

    public static final Path propsPath = Paths.get("module_16", "src", "esempi", "jdbc", "configuration", "config.properties");

    private static ConnectionHandler connectionHandlerInstance;

    private Connection connection;

    private Properties dbProperties;

    //Costruttore privato!!
    private ConnectionHandler() {
        try (BufferedReader br = Files.newBufferedReader(propsPath)) {
            dbProperties = new Properties();
            dbProperties.load(br);

            // Per Logging
            System.out.println("Host name: " + dbProperties.getProperty("host"));
            System.out.println("Database name: " + dbProperties.getProperty("dbName"));
            System.out.println("Username: " + dbProperties.getProperty("dbUser"));
            System.out.println("DB Password: " + dbProperties.getProperty("dbPwd"));
            System.out.println("DB Port: " + dbProperties.getProperty("dbPort"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Pattern Singleton
    public static ConnectionHandler getInstance() {
        if (connectionHandlerInstance == null)
            connectionHandlerInstance = new ConnectionHandler();

        return connectionHandlerInstance;
    }

    // Se connessione al db chiusa oppure mai stata aperta, la devo istanziare di nuovo
    public Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(getDatabaseURL(), dbProperties);
        }

        return connection;
    }

    //Metodo di appoggio
    public String getDatabaseURL(){
        return DB_URL_PREFIX +
                dbProperties.getProperty("host") + ":" +
                dbProperties.getProperty("dbPort") + "/" +
                dbProperties.getProperty("dbName");
    }

    @Override
    public void close() throws Exception {
        if(connection != null && !connection.isClosed()){
            connection.close();
            connection = null;
        }
    }

    /*
    * Mi creo un preparedStatement partendo dalla connessione istanziata precedentemente
    * */
    public PreparedStatement getPreparedStatement(String query) throws SQLException {
        Connection connection = getConnection();
        return connection.prepareStatement(query);
    }
}
