package model;

import javax.naming.AuthenticationNotSupportedException;
import java.util.Objects;

public class Book {
    private String code, title, synopsis;
    //Una soluzione più reale e concreta prevederebbe una collection
    // verso author List<Author> authors (o viceversa da author verso book);
    // jdbc.. per la connessione

    public Book(String code, String title, String synopsis) {
        this.code = code;
        this.title = title;
        this.synopsis = synopsis;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;
        return Objects.equals(code, book.code) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    @Override
    public String toString() {
        return "Book{" +
                "code='" + code + '\'' +
                ", title='" + title + '\'' +
                ", synopsis='" + synopsis + '\'' +
                '}';
    }
}
