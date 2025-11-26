package group1.eProject.imps;

import group1.eProject.entities.Review;
import group1.eProject.repos.ReviewRepo;
import group1.eProject.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImp implements ReviewService {
    @Autowired
    private ReviewRepo reviewRepo;
    @Override
    public List<Review> getReviews(int productId) {
        return reviewRepo.findByProductId(productId);
    }
    @Override
    public void saveReview(Review review) {
        reviewRepo.save(review);
    }
    @Override
    public void deleteReview(int id) {
        reviewRepo.deleteById(id);
    }
}