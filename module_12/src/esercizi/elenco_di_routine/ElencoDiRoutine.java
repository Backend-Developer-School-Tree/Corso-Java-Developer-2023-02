package esercizi.elenco_di_routine;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class ElencoDiRoutine {

    List<Function<String, Integer>> functions = new ArrayList<>();

    public ElencoDiRoutine(List<Function<String, Integer>> functions) {
        this.functions.addAll(functions);
    }

    public ElencoDiRoutine(Function<String, Integer>... functions) {
        this.functions.addAll(List.of(functions));
    }

    public void esegui(String s) {
        for (Function<String, Integer> function : functions) {
            System.out.println(function.apply(s));
        }
    }

    public void add(Function<String, Integer> f) {
        functions.add(f);
    }

    public static void main(String[] args) {
        ElencoDiRoutine edr = new ElencoDiRoutine(String::length); // x -> x.length()

        Function<String, Integer> yOccurrences = (String s) -> Math.toIntExact(s.chars()
                .filter(c -> c == 'y')
                .count());

        // Function<String, Integer> parseInt = (String s) -> Integer.parseInt(s);
        // Function<String, Integer> parseInt = Integer::parseInt;
        Function<String, Integer> parseInt =  s -> s.chars().allMatch(Character::isDigit) ? Integer.parseInt(s) : null;

        Function<String, Integer> sumIntChars = s -> s.chars()
                .boxed()
                .map(Character::getNumericValue)
                .reduce(Integer::sum)
                .get();

        edr.add(yOccurrences);
        edr.add(parseInt);
        edr.add(sumIntChars);

        edr.esegui("123");
    }
}
