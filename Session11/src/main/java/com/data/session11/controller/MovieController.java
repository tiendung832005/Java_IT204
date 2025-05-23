package com.data.session11.controller;

import com.data.session11.entity.Movie;
import com.data.session11.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public String listMovies(Model model) {
        model.addAttribute("movies", movieService.getAllMovies());
        return "movieList";
    }

    @GetMapping("/add")
    public String showAddMovieForm(Model model) {
        model.addAttribute("movie", new Movie());
        return "addMovie";
    }

    @PostMapping("/add")
    public String addMovie(@Valid @ModelAttribute("movie") Movie movie,
                           BindingResult result,
                           @RequestParam("posterFile") MultipartFile posterFile) throws IOException {
        if (result.hasErrors()) {
            return "addMovie";
        }

        String posterUrl = CloudinaryService.uploadFile(posterFile);
        movie.setPoster(posterUrl);

        movieService.saveMovie(movie);
        return "redirect:/movies";
    }

    @GetMapping("/edit/{id}")
    public String showEditMovieForm(@PathVariable("id") Integer id, Model model) {
        Movie movie = movieService.getMovieById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid movie ID: " + id));
        model.addAttribute("movie", movie);
        return "editMovie";
    }

    @PostMapping("/edit/{id}")
    public String editMovie(@PathVariable("id") Integer id,
                            @Valid @ModelAttribute("movie") Movie movie,
                            BindingResult result,
                            @RequestParam("posterFile") MultipartFile posterFile) throws IOException {
        if (result.hasErrors()) {
            return "editMovie";
        }

        if (!posterFile.isEmpty()) {
            String posterUrl = CloudinaryService.uploadFile(posterFile);
            movie.setPoster(posterUrl);
        }

        movieService.saveMovie(movie);
        return "redirect:/movies";
    }

    @GetMapping("/delete/{id}")
    public String deleteMovie(@PathVariable("id") Integer id) {
        movieService.deleteMovieById(id);
        return "redirect:/movies";
    }
}