package labirinto;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        // TODO il metodo deve prendere righe e colonne in input
        Labirinto labirinto = new Labirinto(5, 5);// generaLabirintoCasuale(5,5);

        System.out.println("*** STAMPA LABIRINTO ***");
        labirinto.print();
    }

}

