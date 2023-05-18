package biblioteca;

import java.util.Arrays;
import java.util.Comparator;

public class Libro implements Comparable<Libro> {

    private int index;
    private String author;
    private String name;

    public Libro(int index, String author, String name) {
        this.index = index;
        this.author = author;
        this.name = name;
    }

    public int getIndex() { return index; }

    @Override
    public String toString() {
        return "Libro{" +
                "index=" + index +
                ", author='" + author + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Libro[] array = {
                new Libro(1, "Andrea", "Libro 1"),
                new Libro(2, "Andrea 2", "Libro 2"),
        };

        Arrays.sort(array);
        System.out.println(Arrays.toString(array));

        Arrays.sort(array, Comparator.comparing(l -> l.getIndex()));
        System.out.println(Arrays.toString(array));

        Arrays.sort(array, Comparator.comparing(Libro::getIndex));
        System.out.println(Arrays.toString(array));
    }

    @Override
    public int compareTo(Libro libro) {
        /*
        // per comparare due oggetti dello stesso tipo dobbiamo ritornare un intero (negativo, positivo o 0)
        if (libro.getIndex() == this.getIndex())
            return 0;   // quando il nostro oggetto (this) è uguale al libro passato come parametro
        else if (libro.getIndex() > this.getIndex())
            return -1;  // (qualunque valore negativo) quando il nostro oggetto (this) è più piccolo del libro passato come parametro
        else
            return 1;   // (qualunque valore positivo) quando il nostro oggetto (this) è più grande del libro passato come parametro

        // comparazione analoga su una sola riga utilizzando l'operatore ternario
        // return (libro.getIndex() == this.getIndex()) ? 0 : ((libro.getIndex() > this.getIndex()) ? -1 : 1);

        // modo più standard e pulito per comparare un singolo campo
        // return Integer.compare(libro.getIndex(), this.getIndex());
         */

        // e se volessimo comparare in base a più di un attributo?
        // ad esempio per ordinare prima in base all'index e in caso di uguaglianza anche in base all'autore
        int indexComparison = Integer.compare(libro.getIndex(), this.getIndex());

        // se gli index sono uguali
        if (indexComparison == 0)
            // ordina in base all'autore
            return this.author.compareTo(libro.author);
        else
            // altrimenti ordina solo in base all'index
            return indexComparison;
    }
}
