package esempi.optional_class;

import java.util.Optional;

public class Main {

    public static void main(String[] args){

        // empty()
        Optional<String> emptyOptString = Optional.empty(); //creo Optional vuoto
        System.out.println("Is a value present? " + emptyOptString.isPresent()); //check sul valore

        // nota se passo null ottengo java.lang.NullPointerException
        Optional<String> nameOptString = Optional.of("Davide"); //creo Optional con qualcosa dentro
        if(nameOptString.isPresent()){
            System.out.println(nameOptString.get()); //accedo al valore
        }

        Optional<String> nameOptStringNullable = Optional.ofNullable(null); //creo Optional con qualcosa dentro
        if(nameOptStringNullable.isPresent()){
            System.out.println(nameOptStringNullable.get()); //accedo al valore
        } else {
            System.out.println("Valore null");
        }

    }
}