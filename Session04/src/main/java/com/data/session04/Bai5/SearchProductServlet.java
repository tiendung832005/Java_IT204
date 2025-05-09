package com.data.session04.Bai5;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/search")
public class SearchProductServlet extends HttpServlet {

    private List<Product> productList;

    @Override
    public void init() {
        productList = new ArrayList<>();
        productList.add(new Product(1, "Áo Thun", 150000, "Áo thun chất cotton mịn."));
        productList.add(new Product(2, "Quần Jeans", 350000, "Quần jeans form Hàn."));
        productList.add(new Product(3, "Áo Khoác", 500000, "Áo khoác giữ nhiệt."));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idStr = request.getParameter("productId");
        Product foundProduct = null;

        try {
            int id = Integer.parseInt(idStr);
            for (Product p : productList) {
                if (p.getId() == id) {
                    foundProduct = p;
                    break;
                }
            }
        } catch (NumberFormatException ignored) {}

        request.setAttribute("product", foundProduct);
        request.getRequestDispatcher("Bai5.jsp").forward(request, response);
    }
}

