package esercizi.shared_mobility.dao;

import java.io.IOException;
import java.util.Collection;
import java.util.Optional;

public interface Dao<T> {
    boolean insert(T v) throws IOException;
    boolean update(T v) throws IOException;
    boolean delete(int id) throws IOException;
    Optional<T> get(int id);
    Collection<T> getAll();
}
