package group1.eProject.repos;

import group1.eProject.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepo extends JpaRepository<Review, Integer> {
    List<Review> findByProductId(int productId);
    List<Review> findByUserId(int userId);
}