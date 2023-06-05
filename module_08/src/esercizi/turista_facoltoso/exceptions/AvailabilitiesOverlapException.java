package esercizi.turista_facoltoso.exceptions;

import esercizi.turista_facoltoso.entities.Apartment;

public class AvailabilitiesOverlapException extends Exception {
    public AvailabilitiesOverlapException(Apartment.Availability newAvailability, Apartment.Availability avail) {
        super(newAvailability + " overlaps with " + avail);
    }
}
