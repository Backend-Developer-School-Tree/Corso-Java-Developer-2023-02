package esercizi.turista_facoltoso;

import esercizi.turista_facoltoso.entities.Apartment;
import esercizi.turista_facoltoso.entities.Booking;
import esercizi.turista_facoltoso.entities.Host;
import esercizi.turista_facoltoso.entities.User;
import esercizi.turista_facoltoso.exceptions.AparmentNotAvailableException;
import esercizi.turista_facoltoso.exceptions.ApartmentAlreadyBookedException;
import esercizi.turista_facoltoso.exceptions.UserAlreadyExistsException;
import esercizi.turista_facoltoso.exceptions.UserNotFoundException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class AirBnb {
    /**
     * Map from userId to User itself
     */
    private final Map<Integer, User> userMap = new HashMap<>();
    /**
     * Map from codiceHost to Host itself
     */
    private final Map<Integer, Host> hostMap = new HashMap<>();

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
    public User addUser(User user) throws UserAlreadyExistsException {
        if (userMap.containsKey(user.getId()))
            throw new UserAlreadyExistsException(user);

        return userMap.put(user.getId(), user);
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
        hostMap.put(host.getCodiceHost(), host);
    }

    /**
     * Ritorna le abitazioni corrispondenti al codice host specificato
     */
    public Collection<Apartment> getApartments(int codiceHost) throws UserNotFoundException {
        Host host = hostMap.get(codiceHost);
        if (host == null) throw new UserNotFoundException();

        return host.getApartments();
    }

    public Collection<Apartment> getApartments(Host host) throws UserNotFoundException {
        return getApartments(host.getCodiceHost());
    }

    /**
     * Ritorna l'ultima (più recente) prenotazione effettuata dall'utente con l'id specificato,
     * null se l'utente non ha effettuato alcuna prenotazione
     */
    public Booking getLastBooking(int userId) throws UserNotFoundException {
        User user = userMap.get(userId);
        if (user == null) throw new UserNotFoundException();

        Booking maxBooking = null;
        LocalDateTime maxTime = null;
        for (Booking booking : user.getBookings()) {
            if (maxBooking == null || booking.getTime().isAfter(maxTime)) {
                maxBooking = booking;
                maxTime = booking.getTime();
            }
        }
        return maxBooking;
    }

    public Booking getLastBooking(User user) throws UserNotFoundException {
        return getLastBooking(user.getId());
    }

    /**
     * Ritorna l'appartamento più gettonato nell'ultimo mese
     */
    public Apartment getMostPopularApartment() {
        return getMostPopularApartment(LocalDateTime.now().minusDays(30));
    }

    public Apartment getMostPopularApartment(LocalDateTime fromDate) {
        int maxBookings = 0;
        Apartment maxApartment = null;
        // mappa per contare il numero di prenotazioni totali rispetto ad ogni appartamento
        Map<Apartment, Integer> bookingsCounter = new HashMap<>();

        for (Host host : getHosts()) {
            for (Apartment apartment : host.getApartments()) {
                for (Booking booking : apartment.getBookings()) {
                    // non consideriamo le prenotazioni effettuate più di tot mesi fa
                    if (fromDate.isBefore(booking.getTime())) continue;

                    // aggiorniamo il numero di prenotazioni effettuate negli ultimi tot mesi per l'appartamento
                    Integer bookingsCount = bookingsCounter.get(apartment);
                    if (bookingsCounter.containsKey(apartment))
                        bookingsCounter.put(apartment, 1);
                    else
                        bookingsCounter.replace(apartment, bookingsCount + 1);

                    if (maxApartment == null || bookingsCount > maxBookings) {
                        maxApartment = apartment;
                        maxBookings = bookingsCount;
                    }
                }
            }
        }
        return maxApartment;
    }

    /**
     * Ritorna l'host con più prenotazioni nell'ultimo mese
     */
    public Host getMostPopularHost() {
        return getMostPopularHost(LocalDateTime.now().minusDays(30));
    }

    public Host getMostPopularHost(LocalDateTime fromDate) {
        int maxBookings = 0;
        Host maxHost = null;
        // mappa per contare il numero di prenotazioni totali rispetto ad ogni host
        Map<Host, Integer> bookingsCounter = new HashMap<>();

        for (Host host : getHosts()) {
            for (Apartment apartment : host.getApartments()) {
                for (Booking booking : apartment.getBookings()) {
                    // non consideriamo le prenotazioni effettuate più di tot mesi fa
                    if (fromDate.isBefore(booking.getTime())) continue;

                    // aggiorniamo il numero di prenotazioni effettuate negli ultimi tot mesi per l'appartamento
                    Integer bookingsCount = bookingsCounter.get(host);
                    if (bookingsCounter.containsKey(host))
                        bookingsCounter.put(host, 1);
                    else
                        bookingsCounter.replace(host, bookingsCount + 1);

                    if (maxHost == null || bookingsCount > maxBookings) {
                        maxHost = host;
                        maxBookings = bookingsCount;
                    }
                }
            }
        }
        return maxHost;
    }

    public List<Host> getSuperHosts() {

    }

    public List<User> getTopFiveUsers() {

    }

    public long getAverageBedsNumber() {

    }
}
