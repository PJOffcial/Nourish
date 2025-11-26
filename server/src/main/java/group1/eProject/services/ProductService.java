package group1.eProject.services;

import group1.eProject.entities.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts(Integer categoryId,String keyword);
    Product saveProduct(Product product);
    Product getProductById(int id);
    void deleteProduct(int id);
}