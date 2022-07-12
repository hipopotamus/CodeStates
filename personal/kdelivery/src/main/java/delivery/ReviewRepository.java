package delivery;

import java.util.ArrayList;
import java.util.List;

public class ReviewRepository {
    private static final ReviewRepository reviewRepository = new ReviewRepository();

    public List<Review> reviewList = new ArrayList<>();

    public static ReviewRepository getReviewRepository() {
        return reviewRepository;
    }

    public void add(Review review) {
        reviewList.add(review);
    }
}
