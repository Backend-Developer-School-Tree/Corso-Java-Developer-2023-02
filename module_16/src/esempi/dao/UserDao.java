package esempi.dao;

import java.sql.SQLException;
import java.util.List;

public interface UserDao extends Dao<User> {

    List<User> getByLastName(String lastName) throws SQLException;
}
