package turista_facoltoso.entities;

import lombok.*;
import lombok.experimental.SuperBuilder;

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
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private final List<Booking> bookings = new ArrayList<>();

    public void addBooking(Booking booking) { bookings.add(booking); }
}
