package esercizi.turista_facoltoso.exceptions;

import esercizi.turista_facoltoso.entities.User;
import esercizi.turista_facoltoso.entities.User;

public class UserAlreadyExistsException extends Exception {
    public UserAlreadyExistsException(User user) {
        super("user " + user + " already exists");
    }
}
