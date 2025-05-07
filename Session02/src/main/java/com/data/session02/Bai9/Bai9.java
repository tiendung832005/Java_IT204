package com.data.session02.Bai9;

import java.io.*;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "Bai9", value = "/Bai9")
public class Bai9 extends HttpServlet {
    private final String[] words = {"hangman", "guitar", "developer", "java", "hospital"};

    private String getRandomWord() {
        return words[new Random().nextInt(words.length)];
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();

        GameState game = (GameState) session.getAttribute("game");
        if (game == null || request.getParameter("restart") != null) {
            game = new GameState(getRandomWord());
            session.setAttribute("game", game);
        }

        request.setAttribute("game", game);
        request.getRequestDispatcher("Bai9.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        GameState game = (GameState) session.getAttribute("game");

        if (game != null && !game.isGameOver()) {
            String guess = request.getParameter("guess");
            if (guess != null && !guess.trim().isEmpty()) {
                game.guessLetter(guess.trim());
            }
        }

        response.sendRedirect("guess");
    }
}
