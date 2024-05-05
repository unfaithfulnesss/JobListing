package com.example.joblisting.services;

import com.example.joblisting.entities.Category;
import com.example.joblisting.repositories.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService{
    private CategoryRepository categoryRepository;
    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public void deleteAllCategories() {
        categoryRepository.deleteAll();
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
