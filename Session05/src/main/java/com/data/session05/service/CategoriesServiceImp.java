package com.data.session05.service;

import com.data.session05.dao.CategoriesDAO;
import com.data.session05.dao.CategoriesDAOImp;
import com.data.session05.model.Categories;

public class CategoriesServiceImp implements CategoriesService {
    private final CategoriesDAO categoriesDAO;

    public CategoriesServiceImp() {
        categoriesDAO = new CategoriesDAOImp();
    }

    @Override
    public List<Categories> findAll() {
        return categoriesDAO.findAll();
    }

    @Override
    public boolean save(Categories catalog) {
        return categoriesDAO.save(catalog);
    }
}
