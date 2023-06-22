package org.tree.javacourse.dao;

import org.tree.javacourse.model.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements Dao{

    @Override
    public boolean insert(User u) throws SQLException {
        return false;
    }

    @Override
    public boolean update(User u) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public Optional<User> get(int id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public List<User> getAll() throws SQLException {
        return null;
    }
}
