package live_coding.persona_professore_studente;

import java.util.Objects;

public class Professore extends Persona {

    private int id;

    public Professore(String name) {
        super(name);
    }

    @Override
    public void sayMyName() {
        super.sayMyName();
        System.out.println("Sono il professore: " + name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Professore that = (Professore) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }
}
