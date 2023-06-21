package esempi.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDaoSQL implements UserDao {

    @Override
    public boolean insert(User user) throws SQLException {
        String query = "INSERT INTO siteusers (name, lastname, birthdate) VALUES (?, ?, ?);";

        try (ConnectionHandler ch = ConnectionHandler.getInstance();
             PreparedStatement ps = ch.getPreparedStatement(query))
        {
            ps.setString(1, user.getName());
            ps.setString(2, user.getLastName());
            ps.setDate(3, Date.valueOf(user.getBirthDate()));
            int insertedCount = ps.executeUpdate();

            return insertedCount > 0;
        }
    }

    @Override
    public boolean update(User user) throws SQLException {
        String query = "UPDATE siteusers SET name = ?, lastname = ? WHERE id = ?;";

        try (ConnectionHandler ch = ConnectionHandler.getInstance();
             PreparedStatement ps = ch.getPreparedStatement(query))
        {
            ps.setString(1, user.getName());
            ps.setString(2, user.getLastName());
            ps.setInt(3, user.getId());
            int updatedCount = ps.executeUpdate();
            return updatedCount > 0;
        }
    }

    @Override
    public boolean delete(int id) throws SQLException {
        String query = "DELETE FROM siteusers WHERE id = ?;";

        try (ConnectionHandler ch = ConnectionHandler.getInstance();
             PreparedStatement ps = ch.getPreparedStatement(query))
        {
            ps.setInt(1, id);
            int deletedCount = ps.executeUpdate();
            return deletedCount > 0;
        }
    }

    @Override
    public Optional<User> get(int id) throws SQLException {
        String query = "SELECT * FROM siteusers WHERE id = ?;";

        Optional<User> user = Optional.empty();

        try (ConnectionHandler ch = ConnectionHandler.getInstance();
             PreparedStatement ps = ch.getPreparedStatement(query))
        {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) user = Optional.of(User.fromResultSet(rs));
        }

        return user;
    }

    @Override
    public List<User> getByLastName(String lastName) throws SQLException {
        String query = "SELECT * FROM siteusers WHERE lastname = ?;";

        List<User> users = new ArrayList<>();

        try (ConnectionHandler ch = ConnectionHandler.getInstance();
             PreparedStatement ps = ch.getPreparedStatement(query))
        {
            ps.setString(1, lastName);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) users.add(User.fromResultSet(rs));
        }

        return users;
    }


    @Override
    public List<User> getAll() throws SQLException {
        String query = "SELECT * FROM siteusers;";

        List<User> users = new ArrayList<>();

        try (ConnectionHandler ch = ConnectionHandler.getInstance();
             PreparedStatement ps = ch.getPreparedStatement(query);
             ResultSet rs = ps.executeQuery())
        {
            while (rs.next()) users.add(User.fromResultSet(rs));
        }

        return users;
    }

}
