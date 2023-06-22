package org.tree.javacourse.service;

import org.tree.javacourse.dao.Dao;
import org.tree.javacourse.dao.UserDaoImpl;
import org.tree.javacourse.model.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UserService {

    Dao daoUser;

    public  UserService(){
        daoUser = new UserDaoImpl();
    }

    public boolean insert(User u) throws SQLException {
        return daoUser.insert(u);
    }

    public boolean update(User u) throws SQLException {
        return daoUser.update(u);
    }

    public boolean delete(int id) throws SQLException {
        return daoUser.delete(id);
    }


    public Optional<User> get(int id) throws SQLException {
        return daoUser.get(id);
    }

    public List<User> getAll() throws SQLException {
        return daoUser.getAll();
    }
}
