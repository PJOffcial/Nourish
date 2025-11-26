package group1.eProject.api;

import group1.eProject.entities.Product;
import group1.eProject.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductApi {
    @Autowired
    private ProductService productService;
    @Value("${upload.path}")
    private String uploadPath;
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getAllProducts(Integer categoryId,String keyword) {
        return productService.getAllProducts(categoryId,keyword);
    }
    @PostMapping(value = "/", consumes = "multipart/form-data")
    @ResponseStatus(HttpStatus.CREATED)
    public Product addProduct(
            @RequestPart("data") Product product,
            @RequestPart("image") MultipartFile image
    ) throws IOException {
        // Lưu file ảnh
        String fileName = image.getOriginalFilename();
        File targetFile = new File(uploadPath + "/" + fileName);
        FileCopyUtils.copy(image.getBytes(), targetFile);
        // Gán tên ảnh vào product (nếu có field imageUrl)
        product.setImage(fileName);
        // Lưu vào DB
        return productService.saveProduct(product);
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Product getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProductById(@PathVariable int id) {
        productService.deleteProduct(id);
    }
}