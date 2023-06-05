package esercizi.turista_facoltoso.exceptions;

import esercizi.turista_facoltoso.entities.Booking;
import esercizi.turista_facoltoso.entities.User;
import esercizi.turista_facoltoso.entities.Booking;
import esercizi.turista_facoltoso.entities.User;

public class BookingNotFoundException extends Throwable {
    public BookingNotFoundException(User user, Booking booking) {
        super("user " + user + " never booked " + booking);
    }
}
