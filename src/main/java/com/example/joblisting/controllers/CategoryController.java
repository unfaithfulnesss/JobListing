package com.example.joblisting.controllers;

import com.example.joblisting.entities.Category;
import com.example.joblisting.services.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class CategoryController {
    private CategoryService categoryService;
    @RequestMapping("/createCategory")
    public String createCategory(){
        return "CreateCategory";
    }

    @RequestMapping("/saveCategory")
    public String saveCategory(@ModelAttribute("Category")Category category){
        Category saveCategory = categoryService.saveCategory(category);
        return "CreateCategory";
    }
    @RequestMapping("/CategoriesList")
    public String categoriesList(ModelMap modelMap){
        List<Category> categories = categoryService.getAllCategories();
        modelMap.addAttribute("Categories", categories);
        return "CategoriesList";

    }
    @RequestMapping("/deleteCategory")
    public String deleteCategory(@RequestParam("id") Long id, ModelMap modelMap){
        categoryService.deleteCategory(id);
        return categoriesList(modelMap);
    }
    @RequestMapping("/editCategory")
    public String editCategory(@RequestParam("id") Long id, ModelMap modelMap){
        Category category= categoryService.getCategoryById(id);
        modelMap.addAttribute("Categories", category);
        return "EditCategory";
    }
    @RequestMapping("/updateCategory")
    public String updateCategory(@ModelAttribute("Category")Category category){
        categoryService.updateCategory(category);
        return createCategory();
    }
}
