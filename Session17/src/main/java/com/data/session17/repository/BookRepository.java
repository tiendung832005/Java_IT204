package com.data.session17.repository;

import com.data.session17.entity.Book;

import java.util.List;

public interface BookRepository {
    List<com.data.session17.entity.Book> getAll();

    void delete(int id);
}