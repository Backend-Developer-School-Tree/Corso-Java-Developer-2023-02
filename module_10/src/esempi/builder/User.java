package esempi.builder;

import lombok.Builder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Con Lombok possiamo usare il pattern Builder aggiungendo l'annotazione @Builder alla classe
// senza necessità di implementarlo da zero come in questo esempio
// @Builder
public class User {
    private final String firstName;
    private final String lastName;

    private User(User.Builder builder) {
        firstName = builder.firstName;
        lastName = builder.lastName;
    }

    public static class Builder {
        private String firstName;
        private String lastName;

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    public static void main(String[] args) {
        User.Builder ub = new User.Builder();

        ub.firstName("Andrea");
        ub.lastName("Gasparini");

        User user = ub.build();

        User user2 = new User.Builder()
                .firstName("Andrea")
                .lastName("Gasparini")
                .build();

        // Java Stream/Lambda function (che vedremo nel prossimo modulo) hanno un'implementazione analoga al pattern Builder
        List<User> list = new ArrayList<>();
        list.stream()
                .map(s -> s.firstName)
                .filter(s -> s.equals("Andrea"))
                .collect(Collectors.toCollection(ArrayList::new));  // analogo al metodo build()
    }
}
