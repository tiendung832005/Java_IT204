package com.data.session11.controller;

import com.data.session11.entity.Category;
import com.data.session11.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public String listCategories(Model model) {
        model.addAttribute("categories", categoryService.getAllCategories());
        return "categoryList";
    }

    @GetMapping("/categories/add")
    public String showAddCategoryForm(Model model) {
        model.addAttribute("category", new Category());
        return "addCategory";
    }

    @PostMapping("/categories/add")
    public String addCategory(@Valid @ModelAttribute("category") Category category,
                              BindingResult result, Model model) {
        if (!categoryService.isCategoryNameUnique(category.getCategoryName(), null)) {
            result.rejectValue("categoryName", "error.category", "Tên danh mục đã tồn tại!");
        }

        if (result.hasErrors()) {
            return "addCategory";
        }

        categoryService.saveCategory(category);
        return "redirect:/categories";
    }

    @GetMapping("/categories/edit/{id}")
    public String showEditCategoryForm(@PathVariable("id") Integer id, Model model) {
        Category category = categoryService.getCategoryById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid category ID: " + id));
        model.addAttribute("category", category);
        return "editCategory";
    }

    @PostMapping("/categories/edit/{id}")
    public String editCategory(@PathVariable("id") Integer id,
                               @Valid @ModelAttribute("category") Category category,
                               BindingResult result, Model model) {
        if (!categoryService.isCategoryNameUnique(category.getCategoryName(), id)) {
            result.rejectValue("categoryName", "error.category", "Tên danh mục đã tồn tại!");
        }

        if (result.hasErrors()) {
            return "editCategory";
        }

        categoryService.saveCategory(category);
        return "redirect:/categories";
    }

    @GetMapping("/categories/delete/{id}")
    public String deleteCategory(@PathVariable("id") Integer id) {
        categoryService.deleteCategoryById(id);
        return "redirect:/categories";
    }
}