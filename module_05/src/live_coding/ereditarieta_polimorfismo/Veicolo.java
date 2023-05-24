package live_coding.ereditarieta_polimorfismo;

import java.util.Objects;

public class Veicolo {
    private String marca;
    private String modello;

    public Veicolo(String marca, String modello) {
        this.marca = marca;
        this.modello = modello;
    }

    public void accelera(){
        System.out.println("Il veicolo sta accelerando..");
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    @Override
    public String toString() {
        return "Veicolo{" +
                "marca='" + marca + '\'' +
                ", modello='" + modello + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        //Sto confrontando la stessa istanza
        if (this == o) return true;

        /*
        * Se non mi stai passando nulla allora torna false
        * Se le classi sono diverse allora torna false
        *
        * nb: getClass() ereditato da Object
        * */
        if (o == null || getClass() != o.getClass()) return false;

        //Cast della mia istanza da Obj a Veicolo
        Veicolo veicolo = (Veicolo) o;

        /*
        * Qui sto confrontando variabile per variabile in modo da controllare se logicamente
        * sono la stessa istanza. Quali parametri considerare? Lo decido io
        * */
        return Objects.equals(marca, veicolo.marca) && Objects.equals(modello, veicolo.modello);
    }

    @Override
    public int hashCode() {
        // Qui posso mettere i parametri che voglio
        return Objects.hash(marca, modello);
    }
}
