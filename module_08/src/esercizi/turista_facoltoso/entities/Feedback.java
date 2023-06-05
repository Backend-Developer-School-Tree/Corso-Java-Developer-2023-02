package esercizi.turista_facoltoso.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@Getter
@AllArgsConstructor
public class Feedback {
    private int id;
    @NonNull private String title;
    @NonNull private String body;
    @NonNull private Score score;

    public static class Score {
        public static final int MIN = 1;
        public static final int MAX = 5;

        @Getter
        private final int value;

        public Score(int value) {
            if (value < MIN || value > MAX)
                throw new IllegalArgumentException("value must be >= " + MIN + " and <= " + MAX);

            this.value = value;
        }
    }
}
