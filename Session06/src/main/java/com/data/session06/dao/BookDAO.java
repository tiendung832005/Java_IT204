package com.data.session06.dao;

import com.data.session06.model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    private final String jdbcURL = "jdbc:mysql://localhost:3306";
    private final String jdbcUsername = "root";
    private final String jdbcPassword = "12345678";

    private static final String INSERT_BOOK_SQL = "INSERT INTO books (bookCode, title, author, genre, quantity) VALUES (?, ?, ?, ?, ?);";
    private static final String SELECT_BOOK_BY_CODE = "SELECT * FROM books WHERE bookCode = ?;";
    private static final String SELECT_ALL_BOOKS = "SELECT * FROM books;";
    private static final String UPDATE_BOOKS_SQL = "UPDATE books SET title = ?, author = ?, genre = ?, quantity = ? WHERE bookCode = ?;";
    private static final String DELETE_BOOKS_SQL = "DELETE FROM books WHERE bookCode = ?;";

    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }

    public void insertBook(Book book) throws SQLException{
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BOOK_SQL)) {
            preparedStatement.setString(1, book.getBookCode());
            preparedStatement.setString(2, book.getTitle());
            preparedStatement.setString(3, book.getAuthor());
            preparedStatement.setString(4, book.getGenre());
            preparedStatement.setInt(5, book.getQuantity());
            preparedStatement.executeUpdate();
        }
    }

    public Book selectBook(String bookCode) throws SQLException {
        Book book = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOK_BY_CODE)) {
            preparedStatement.setString(1, bookCode);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                book = new Book(rs.getString("book_code"), rs.getString("title"), rs.getString("author"),
                        rs.getString("genre"), rs.getInt("quantity"));
            }
        }
        return book;
    }

    public List<Book> selectAllBook() throws SQLException {
        List<Book> books = new ArrayList<>();
        try(Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BOOKS)){
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                books.add(new Book(rs.getString("book_code"), rs.getString("title"), rs.getString("author"),
                        rs.getString("genre"), rs.getInt("quantity")));
            }
        }
        return books;
    }

    public boolean updateBook(Book book) throws SQLException{
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE_BOOKS_SQL")){
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setString(3, book.getGenre());
            preparedStatement.setInt(4, book.getQuantity());
            preparedStatement.setString(5, book.getBookCode());
            return preparedStatement.executeUpdate() > 0;
        }
    }

    public boolean deleteBook(String bookCode) throws SQLException{
        try(Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BOOKS_SQL)){
            preparedStatement.setString(1, bookCode);
            return preparedStatement.executeUpdate() > 0;
        }
    }
}

