package com.data.session06.model;

public class Book {
    private String bookCode;
    private String title;
    private String author;
    private String genre;
    private int quantity;

    public Book (){}

    public Book(String bookCode, String title, String author, String genre, int quantity) {
        this.bookCode = bookCode;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.quantity = quantity;
    }

    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
