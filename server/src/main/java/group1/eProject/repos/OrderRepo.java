package group1.eProject.repos;

import group1.eProject.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepo extends JpaRepository<Order,Integer> {
    List<Order> findByCustomerId(int customerId);
}