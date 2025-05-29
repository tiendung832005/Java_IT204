package com.data.demo_hackathon_02.controller;


import com.data.demo_hackathon_02.dto.ProductDTO;
import com.data.demo_hackathon_02.model.Product;
import com.data.demo_hackathon_02.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductController", urlPatterns = {"/products"})
public class ProductController extends HttpServlet {
    private final ProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Product> products = productService.getAllProducts();
            req.setAttribute("products", products);
            req.getRequestDispatcher("/WEB-INF/views/product-list.jsp").forward(req, resp);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        try {
            if ("update".equals(action)) {
                int id = Integer.parseInt(req.getParameter("id"));
                ProductDTO productDTO = new ProductDTO();
                productDTO.setProductName(req.getParameter("productName"));
                productDTO.setPrice(Integer.parseInt(req.getParameter("price")));
                productDTO.setDescription(req.getParameter("description"));
                productDTO.setStatus(req.getParameter("status"));
                productService.updateProduct(id, productDTO);
            } else if ("delete".equals(action)) {
                int id = Integer.parseInt(req.getParameter("id"));
                productService.deleteProduct(id);
            } else if ("search".equals(action)) {
                String keyword = req.getParameter("keyword");
                List<Product> products = productService.searchProducts(keyword);
                req.setAttribute("products", products);
                req.getRequestDispatcher("/WEB-INF/views/product-list.jsp").forward(req, resp);
                return;
            }
            resp.sendRedirect("products");
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
