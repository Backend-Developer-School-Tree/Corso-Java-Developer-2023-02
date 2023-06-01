package turista_facoltoso.exceptions;

import turista_facoltoso.entities.User;

public class UserNotFoundException extends Exception {

    public UserNotFoundException() { super(); }

    public UserNotFoundException(User user) {
        super("user " + user + " not found");
    }
}
