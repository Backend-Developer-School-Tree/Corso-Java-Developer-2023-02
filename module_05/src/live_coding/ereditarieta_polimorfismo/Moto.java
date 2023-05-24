package live_coding.ereditarieta_polimorfismo;

public class Moto extends Veicolo {
    private int cilindrata;



    public Moto(String marca, String modello, int cilindrata) {
        super(marca, modello); //chiamata al costruttore della superclasse (Veicolo)

        // Posso aggiungere quello che voglio
        this.cilindrata = cilindrata;
    }

    public void avviaMoto(){
        System.out.println("Sto avviando la moto..");
    }

    public int getCilindrata() {
        return cilindrata;
    }

    public void setCilindrata(int cilindrata) {
        this.cilindrata = cilindrata;
    }

    @Override
    public String toString() {
        //super.toString();
        return "Moto{" +
                "cilindrata=" + cilindrata +
                '}';
    }
}
