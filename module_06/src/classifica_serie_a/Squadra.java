package classifica_serie_a;

import java.util.Arrays;
import java.util.Comparator;

public class Squadra implements Comparable<Squadra> {

    private static int count = 1;
    private final int id;
    private String nome;
    private Giocatore[] rosaGiocatori;
    private int punteggio;
    private int golFatti;
    private int golSubiti;

    public Squadra(String nome, Giocatore[] rosaGiocatori) {
        this.id = count++;
        this.nome = nome;
        this.rosaGiocatori = rosaGiocatori;
        this.punteggio = 0;
        this.golFatti = 0;
        this.golSubiti = 0;
    }

    public int getId() { return id; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public Giocatore[] getRosaGiocatori() { return rosaGiocatori; }

    public void setRosaGiocatori(Giocatore[] rosaGiocatori) { this.rosaGiocatori = rosaGiocatori; }

    public int getPunteggio() { return punteggio; }

    public void setPunteggio(int punteggio) { this.punteggio = punteggio; }

    public int getGolFatti() { return golFatti; }

    public void setGolFatti(int golFatti) { this.golFatti = golFatti; }

    public int getGolSubiti() { return golSubiti; }

    public void setGolSubiti(int golSubiti) { this.golSubiti = golSubiti; }

    @Override
    public String toString() {
        return "Squadra {" +
                " \nid=" + id +
                ",\n nome='" + nome + '\'' +
                ",\n rosaGiocatori=" + Arrays.toString(rosaGiocatori) +
                ",\n punteggio=" + punteggio +
                ",\n golFatti=" + golFatti +
                ",\n golSubiti=" + golSubiti +
                "\n}";
    }

    @Override
    public int compareTo(Squadra o) { return nome.compareTo(o.getNome()); }

    // nested class equivalente alla classe top-level SquadraInClassificaComparator
    public static class InClassificaComparator implements Comparator<Squadra> {
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
}
