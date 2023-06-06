package esempi.java_packages;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class JavaDateTime {

    public static void main(String[] args){

        LocalDate currentDate = LocalDate.now();
        System.out.println("Current Date: " + currentDate);

        // Utile se sto leggendo dati da una fonte esterna (es servizio web)
        LocalDate specificDate = LocalDate.of(2022, 5, 16);
        System.out.println("Specific Date: " + specificDate);

        System.out.println("Day: " + currentDate.getDayOfMonth() + ", month: " + currentDate.getMonth() + ", year: " + currentDate.getYear());

        // Intervallo tra date
        Period p1 = Period.between(specificDate, currentDate);
        System.out.println("Period days:" + p1.getDays());
        System.out.println("Period months:" + p1.getMonths());
        System.out.println("Period years:" + p1.getYears());

        // Se voglio l'orario oltre la data (es timestamp di un log)
        LocalDateTime timestamp = LocalDateTime.now();
        System.out.println("Timestamp:" + timestamp);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        System.out.println("timestamp formatted: " + timestamp.format(dateTimeFormatter));



    }
}
