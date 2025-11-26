package group1.eProject.repos;

import group1.eProject.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProductRepo extends JpaRepository<Product,Integer>,JpaSpecificationExecutor<Product>{

}