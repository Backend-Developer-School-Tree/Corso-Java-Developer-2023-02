package lampadina_live_coding;

public class Interruttore {

    private Lampadina[] lampadine;

    Interruttore() {}

    Interruttore(Lampadina lampadina) {
        this.lampadine = new Lampadina[]{lampadina};
    }

    Interruttore(Lampadina[] lampadine) {
        this.lampadine = lampadine;
    }

    public void toggle() {
        for (int i = 0; i < this.lampadine.length; i++) {
            this.lampadine[i].aziona();
        }

        /*
        // sintassi analoga con for-each
        for (Lampadina lampadina : this.lampadine) {
            lampadina.aziona();
        }
         */
    }
}
