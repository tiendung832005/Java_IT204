package com.data.session04.Bai1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Áo thun", 150000, "Áo thun cotton 100%"));
        products.add(new Product(2, "Quần jeans", 350000, "Quần jeans nam co giãn"));
        products.add(new Product(3, "Giày sneaker", 500000, "Giày thể thao thời trang"));

        request.setAttribute("productList", products);
        request.getRequestDispatcher("productList.jsp").forward(request, response);
    }
}
