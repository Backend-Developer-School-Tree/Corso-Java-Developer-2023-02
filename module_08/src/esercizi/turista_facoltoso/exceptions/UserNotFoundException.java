package esercizi.turista_facoltoso.exceptions;

import esercizi.turista_facoltoso.entities.User;

public class UserNotFoundException extends Exception {

    public UserNotFoundException() { super(); }

    public UserNotFoundException(User user) {
        super("user " + user + " not found");
    }
}
