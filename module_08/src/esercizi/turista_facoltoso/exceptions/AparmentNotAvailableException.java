package esercizi.turista_facoltoso.exceptions;

import esercizi.turista_facoltoso.entities.Apartment;
import esercizi.turista_facoltoso.entities.Apartment;

import java.time.LocalDate;

public class AparmentNotAvailableException extends Throwable {
    public AparmentNotAvailableException(Apartment apartment, LocalDate start, LocalDate end) {
        super("apartment " + apartment + " is not available for booking from " + start + " to " + end);
    }
}
