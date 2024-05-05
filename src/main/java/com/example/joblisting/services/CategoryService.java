package com.example.joblisting.services;

import com.example.joblisting.entities.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    Category saveCategory(Category category);
    Category updateCategory(Category category);
    void deleteCategory(Long id);
    void deleteAllCategories();
    Category getCategoryById(Long id);
    List<Category> getAllCategories();
}
