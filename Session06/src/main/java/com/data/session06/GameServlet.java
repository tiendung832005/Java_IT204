package com.data.session06;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Random;

public class GameServlet extends HttpServlet {
    private final String[] choices = {"Búa", "Kéo", "Lá"};

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String playerChoice = request.getParameter("playerChoice");

        String computerChoice = choices[new Random().nextInt(3)];

        String result;
        if (playerChoice.equals(computerChoice)) {
            result = "Hòa!";
        } else if (
                (playerChoice.equals("Búa") && computerChoice.equals("Kéo")) ||
                        (playerChoice.equals("Kéo") && computerChoice.equals("Lá")) ||
                        (playerChoice.equals("Lá") && computerChoice.equals("Búa"))
        ) {
            result = "Bạn thắng!";
        } else {
            result = "Máy thắng!";
        }

        // Gửi dữ liệu sang JSP
        request.setAttribute("playerChoice", playerChoice);
        request.setAttribute("computerChoice", computerChoice);
        request.setAttribute("result", result);

        RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");
        dispatcher.forward(request, response);
    }
}

