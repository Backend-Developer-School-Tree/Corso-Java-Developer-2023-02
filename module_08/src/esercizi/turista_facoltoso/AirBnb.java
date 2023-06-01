package turista_facoltoso;

import turista_facoltoso.entities.Apartment;
import turista_facoltoso.entities.Booking;
import turista_facoltoso.entities.Host;
import turista_facoltoso.entities.User;
import turista_facoltoso.exceptions.AparmentNotAvailableException;
import turista_facoltoso.exceptions.ApartmentAlreadyBookedException;
import turista_facoltoso.exceptions.UserAlreadyExistsException;
import turista_facoltoso.exceptions.UserNotFoundException;

import java.time.LocalDate;
import java.util.*;

public class AirBnb {
    /**
     * Map from userId to User itself
     */
    private Map<Integer, User> userMap = new HashMap<>();
    /**
     * Map from codiceHost to Host itself
     */
    private Map<Integer, Host> hostMap = new HashMap<>();

    private Collection<User> getUsers() { return userMap.values(); }
    private Collection<Host> getHosts() { return hostMap.values(); }

    /**
     * Effettua una prenotazione per un Appartamento da parte di un Utente
     *
     * @param user utente che effettua la prenotazione
     * @param apartment appartamento che si vuole prenotare
     * @param start data di inizio prenotazione
     * @param end data di fine prenotazione
     *
     * @throws ApartmentAlreadyBookedException se esiste già una prenotazione che intersechi le date di inizio e fine
     * @throws AparmentNotAvailableException se l'appartamento non accetta prenotazioni per il periodo specificato
     */
    public void book(User user, Apartment apartment, LocalDate start, LocalDate end) throws ApartmentAlreadyBookedException, AparmentNotAvailableException {
        // verifica della disponibilità dell'appartamento nel periodo indicato
        List<Apartment.Availability> availabilities = apartment.getAvailabilities();
        for (Apartment.Availability availability : availabilities) {
            // il periodo indicato deve essere compreso nell'intervallo definito dalle date di disponibilità dell'appartamento
            if (availability.getStart().isBefore(start) && availability.getEnd().isAfter(end)) {

                // non può esistere un'altra prenotazione che intersechi già le date della ricerca di disponibilità
                List<Booking> bookings = apartment.getBookings();
                for (Booking booking : bookings) {
                    if (start.isAfter(booking.getStart()) && end.isBefore(booking.getEnd()))
                        throw new ApartmentAlreadyBookedException(apartment, booking);
                }
            }
            else throw new AparmentNotAvailableException(apartment, start, end);
        }

        Booking booking = new Booking(start, end, apartment, user);
        user.addBooking(booking);
        apartment.addBooking(booking);
    }

    /**
     * Registra un nuovo utente nella piattaforma
     *
     * @param user utente da registrare
     * @throws UserAlreadyExistsException se un utente con lo stesso id è già registrato
     */
    public void addUser(User user) throws UserAlreadyExistsException {
        if (userMap.containsKey(user.getId()))
            throw new UserAlreadyExistsException(user);

        userMap.put(user.getId(), user);
    }

    /**
     * Approva come Host un utente già registrato
     *
     * @param user utente da approvare come host
     * @throws UserNotFoundException se l'utente non è già registrato nella piattaforma
     */
    public void promoteToHost(User user) throws UserNotFoundException {
        if (!userMap.containsKey(user.getId()))
            throw new UserNotFoundException(user);

        Host host = Host.fromUser(user);
        userMap.replace(host.getId(), host);
        hostMap.put(host.getId(), host);
    }
}
