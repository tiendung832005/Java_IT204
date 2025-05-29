package com.data.session14.controller;


import com.data.session14.model.CategoryEn;
import com.data.session14.model.CategoryVi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
public class CategoryController {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private DataSource dataSource;

    @GetMapping("/categories")
    public String showCategoryForm(HttpSession session, Model model) {
        Locale locale = (Locale) session.getAttribute("locale");
        if (locale == null) {
            locale = Locale.ENGLISH;
            session.setAttribute("locale", locale);
        }
        model.addAttribute("locale", locale);
        return "categories";
    }

    @PostMapping("/categories/add")
    public String addCategory(@RequestParam String categoryNameVi, @RequestParam String descriptionVi,
                              @RequestParam String categoryNameEn, @RequestParam String descriptionEn,
                              HttpSession session, Model model) {
        try (Connection connection = dataSource.getConnection()) {
            String sqlVi = "INSERT INTO categories_vi (categoryName, description) VALUES (?, ?)";
            try (PreparedStatement psVi = connection.prepareStatement(sqlVi)) {
                psVi.setString(1, categoryNameVi);
                psVi.setString(2, descriptionVi);
                psVi.executeUpdate();
            }

            String sqlEn = "INSERT INTO categories_en (categoryName, description) VALUES (?, ?)";
            try (PreparedStatement psEn = connection.prepareStatement(sqlEn)) {
                psEn.setString(1, categoryNameEn);
                psEn.setString(2, descriptionEn);
                psEn.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Locale locale = (Locale) session.getAttribute("locale");
        model.addAttribute("message", messageSource.getMessage("success.category.added", null, locale));
        return "redirect:/categories/view";
    }

    @GetMapping("/categories/view")
    public String viewCategories(HttpSession session, Model model) {
        Locale locale = (Locale) session.getAttribute("locale");
        List<?> categories = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            String sql = locale.equals(Locale.ENGLISH) ? "SELECT * FROM categories_en" : "SELECT * FROM categories_vi";
            try (PreparedStatement ps = connection.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    if (locale.equals(Locale.ENGLISH)) {
                        categories.add(new CategoryEn(rs.getInt("id"), rs.getString("categoryName"), rs.getString("description")));
                    } else {
                        categories.add(new CategoryVi(rs.getInt("id"), rs.getString("categoryName"), rs.getString("description")));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("categories", categories);
        return "viewCategories";
    }

    @GetMapping("/change-language")
    public String changeLanguage(@RequestParam String lang, HttpSession session) {
        Locale locale = "vi".equals(lang) ? new Locale("vi") : Locale.ENGLISH;
        session.setAttribute("locale", locale);
        return "redirect:/categories";
    }
}
