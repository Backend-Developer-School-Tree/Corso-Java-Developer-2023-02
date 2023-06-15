package esercizi.shared_mobility.model;

import lombok.*;

import java.time.LocalDate;
import java.util.Arrays;

@Getter
@Builder
@EqualsAndHashCode
@AllArgsConstructor
public class Utente {
    private final Integer id;
    private String nome;
    private String cognome;
    private LocalDate dataNascita;
    /*
    private String codiceFiscale;
    private Patente[] patenti;
    private boolean casco;
    private int credito;
     */

    public String getCsv() {
        return String.join(",", Arrays.asList(id.toString(), nome, cognome, dataNascita.toString()));
    }

    public static Utente parseCsv(String csv) {
        // "1,Mario,Mario,1981-07-09"
        String[] values = csv.split(",");

        Utente.UtenteBuilder ub = Utente.builder();
        ub.id(Integer.parseInt(values[0]));
        ub.nome(values[1]);
        ub.cognome(values[2]);
        ub.dataNascita(LocalDate.parse(values[3]));
        // codiceFiscale ecc...

        return ub.build();
    }
}
