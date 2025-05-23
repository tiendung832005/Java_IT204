package com.data.session11.repository;

import com.data.session11.model.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieRepository {
    Movie findByTitle(String title);

    List<com.data.session11.entity.Movie> findAll();

    Optional<com.data.session11.entity.Movie> findById(Integer id);

    void deleteById(Integer id);

    void save(com.data.session11.entity.Movie movie);
}
