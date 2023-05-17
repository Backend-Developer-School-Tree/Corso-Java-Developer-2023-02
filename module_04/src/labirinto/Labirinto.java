package labirinto;

import java.util.Random;

public class Labirinto {

    char[][] labirinto;

    Labirinto(char[][] labirinto) { this.labirinto = labirinto; }

    Labirinto(int righe, int colonne) {
        Random generatoreCasuale = new Random();

        labirinto = new char[righe][colonne];

        for(int i=0; i< labirinto.length; i++){
            for(int j=0; j< labirinto[0].length; j++){
                labirinto[i][j] = '-';
            }
        }

        // Genero casualmente la riga su cui voglio posizionare giocatore ed uscita
        int rigaGiocatore = generatoreCasuale.nextInt(righe);
        int rigaUscita = generatoreCasuale.nextInt(righe);

        // Variante: genero prima i muri e dopo metto P ed E (nel caso sovracrivo)
        labirinto[rigaGiocatore][0] = 'P';
        labirinto[rigaUscita][colonne-1] = 'E';

        for(int i=0; i<labirinto.length; i++){
            for(int j=0; j<labirinto[0].length;j++){

                // se ho P oppure E, continua con il ciclo
                if(labirinto[i][j] != '-')
                    continue;

                // probabilità
                int prob = generatoreCasuale.nextInt(10);

                //2 è un parametro arbitrario, potrebbe essere anche di più
                if(prob <= 2){
                    labirinto[i][j] = 'W';
                }
            }
        }
    }

    public void print() {
        for (int i = 0; i < labirinto.length; i++) {
            for (int j = 0; j < labirinto[0].length; j++)
                System.out.print(labirinto[i][j]);
            System.out.println();
        }
    }

    public boolean muoviGiocatore(char mossa) {
        return muoviGiocatore(mossa, 1);
    }

    public boolean muoviGiocatore(char mossa, int numeroVolte) {
        return false; //temporaneo
    }

    public boolean checkVittoriaGiocatore() {

        return false; //temporaneo
    }

    public int[] trovaGiocatore() {
        return null;
    }

    public static void main(String[] args) {
        Labirinto lab = new Labirinto(5, 5);

        new Labirinto(new char[][]{
                new char[]{1,2,3,},
                new char[]{1,2,3,},
                new char[]{1,2,3,}
        });

        lab.muoviGiocatore('M');
        lab.muoviGiocatore('M');
    }
}
