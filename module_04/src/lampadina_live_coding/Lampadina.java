package lampadina_live_coding;

public class Lampadina {

    private static boolean corrente = true;

    private StatoLampadina statoSenzaCorrente;
    private StatoLampadina stato = StatoLampadina.SPENTA;
    private int maxUtilizzi = 5;
    private int countUtilizzi = 0;

    Lampadina() {}

    Lampadina(int maxUtilizzi) {
        this.maxUtilizzi = maxUtilizzi;
    }

    public StatoLampadina getStato() { return stato; }

    public void toggleCorrente() {
        corrente = !corrente;

        if (!corrente) {
            if (stato != StatoLampadina.ROTTA) {
                statoSenzaCorrente = stato;
                stato = StatoLampadina.SPENTA;
            }
        }
        else {
            stato = statoSenzaCorrente;
        }
    }

    public void aziona() {

        if (++countUtilizzi > maxUtilizzi)
            stato = StatoLampadina.ROTTA;
        else {
            // l'operatore ternario può essere più leggibile rispetto ad un if su 4 righe se condizione e valori sono "piccoli"
            // stato = stato == StatoLampadina.ACCESA ? StatoLampadina.SPENTA : StatoLampadina.ACCESA;

            if (stato == StatoLampadina.ACCESA)
                stato = StatoLampadina.SPENTA;
            else if (corrente)
                stato = StatoLampadina.ACCESA;
        }
    }

    public static void main(String[] args) {
        Lampadina lampadina = new Lampadina();
        System.out.println(lampadina.getStato()); // spenta
        lampadina.aziona();
        System.out.println(lampadina.getStato()); // accesa
        lampadina.toggleCorrente();
        System.out.println(lampadina.getStato()); // spenta
        lampadina.aziona();
        System.out.println(lampadina.getStato()); // spenta (non c'è corrente, non si può accendere)
        lampadina.toggleCorrente();
        System.out.println(lampadina.getStato()); // accesa
    }
}
