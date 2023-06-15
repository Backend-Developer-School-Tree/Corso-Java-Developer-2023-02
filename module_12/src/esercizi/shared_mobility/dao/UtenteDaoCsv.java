package esercizi.shared_mobility.dao;

import esercizi.shared_mobility.model.Utente;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UtenteDaoCsv implements Dao<Utente> {

    // si potrebbe implementare singleton per garantire la consistenza

    private final Path csvPath;

    private final Map<Integer, Utente> users = new HashMap<>();

    public UtenteDaoCsv(Path csvPath) throws IOException {
        this.csvPath = csvPath;

        if (!Files.exists(csvPath))
            Files.createFile(csvPath);
        else
            this.users.putAll(Files.lines(csvPath)
                .map(csvRow -> Utente.parseCsv(csvRow))
                .collect(Collectors.toMap(
                        Utente::getId,      // u -> u.getId()
                        Function.identity() // u -> u
                )));
    }

    private boolean updateCsv() throws IOException {
        try (BufferedWriter bw = Files.newBufferedWriter(this.csvPath)) {
            for (Utente u : this.users.values()) {
                bw.write(u.getCsv());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
    public boolean insert(Utente v) throws IOException {
        this.users.put(v.getId(), v);
        return users.get(v.getId()).equals(v) && this.updateCsv();
    }

    @Override
    public boolean update(Utente v) throws IOException {
        users.replace(v.getId(), v);
        return users.get(v.getId()).equals(v) && this.updateCsv();
    }

    @Override
    public boolean delete(int id) throws IOException {
        return users.remove(id) != null && this.updateCsv();
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
