package com.data.session11.service;

import com.data.session11.entity.Category;
import com.data.session11.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public boolean isCategoryNameUnique(String categoryName, Integer id) {
        Optional<Category> existingCategory = categoryRepository.findByCategoryName(categoryName);
        return existingCategory.isEmpty() || existingCategory.get().getId().equals(id);
    }

    public void saveCategory(Category category) throws InterruptedException {
        categoryRepository.wait(category.getId());
    }

    public Optional<Category> getCategoryById(Integer id) {
        return categoryRepository.findById(id);
    }

    public void deleteCategoryById(Integer id) {
        categoryRepository.deleteById(id);
    }
}