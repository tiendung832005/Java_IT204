package com.data.session09.service;

import com.data.session09.dao.MovieDAO;
import com.data.session09.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieDAO movieDAO;

    public List<Movie> getAllMovies() {
        return movieDAO.getAllMovies();
    }

    public Movie getMovieById(Long id) {
        return movieDAO.getMovieById(id);
    }
}
