package turista_facoltoso.entities;

import lombok.Getter;
import lombok.NonNull;

public class Feedback {
    private int id;
    @NonNull private String title;
    @NonNull private String body;
    @NonNull private Score score;

    public static class Score {
        public static int MIN = 1;
        public static int MAX = 5;

        @Getter
        private final int value;

        public Score(int value) {
            if (value < MIN || value > MAX) throw new IllegalArgumentException("value must be >= " + MIN + " and <= " + MAX);

            this.value = value;
        }
    }
}
