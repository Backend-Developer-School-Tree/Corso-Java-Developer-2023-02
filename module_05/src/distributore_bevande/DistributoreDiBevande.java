package distributore_bevande;

public class DistributoreDiBevande {

    private Prodotto[] prodotti;
    private double importoAttuale;

    public DistributoreDiBevande(int capienza) {
        prodotti = new Prodotto[capienza];
        importoAttuale = 0.0; //ricorda i valori default
    }

    public void caricaProdotto(Prodotto prodotto) {
        for (int i = 0; i < prodotti.length; i++) {
            if (prodotti[i] == null) {
                prodotti[i] = prodotto;
                break; //Se dimentichi il break riempio l'array solo con il primo elemento :)
            }
        }
    }

    public void inserisciImporto(double importo) {
        importoAttuale += importo;
    }

    public Prodotto scegliProdotto(String codice) {
        Prodotto prodotto = null;

        for(int i=0; i< prodotti.length; i++){

            // Posso avere le 3 condizioni insieme in cascata ma perdo precisione se devo stampare messaggi di errore (es importo non sufficiente)
            if(prodotti[i] != null
                    && prodotti[i].getCodice().equals(codice)
                    && prodotti[i].getPrezzo() <= importoAttuale ){

                importoAttuale -= prodotti[i].getPrezzo();
                prodotto = prodotti[i];
                prodotti[i] = null;
                break;
            }
        }

        return prodotto;
    }

    public double saldoAttuale() {
        return importoAttuale;
    }

    public double getResto() {
        double importoTmp = importoAttuale;
        importoAttuale = 0.0; //resetto l'importo
        return importoTmp;
    }

    public void stampaTuttiProdottiCaricati(){
        for(int i=0; i< prodotti.length; i++){
            if(prodotti[i] != null){
                System.out.println(prodotti[i]);
            }
        }
    }


    /*
    * TODO: Modificare questo metodo in modo che torni un array
    *  con gli elementi effettivi (senza quindi i null)
    *   + contare quante posizioni avete non nulle
    *   + init nuovo array
    *   + scorrere e aggiungere in nuovo array (return)
    * */
    public Prodotto[] getProdotti() {
        return prodotti;
    }
}
