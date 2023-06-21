package esempi.dao;

import java.sql.SQLException;
import java.util.List;

public class App {

    public static void main(String[] args) throws SQLException {
        System.out.println("Hello world!");

        UserDao userDao = new UserDaoSQL();

        List<User> users = userDao.getAll();
        for(User u : users){
            System.out.println(u);
        }
    }
}
