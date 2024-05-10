package com.example.joblisting.controllers;

import com.example.joblisting.entities.Category;
import com.example.joblisting.services.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
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
    public String categoriesList(ModelMap modelMap,
                                 @RequestParam(name = "page", defaultValue = "0") int page,
                                 @RequestParam(name = "size", defaultValue = "4") int size)
    {
        Page<Category> categories = categoryService.getAllCategoriesByPage(page, size);
        modelMap.addAttribute("Categories", categories);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("pages", new int[categories.getTotalPages()]);
        return "CategoriesList";

    }
    @RequestMapping("/deleteCategory")
    public String deleteCategory(@RequestParam("id") Long id, ModelMap modelMap,
                                 @RequestParam(name = "page", defaultValue = "0") int page,
                                 @RequestParam(name = "size", defaultValue = "4") int size)
    {
        categoryService.deleteCategory(id);
        Page<Category> categories = categoryService.getAllCategoriesByPage(page, size);
        modelMap.addAttribute("Categories", categories);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("pages", new int[categories.getTotalPages()]);
        return "CategoriesList";
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
