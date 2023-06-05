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
import java.time.Period;
import java.util.*;

public class AirBnb {
    /**
     * Limite minimo di prenotazioni per considerare un Host come super-host
     */
    public static final int SUPER_HOST_THRESHOLD = 100;
    /**
     * Mappa da id utente alla relativa istanza di User
     */
    private final Map<Integer, User> userMap = new HashMap<>();
    /**
     * Mappa da codice host alla relativa istanza di Host
     */
    private final Map<UUID, Host> hostMap = new HashMap<>();

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
                    if (start.isAfter(booking.getStart()) && start.isBefore(booking.getEnd()) ||
                            end.isAfter(booking.getStart()) && end.isBefore(booking.getEnd()))
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
     *
     * @param codiceHost codice host di cui si vuole ritornare gli appartamenti associati
     * @return una collection degli appartamenti corrispondenti al codice host specificato
     * @throws UserNotFoundException se il codice host non corrisponde a nessun Host registrato
     */
    public Collection<Apartment> getApartments(UUID codiceHost) throws UserNotFoundException {
        Host host = hostMap.get(codiceHost);
        if (host == null) throw new UserNotFoundException();

        return host.getApartments();
    }

    public Collection<Apartment> getApartments(Host host) throws UserNotFoundException {
        return getApartments(host.getCodiceHost());
    }


    /**
     * Ritorna l'ultima (più recente) prenotazione effettuata dall'utente con l'id specificato,
     * o null se l'utente non ha effettuato alcuna prenotazione
     *
     * @param userId id dell'utente di cui si vuole ritornare la prenotazione associata più recente
     * @return la prenotazione più recente effettuata dall'utente, o null se non ne ha effettuato alcuna
     * @throws UserNotFoundException se l'id utente non corrisponde a nessun utente registrato
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
     *
     * @return l'appartamento più gettonato nell'ultimo mese
     */
    public Apartment getMostPopularApartment() {
        return getMostPopularApartment(LocalDateTime.now().minusDays(30));
    }

