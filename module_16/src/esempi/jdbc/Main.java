package esempi.jdbc;

import esempi.jdbc.connection_handler.ConnectionHandler;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        System.out.println("**** SYSTEM STARTUP ****");
        String databaseDriver = "org.postgresql.Driver";

        /*
        * TODO: Refactor del codice utilizzando il ConnectionHandler!
        * */

        // 1. Carico il driver
        Connection conn;
        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/myfancycompany" +
                                                                             "?user=postgres" +
                                                                             "&password=postgres");


        // 2. Carico il driver (non più necessario nelle nuove versioni
        Class.forName(databaseDriver);


        // 3. Creo oggetto PreparedStatement, passando come parametro il template della Query
        PreparedStatement ps_all_impiegati = conn.prepareStatement("select id, nome from impiegati");


        // TODO: Con un model disponibile mi andrei a creare l'oggetto Java (dipendente.setId(...),)
        // TODO: fattorizzare il metodo di lettura di un dipendente con un metodo ausiliario
        ResultSet rs = ps_all_impiegati.executeQuery();
        while (rs.next()) {
            System.out.print(rs.getInt("id"));
            System.out.print(" - ");
            System.out.println(rs.getString("nome"));
        }

        // PS per modificare un dato (DML!)
        String queryAggiornaDipendente = "UPDATE impiegati SET nome=? WHERE id=?";
        PreparedStatement ps_aggiorna_dipendente = conn.prepareStatement(queryAggiornaDipendente);
        ps_aggiorna_dipendente.setString(1, "Test Aggiorna Java");
        ps_aggiorna_dipendente.setInt(2, 1);
        ps_aggiorna_dipendente.executeUpdate();
        ps_aggiorna_dipendente.close();

        // Rilascio tutte le risorse aperte.
        conn.close();
        ps_all_impiegati.close();
        rs.close();
    }
}