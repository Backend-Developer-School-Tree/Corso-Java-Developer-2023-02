package esercizi.turista_facoltoso.exceptions;

import esercizi.turista_facoltoso.entities.Apartment;
import esercizi.turista_facoltoso.entities.Apartment;

public class ApartmentNotFoundException extends Exception {
    public ApartmentNotFoundException(Apartment apartment) {
        super("apartment " + apartment + " not found");
    }
}
