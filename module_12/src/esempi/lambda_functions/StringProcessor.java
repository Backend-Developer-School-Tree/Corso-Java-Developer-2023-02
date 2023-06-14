package esempi.lambda_functions;

@FunctionalInterface
// StringProcessor accetta qualunque lambda con un solo parametro di tipo String e un valore di ritorno di tipo String
public interface StringProcessor {
    String process(String s);
}
