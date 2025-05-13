package com.data.session06.controller;
import com.data.session06.model.Book;
import com.data.session06.service.BookService;

import java.io.*;
import java.rmi.ServerException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/books")
public class BookController extends HttpServlet {
    private final BookService bookService = new BookService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        try{
            switch (action == null ? "list" : action){
                case "add":
                    showAddForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteBook(request, response);
                    break;
                default:
                    listBooks(request, response);
                    break;
            }

        }
        catch (SQLException e) {
            throw new ServletException(e);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        try{
            switch (action){
                case "create":
                    createBook(request, response);
                    break;
                    case "update":
                    updateBook(request, response);
                default:
                    response.sendRedirect("books");
                    break;
            }
        }
        catch (SQLException e){
            throw new ServletException(e);
        }
    }

    private void listBooks(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        request.setAttribute("books", bookService.getAllBooks());
        RequestDispatcher dispatcher = request.getRequestDispatcher("listBook.jsp");
        dispatcher.forward(request, response);
    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("formAdd.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String bookCode = request.getParameter("bookCode");
        Book book = bookService.getBook(bookCode);
        request.setAttribute("book", book);
        RequestDispatcher dispatcher = request.getRequestDispatcher("formEdit.jsp");
        dispatcher.forward(request, response);
    }

    private void createBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String bookCode = request.getParameter("bookCode");
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String genre = request.getParameter("genre");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        Book book = new Book(bookCode, title, author, genre, quantity);
        bookService.addBook(book);
        response.sendRedirect("books");
    }

    private void updateBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String bookCode = request.getParameter("bookCode");
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String genre = request.getParameter("genre");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        Book book = new Book(bookCode, title, author, genre, quantity);
        bookService.updateBook(book);
        response.sendRedirect("books");
    }

    private void deleteBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String bookCode = request.getParameter("bookCode");
        bookService.deleteBook(bookCode);
        response.sendRedirect("books");
    }
}
