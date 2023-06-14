package esempi.lambda_functions;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.DoubleToIntFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    // metodo che accetta una stringa e una funzione da applicare su di essa
    private static String applyFunctionOnString(String s, Function<String, String> processor) {
        return processor.apply(s);
    }

    public static void main(String[] args) {
        // StringProcessor accetta qualunque lambda con un solo parametro di tipo String e un valore di ritorno di tipo String
        StringProcessor sp = (String s) -> s.toLowerCase();
        StringProcessor sp2 = String::toLowerCase;

        System.out.println(sp.process("TEST")); // come se stessimo fornendo l'implementazione del metodo process

        // Function<String, String> accetta qualunque lambda con un solo parametro di tipo String e un valore di ritorno di tipo String
        Function<String, String> fun  = (String s) -> s.toLowerCase();
        Function<String, String> fun2 = String::toLowerCase;

        DoubleToIntFunction fun3; // analogo a Function<Double, Integer>, prende un Double e ritorna un Intero

        // funzione identità, dato qualunque input lo ritorna identico in output
        Function<Integer, Integer> fun4 = Function.identity(); // analogo alla lambda x -> x
        // Function<Integer, Integer> fun4 = x -> x;

        String str = "bella";
        Function<String, String> concatToBella = str::concat; // analogo alla lambda s -> str.concat(s)
        // Function<String, String> concatToBella = s -> str.concat(s);
        System.out.println(concatToBella.apply(" zi"));

        BiFunction<String, String, String> concat = String::concat; // analogo alla lambda (s1, s2) -> s1.concat(s2)
        // BiFunction<String, String, String> concat = (s1, s2) -> s1.concat(s2);
        System.out.println(concat.apply("bella", " zi"));



        System.out.println(applyFunctionOnString("BELLA", s -> s.toLowerCase()));
        System.out.println(applyFunctionOnString("BELLA", s -> s.concat(" ZI")));



        List<String> list = List.of("andrea", "marco", "davide");

        List<String> list2 = list.stream()
                .map(String::toUpperCase) // analogo a s -> s.toUpperCase()
                .filter(s -> s.startsWith("A") || s.endsWith("E"))
                .toList(); // analogo a .collect(Collectors.toList())

        Map<Character, String> mappa = list.stream()
                .collect(Collectors.toMap(s -> s.charAt(0), Function.identity()));

        Map<String, Integer> mappa2 = list.stream()
                        .collect(Collectors.toMap(Function.identity(), String::length));

        System.out.println(mappa);
        System.out.println(mappa2);



        // Comparator può essere definito tramite una lambda, essendo un'interfaccia funzionale

        Comparator<String> cmp;

        cmp = new StringComparator();
        cmp = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        };
        cmp = (String s1, String s2) -> s1.length() - s2.length();
        cmp = Comparator.comparing((String s) -> s.length());
        cmp = Comparator.comparing(String::length);


        Comparator<Integer> cmpInt = (o1, o2) -> Integer.compare(o1, o2);
        Comparator<Integer> cmpInt3 = Integer::compare;
    }
}
