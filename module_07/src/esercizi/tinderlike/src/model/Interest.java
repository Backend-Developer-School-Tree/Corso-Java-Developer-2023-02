package model;

import java.util.Comparator;
import java.util.Objects;
import java.util.UUID;

public class Interest implements Comparable<Interest> {
    private String text; //text è la descrizione dell'interesse
    private UUID id;

    public Interest(String text) {
        id = UUID.randomUUID();
        this.text = text;
    }

    public UUID getId() {
        return id;
    }

    public String getText(){
        return text;
    }


    @Override
    public String toString() {
        return "Interest{" +
                "id='" + id + '\'' +
                ", text='" + text + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Interest interest = (Interest) o;
        return id.equals(interest.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(Interest o) {
        return Comparator.comparing(Interest::getId).compare(this, o);
    }
}
