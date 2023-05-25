package classifica_serie_a;

import java.util.Arrays;
import java.util.Comparator;

public class TestComparison {

    public static void main(String[] args) {
        Giocatore nicoloZaniolo = new Giocatore("Nicolò", "Zaniolo");
        Giocatore tammyAbraham = new Giocatore("Tammy", "Abraham");
        Squadra roma = new Squadra("A.S. Roma", new Giocatore[]{nicoloZaniolo, tammyAbraham});

        Giocatore luisAlberto = new Giocatore("Luis", "Alberto");
        Giocatore ciroImmobile = new Giocatore("Ciro", "Immobile");
        Squadra lazio = new Squadra("S.S. Lazio", new Giocatore[]{luisAlberto, ciroImmobile});

        Giocatore lautaroMartinez = new Giocatore("Lautaro", "Martinez");
        Giocatore edinDzeko = new Giocatore("Edin", "Dzeko");
        Squadra inter = new Squadra("F.C. Inter", new Giocatore[]{lautaroMartinez, edinDzeko});

        Giocatore leaoMartinez = new Giocatore("Leao", "Martinez");
        Giocatore zlatanIbrahimovic = new Giocatore("Zlatan", "Ibrahimovic");
        Squadra milan = new Squadra("A.C. Milan", new Giocatore[]{leaoMartinez, zlatanIbrahimovic});

        Squadra[] squadre = {roma, lazio, inter, milan};

        ClassificaSerieA classificaSerieA = new ClassificaSerieA(new Squadra[]{roma, lazio, inter, milan});

        classificaSerieA.esitoPartita(roma, 3, lazio, 0);
        classificaSerieA.esitoPartita(milan, 1, inter, 0);

        classificaSerieA.esitoPartita(inter, 2, roma, 3);
        classificaSerieA.esitoPartita(lazio, 2, milan, 2);

        classificaSerieA.esitoPartita(lazio, 3, inter, 2);

        Arrays.sort(squadre);
        System.out.println(Arrays.toString(squadre));

        System.out.println("==========================");

        Arrays.sort(squadre, new SquadraInClassificaComparator());
        System.out.println(Arrays.toString(squadre));

        System.out.println("==========================");

        Arrays.sort(squadre, new Squadra.InClassificaComparator());
        System.out.println(Arrays.toString(squadre));

        System.out.println("==========================");

        Arrays.sort(squadre, new Comparator<Squadra>() {
            @Override
            public int compare(Squadra o1, Squadra o2) {
                return -Integer.compare(o1.getGolFatti(), o2.getGolFatti());
            }});
        System.out.println(Arrays.toString(squadre));

        System.out.println("==========================");

        // I seguenti due modi riguardano argomenti dei prossimi moduli (espressioni lambda e riferimenti a metodo)

        Arrays.sort(squadre, Comparator.comparing((Squadra o) -> -o.getPunteggio())
                .thenComparing((Squadra o) -> -o.getGolFatti())
                .thenComparing((Squadra o) -> -o.getGolSubiti()));
        System.out.println(Arrays.toString(squadre));

        System.out.println("==========================");

        Arrays.sort(squadre, Comparator.comparing(Squadra::getPunteggio)
                .thenComparing(Squadra::getGolFatti)
                .thenComparing(Squadra::getGolSubiti)
                .reversed());
        System.out.println(Arrays.toString(squadre));
    }
}
