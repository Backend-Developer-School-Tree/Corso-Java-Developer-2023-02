package live_coding.persona_professore_studente;

import java.util.Objects;

public class Persona {

    protected String name;

    public Persona(String name) {
        this.name = name;
    }

    public void sayMyName() {
        System.out.println("Sono una persona");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return Objects.equals(name, persona.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
