package turista_facoltoso.entities;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import turista_facoltoso.exceptions.IllegalPeriodException;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Booking {
    @NonNull
    @EqualsAndHashCode.Include
    private UUID id;
    @NonNull private LocalDate start;
    @NonNull private LocalDate end;
    @NonNull private Apartment apartment;
    @NonNull private User user;

    public Booking(@NonNull LocalDate start, @NonNull LocalDate end, @NonNull Apartment apartment, @NonNull User user) {
        if (start.isAfter(end)) throw new IllegalPeriodException(start, end);

        this.id = UUID.randomUUID();
        this.start = start;
        this.end = end;
        this.apartment = apartment;
        this.user = user;
    }
}
