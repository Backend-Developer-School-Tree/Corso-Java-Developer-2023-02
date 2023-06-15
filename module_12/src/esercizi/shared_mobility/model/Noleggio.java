package esercizi.shared_mobility.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@Builder
@EqualsAndHashCode
@AllArgsConstructor
public class Noleggio {
    private final int id;
    private String data;
    private int durata;
    private int costo;
    private Utente cliente;
    private Veicolo veicolo;
}
