package com.data.session06.service;

import com.data.session06.dao.BookDAO;
import com.data.session06.model.Book;

import java.sql.SQLException;
import java.util.List;

public class BookService {
    private final BookDAO bookDAO = new BookDAO();

    public void addBook(Book book) throws SQLException{
        bookDAO.insertBook(book);
    }

    public Book getBook(String bookCode) throws SQLException {
        return bookDAO.selectBook(bookCode);
    }

    public List<Book> getAllBooks() throws SQLException{
        return bookDAO.selectAllBook();
    }

    public void updateBook (Book book) throws SQLException{
        bookDAO.updateBook(book);
    }

    public void deleteBook (String bookCode) throws SQLException{
        bookDAO.deleteBook(bookCode);
    }
}
