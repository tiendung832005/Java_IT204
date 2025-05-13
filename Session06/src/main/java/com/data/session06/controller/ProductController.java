package com.data.session06.controller;


import com.data.session06.model.Product;
import com.data.session06.service.ProductCartService;
import com.data.session06.service.ProductService;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/products")
public class ProductController extends HttpServlet {
    private final ProductService productService = new ProductService();
    private final ProductCartService productCartService = new ProductCartService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Product> products = productService.getAllProducts();
            request.setAttribute("products", products);
            RequestDispatcher dispatcher = request.getRequestDispatcher("listProduct.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        int productId = Integer.parseInt(request.getParameter("productId"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        try {
            productCartService.addToCart(userId, productId, quantity);
            response.sendRedirect("products");
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}
