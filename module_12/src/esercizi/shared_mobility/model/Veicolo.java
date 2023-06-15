package esercizi.shared_mobility.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@Builder
@EqualsAndHashCode
@AllArgsConstructor
public class Veicolo {
    private final int id;
    private PosizioneGeografica posizioneGeografica;
    private double tariffaAlMinuto;
    private boolean cascoRichiesto;
    private boolean noleggiato;
    private Patente patenteRichiesta;
}
