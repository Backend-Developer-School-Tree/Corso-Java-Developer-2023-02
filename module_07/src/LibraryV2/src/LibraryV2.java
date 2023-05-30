import model.Author;
import model.Book;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//Nome arbitrario
public class LibraryV2 {

    // Potevo creare le istanze nel costruttore di LibraryV2
    private Map<Author, Set<Book>> library = new HashMap<>();
    private Map<String, Author> bookAuthor = new HashMap<>();

    // C.R.U.D.
    public void insertBook(Author author, Book book) {
        if(author == null || book == null)
            return;
        if(library.containsKey(author)) {
            //Sto operando su una mappa, partendo dalla chiave aggiungo un libro al SET
            library.get(author).add(book);

            // Anche qui una mappa, inserisco codice con autore
            bookAuthor.put(book.getCode(), author);
        }
        else {
            //Mi creo un nuovo set di libri perchè autore non presente (ancora)
            Set<Book> books = new HashSet<>();
            books.add(book);

            library.putIfAbsent(author, books);

            // Anche qui una mappa, inserisco codice con autore
            bookAuthor.put(book.getCode(), author);
        }
    }
    //Ricorda abbiamo Map<Author, Set<Book>> library
    public void removeBook(Book book) {
        if(book == null)
            return;
        Author a = bookAuthor.get(book.getCode()); //Autore da codice libro preso in input
        library.get(a).removeIf(book1 -> book1.equals(book));
    }

    public Set<Book> getBooks(Author author) throws AuthorNotFoundException {
        checkAuthorExistsInLibrary(author);

        //Se arrivo qui, autore presente (altrimenti lancia eccezione)
        return library.get(author);
    }

    //Ricorda abbiamo Map<Author, Set<Book>> library che devo iterare.
    public Set<Book> getBooks(String code) {
        Set<Book> found = new HashSet<>();
        for(Map.Entry<Author, Set<Book>> entry : library.entrySet())

            //Itero sui SET (Books)
            for(Book book : entry.getValue())

                // Se codice è uguale allora torna
                if(book.getCode().equals(code))
                    found.add(book);
        return found;
    }

    public Set<Book> getBooksByTitle(String title) {
        Set<Book> found = new HashSet<>();

        for(Map.Entry<Author, Set<Book>> entry : library.entrySet())
            for(Book book : entry.getValue())

                //Controllo tra stringhe
                if(book.getTitle().startsWith(title) || book.getTitle().contains(title)
                        || book.getTitle().endsWith(title) )
                    found.add(book);
        return found;
    }

    private void checkAuthorExistsInLibrary(Author author) throws AuthorNotFoundException {
        if(!library.containsKey(author)){
            throw new AuthorNotFoundException();
        }
    }


    public static void main(String[] args) {
        LibraryV2 library = new LibraryV2();

        Book lordRings = new Book("12345", "Il Signore degli Anelli", "\"Il Signore degli Anelli (titolo originale in inglese: \" +\n" +
                "\"The Lord of the Rings) è un romanzo high fantasy epico scritto da J. R. R. Tolkien" );

        Author tolkien = new Author("abcd123", "Jhon Ronald Reuel", "Tolkien");
        Author Orwell = new Author("abcd456", "George", "Orwell");


        library.insertBook(tolkien,lordRings);
        library.removeBook(lordRings); //non rimuove l'autore associato

        try {
            Set<Book> books = library.getBooks(tolkien);
            for(Book b : books){
                System.out.println(b);
            }

        } catch (AuthorNotFoundException e) {
            System.out.println("Author not found. Error code: " + e.errorCode);
            //e.printStackTrace(); //stampa in console lo stacktrace dell'errore
        }


    }

    //TODO: Spostare in un package apposito
    class AuthorNotFoundException extends Exception {
        private final String errorCode = "1";
    }
}