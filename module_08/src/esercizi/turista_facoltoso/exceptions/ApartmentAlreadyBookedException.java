package esercizi.turista_facoltoso.exceptions;

import esercizi.turista_facoltoso.entities.Apartment;
import esercizi.turista_facoltoso.entities.Booking;
import esercizi.turista_facoltoso.entities.Apartment;
import esercizi.turista_facoltoso.entities.Booking;

public class ApartmentAlreadyBookedException extends Exception {
    public ApartmentAlreadyBookedException(Apartment apartment, Booking booking) {
        super("apartment " + apartment + " is already booked from " + booking.getStart() + " to " + booking.getEnd());
    }
}
