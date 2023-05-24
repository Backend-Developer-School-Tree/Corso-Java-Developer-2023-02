package classifica_serie_a;

import java.util.Arrays;
import java.util.Comparator;

public class ClassificaSerieA {

    private static final int VALORE_VITTORIA = 3;
    private static final int VALORE_PAREGGIO = 1;

    private Squadra[] classifica;

    public ClassificaSerieA(Squadra[] classifica) {
        this.classifica = classifica;
        sortClassifica();
    }

    private void sortClassifica() {
        Arrays.sort(this.classifica, Comparator.comparingInt(Squadra::getPunteggio)
                .thenComparing(Squadra::getGolFatti)
                .thenComparing(Squadra::getId).reversed());
    }

    public Squadra[] getClassifica() {
        return classifica;
    }

    public void setClassifica(Squadra[] classifica) {
        this.classifica = classifica;
    }

    public void esitoPartita(Squadra squadraCasa, int golCasa, Squadra squadraOspite, int golOspite) {
        if (golCasa > golOspite)
            squadraCasa.setPunteggio(squadraCasa.getPunteggio() + VALORE_VITTORIA);
        else if (golCasa < golOspite)
            squadraOspite.setPunteggio(squadraOspite.getPunteggio() + VALORE_VITTORIA);
        else {
            squadraCasa.setPunteggio(squadraCasa.getPunteggio() + VALORE_PAREGGIO);
            squadraOspite.setPunteggio(squadraOspite.getPunteggio() + VALORE_PAREGGIO);
        }

        squadraCasa.setGolFatti(squadraCasa.getGolFatti() + golCasa);
        squadraOspite.setGolFatti(squadraOspite.getGolFatti() + golOspite);

        squadraCasa.setGolSubiti(squadraCasa.getGolSubiti() + golOspite);
        squadraOspite.setGolSubiti(squadraOspite.getGolSubiti() + golCasa);

        sortClassifica();
    }

    public Squadra getMigliorAttacco() {
        Squadra squadraMigliorAttacco = null;

        for (Squadra squadra : this.classifica)
            if (squadraMigliorAttacco == null || squadra.getGolFatti() > squadraMigliorAttacco.getGolFatti())
                squadraMigliorAttacco = squadra;

        return squadraMigliorAttacco;
    }

    public Squadra getPeggiorDifesa() {
        Squadra squadraPeggiorDifesa = null;

        for (Squadra squadra : this.classifica)
            if (squadraPeggiorDifesa == null || squadra.getGolSubiti() > squadraPeggiorDifesa.getGolSubiti())
                squadraPeggiorDifesa = squadra;

        return squadraPeggiorDifesa;
    }

    @Override
    public String toString() {
        String output = "\nCLASSIFICA SERIE A:\n\nSquadra\t\tP\tGF\tGS\n";

        for (int i = 0; i < classifica.length; i++) {
            output += classifica[i].getNome() + "\t" +
                    classifica[i].getPunteggio() + "\t" +
                    classifica[i].getGolFatti() + "\t" +
                    classifica[i].getGolSubiti() + "\n";
        }

        return output;
    }
}
