package turista_facoltoso.exceptions;

import lombok.NonNull;

import java.time.LocalDate;

public class IllegalPeriodException extends RuntimeException {
    public IllegalPeriodException(LocalDate start, LocalDate end) {
        super("start date " + start + " is after end date " + end);
    }
}
