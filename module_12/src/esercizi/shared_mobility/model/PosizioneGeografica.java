package esercizi.shared_mobility.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@Builder
@EqualsAndHashCode
@AllArgsConstructor
public class PosizioneGeografica {
    private double latitudine;
    private double longitudine;
}
