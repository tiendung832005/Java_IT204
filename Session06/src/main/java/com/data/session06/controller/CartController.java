package com.data.session06.controller;


import com.data.session06.service.ProductCartService;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/cart")
public class CartController extends HttpServlet {
    private final ProductCartService productCartService = new ProductCartService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("cart.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cartId = Integer.parseInt(request.getParameter("cartId"));

        try {
            productCartService.removeFromCart(cartId);
            response.sendRedirect("cart");
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}
