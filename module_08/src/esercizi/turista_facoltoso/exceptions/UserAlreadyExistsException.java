package turista_facoltoso.exceptions;

import turista_facoltoso.entities.User;

public class UserAlreadyExistsException extends Exception {
    public UserAlreadyExistsException(User user) {
        super("user " + user + " already exists");
    }
}
