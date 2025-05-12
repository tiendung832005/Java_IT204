package com.data.session05.controller.Bai6;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class AuthFilter implements Filter {
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(false);

        String uri = request.getRequestURI();
        boolean isLoginPage = uri.endsWith("login.jsp") || uri.endsWith("login");

        if (session != null && session.getAttribute("user") != null || isLoginPage) {
            chain.doFilter(req, res); // Cho phép đi tiếp
        } else {
            response.sendRedirect("login.jsp"); // Chặn và chuyển về login
        }
    }
}
