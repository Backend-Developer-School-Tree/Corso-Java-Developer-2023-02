package live_coding.persona_professore_studente;

public class Main {
    public static void main(String[] args) {
        Studente studente = new Studente("Andrea");
        studente.sayMyName();
        studente.printMatricola();

        Persona persona = new Studente("Andrea");
        persona.sayMyName();
        // persona.printMatricola();

        System.out.println(persona instanceof Studente);

        if (persona instanceof Studente) {
            Studente studente1 = (Studente) persona;
            studente1.printMatricola();
        }
    }
}
