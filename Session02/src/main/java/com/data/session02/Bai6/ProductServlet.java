package com.data.session02.Bai6;

import java.io.*;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "ProductServlet", value = "/ProductServlet")
public class ProductServlet extends HttpServlet {
    private static final ArrayList<Product> productList = new ArrayList<>();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("edit".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            for (Product p : productList) {
                if (p.getId() == id) {
                    request.setAttribute("product", p);
                    request.getRequestDispatcher("updateProduct.jsp").forward(request, response);
                    return;
                }
            }
            response.sendRedirect("products");
        } else {
            request.setAttribute("products", productList);
            request.getRequestDispatcher("productList.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("update".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String priceStr = request.getParameter("price");

            String error = null;
            double price = 0;

            if (name == null || name.trim().isEmpty()) {
                error = "Tên sản phẩm không được để trống.";
            }

            try {
                price = Double.parseDouble(priceStr);
                if (price < 0) error = "Giá phải lớn hơn 0.";
            } catch (Exception e) {
                error = "Giá không hợp lệ.";
            }

            if (error != null) {
                Product p = new Product(id, name, 0);
                request.setAttribute("product", p);
                request.setAttribute("error", error);
                request.getRequestDispatcher("updateProduct.jsp").forward(request, response);
                return;
            }

            for (Product p : productList) {
                if (p.getId() == id) {
                    p.setName(name);
                    p.setPrice(price);
                    break;
                }
            }

            HttpSession session = request.getSession();
            session.setAttribute("message", "Cập nhật thành công!");
            response.sendRedirect("products");
        }
        else if ("delete".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            boolean removed = productList.removeIf(p -> p.getId() == id);

            HttpSession session = request.getSession();
            if (removed) {
                session.setAttribute("message", "Xóa sản phẩm thành công!");
            } else {
                session.setAttribute("message", "Không tìm thấy sản phẩm để xóa.");
            }

            response.sendRedirect("products");
        }
        else {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            double price = Double.parseDouble(request.getParameter("price"));

            productList.add(new Product(id, name, price));
            response.sendRedirect("products");
        }
    }
}
