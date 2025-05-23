package com.data.session11.repository;


import com.data.session11.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Optional<Category> findByCategoryName(String categoryName);

    List<Category> findAll();

    Optional<Category> findById(Integer id);

    void deleteById(Integer id);
}
