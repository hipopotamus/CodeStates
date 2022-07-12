package delivery;

import org.junit.jupiter.api.Test;

class ReviewTest {
    @Test
    public void toStringTest() {
        Review review = new Review("박성우", "노랑 통닭", "통닭", 3);
        System.out.println(review);
    }

}