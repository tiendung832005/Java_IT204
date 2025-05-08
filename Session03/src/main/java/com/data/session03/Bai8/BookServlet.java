package com.data.session03.Bai8;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/books")
public class BookServlet extends HttpServlet {
    private List<Book> bookList;

    @Override
    public void init() throws ServletException {
        bookList = new ArrayList<>();
        getServletContext().setAttribute("bookList", bookList);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("add".equals(action)) {
            String title = request.getParameter("title");
            String author = request.getParameter("author");
            int year = Integer.parseInt(request.getParameter("year"));

            Book book = new Book(title, author, year);
            bookList.add(book);
        }

        if ("search".equals(action)) {
            String keyword = request.getParameter("searchTerm").toLowerCase();
            List<Book> results = bookList.stream()
                    .filter(book -> book.getTitle().toLowerCase().contains(keyword))
                    .collect(Collectors.toList());

            request.setAttribute("searchResults", results);
        }

        request.getRequestDispatcher("Bai8.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("Bai8.jsp").forward(request, response);
    }
}

