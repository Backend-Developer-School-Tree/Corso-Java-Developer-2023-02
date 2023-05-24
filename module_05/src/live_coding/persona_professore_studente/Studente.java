package live_coding.persona_professore_studente;

import java.util.Objects;

public class Studente extends Persona {

    private String matricola;

    public Studente(String name) {
        super(name);
    }

    public void printMatricola() {
        System.out.println(matricola);
    }

    @Override
    public void sayMyName() {
        super.sayMyName();
        System.out.println("Sono lo studente: " + name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Studente studente = (Studente) o;
        return matricola.equals(studente.matricola);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), matricola);
    }
}