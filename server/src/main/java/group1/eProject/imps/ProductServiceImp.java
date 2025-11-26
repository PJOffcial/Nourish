package group1.eProject.imps;

import group1.eProject.entities.Product;
import group1.eProject.repos.ProductRepo;
import group1.eProject.services.ProductService;
import jakarta.persistence.criteria.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    private ProductRepo productRepo;
    @Override
    public List<Product> getAllProducts(Integer categoryId, String keyword) {
        Specification<Product> spec = (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (categoryId != null) {
                predicates.add(cb.equal(root.get("category").get("id"), categoryId));
            }
            if (keyword != null && !keyword.trim().isEmpty()) {
                predicates.add(cb.like(cb.lower(root.get("name")), "%" + keyword.toLowerCase() + "%"));
            }
            return cb.and(predicates.toArray(new Predicate[0]));
        };
        return productRepo.findAll(spec);
    }
    @Override
    public Product saveProduct(Product product) {
        return productRepo.save(product);
    }
    @Override
    public Product getProductById(int id) {
        return productRepo.findById(id)
                .orElseThrow(()->new RuntimeException("Product not found"));
    }
    @Override
    public void deleteProduct(int id) {
        productRepo.deleteById(id);
    }
}