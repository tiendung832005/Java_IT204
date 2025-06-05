package com.data.session19a.controller;

import com.data.session19a.entity.Movie;
import com.data.session19a.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping
    public String listMovies(@RequestParam(defaultValue = "1") int page,
                             @RequestParam(defaultValue = "5") int size,
                             Model model) {
        List<Movie> movies = movieRepository.findAllMovies(page, size);
        model.addAttribute("movies", movies);
        model.addAttribute("currentPage", page);
        model.addAttribute("pageSize", size);
        return "movie-list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("movie", new Movie());
        return "movie-form";
    }

    @PostMapping("/add")
    public String addMovie(@Valid @ModelAttribute Movie movie, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("movie", movie);
            return "movie-form";
        }
        movieRepository.saveMovie(movie);
        return "redirect:/movies";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Movie movie = movieRepository.findMovieById(id);
        model.addAttribute("movie", movie);
        return "movie-form";
    }

    @PostMapping("/edit")
    public String editMovie(@Valid @ModelAttribute Movie movie, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("movie", movie);
            return "movie-form";
        }
        movieRepository.updateMovie(movie);
        return "redirect:/movies";
    }

    @PostMapping("/delete/{id}")
    public String deleteMovie(@PathVariable Long id) {
        movieRepository.deleteMovie(id);
        return "redirect:/movies";
    }

    @PostMapping("/status/{id}")
    public String setMovieStatus(@PathVariable Long id, @RequestParam boolean status) {
        movieRepository.setMovieStatus(id, status);
        return "redirect:/movies";
    }
}