package com.data.session04.Bai7;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {
    private List<Product> productList = new ArrayList<>();

    @Override
    public void init() {
        productList.add(new Product(1, "Áo Thun", 150000));
        productList.add(new Product(2, "Quần Jean", 300000));
        productList.add(new Product(3, "Giày Sneaker", 800000));
        productList.add(new Product(4, "Mũ Lưỡi Trai", 100000));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String minStr = request.getParameter("min");
        String maxStr = request.getParameter("max");

        List<Product> filtered = new ArrayList<>();

        if (minStr != null && maxStr != null && !minStr.isEmpty() && !maxStr.isEmpty()) {
            double min = Double.parseDouble(minStr);
            double max = Double.parseDouble(maxStr);

            for (Product p : productList) {
                if (p.getPrice() >= min && p.getPrice() <= max) {
                    filtered.add(p);
                }
            }
        }

        request.setAttribute("products", filtered);
        request.setAttribute("filterApplied", minStr != null && maxStr != null);
        request.getRequestDispatcher("Bai7.jsp").forward(request, response);
    }
}

