package esercizi.turista_facoltoso.entities;

import lombok.*;
import lombok.experimental.SuperBuilder;
import esercizi.turista_facoltoso.exceptions.BookingNotFoundException;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
@SuperBuilder
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User {
    @NonNull
    @EqualsAndHashCode.Include
    protected Integer id;
    protected String email;
    protected String firstName;
    protected String lastName;
    protected String address;
    protected final List<Booking> bookings = new ArrayList<>();

    public void addBooking(Booking booking) { bookings.add(booking); }

    public void leaveFeedback(Booking booking, Feedback feedback) throws BookingNotFoundException {
        for (Booking booking1 : bookings) {
            if (booking.equals(booking1))
                booking.getApartment().addFeedback(feedback);
        }
        throw new BookingNotFoundException(this, booking);
    }
}
