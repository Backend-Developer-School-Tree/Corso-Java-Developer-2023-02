package turista_facoltoso.exceptions;

import turista_facoltoso.entities.Apartment;

public class AvailabilitiesOverlapException extends Throwable {
    public AvailabilitiesOverlapException(Apartment.Availability newAvailability, Apartment.Availability avail) {
        super(newAvailability + " overlaps with " + avail);
    }
}
