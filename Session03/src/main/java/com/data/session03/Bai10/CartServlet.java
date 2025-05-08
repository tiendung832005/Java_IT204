package com.data.session03.Bai10;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

    private List<Product> products = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        // Sản phẩm mẫu
        products.add(new Product(1, "Áo thun", 150000));
        products.add(new Product(2, "Quần jean", 300000));
        products.add(new Product(3, "Giày thể thao", 500000));
        getServletContext().setAttribute("products", products);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CartManager cart = getCartManager(request);
        String action = request.getParameter("action");
        String idStr = request.getParameter("id");

        if ("add".equals(action) && idStr != null) {
            int id = Integer.parseInt(idStr);
            Product product = products.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
            if (product != null) {
                cart.addProduct(product);
            }
            request.setAttribute("message", "Đã thêm sản phẩm vào giỏ hàng (hoặc đã có sẵn).");
            request.getRequestDispatcher("products.jsp").forward(request, response);
        } else if ("remove".equals(action) && idStr != null) {
            int id = Integer.parseInt(idStr);
            cart.removeProduct(id);
            response.sendRedirect("cart.jsp");
        }
    }

    private CartManager getCartManager(HttpServletRequest request) {
        HttpSession session = request.getSession();
        CartManager cart = (CartManager) session.getAttribute("cart");
        if (cart == null) {
            cart = new CartManager();
            session.setAttribute("cart", cart);
        }
        return cart;
    }
}

