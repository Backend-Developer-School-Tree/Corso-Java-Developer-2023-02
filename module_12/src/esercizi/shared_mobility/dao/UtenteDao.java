package esercizi.shared_mobility.dao;

import esercizi.shared_mobility.model.Utente;

import java.util.*;

public class UtenteDao implements Dao<Utente> {

    // si potrebbe implementare singleton per garantire la consistenza

    private Map<Integer, Utente> users = new HashMap<>();

    @Override
    public boolean insert(Utente v) {
        users.put(v.getId(), v);
        return users.get(v.getId()).equals(v);
    }

    @Override
    public boolean update(Utente v) {
        users.replace(v.getId(), v);
        return users.get(v.getId()).equals(v);
    }

    @Override
    public boolean delete(int id) {
        return users.remove(id) != null;
    }

    @Override
    public Optional<Utente> get(int id) {
        return Optional.ofNullable(users.get(id));
    }

    @Override
    public Collection<Utente> getAll() {
        return users.values();
    }
}
