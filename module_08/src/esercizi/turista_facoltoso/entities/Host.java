package turista_facoltoso.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import turista_facoltoso.exceptions.ApartmentNotFoundException;
import turista_facoltoso.exceptions.AvailabilitiesOverlapException;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@SuperBuilder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class Host extends User {
    @NonNull
    private UUID codiceHost;
    private final Set<Apartment> apartments = new HashSet<>();

    public boolean addApartment(Apartment apartment) {
        return apartments.add(apartment);
    }

    public boolean addAvailability(Apartment.Availability availability) throws ApartmentNotFoundException, AvailabilitiesOverlapException {
        Apartment apartment = availability.getApartment();
        if (!apartments.contains(apartment)) throw new ApartmentNotFoundException(apartment);
        return apartment.addAvailability(availability);
    }

    public static Host fromUser(User user) {
        return Host.builder()
                .codiceHost(UUID.randomUUID())
                .id(user.getId())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .address(user.getAddress())
                .build();
    }
}
