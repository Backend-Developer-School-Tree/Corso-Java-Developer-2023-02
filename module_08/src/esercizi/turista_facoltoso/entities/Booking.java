package esercizi.turista_facoltoso.entities;

import esercizi.turista_facoltoso.exceptions.IllegalPeriodException;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import esercizi.turista_facoltoso.exceptions.IllegalPeriodException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Booking {
    @NonNull
    @EqualsAndHashCode.Include
    private UUID id;
    @NonNull private LocalDate start;
    @NonNull private LocalDate end;
    @NonNull private LocalDateTime time;
    @NonNull private Apartment apartment;
    @NonNull private User user;

    public Booking(@NonNull LocalDate start, @NonNull LocalDate end, @NonNull Apartment apartment, @NonNull User user) {
        if (start.isAfter(end)) throw new IllegalPeriodException(start, end);

        this.id = UUID.randomUUID();
        this.start = start;
        this.end = end;
        this.time = time;
        this.apartment = apartment;
        this.user = user;
    }
}
