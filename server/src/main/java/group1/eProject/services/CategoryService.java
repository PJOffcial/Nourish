package group1.eProject.services;

import group1.eProject.entities.Category;

import java.util.List;

public interface CategoryService{
    List<Category> getAllCategories();
    Category saveCategory(Category category);
    void deleteCategory(int id);
}