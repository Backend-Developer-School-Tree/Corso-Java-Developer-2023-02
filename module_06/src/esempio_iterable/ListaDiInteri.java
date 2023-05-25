package esempio_iterable;

import java.util.Arrays;
import java.util.Iterator;

public class ListaDiInteri implements Iterable<Integer> {

    private int[] values = new int[0];

    public ListaDiInteri() {}

    public ListaDiInteri(int[] values) {
        for (int value : values)
            add(value);
    }

    /**
     * @return lunghezza della lista di interi
     */
    public int length() { return values.length; }

    /**
     * Aggiunge un valore nella lista di interi, estendendo la dimensione dell'array di 1
     *
     * @param value l'intero da aggiungere alla lista
     */
    public void add(int value) {
        // estendiamo l'array di interi creandone uno nuovo temporaneo di lunghezza maggiore di 1
        // così da poter aggiungere un nuovo valore
        int[] tmp = new int[values.length + 1];
        // copiamo ogni intero nel nuovo array esteso di lunghezza
        for (int i = 0; i < values.length; i++)
            tmp[i] = values[i];
        // aggiungiamo il nuovo valore in ultima posizione
        tmp[values.length] = value;
        // salviamo nel campo values il riferimento in memoria dell'array esteso con il nuovo valore
        values = tmp;
    }

    /**
     * Ritorna il valore all'indice in input
     *
     * @param i indice dell'intero nella lista
     * @return il valore all'indice in input
     */
    public Integer get(int i) {
        if (i > values.length) return null;
        return values[i];
    }

    public boolean contains(int value) {
        for (int i : values)
            if (i == value)
                return true;

        return false;
    }

    public int indexOf(int value) {
        for (int i = 0; i < values.length; i++)
            if (values[i] == value)
                return i;

        return -1;
    }

    @Override
    public String toString() { return Arrays.toString(values); }

    @Override
    public Iterator<Integer> iterator() {
        // Iterator implementato con classe interna
        // return new ListaDiInteriIterator();

        // Iterator implementato con classe anonima
        return new Iterator<Integer>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index != length();
            }

            @Override
            public Integer next() {
                return get(index++);
            }
        };
    }

    // inner class analoga alla classe anonima definita direttamente nel metodo iterator
    public class ListaDiInteriIterator implements Iterator<Integer> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index != length();
        }

        @Override
        public Integer next() {
            return get(index++);
        }
    }

    public static void main(String[] args) {
        ListaDiInteri lista = new ListaDiInteri();
        lista.add(1);
        lista.add(2);
        lista.add(3);

        // implementando l'interfaccia Iterable abbiamo la possibilità di utilizzare il costrutto for-each
        for (Integer integer : lista)
            System.out.println(integer);
    }
}
