package org.tree.javacourse.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.tree.javacourse.model.User;

public interface Dao {
    boolean insert(User u) throws SQLException;

    boolean update(User u) throws SQLException;

    boolean delete(int id) throws SQLException;

    Optional<User> get(int id) throws SQLException;

    List<User> getAll() throws SQLException;
}