    /**
     * Ritorna l'appartamento più gettonato a partire dalla data specificata
     *
     * @param fromDate data a partire dal quale considerare gli appartamenti
     * @return l'appartamento più gettonato a partire dalla data specificata
     */
    private Apartment getMostPopularApartment(LocalDateTime fromDate) {
        int maxBookings = 0;
        Apartment maxApartment = null;
        // mappa per contare il numero di prenotazioni totali rispetto ad ogni appartamento
        Map<Apartment, Integer> bookingsCounter = new HashMap<>();

        for (User user : getUsers()) {
            for (Booking booking : user.getBookings()) {
                // non consideriamo le prenotazioni effettuate prima della data specificata
                if (fromDate.isBefore(booking.getTime())) continue;

                Apartment apartment = booking.getApartment();
                // aggiorniamo il numero di prenotazioni effettuate per l'appartamento
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

        return maxApartment;
    }

    /**
     * Ritorna l'host con più prenotazioni nell'ultimo mese
     *
     * @return l'host con più prenotazioni nell'ultimo mese
     */
    public Host getMostPopularHost() {
        return getMostPopularHost(LocalDateTime.now().minusDays(30));
    }

    /**
     * Ritorna l'host con più prenotazioni a partire dalla data specificata
     *
     * @param fromDate data a partire dal quale considerare le prenotazioni
     * @return l'host con più prenotazioni a partire dalla data specificata
     */
    private Host getMostPopularHost(LocalDateTime fromDate) {
        int maxBookings = 0;
        Host maxHost = null;
        // mappa per contare il numero di prenotazioni totali rispetto ad ogni host
        Map<Host, Integer> bookingsCounter = new HashMap<>();

        for (User user : getUsers()) {
            for (Booking booking : user.getBookings()) {
                // non consideriamo le prenotazioni effettuate prima della data specificata
                if (fromDate.isBefore(booking.getTime())) continue;

                Host host = booking.getApartment().getHost();
                // aggiorniamo il numero di prenotazioni effettuate per l'appartamento
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
        return maxHost;
    }

    /**
     * Ritorna tutti gli Host registrati nella piattaforma che sono anche super-host
     *
     * @return i super-host registrati nella piattaforma
     */
    public List<Host> getSuperHosts() {
        List<Host> superHosts = new ArrayList<>();
        for (Host host : getHosts()) {
            if (host.getBookings().size() > SUPER_HOST_THRESHOLD)
                superHosts.add(host);
        }
        return superHosts;
    }

    /**
     * Ritorna i cinque utenti con più giorni prenotati nell'ultimo mese
     *
     * @return i cinque utenti con più giorni prenotati nell'ultimo mese
     */
    public User[] getTopFiveUsers() {
        return getTopFiveUsers(LocalDateTime.now().minusDays(30));
    }

    /**
     * Ritorna i cinque utenti con più giorni prenotati a partire dalla data specificata
     *
     * @param fromDate data a partire dal quale considerare le prenotazioni
     * @return i cinque utenti con più giorni prenotati a partire dalla data specificata
     */
    private User[] getTopFiveUsers(LocalDateTime fromDate) {
        User[] topFiveUsers = new User[5];
        // aggiungiamo l'utente con il massimo numero di prenotazioni ...
        topFiveUsers[0] = getTopUser(fromDate);
        // ... poi l'utente con il massimo numero di prenotazioni ignorando il precedente (ovvero il secondo con più prenotazioni) ...
        topFiveUsers[1] = getTopUser(fromDate, new HashSet<>(Arrays.asList(topFiveUsers)));
        // ... allo stesso modo per il terzo utente con il massimo numero di prenotazioni, ignorando i primi due, etc.
        topFiveUsers[2] = getTopUser(fromDate, new HashSet<>(Arrays.asList(topFiveUsers)));
        topFiveUsers[3] = getTopUser(fromDate, new HashSet<>(Arrays.asList(topFiveUsers)));
        topFiveUsers[4] = getTopUser(fromDate, new HashSet<>(Arrays.asList(topFiveUsers)));
        return topFiveUsers;
    }

    /**
     * Ritorna l'utente con più giorni prenotati a partire dalla data specificata
     *
     * @param fromDate data a partire dal quale considerare le prenotazioni
     * @return l'utente con più giorni prenotati a partire dalla data specificata
     */
    private User getTopUser(LocalDateTime fromDate) {
        return getTopUser(LocalDateTime.now().minusDays(30), new HashSet<>());
    }

    /**
     * Ritorna l'utente con più giorni prenotati a partire dalla data specificata,
     * senza considerare nella statistica gli utenti specificati
     *
     * @param fromDate data a partire dal quale considerare le prenotazioni
     * @param ignoredUsers utenti da non considerare per il calcolo
     * @return l'utente con più giorni prenotati a partire dalla data specificata,
     * senza considerare gli utenti specificati
     */
    private User getTopUser(LocalDateTime fromDate, Set<User> ignoredUsers) {
        int maxBookedDays = 0;
        User maxUser = null;
        for (User user : getUsers()) {
            if (ignoredUsers.contains(user)) continue;

            int bookedDays = 0;
            for (Booking booking : user.getBookings()) {
                // non consideriamo le prenotazioni effettuate prima della data specificata
                if (fromDate.isBefore(booking.getTime())) continue;

                bookedDays += Period.between(booking.getStart(), booking.getEnd()).getDays();
            }

            if (maxUser == null || bookedDays > maxBookedDays) {
                maxUser = user;
                maxBookedDays = bookedDays;
            }
        }
        return maxUser;
    }

    /**
     * Ritorna il numero medio di posti letto calcolato in base a tutte le abitazioni disponibili sulla piattaforma
     *
     * @return il numero medio di posti letto calcolato in base a tutte le abitazioni disponibili sulla piattaforma
     */
    public double getAverageBedsNumber() {
        double nApartments = 0;
        double nBeds = 0;
        for (Host host : getHosts()) {
            for (Apartment apartment : host.getApartments()) {
                nApartments += 1;
                nBeds += apartment.getNBeds();
            }
        }
        return nBeds / nApartments;
    }
}
