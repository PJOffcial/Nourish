package group1.eProject.services;

import group1.eProject.entities.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getReviews(int productId);
    void saveReview(Review review);
    void deleteReview(int id);
}