package esempi.dao;

import java.nio.file.Paths;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        UserDao userDao = new UserDaoCsv(Paths.get("module_10", "src", "esempi", "dao", "users.csv"));

        userDao.insert(new User(1,"Andrea", "Rossi", LocalDate.of(2023, 2, 28)));
        userDao.insert(new User(2,"Luca", "Verdi", LocalDate.of(2023, 2, 27)));

        System.out.println(userDao.getAll());

        System.out.println(userDao.get(1));
        userDao.update(new User(1,"Giovanni", "Rossi", LocalDate.of(2023, 2, 28)));
        System.out.println(userDao.get(1));

        System.out.println(userDao.get(1));
        userDao.delete(1);
        System.out.println(userDao.get(1));

        System.out.println(userDao.getAll());
    }
    
}
