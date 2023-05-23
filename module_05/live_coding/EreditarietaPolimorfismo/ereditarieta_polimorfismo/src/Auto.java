public class Auto extends Veicolo{
    private int numeroPorte;

    public Auto(String marca, String modello, int numeroPorte) {
        super(marca, modello);

        this.numeroPorte = numeroPorte;
    }

    public void apriPorte(){
        System.out.println("Sto aprendo le porte dell'auto..");
    }

    @Override
    public void accelera(){
        System.out.println("L'auto sta accelerando..");
    }

    public int getNumeroPorte() {
        return numeroPorte;
    }

    public void setNumeroPorte(int numeroPorte) {
        this.numeroPorte = numeroPorte;
    }
}
