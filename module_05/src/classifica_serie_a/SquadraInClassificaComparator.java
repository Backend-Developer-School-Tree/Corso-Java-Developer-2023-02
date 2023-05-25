package classifica_serie_a;

import java.util.Comparator;

public class SquadraInClassificaComparator implements Comparator<Squadra> {
    @Override
    public int compare(Squadra o1, Squadra o2) {
        int comparisonPunteggio = -Integer.compare(o1.getPunteggio(), o2.getPunteggio());

        if (comparisonPunteggio == 0) {
            // confrontiamo i gol fatti solamente quando le due squadre hanno lo stesso punteggio (confronto uguale a 0)
            int comparisonGolFatti = -Integer.compare(o1.getGolFatti(), o2.getGolFatti());

            if (comparisonGolFatti == 0)
                // confrontiamo i gol subito solamente a parità di gol fatti e di punteggio
                return -Integer.compare(o1.getGolSubiti(), o2.getGolSubiti());
            else
                return comparisonGolFatti;
        }

        return comparisonPunteggio;
    }
}
