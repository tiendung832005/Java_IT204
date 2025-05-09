package com.data.session04.Bai8;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/revenues")
public class RevenueServlet extends HttpServlet {

    @Override
    public void init() {
        List<Revenue> revenueList = new ArrayList<>();
        revenueList.add(new Revenue("Tháng 1", 3000));
        revenueList.add(new Revenue("Tháng 2", 2500));
        revenueList.add(new Revenue("Tháng 3", 4000));
        revenueList.add(new Revenue("Tháng 4", 1500));

        getServletContext().setAttribute("revenueList", revenueList);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("revenues.jsp").forward(request, response);
    }
}
