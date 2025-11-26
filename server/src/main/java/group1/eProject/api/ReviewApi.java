package group1.eProject.api;

import group1.eProject.entities.Review;
import group1.eProject.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewApi {
    @Autowired
    private ReviewService reviewService;
    @GetMapping("/product/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Review> getReviews(@PathVariable int productId) {
        return reviewService.getReviews(productId);
    }
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void createReview(@RequestBody Review review) {
        reviewService.saveReview(review);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteReview(@PathVariable int id) {
        reviewService.deleteReview(id);
    }
}