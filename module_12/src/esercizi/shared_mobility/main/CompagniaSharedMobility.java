package esercizi.shared_mobility.main;

import esercizi.shared_mobility.dao.Dao;
import esercizi.shared_mobility.dao.UtenteDao;
import esercizi.shared_mobility.model.Noleggio;
import esercizi.shared_mobility.model.Utente;
import esercizi.shared_mobility.model.Veicolo;

import java.io.IOException;

public class CompagniaSharedMobility {
    private final Dao<Utente> utenteDao;
    private final Dao<Veicolo> veicoloDao;
    private final Dao<Noleggio> noleggioDao;

    // preferiamo la dependency-injection piuttosto che inizializzare noi le classi DAO
    public CompagniaSharedMobility(Dao<Utente> utenteDao, Dao<Veicolo> veicoloDao, Dao<Noleggio> noleggioDao) {
        this.utenteDao = utenteDao;
        this.veicoloDao = veicoloDao;
        this.noleggioDao = noleggioDao;
    }

    public void addUser(Utente u) throws IOException {
        utenteDao.insert(u);
    }

    // altre funzionalità richieste ...

    public static void main(String[] args) throws IOException {
        /*
        new CompagniaSharedMobility(
                new UtenteDao(),
                new VeicoloDao(),
                new NoleggioDao()
        );
         */
    }
}
