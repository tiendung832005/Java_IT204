package com.data.session06.dao;


import com.data.session06.model.Categories;

import java.util.List;

public interface CategoriesDAO {
    List<Categories> findAll();

    boolean save(Categories catalog);

    Categories findById(int catalogId);

    boolean update(Categories catalog);

    boolean delete(int catalogId);
}
