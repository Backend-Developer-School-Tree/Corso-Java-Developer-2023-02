package turista_facoltoso.exceptions;

import turista_facoltoso.entities.Apartment;

public class ApartmentNotFoundException extends Throwable {
    public ApartmentNotFoundException(Apartment apartment) {
        super("apartment " + apartment + " not found");
    }
}
