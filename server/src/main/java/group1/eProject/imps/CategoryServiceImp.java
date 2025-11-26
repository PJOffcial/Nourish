package group1.eProject.imps;

import group1.eProject.entities.Category;
import group1.eProject.repos.CategoryRepo;
import group1.eProject.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImp implements CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;
    @Override
    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }
    @Override
    public Category saveCategory(Category category) {
        categoryRepo.save(category);
        return categoryRepo.findById(category.getId())
                .orElseThrow(()->new RuntimeException("Category saving failed"));
    }
    @Override
    public void deleteCategory(int id) {
        categoryRepo.deleteById(id);
    }
}